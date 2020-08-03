package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.ReferenciaPersonalDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.ReferenciaPersonal;
import pe.com.builderp.core.model.vo.cooperativa.ReferenciaPersonalDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class ConfiguracionAtributoDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:56 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class ReferenciaPersonalDaoImpl extends  GenericFacturacionDAOImpl<String, ReferenciaPersonal> implements ReferenciaPersonalDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ConfiguracionAtributoDaoLocal#listarConfiguracionAtributo(pe.com.builderp.core.facturacion.model.jpa.venta.ConfiguracionAtributo)
     */  
    @Override	 
    public List<ReferenciaPersonal> listarReferenciaPersonal(ReferenciaPersonalDTO ReferenciaPersonal) {
        Query query = generarQueryListaReferenciaPersonal(ReferenciaPersonal, false);
        query.setFirstResult(ReferenciaPersonal.getStartRow());
        query.setMaxResults(ReferenciaPersonal.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista ReferenciaPersonal.
     *
     * @param ReferenciaPersonalDTO el ReferenciaPersonal
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idReferenciaPersonal) from ReferenciaPersonal o where 1=1 ");
        } else {
            jpaql.append(" select o from ReferenciaPersonal o where 1=1 ");           
        }
        jpaql.append(" and o.evaluacionCredito.idEvaluacionCredito = :idEvaluacionCredito ");
      	parametros.put("idEvaluacionCredito", referenciaPersonal.getId() + "");
      	
		if (!StringUtils.isNullOrEmpty(referenciaPersonal.getSearch())) {
	          jpaql.append(" and upper(o.idReferenciaPersonal) like :search ");
	          parametros.put("search", "%" + referenciaPersonal.getSearch().toUpperCase() + "%");
	    }  
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ReferenciaPersonalDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.ReferenciaPersonalDTO)
     */
	@Override
    public int contarListarReferenciaPersonal(ReferenciaPersonalDTO ReferenciaPersonal) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaReferenciaPersonal(ReferenciaPersonal, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ReferenciaPersonalDaoLocal#generarIdReferenciaPersonal()
     */
	 @Override
    public String generarIdReferenciaPersonal() {
        String resultado = "1";
        Query query = createQuery("select max(o.idReferenciaPersonal) from ReferenciaPersonal o", null);
        List<Object> listLong =  query.getResultList();
        if (listLong != null && listLong.size() > 0 && listLong.get(0) != null)  {
            Long ultimoIdGenerado = Long.valueOf(listLong.get(0).toString());
            if (!StringUtils.isNullOrEmpty(ultimoIdGenerado)) {
                resultado = resultado + ultimoIdGenerado;
            }
        }
        return resultado;
    }
   
}