package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.DetCobranzaDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.DetCobranza;
import pe.com.builderp.core.model.vo.cooperativa.DetCobranzaDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericAcademicoDAOImpl; 
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil; 
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class DetCobranzaDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 19:53:46 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class DetCobranzaDaoImpl extends  GenericAcademicoDAOImpl<String, DetCobranza> implements DetCobranzaDaoLocal  {

	
	@Override
	public List<DetCobranza> listarDetCobranza(String idControlPago) throws Exception {
		Query query = createQuery("from DetCobranza DetCobranza  where DetCobranza.controlPago.idControlPago = :idControlPago order by to_number(DetCobranza.nroCuota,'') asc,DetCobranza.controlPago.fechaPago asc ",null);
		query.setParameter("idControlPago", idControlPago);
		return query.getResultList();
	}
	
	@Override
	public List<DetCobranza> listarDetCobranzaByDetPlan(String idDetPlanpagos) throws Exception {
		Query query = createQuery("from DetCobranza DetCobranza  where DetCobranza.detPlanPagos.idDetPlanPagos = :idDetPlanPagos order by to_number(DetCobranza.nroCuota,'') asc,DetCobranza.controlPago.fechaPago asc ",null);
		query.setParameter("idDetPlanPagos", idDetPlanpagos);
		return query.getResultList();
	}
	
	@Override
	public BigDecimal listarSumaControlpagoByDetplanpagos(String idDetPlanpagos) throws Exception {
		Query query = createQuery("select sum (DetCobranza.monto) from DetCobranza DetCobranza  where DetCobranza.credito.idCredito = :idDetPlanPagos ",null);
		query.setParameter("idDetPlanPagos", idDetPlanpagos);
		return ((BigDecimal) query.getSingleResult());
	}
	
	 @Override
	 public String generarIdDetCobranza(String idControlPago) throws Exception {
			String resultado = FechaUtil.obtenerFechaFormatoPersonalizado(FechaUtil.obtenerFecha(), "ddMMyyyy") + "000001";
			Query query = createQuery("select max(dcp.idDetCobranza) from DetCobranza dcp",null);
			//query.setParameter("idControlPago", idControlPago);
			List<String> listLong =  query.getResultList();
			if (listLong != null && listLong.size() > 0) {
				String ultimoIdGenerado = listLong.get(0);
				if (StringUtils.isNotNullOrBlank(ultimoIdGenerado)) {
					long ultimoId = Long.parseLong(ultimoIdGenerado.trim());
					ultimoId++;
					resultado = "" + ultimoId;
				}
			}
			return resultado;
	}
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.DetCobranzaDaoLocal#listarDetCobranza(pe.com.edu.siaa.core.model.jpa.seguridad.DetCobranza)
     */  
    @Override	 
    public List<DetCobranza> listarDetCobranza(DetCobranzaDTO DetCobranza) {
        Query query = generarQueryListaDetCobranza(DetCobranza, false);
        query.setFirstResult(DetCobranza.getStartRow());
        query.setMaxResults(DetCobranza.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista DetCobranza.
     *
     * @param DetCobranzaDTO el DetCobranza
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaDetCobranza(DetCobranzaDTO DetCobranza, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idDetCobranza) from DetCobranza o where 1=1 ");
        } else {
            jpaql.append(" select o from DetCobranza o where 1=1 ");           
        }
        
		 if (!StringUtils.isNullOrEmpty(DetCobranza.getListidEgresados())) {
		        jpaql.append(" and o.cobranza.idCobranza in(:listaIdPlanPagos) ");
		        parametros.put("listaIdPlanPagos", DetCobranza.getListidEgresados());
		 }
		 
		 if (!StringUtils.isNullOrEmpty(DetCobranza.getId())) {
		        jpaql.append(" and o.credito.idCredito =:idDetPlanPagos ");
		        parametros.put("idDetPlanPagos", DetCobranza.getId());
		 }
		 
		if (!StringUtils.isNullOrEmpty(DetCobranza.getSearch())) {
	          jpaql.append(" and upper(o.idDetCobranza) like :search ");
	          parametros.put("search", "%" + DetCobranza.getSearch().toUpperCase() + "%");
	    } else {
			if (!StringUtils.isNullOrEmpty(DetCobranza.getDescripcionConcepto())) {
				jpaql.append(" and upper(o.descripcionConcepto) like :descripcionConcepto ");
				parametros.put("descripcionConcepto", "%" + DetCobranza.getDescripcionConcepto().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmptyNumeric(DetCobranza.getMonto())) {
				jpaql.append(" and o.monto = :monto ");
				parametros.put("monto", DetCobranza.getMonto());
			}
			if (!StringUtils.isNullOrEmptyNumeric(DetCobranza.getMora())) {
				jpaql.append(" and o.mora = :mora ");
				parametros.put("mora", DetCobranza.getMora());
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getFechaReversion())) {
				jpaql.append(" and o.fechaReversion = :fechaReversion ");
				parametros.put("fechaReversion", DetCobranza.getFechaReversion());
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getFechaCreacion())) {
				jpaql.append(" and o.fechaCreacion = :fechaCreacion ");
				parametros.put("fechaCreacion", DetCobranza.getFechaCreacion());
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getUsuarioCreacion())) {
				jpaql.append(" and upper(o.usuarioCreacion) like :usuarioCreacion ");
				parametros.put("usuarioCreacion", "%" + DetCobranza.getUsuarioCreacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getFechaModificacion())) {
				jpaql.append(" and o.fechaModificacion = :fechaModificacion ");
				parametros.put("fechaModificacion", DetCobranza.getFechaModificacion());
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getUsuarioModificacion())) {
				jpaql.append(" and upper(o.usuarioModificacion) like :usuarioModificacion ");
				parametros.put("usuarioModificacion", "%" + DetCobranza.getUsuarioModificacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getEstado())) {
				jpaql.append(" and upper(o.estado) like :estado ");
				parametros.put("estado", "%" + DetCobranza.getEstado().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(DetCobranza.getIp())) {
				jpaql.append(" and upper(o.ip) like :ip ");
				parametros.put("ip", "%" + DetCobranza.getIp().toUpperCase() + "%");
			}
		}
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.DetCobranzaDaoLocal#contarListar{entity.getClassName()}(pe.com.edu.siaa.core.model.jpa.seguridad.DetCobranzaDTO)
     */
	@Override
    public int contarListarDetCobranza(DetCobranzaDTO DetCobranza) {
        int resultado = 0;
        try {
            Query query = generarQueryListaDetCobranza(DetCobranza, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.DetCobranzaDaoLocal#generarIdDetCobranza()
     */
	 @Override
    public String generarIdDetCobranza() {
        String resultado = "1";
        Query query = createQuery("select max(o.idDetCobranza) from DetCobranza o", null);
        List<Object> listLong =  query.getResultList();
        if (listLong != null && listLong.size() > 0 && listLong.get(0) != null)  {
            Long ultimoIdGenerado = Long.valueOf(listLong.get(0).toString());
            if (!StringUtils.isNullOrEmpty(ultimoIdGenerado)) {
                resultado = resultado + ultimoIdGenerado;
            }
        }
        return resultado;
    }
   
		@Override
		public List<DetCobranza> listaDetCobranza(String idCobranza) throws Exception {
			Map<String, Object> parametros = new HashMap<String, Object>();
			boolean ejecutarQuery = false;
			StringBuilder jpaql = new StringBuilder();
			jpaql.append("from DetCobranza dm left join fetch dm.cobranza  left join fetch dm.credito where 1 = 1 ");
			if (StringUtils.isNotNullOrBlank(idCobranza)) {
				ejecutarQuery = true;
				jpaql.append(" and dm.cobranza.idCobranza=:idCobranza ");
				parametros.put("idCobranza", idCobranza);
			}
			//jpaql.append(" order by dm.detCargaLectiva.detPlanEstudio.descripcionCurso");
			if (ejecutarQuery) {		
				Query query = createQuery(jpaql.toString(), parametros);
				return query.getResultList();
			} 
			return null;
		}
		
		@Override
		public DetCobranza findByDetCobranza(String idDetPlanpagos) throws Exception {
			DetCobranza resultado = null;
			StringBuilder jpaql = new StringBuilder();
			jpaql.append("from DetCobranza dm left join fetch dm.cobranza  left join fetch dm.credito ");
			jpaql.append(" where dm.credito.idCredito =:idDetPlanpagos and to_char(dm.fechaCreacion,'dd/MM/yyyy')=:fechaActual ");
			Query query = createQuery(jpaql.toString(),null);
			query.setParameter("idDetPlanpagos", idDetPlanpagos);
			query.setParameter("fechaActual",FechaUtil.obtenerFechaFormatoPersonalizado(FechaUtil.obtenerFecha(), "dd/MM/yyyy"));
			List<DetCobranza> listaAlumno = query.getResultList();
			if (listaAlumno != null && listaAlumno.size() > 0) {
				resultado = listaAlumno.get(0);
			}
			return resultado;	
		}
		
		@Override
		public DetCobranza findByDetCobranzaByCon(String idControl) throws Exception {
			DetCobranza resultado = null;
			StringBuilder jpaql = new StringBuilder();
			jpaql.append("from DetCobranza dm left join fetch dm.cobranza  left join fetch dm.credito ");
			jpaql.append(" where dm.cobranza.idCobranza =:idControlPago ");
			Query query = createQuery(jpaql.toString(),null);
			query.setParameter("idControlPago", idControl); 
			List<DetCobranza> listaAlumno = query.getResultList();
			if (listaAlumno != null && listaAlumno.size() > 0) {
				resultado = listaAlumno.get(0);
			}
			return resultado;	
		}
		
}