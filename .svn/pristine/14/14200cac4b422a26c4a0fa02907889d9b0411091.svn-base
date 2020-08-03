package pe.com.builderp.core.facturacion.ejb.dao.venta.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.ProformaDTO;
import pe.com.builderp.core.facturacion.model.jpa.venta.Proforma;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
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
public class ProformaDaoImpl extends  GenericFacturacionDAOImpl<String, Proforma> implements ProformaDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<Proforma> listarProforma(ProformaDTO proforma) {
        Query query = generarQueryListaProforma(proforma, false);
        query.setFirstResult(proforma.getStartRow());
        query.setMaxResults(proforma.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Proforma.
     *
     * @param ProformaDTO el proforma
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaProforma(ProformaDTO proforma, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idProforma) from Proforma o where 1=1 ");
        } else {
            jpaql.append(" select o from Proforma o where 1=1 ");           
        }
		if (!StringUtils.isNullOrEmpty(proforma.getSearch())) {
	          jpaql.append(" and upper(o.idProforma) like :search ");
	          parametros.put("search", "%" + proforma.getSearch().toUpperCase() + "%");
	    } else {
			if (!StringUtils.isNullOrEmpty(proforma.getCodigoProforma())) {
				jpaql.append(" and upper(o.codigoProforma) like :codigoProforma ");
				parametros.put("codigoProforma", "%" + proforma.getCodigoProforma().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmptyNumeric(proforma.getTipoCambio())) {
				jpaql.append(" and o.tipoCambio = :tipoCambio ");
				parametros.put("tipoCambio", proforma.getTipoCambio());
			}
			if (!StringUtils.isNullOrEmpty(proforma.getNroDoc())) {
				jpaql.append(" and upper(o.nroDoc) like :nroDoc ");
				parametros.put("nroDoc", "%" + proforma.getNroDoc().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmptyNumeric(proforma.getProcentajeIgv())) {
				jpaql.append(" and o.procentajeIgv = :procentajeIgv ");
				parametros.put("procentajeIgv", proforma.getProcentajeIgv());
			}
			if (!StringUtils.isNullOrEmptyNumeric(proforma.getIgv())) {
				jpaql.append(" and o.igv = :igv ");
				parametros.put("igv", proforma.getIgv());
			}
			if (!StringUtils.isNullOrEmptyNumeric(proforma.getDescuentoTotal())) {
				jpaql.append(" and o.descuentoTotal = :descuentoTotal ");
				parametros.put("descuentoTotal", proforma.getDescuentoTotal());
			}
			if (!StringUtils.isNullOrEmptyNumeric(proforma.getSubMontoTotal())) {
				jpaql.append(" and o.subMontoTotal = :subMontoTotal ");
				parametros.put("subMontoTotal", proforma.getSubMontoTotal());
			}
			if (!StringUtils.isNullOrEmptyNumeric(proforma.getMontoTotal())) {
				jpaql.append(" and o.montoTotal = :montoTotal ");
				parametros.put("montoTotal", proforma.getMontoTotal());
			}
			if (!StringUtils.isNullOrEmpty(proforma.getFechaProforma())) {
				jpaql.append(" and o.fechaProforma = :fechaProforma ");
				parametros.put("fechaProforma", proforma.getFechaProforma());
			}
			if (!StringUtils.isNullOrEmpty(proforma.getFechaCreacion())) {
				jpaql.append(" and o.fechaCreacion = :fechaCreacion ");
				parametros.put("fechaCreacion", proforma.getFechaCreacion());
			}
			if (!StringUtils.isNullOrEmpty(proforma.getUsuarioCreacion())) {
				jpaql.append(" and upper(o.usuarioCreacion) like :usuarioCreacion ");
				parametros.put("usuarioCreacion", "%" + proforma.getUsuarioCreacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(proforma.getFechaModificacion())) {
				jpaql.append(" and o.fechaModificacion = :fechaModificacion ");
				parametros.put("fechaModificacion", proforma.getFechaModificacion());
			}
			if (!StringUtils.isNullOrEmpty(proforma.getUsuarioModificacion())) {
				jpaql.append(" and upper(o.usuarioModificacion) like :usuarioModificacion ");
				parametros.put("usuarioModificacion", "%" + proforma.getUsuarioModificacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(proforma.getEstado())) {
				jpaql.append(" and upper(o.estado) like :estado ");
				parametros.put("estado", "%" + proforma.getEstado().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(proforma.getIpAcceso())) {
				jpaql.append(" and upper(o.ipAcceso) like :ipAcceso ");
				parametros.put("ipAcceso", "%" + proforma.getIpAcceso().toUpperCase() + "%");
			}
		}
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.ProformaDTO)
     */
	@Override
    public int contarListarProforma(ProformaDTO proforma) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaProforma(proforma, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#generarIdProforma()
     */
	 @Override
    public String generarIdProforma() {
        String resultado = "1";
        Query query = createQuery("select max(o.idProforma) from Proforma o", null);
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