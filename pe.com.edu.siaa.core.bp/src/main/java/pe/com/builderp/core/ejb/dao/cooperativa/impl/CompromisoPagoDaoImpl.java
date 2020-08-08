package pe.com.builderp.core.ejb.dao.cooperativa.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.CompromisoPagoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.CompromisoPago;
import pe.com.builderp.core.model.vo.cooperativa.CompromisoPagoDTO;
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
public class CompromisoPagoDaoImpl extends  GenericFacturacionDAOImpl<String, CompromisoPago> implements CompromisoPagoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<CompromisoPago> listarCompromisoPago(CompromisoPagoDTO CompromisoPago) {
        Query query = generarQueryListaCompromisoPago(CompromisoPago, false);
        query.setFirstResult(CompromisoPago.getStartRow());
        query.setMaxResults(CompromisoPago.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista CompromisoPago.
     *
     * @param CompromisoPagoDTO el CompromisoPago
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaCompromisoPago(CompromisoPagoDTO CompromisoPago, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idCompromisoPago) from CompromisoPago o where 1=1 ");
        } else {
            jpaql.append(" select o from CompromisoPago o where 1=1 ");           
        }
        if (!StringUtils.isNullOrEmpty(CompromisoPago.getId())) {
			jpaql.append(" and o.montoCiere is null "); 
		} 
        
		if (!StringUtils.isNullOrEmpty(CompromisoPago.getSearch())) {
	          jpaql.append(" and upper(o.idCompromisoPago) like :search ");
	          parametros.put("search", "%" + CompromisoPago.getSearch().toUpperCase() + "%");
	    } 
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.CompromisoPagoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.CompromisoPagoDTO)
     */
	@Override
    public int contarListarCompromisoPago(CompromisoPagoDTO CompromisoPago) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaCompromisoPago(CompromisoPago, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.CompromisoPagoDaoLocal#generarIdCompromisoPago()
     */
	 @Override
    public String generarIdCompromisoPago() { 
		return UUIDUtil.generarElementUUID();
    }
  
}