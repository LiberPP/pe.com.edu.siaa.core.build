package pe.com.builderp.core.ejb.dao.cooperativa.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.IngresoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.Ingreso;
import pe.com.builderp.core.model.vo.cooperativa.IngresoDTO;
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
public class IngresoDaoImpl extends  GenericFacturacionDAOImpl<String, Ingreso> implements IngresoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<Ingreso> listarIngreso(IngresoDTO Ingreso) {
        Query query = generarQueryListaIngreso(Ingreso, false);
        query.setFirstResult(Ingreso.getStartRow());
        query.setMaxResults(Ingreso.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Ingreso.
     *
     * @param IngresoDTO el Ingreso
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaIngreso(IngresoDTO Ingreso, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idIngreso) from Ingreso o where 1=1 ");
        } else {
            jpaql.append(" select o from Ingreso o where 1=1 ");           
        } 
		if (!StringUtils.isNullOrEmpty(Ingreso.getSearch())) {
	          jpaql.append(" and upper(o.idIngreso) like :search ");
	          parametros.put("search", "%" + Ingreso.getSearch().toUpperCase() + "%");
	    } 
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.IngresoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.IngresoDTO)
     */
	@Override
    public int contarListarIngreso(IngresoDTO Ingreso) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaIngreso(Ingreso, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.IngresoDaoLocal#generarIdIngreso()
     */
	 @Override
    public String generarIdIngreso() { 
		return UUIDUtil.generarElementUUID();
    }
 
 
}