package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.FraccionamientoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.Fraccionamiento;
import pe.com.builderp.core.model.vo.cooperativa.FraccionamientoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericAcademicoDAOImpl; 
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class FraccionamientoDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 19:53:34 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class FraccionamientoDaoImpl extends  GenericAcademicoDAOImpl<String, Fraccionamiento> implements FraccionamientoDaoLocal  {

	
	@Override
	public String generarIdFraccionamiento(String idDetPlanPagos) throws Exception {
		 Map<String, Object> parametros = new HashMap<String, Object>();
		String resultado = idDetPlanPagos.trim() + "01";
		Query query = createQuery("select max(f.idFraccionamiento) from Fraccionamiento f where f.credito.idCredito=:idDetPlanPagos",parametros);
		query.setParameter("idDetPlanPagos", idDetPlanPagos);
		List<String> listCodigo =  query.getResultList();
		if (listCodigo != null && listCodigo.size() > 0) {
			String ultimoIdGenerado = listCodigo.get(0);
			if (StringUtils.isNotNullOrBlank(ultimoIdGenerado)) {
				ultimoIdGenerado = ultimoIdGenerado.trim();
				int len = ultimoIdGenerado.length();
				String ultimoIdGeneradoIzquierdo = ultimoIdGenerado.substring(0, len - 2);
				Long ultimoId = Long.parseLong(ultimoIdGenerado.substring(len - 2, len));
				ultimoId++;
				String ultimoIdGeneradoDerecho = StringUtils.completeLeft(ultimoId, '0', 2);
				resultado = ultimoIdGeneradoIzquierdo + ultimoIdGeneradoDerecho;
			}
		}
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see pe.edu.upp.siaa.pago.dao.FraccionamientoDaoLocal#actualizarMontoResta(pe.edu.upp.siaa.entity.Fraccionamiento)
	 */
	@Override
	public void actualizarMontoResta(Fraccionamiento fraccionamiento ) throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		Query query = createQuery("update Fraccionamiento set montoFraccionadoResta=:montoResta, estado=:valorEsatdo where idFraccionamiento=:idFraccionamiento",parametros);
		query.setParameter("montoResta", fraccionamiento.getMontoFraccionadoResta());
		query.setParameter("valorEsatdo", fraccionamiento.getEstado());
		query.setParameter("idFraccionamiento", fraccionamiento.getIdFraccionamiento());
		query.executeUpdate();
	}
	
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.FraccionamientoDaoLocal#listarFraccionamiento(pe.com.edu.siaa.core.model.jpa.seguridad.Fraccionamiento)
     */  
    @Override	 
    public List<Fraccionamiento> listarFraccionamiento(FraccionamientoDTO fraccionamiento) {
        Query query = generarQueryListaFraccionamiento(fraccionamiento, false);
        query.setFirstResult(fraccionamiento.getStartRow());
        query.setMaxResults(fraccionamiento.getOffset());
        return query.getResultList();
    }   
    
    @Override
    public Map<String,List<Fraccionamiento>> obtenerListaFraccionamientoMap(List<String> listaDetPlanPagos, boolean flagFaltaMontoResta) throws Exception {
		Map<String,List<Fraccionamiento>> resultado = new HashMap<String, List<Fraccionamiento>>();
		if (listaDetPlanPagos == null || listaDetPlanPagos.size() == 0) {
			return resultado;
		}
		 Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuilder jpaql = new StringBuilder();
		jpaql.append(" from Fraccionamiento fraccionamiento  ");
		jpaql.append(" where fraccionamiento.credito.idCredito in (:listaDetPlanPagos) ");
		if (flagFaltaMontoResta) {
			jpaql.append(" and (fraccionamiento.montoFraccionadoResta is null or fraccionamiento.montoFraccionadoResta > 0) ");
		}
		jpaql.append(" order by to_number(fraccionamiento.nro,''),fraccionamiento.fechaVencimiento asc");
		parametros.put("listaDetPlanPagos", listaDetPlanPagos);
		Query query = createQuery(jpaql.toString(),parametros);
		List<Fraccionamiento> listaFraccionamiento = query.getResultList();	
		for (String idDetPlanPagos : listaDetPlanPagos) {
			for (Fraccionamiento fraccionamiento2 : listaFraccionamiento) {
				if (idDetPlanPagos.equals(fraccionamiento2.getCredito().getIdCredito())) {
					if (resultado.containsKey(idDetPlanPagos)) {
						List<Fraccionamiento> value = resultado.get(idDetPlanPagos);
						value.add(fraccionamiento2);
						resultado.put(idDetPlanPagos, value);
					} else {
						List<Fraccionamiento> value = new ArrayList<Fraccionamiento>();
						value.add(fraccionamiento2);
						resultado.put(idDetPlanPagos, value);
					}
				}
			}
		}
		return resultado;
	}
   
    /**
     * Generar query lista Fraccionamiento.
     *
     * @param FraccionamientoDTO el fraccionamiento
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaFraccionamiento(FraccionamientoDTO fraccionamiento, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idFraccionamiento) from Fraccionamiento o where 1=1 ");
        } else {
            jpaql.append(" select o from Fraccionamiento o where 1=1 ");           
        }
        
        
		 if (!StringUtils.isNullOrEmpty(fraccionamiento.getListidEgresados())) {
		        jpaql.append(" and o.detPlanPagos.idDetPlanPagos in(:listaIdPlanPagos) ");
		        parametros.put("listaIdPlanPagos", fraccionamiento.getListidEgresados());
		 }
		 
		if (!StringUtils.isNullOrEmpty(fraccionamiento.getSearch())) {
	          jpaql.append(" and upper(o.idFraccionamiento) like :search ");
	          parametros.put("search", "%" + fraccionamiento.getSearch().toUpperCase() + "%");
	    } else {
			if (!StringUtils.isNullOrEmpty(fraccionamiento.getNro())) {
				jpaql.append(" and upper(o.nro) like :nro ");
				parametros.put("nro", "%" + fraccionamiento.getNro().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmptyNumeric(fraccionamiento.getCuotaFracionada())) {
				jpaql.append(" and o.cuotaFracionada = :cuotaFracionada ");
				parametros.put("cuotaFracionada", fraccionamiento.getCuotaFracionada());
			}
			if (!StringUtils.isNullOrEmptyNumeric(fraccionamiento.getMontoFraccionadoResta())) {
				jpaql.append(" and o.montoFraccionadoResta = :montoFraccionadoResta ");
				parametros.put("montoFraccionadoResta", fraccionamiento.getMontoFraccionadoResta());
			}
			if (!StringUtils.isNullOrEmpty(fraccionamiento.getFechaVencimiento())) {
				jpaql.append(" and o.fechaVencimiento = :fechaVencimiento ");
				parametros.put("fechaVencimiento", fraccionamiento.getFechaVencimiento());
			}
			if (!StringUtils.isNullOrEmpty(fraccionamiento.getFechaCreacion())) {
				jpaql.append(" and o.fechaCreacion = :fechaCreacion ");
				parametros.put("fechaCreacion", fraccionamiento.getFechaCreacion());
			}
			if (!StringUtils.isNullOrEmpty(fraccionamiento.getUsuarioCreacion())) {
				jpaql.append(" and upper(o.usuarioCreacion) like :usuarioCreacion ");
				parametros.put("usuarioCreacion", "%" + fraccionamiento.getUsuarioCreacion().toUpperCase() + "%");
			}
		}
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.FraccionamientoDaoLocal#contarListar{entity.getClassName()}(pe.com.edu.siaa.core.model.jpa.seguridad.FraccionamientoDTO)
     */
	@Override
    public int contarListarFraccionamiento(FraccionamientoDTO fraccionamiento) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaFraccionamiento(fraccionamiento, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.FraccionamientoDaoLocal#generarIdFraccionamiento()
     */
	@Override
    public String generarIdFraccionamiento() {
        String resultado = "1";
        Query query = createQuery("select max(o.idFraccionamiento) from Fraccionamiento o", null);
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
    public void eliminarFraccionamiento(String idCredito ) throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		Query query = createQuery("delete from Fraccionamiento  where credito.idCredito=:idCredito",parametros);
		query.setParameter("idCredito", idCredito);
		query.executeUpdate();
	}
	
	
	@Override
	public List<Fraccionamiento> listarFraccionamientoByDetPl(String idCredito) throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		boolean ejecutarQuery = false;
		StringBuilder jpaql = new StringBuilder();
		jpaql.append("from Fraccionamiento fr left join fetch fr.credito where 1 = 1 ");
		if (StringUtils.isNotNullOrBlank(idCredito)) {
			ejecutarQuery = true;
			jpaql.append(" and fr.credito.idCredito=:idCredito ");
			parametros.put("idCredito", idCredito);
		}
		//jpaql.append(" order by dm.detCargaLectiva.detPlanEstudio.descripcionCurso");
		if (ejecutarQuery) {		
			Query query = createQuery(jpaql.toString(), parametros);
			return query.getResultList();
		} 
		return null;
	}
	 
	@Override
	public BigDecimal listarSumaFraccionamientoByDetplanpagos(String idDetPlanpagos) throws Exception {
		Query query = createQuery("select sum(fraccionamiento.montoFraccionadoResta) from Fraccionamiento fraccionamiento  where fraccionamiento.credito.idCredito = :idDetPlanpagos ",null);
		query.setParameter("idDetPlanpagos", idDetPlanpagos);
		return ((BigDecimal) query.getSingleResult());
	}
}