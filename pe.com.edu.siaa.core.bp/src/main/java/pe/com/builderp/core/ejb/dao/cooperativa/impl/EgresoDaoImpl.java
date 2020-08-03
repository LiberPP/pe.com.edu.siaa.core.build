package pe.com.builderp.core.ejb.dao.cooperativa.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.EgresoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.Egreso;
import pe.com.builderp.core.model.vo.cooperativa.EgresoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl; 
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
public class EgresoDaoImpl extends  GenericFacturacionDAOImpl<String, Egreso> implements EgresoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<Egreso> listarEgreso(EgresoDTO Egreso) {
        Query query = generarQueryListaEgreso(Egreso, false);
        query.setFirstResult(Egreso.getStartRow());
        query.setMaxResults(Egreso.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Egreso.
     *
     * @param EgresoDTO el Egreso
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaEgreso(EgresoDTO egreso, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idEgreso) from Egreso o where 1=1 ");
        } else {
            jpaql.append(" select o from Egreso o where 1=1 ");           
        }
        if (!StringUtils.isNullOrEmpty(egreso.getFechaPago())) {
			jpaql.append(" and to_char(o.fechaCreacion,'dd/MM/yyyy') =:fecha "); 
			parametros.put("fecha", egreso.getFechaPago());
		} 
        
		if (!StringUtils.isNullOrEmpty(egreso.getSearch())) {
	          jpaql.append(" and upper(o.idEgreso) like :search ");
	          parametros.put("search", "%" + egreso.getSearch().toUpperCase() + "%");
	    } 
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.EgresoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.EgresoDTO)
     */
	@Override
    public int contarListarEgreso(EgresoDTO Egreso) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaEgreso(Egreso, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.EgresoDaoLocal#generarIdEgreso()
     */
	 @Override
    public String generarIdEgreso() { 
		return UUIDUtil.generarElementUUID();
    }
 
 
}