package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.CreditoDaoLocal; 
import pe.com.builderp.core.model.jpa.cooperativa.Credito; 
import pe.com.builderp.core.model.vo.cooperativa.CreditoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class ClienteDaoImpl.
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
public class CreditoDaoImpl extends  GenericFacturacionDAOImpl<String, Credito> implements CreditoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ClienteDaoLocal#listarCliente(pe.com.builderp.core.facturacion.model.jpa.venta.Cliente)
     */  
    @Override	 
    public List<Credito> listarCredito(CreditoDTO Credito) {
        Query query = generarQueryListaCredito(Credito, false);
        query.setFirstResult(Credito.getStartRow());
        query.setMaxResults(Credito.getOffset());
        return query.getResultList();
    }   
    /**
     * Generar query lista Credito.
     *
     * @param CreditoDTO el Credito
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaCredito(CreditoDTO Credito, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idCredito) from Credito o where 1=1 ");
        } else {
            jpaql.append(" select o from Credito o  left join o.verificacionFisica ver left join ver.evaluacionCredito eva left join eva.cliente where 1=1 ");           
        }
		if (!StringUtils.isNullOrEmpty(Credito.getId())) {
	          jpaql.append(" and o.montoResta != 0.00 )"); 
	    }
        if (!StringUtils.isNullOrEmpty(Credito.getSearch())) {
	          jpaql.append(" and upper(o.codigo) like :search )");
	          parametros.put("search", "%" + Credito.getSearch().toUpperCase() + "%");
	    }
        if (!esContador) {
            //jpaql.append(" ORDER BY o.nombre,o.apellidoPaterno asc ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.CreditoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.CreditoDTO)
     */
	@Override
    public int contarListarCredito(CreditoDTO Credito) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaCredito(Credito, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.CreditoDaoLocal#generarIdCredito()
     */
	 @Override
    public String generarIdCredito() {
		 return UUIDUtil.generarElementUUID();
       /* String resultado = "1";
        Query query = createQuery("select max(o.idCliente) from Cliente o", null);
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
	    public String generarCodigo() {
	        String resultado = "CREDI-00001";
			 Query query = createQuery("select max(h.descripcion) from Credito h  ", null);
			 //query.setParameter("idPlanPagos", idPlanPagos);
			 List<String> listaCodigo = query.getResultList();
				if (listaCodigo != null && listaCodigo.size() > 0) {
					String ultimoIdGenerado = listaCodigo.get(0);
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
	 
	 
	 @Override
		public List<Credito> listarConceptoPagoCliente(String idCliente,boolean flagFaltaMontoResta) throws Exception {
			List<Credito> resultado = new ArrayList<Credito>();
			Map<String, Object> parametros = new HashMap<String, Object>();
			StringBuilder jpaql = new StringBuilder();
			jpaql.append("from Credito credito");		 
			if (StringUtils.isNotNullOrBlank(idCliente)) {
				jpaql.append(" where credito.verificacionFisica.evaluacionCredito.cliente.idCliente=:idCliente ");
				parametros.put("idCliente", idCliente);
			} 
			if (flagFaltaMontoResta) {
				jpaql.append(" and (montoResta is null or montoResta > 0) ");
			}
			jpaql.append(" order by  credito.fechaCreacion ");
			Query query = this.createQuery(jpaql.toString(),parametros);
			resultado = query.getResultList();
			return resultado;
		}
	 
		@Override
		public Credito findByPrestamoDatos(String idCliente) throws Exception {
			Credito resultado = null;
			StringBuilder jpaql = new StringBuilder();
			jpaql.append("from Credito o left join fetch o.verificacionFisica pl left join fetch pl.evaluacionCredito eva left join fetch eva.cliente "); 
			jpaql.append(" where o.verificacionFisica.evaluacionCredito.cliente.idCliente =:idCliente and o.montoResta!=0.00 order by to_char(o.fechacontrato,'dd/MM/yyy') desc");
			Query query = createQuery(jpaql.toString(),null);
			query.setParameter("idCliente", idCliente); 
			List<Credito> listaAlumno = query.getResultList();
			if (listaAlumno != null && listaAlumno.size() > 0) {
				resultado = listaAlumno.get(0);
			}
			return resultado;	
		}
		
}