package pe.com.builderp.core.ejb.dao.cooperativa.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.AvalDatosDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.AvalDatos;
import pe.com.builderp.core.model.jpa.cooperativa.InformacionLaboral;
import pe.com.builderp.core.model.vo.cooperativa.AvalDatosDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.factory.CollectionUtil;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil; 
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class ProformaDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:58 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class AvalDatosDaoImpl extends  GenericFacturacionDAOImpl<String, AvalDatos> implements AvalDatosDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<AvalDatos> listarAval(AvalDatosDTO Aval) {
        Query query = generarQueryListaAval(Aval, false);
        query.setFirstResult(Aval.getStartRow());
        query.setMaxResults(Aval.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Aval.
     *
     * @param AvalDatosDTO el Aval
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaAval(AvalDatosDTO Aval, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idAvalDatos) from AvalDatos o where 1=1 ");
        } else {
            jpaql.append(" select o from AvalDatos o where 1=1 ");           
        }
        if (!StringUtils.isNullOrEmpty(Aval.getId())) {
			jpaql.append(" and o.montoCiere is null "); 
		} 
        
		if (!StringUtils.isNullOrEmpty(Aval.getSearch())) {
	          jpaql.append(" and upper(o.idAval) like :search ");
	          parametros.put("search", "%" + Aval.getSearch().toUpperCase() + "%");
	    } 
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.AvalDTO)
     */
	@Override
    public int contarListarAval(AvalDatosDTO Aval) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaAval(Aval, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal#generarIdAval()
     */
	 @Override
    public String generarIdAvalDatos() { 
		return UUIDUtil.generarElementUUID();
    }
 
	 
	@Override	 
	public AvalDatos findByAval(String idEvaluacionCredito) throws Exception {
		AvalDatos resultado = new AvalDatos();
		Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        jpaql.append(" select o from AvalDatos o ");        
        jpaql.append(" where o.evaluacionCredito.idEvaluacionCredito = :idEvaluacionCredito ");
        parametros.put("idEvaluacionCredito", idEvaluacionCredito);
        Query query = createQuery(jpaql.toString(), parametros);
        List<AvalDatos> listaTemp = query.getResultList();
        if (!CollectionUtil.isEmpty(listaTemp)) {
        	resultado = listaTemp.get(0);
        }
		return resultado;
	}
	 
}