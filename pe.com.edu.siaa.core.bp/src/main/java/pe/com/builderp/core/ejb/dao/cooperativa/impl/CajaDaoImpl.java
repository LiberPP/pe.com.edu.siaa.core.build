package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.CajaDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.Caja;
import pe.com.builderp.core.model.vo.cooperativa.CajaDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.model.estate.EstadoGeneralState; 
import pe.com.edu.siaa.core.model.util.ObjectUtil;
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
public class CajaDaoImpl extends  GenericFacturacionDAOImpl<String, Caja> implements CajaDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<Caja> listarCaja(CajaDTO Caja) {
        Query query = generarQueryListaCaja(Caja, false);
        query.setFirstResult(Caja.getStartRow());
        query.setMaxResults(Caja.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Caja.
     *
     * @param CajaDTO el Caja
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaCaja(CajaDTO Caja, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idCaja) from Caja o where 1=1 ");
        } else {
            jpaql.append(" select o from Caja o where 1=1 ");           
        }
        if (!StringUtils.isNullOrEmpty(Caja.getId())) {
			jpaql.append(" and o.montoCiere is null "); 
		} 
        
		if (!StringUtils.isNullOrEmpty(Caja.getSearch())) {
	          jpaql.append(" and upper(o.idCaja) like :search ");
	          parametros.put("search", "%" + Caja.getSearch().toUpperCase() + "%");
	    } 
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.CajaDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.CajaDTO)
     */
	@Override
    public int contarListarCaja(CajaDTO Caja) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaCaja(Caja, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.CajaDaoLocal#generarIdCaja()
     */
	 @Override
    public String generarIdCaja() {
       /* String resultado = "1";
        Query query = createQuery("select max(o.idCaja) from Caja o", null);
        List<Object> listLong =  query.getResultList();
        if (listLong != null && listLong.size() > 0 && listLong.get(0) != null)  {
            Long ultimoIdGenerado = Long.valueOf(listLong.get(0).toString());
            if (!StringUtils.isNullOrEmpty(ultimoIdGenerado)) {
                resultado = resultado + ultimoIdGenerado;
            }
        }
        return resultado;*/
		return UUIDUtil.generarElementUUID();
    }
 
		@Override
		public void updateCajaCierre(CajaDTO caja) throws Exception {
			 Map<String, Object> parametros = new HashMap<String, Object>();
			 parametros.put("montoTotal",caja.getMontoTotal());
			 parametros.put("horacierre", FechaUtil.obtenerHoraMinutos());
			 parametros.put("fecha", caja.getFechaActual());
			 parametros.put("userName", caja.getAdmin());
			 Query query = createNativeQuery("UPDATE cooperativa.caja SET usuariomodificacion=:userName, estado='C', fechamodificacion=:fecha,  montototal=:montoTotal,montociere=:montoTotal,horacierre=:horacierre where montociere is null ",parametros);
			 query.executeUpdate();
			
		}
		
		
		@Override
		public Caja findByCaja() throws Exception {
			Caja resultado = null;
			StringBuilder jpaql = new StringBuilder();
			jpaql.append("from Caja a  ");
			jpaql.append(" where a.montoCiere is null");
			Query query = createQuery(jpaql.toString(),null); 
			List<Caja> listaAlumno = query.getResultList();
			if (listaAlumno != null && listaAlumno.size() > 0) {
				resultado = listaAlumno.get(0);
			}
			return resultado;	
		}
		
	@Override
	public Caja findByCaja(String idUsuario) throws Exception {
		Caja resultado = null;
		StringBuilder jpaql = new StringBuilder();
		jpaql.append("from Caja a  ");
		jpaql.append(" where a.montoCiere is null and a.usuario.idUsuario=:idUsuario");
		Query query = createQuery(jpaql.toString(),null); 
		query.setParameter("idUsuario", idUsuario);
		List<Caja> listaAlumno = query.getResultList();
		if (listaAlumno != null && listaAlumno.size() > 0) {
			resultado = listaAlumno.get(0);
		}
		return resultado;	
	}
	
	
	@Override
	public Caja findByCajaFecha(String idUsuario,Date fecha) throws Exception {
		Caja resultado = null;
		StringBuilder jpaql = new StringBuilder();
		jpaql.append("from Caja a  ");
		jpaql.append(" where a.montoCiere is null and a.usuario.idUsuario=:idUsuario and to_char(a.fechaCreacion,'dd/MM/yyyy')=:fecha ");
		Query query = createQuery(jpaql.toString(),null); 
		query.setParameter("idUsuario", idUsuario);
		query.setParameter("fecha", FechaUtil.obtenerFechaFormatoPersonalizado(fecha, "dd/MM/yyyy"));
		List<Caja> listaAlumno = query.getResultList();
		if (listaAlumno != null && listaAlumno.size() > 0) {
			resultado = listaAlumno.get(0);
		}
		return resultado;	
	}
}