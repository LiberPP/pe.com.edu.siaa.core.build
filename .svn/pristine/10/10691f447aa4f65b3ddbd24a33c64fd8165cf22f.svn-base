package pe.com.builderp.core.facturacion.ejb.dao.venta.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.contabilidad.model.vo.RegistroAsientoFiltroVO;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.VentaDaoLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.VentaDTO;
import pe.com.builderp.core.facturacion.model.jpa.venta.Venta;
import pe.com.builderp.core.facturacion.model.vo.venta.RegistroVentaVO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.factory.ConstanteQueryNameUtil;
import pe.com.edu.siaa.core.ejb.factory.SqlMapingUtil;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.jdbc.generic.GenericJDBC;
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.model.jdbc.vo.ScriptSqlResulJDBCVO;
import pe.com.edu.siaa.core.model.util.ObjectUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class VentaDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:59 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class VentaDaoImpl extends  GenericFacturacionDAOImpl<String, Venta> implements VentaDaoLocal  {

	@Override	 
	 public List<Map<String,Object>> listarVentaReporteTXT(RegistroAsientoFiltroVO registroVentaFiltroVO) throws Exception {
		Map<String,String> formatoFechaMap = new HashMap<String,String>();
		formatoFechaMap.put("fechaEmision", FechaUtil.DATE_DMY);
		formatoFechaMap.put("fechaVencimientoOPago", FechaUtil.DATE_DMY);
		formatoFechaMap.put("fehaRefComprobanteDocModifica", FechaUtil.DATE_DMY);
		ScriptSqlResulJDBCVO resultadoTemp = obtenerScriptSqlTXT(registroVentaFiltroVO,false);
		return resultadoTemp.getListaData();
	}
		 
	@Override	 
	public  int contarListarVentaReporteTXT(RegistroAsientoFiltroVO registroVentaFiltroVO) {
		int resultado = 0;
		try {
			resultado = Integer.parseInt(obtenerScriptSqlTXT(registroVentaFiltroVO,true).getListaData().get(0).get("CONTADOR") + "");
		} catch (Exception e) {
			resultado = 0;
		}
		return resultado;	 
	}

	
	 @Override	 
	 public List<RegistroVentaVO> listarVentaReporte(RegistroAsientoFiltroVO registroVentaFiltroVO) throws Exception {
		List<RegistroVentaVO> resultado = new ArrayList<RegistroVentaVO>();
		Map<String,String> formatoFechaMap = new HashMap<String,String>();
		formatoFechaMap.put("fechaEmision", FechaUtil.DATE_DMY);
		formatoFechaMap.put("fechaVencimientoOPago", FechaUtil.DATE_DMY);
		formatoFechaMap.put("fehaRefComprobanteDocModifica", FechaUtil.DATE_DMY);
		ScriptSqlResulJDBCVO resultadoTemp = obtenerScriptSql(registroVentaFiltroVO,false);
		resultado = TransferDataObjectUtil.transferObjetoEntityListVO(resultadoTemp, RegistroVentaVO.class, formatoFechaMap);
		return resultado;
	}
		 
	@Override	 
	public  int contarListarVentaReporte(RegistroAsientoFiltroVO registroVentaFiltroVO) {
		int resultado = 0;
		try {
			resultado = Integer.parseInt(obtenerScriptSql(registroVentaFiltroVO,true).getListaData().get(0).get("CONTADOR") + "");
		} catch (Exception e) {
			resultado = 0;
		}
		return resultado;	 
	}

	private ScriptSqlResulJDBCVO obtenerScriptSqlTXT(RegistroAsientoFiltroVO registroVentaFiltroVO, boolean isContador) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("fechaInicio", registroVentaFiltroVO.getFechaAsientoDesde());
		parametros.put("fechaFin", registroVentaFiltroVO.getFechaAsientoHasta());
		
		parametros.put("ejercicio", registroVentaFiltroVO.getEjercicio());
		parametros.put("periodo", registroVentaFiltroVO.getPeriodo());
		
		parametros.put("idEntidad", registroVentaFiltroVO.getIdEntidad());
		//parametros.putAll(parametroFiltroMap);
		StringBuilder filtroDinamic = new StringBuilder();
		if (!isContador) {
			parametros.put("offset", registroVentaFiltroVO.getOffset());
			parametros.put("startRow", registroVentaFiltroVO.getStartRow());
			sql.append(SqlMapingUtil.obtenerSqlSentenciaBuildERP(ConstanteQueryNameUtil.REPORTE_TXT_OBTENER_REGISTRO_VENTA)); 
		 } else {
			sql.append(SqlMapingUtil.obtenerSqlSentenciaBuildERP(ConstanteQueryNameUtil.REPORTE_TXT_CONTAR_OBTENER_REGISTRO_VENTA));
		}
		sql = new StringBuilder(sql.toString().replace("${filtroDinamic}", filtroDinamic));
		return GenericJDBC.executeQuery(sql, parametros);
	}
	
	private ScriptSqlResulJDBCVO obtenerScriptSql(RegistroAsientoFiltroVO registroVentaFiltroVO, boolean isContador) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idEntidad", registroVentaFiltroVO.getIdEntidad());
		parametros.put("idEnteUniversitaria", ObjectUtil.objectToLong(registroVentaFiltroVO.getCodigoEntidadUniversitaria()));
		
		//parametros.putAll(parametroFiltroMap);
		StringBuilder filtroDinamic = new StringBuilder();
		StringBuilder filtroDinamicUnion = new StringBuilder();
		if (!isContador) {
			parametros.put("offset", registroVentaFiltroVO.getOffset());
			parametros.put("startRow", registroVentaFiltroVO.getStartRow());
			sql.append(SqlMapingUtil.obtenerSqlSentenciaBuildERP(ConstanteQueryNameUtil.REPORTE_XLSX_OBTENER_REGISTRO_VENTA)); 
		 } else {
			sql.append(SqlMapingUtil.obtenerSqlSentenciaBuildERP(ConstanteQueryNameUtil.REPORTE_XLSX_CONTAR_OBTENER_REGISTRO_VENTA));
		}
		if (StringUtils.isNotNullOrBlank(registroVentaFiltroVO.getFechaAsientoDesde())) {
			filtroDinamic.append("  and to_date(to_char( fechaPago,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date(:fechaInicio,'dd/mm/yyyy') ");
			filtroDinamicUnion.append("  and to_date(to_char( fechaVenta,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date(:fechaVentaInicio,'dd/mm/yyyy') ");
			parametros.put("fechaInicio", FechaUtil.obtenerFechaFormatoSimple(registroVentaFiltroVO.getFechaAsientoDesde()));
			parametros.put("fechaVentaInicio", FechaUtil.obtenerFechaFormatoSimple(registroVentaFiltroVO.getFechaAsientoDesde()));
		}
        if (StringUtils.isNotNullOrBlank(registroVentaFiltroVO.getFechaAsientoHasta())) {
        	filtroDinamic.append("  and to_date(to_char( fechaPago,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date(:fechaFin,'dd/mm/yyyy') ");
        	filtroDinamicUnion.append("  and to_date(to_char( fechaVenta,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date(:fechaVentaFin,'dd/mm/yyyy') ");
			parametros.put("fechaFin", FechaUtil.obtenerFechaFormatoSimple(registroVentaFiltroVO.getFechaAsientoHasta()));
			parametros.put("fechaVentaFin", FechaUtil.obtenerFechaFormatoSimple(registroVentaFiltroVO.getFechaAsientoHasta()));
		}
        if (StringUtils.isNotNullOrBlank(registroVentaFiltroVO.getEjercicio())) {
			filtroDinamic.append("  and to_char( fechaPago,'yyyy') =:ejercicio ");
			filtroDinamicUnion.append(" and to_char( fechaVenta,'yyyy') =:ejercicioVenta ");
			parametros.put("ejercicio", registroVentaFiltroVO.getEjercicio());
			parametros.put("ejercicioVenta", registroVentaFiltroVO.getEjercicio());
		}
        if (StringUtils.isNotNullOrBlank(registroVentaFiltroVO.getPeriodo())) {
			filtroDinamic.append(" and to_char( fechaPago,'mm') =:periodo  ");
			filtroDinamicUnion.append(" and to_char( fechaVenta,'mm') =:periodoVenta ");
			parametros.put("periodo", registroVentaFiltroVO.getPeriodo());
			parametros.put("periodoVenta", registroVentaFiltroVO.getPeriodo());
		}
        filtroDinamicUnion.append(" and cp.idEntidad =:idEntidad "); 
        filtroDinamic.append(" and per.idEntidadUniversitaria =:idEnteUniversitaria "); 
        
        if (StringUtils.isNotNullOrBlank(registroVentaFiltroVO.getIdEntidad())) {
			filtroDinamic.append("");
		}
		sql = new StringBuilder(sql.toString().replace("${filtroDinamic}", filtroDinamic));
		sql = new StringBuilder(sql.toString().replace("${filtroDinamicUnion}", filtroDinamicUnion));
		return GenericJDBC.executeQuery(sql, parametros);
	}
	
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.VentaDaoLocal#listarVenta(pe.com.builderp.core.facturacion.model.jpa.venta.Venta)
     */  
    @Override	 
    public List<Venta> listarVenta(VentaDTO venta) {
        Query query = generarQueryListaVenta(venta, false);
        query.setFirstResult(venta.getStartRow());
        query.setMaxResults(venta.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Venta.
     *
     * @param VentaDTO el venta
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaVenta(VentaDTO venta, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idVenta) from Venta o where 1=1 ");
        } else {
            jpaql.append(" select o from Venta o  left join fetch o.tipoDocSunat ");
            jpaql.append(" left join fetch o.itemByTipoMoneda left join fetch o.pedido  "); 
            jpaql.append(" left join fetch o.cliente  where 1=1 ");
        }
		if (!StringUtils.isNullOrEmpty(venta.getSearch())) {
	          jpaql.append(" and upper(o.idVenta) like :search ");
	          parametros.put("search", "%" + venta.getSearch().toUpperCase() + "%");
	    } else {
			if (!StringUtils.isNullOrEmptyNumeric(venta.getTipoCambio())) {
				jpaql.append(" and o.tipoCambio = :tipoCambio ");
				parametros.put("tipoCambio", venta.getTipoCambio());
			}
			if (!StringUtils.isNullOrEmpty(venta.getNroDoc())) {
				jpaql.append(" and upper(o.nroDoc) like :nroDoc ");
				parametros.put("nroDoc", "%" + venta.getNroDoc().toUpperCase() + "%");
			}

			if (!StringUtils.isNullOrEmptyNumeric(venta.getIgv())) {
				jpaql.append(" and o.igv = :igv ");
				parametros.put("igv", venta.getIgv());
			}
			if (!StringUtils.isNullOrEmptyNumeric(venta.getDescuentoTotal())) {
				jpaql.append(" and o.descuentoTotal = :descuentoTotal ");
				parametros.put("descuentoTotal", venta.getDescuentoTotal());
			}
			if (!StringUtils.isNullOrEmptyNumeric(venta.getSubMontoTotal())) {
				jpaql.append(" and o.subMontoTotal = :subMontoTotal ");
				parametros.put("subMontoTotal", venta.getSubMontoTotal());
			}
			if (!StringUtils.isNullOrEmptyNumeric(venta.getMontoTotal())) {
				jpaql.append(" and o.montoTotal = :montoTotal ");
				parametros.put("montoTotal", venta.getMontoTotal());
			}
			if (!StringUtils.isNullOrEmpty(venta.getFechaVenta())) {
				jpaql.append(" and o.fechaVenta = :fechaVenta ");
				parametros.put("fechaVenta", venta.getFechaVenta());
			}
			if (!StringUtils.isNullOrEmptyNumeric(venta.getNroCorrelativoOperacion())) {
				jpaql.append(" and o.nroCorrelativoOperacion = :nroCorrelativoOperacion ");
				parametros.put("nroCorrelativoOperacion", venta.getNroCorrelativoOperacion());
			}
			if (!StringUtils.isNullOrEmpty(venta.getFechaCreacion())) {
				jpaql.append(" and o.fechaCreacion = :fechaCreacion ");
				parametros.put("fechaCreacion", venta.getFechaCreacion());
			}
			if (!StringUtils.isNullOrEmpty(venta.getUsuarioCreacion())) {
				jpaql.append(" and upper(o.usuarioCreacion) like :usuarioCreacion ");
				parametros.put("usuarioCreacion", "%" + venta.getUsuarioCreacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(venta.getFechaModificacion())) {
				jpaql.append(" and o.fechaModificacion = :fechaModificacion ");
				parametros.put("fechaModificacion", venta.getFechaModificacion());
			}
			if (!StringUtils.isNullOrEmpty(venta.getUsuarioModificacion())) {
				jpaql.append(" and upper(o.usuarioModificacion) like :usuarioModificacion ");
				parametros.put("usuarioModificacion", "%" + venta.getUsuarioModificacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(venta.getEstado())) {
				jpaql.append(" and upper(o.estado) like :estado ");
				parametros.put("estado", "%" + venta.getEstado().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(venta.getIpAcceso())) {
				jpaql.append(" and upper(o.ipAcceso) like :ipAcceso ");
				parametros.put("ipAcceso", "%" + venta.getIpAcceso().toUpperCase() + "%");
			}
		}
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.VentaDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.VentaDTO)
     */
	@Override
    public int contarListarVenta(VentaDTO venta) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaVenta(venta, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.VentaDaoLocal#generarIdVenta()
     */
	 @Override
    public String generarIdVenta() {
        return UUIDUtil.generarElementUUID();
    }
   
}