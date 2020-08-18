package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.InformacionLaboralDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.InformacionLaboral;
import pe.com.builderp.core.model.vo.cooperativa.InformacionLaboralDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.factory.CollectionUtil;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
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
public class InformacionLaboralDaoImpl extends  GenericFacturacionDAOImpl<String, InformacionLaboral> implements InformacionLaboralDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ConfiguracionAtributoDaoLocal#listarConfiguracionAtributo(pe.com.builderp.core.facturacion.model.jpa.venta.ConfiguracionAtributo)
     */  
    @Override	 
    public List<InformacionLaboral> listarInformacionLaboral(InformacionLaboralDTO InformacionLaboral) {
        Query query = generarQueryListaInformacionLaboral(InformacionLaboral, false);
        query.setFirstResult(InformacionLaboral.getStartRow());
        query.setMaxResults(InformacionLaboral.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista InformacionLaboral.
     *
     * @param InformacionLaboralDTO el InformacionLaboral
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaInformacionLaboral(InformacionLaboralDTO InformacionLaboral, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idInformacionLaboral) from InformacionLaboral o where 1=1 ");
        } else {
            jpaql.append(" select o from InformacionLaboral o where 1=1 ");           
        }
		if (!StringUtils.isNullOrEmpty(InformacionLaboral.getSearch())) {
	          jpaql.append(" and upper(o.idInformacionLaboral) like :search ");
	          parametros.put("search", "%" + InformacionLaboral.getSearch().toUpperCase() + "%");
	    }  
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.InformacionLaboralDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.InformacionLaboralDTO)
     */
	@Override
    public int contarListarInformacionLaboral(InformacionLaboralDTO InformacionLaboral) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaInformacionLaboral(InformacionLaboral, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.InformacionLaboralDaoLocal#generarIdInformacionLaboral()
     */
	 @Override
    public String generarIdInformacionLaboral() {
		 return UUIDUtil.generarElementUUID();
		 /* String resultado = "1";
        Query query = createQuery("select max(o.idInformacionLaboral) from InformacionLaboral o", null);
        List<Object> listLong =  query.getResultList();
        if (listLong != null && listLong.size() > 0 && listLong.get(0) != null)  {
            Long ultimoIdGenerado = Long.valueOf(listLong.get(0).toString());
            if (!StringUtils.isNullOrEmpty(ultimoIdGenerado)) {
                resultado = resultado + ultimoIdGenerado;
            }
        }
        return resultado;*/
    }
   
	 
		@Override	 
		public InformacionLaboral findByInformacionLaboralID(String idEvaluacionCredito) throws Exception {
			InformacionLaboral resultado = new InformacionLaboral();
			Map<String, Object> parametros = new HashMap<String, Object>();
	        StringBuilder jpaql = new StringBuilder();
	        jpaql.append(" select o from InformacionLaboral o ");        
	        jpaql.append(" where o.evaluacionCredito.idEvaluacionCredito = :idEvaluacionCredito ");
	        parametros.put("idEvaluacionCredito", idEvaluacionCredito);
	        Query query = createQuery(jpaql.toString(), parametros);
	        List<InformacionLaboral> listaTemp = query.getResultList();
	        if (!CollectionUtil.isEmpty(listaTemp)) {
	        	resultado = listaTemp.get(0);
	        }
			return resultado;
		}
		
		
		@Override	 
		public InformacionLaboral findByinformacionLaboralAvalDatos(String idAvalDatos) throws Exception {
			InformacionLaboral resultado = new InformacionLaboral();
			Map<String, Object> parametros = new HashMap<String, Object>();
	        StringBuilder jpaql = new StringBuilder();
	        jpaql.append(" select o from InformacionLaboral o ");        
	        jpaql.append(" where o.avalDatos.idAvalDatos = :idAvalDatos ");
	        parametros.put("idAvalDatos", idAvalDatos);
	        Query query = createQuery(jpaql.toString(), parametros);
	        List<InformacionLaboral> listaTemp = query.getResultList();
	        if (!CollectionUtil.isEmpty(listaTemp)) {
	        	resultado = listaTemp.get(0);
	        }
			return resultado;
		}
}