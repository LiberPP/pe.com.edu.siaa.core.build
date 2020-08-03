package pe.com.builderp.core.facturacion.ejb.dao.venta.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetalleVentaDaoLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.DetalleVentaDTO;
import pe.com.builderp.core.facturacion.model.jpa.venta.DetalleVenta;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class DetalleVentaDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:57 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class DetalleVentaDaoImpl extends  GenericFacturacionDAOImpl<String, DetalleVenta> implements DetalleVentaDaoLocal  {


    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetalleVentaDaoLocal#listarDetalleVenta(pe.com.builderp.core.facturacion.model.jpa.venta.DetalleVenta)
     */  
    @Override	 
    public List<DetalleVenta> listarDetalleVenta(DetalleVentaDTO detalleVenta) {
        Query query = generarQueryListaDetalleVenta(detalleVenta, false);
        query.setFirstResult(detalleVenta.getStartRow());
        query.setMaxResults(detalleVenta.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista DetalleVenta.
     *
     * @param DetalleVentaDTO el detalleVenta
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaDetalleVenta(DetalleVentaDTO detalleVenta, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idDetalleVenta) from DetalleVenta o where 1=1 ");
        } else {
            jpaql.append(" select o from DetalleVenta o left join fetch o.producto where 1=1 ");           
        }
        jpaql.append(" and o.venta.idVenta = :idVenta ");
      	parametros.put("idVenta", detalleVenta.getId() + "");
		if (!StringUtils.isNullOrEmpty(detalleVenta.getSearch())) {
	          jpaql.append(" and upper(o.idDetalleVenta) like :search ");
	          parametros.put("search", "%" + detalleVenta.getSearch().toUpperCase() + "%");
	    } else {
			if (!StringUtils.isNullOrEmpty(detalleVenta.getDescripcionProducto())) {
				jpaql.append(" and upper(o.descripcionProducto) like :descripcionProducto ");
				parametros.put("descripcionProducto", "%" + detalleVenta.getDescripcionProducto().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmptyNumeric(detalleVenta.getPrecio())) {
				jpaql.append(" and o.precio = :precio ");
				parametros.put("precio", detalleVenta.getPrecio());
			}
			if (!StringUtils.isNullOrEmptyNumeric(detalleVenta.getCantidad())) {
				jpaql.append(" and o.cantidad = :cantidad ");
				parametros.put("cantidad", detalleVenta.getCantidad());
			}
			if (!StringUtils.isNullOrEmptyNumeric(detalleVenta.getDescuento())) {
				jpaql.append(" and o.descuento = :descuento ");
				parametros.put("descuento", detalleVenta.getDescuento());
			}
			if (!StringUtils.isNullOrEmptyNumeric(detalleVenta.getSubMontoTotal())) {
				jpaql.append(" and o.subMontoTotal = :subMontoTotal ");
				parametros.put("subMontoTotal", detalleVenta.getSubMontoTotal());
			}
			if (!StringUtils.isNullOrEmptyNumeric(detalleVenta.getMontoTotal())) {
				jpaql.append(" and o.montoTotal = :montoTotal ");
				parametros.put("montoTotal", detalleVenta.getMontoTotal());
			}
		}
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetalleVentaDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.DetalleVentaDTO)
     */
	@Override
    public int contarListarDetalleVenta(DetalleVentaDTO detalleVenta) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaDetalleVenta(detalleVenta, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetalleVentaDaoLocal#generarIdDetalleVenta()
     */
	 @Override
    public String generarIdDetalleVenta() {
        return UUIDUtil.generarElementUUID();
    }
   
}