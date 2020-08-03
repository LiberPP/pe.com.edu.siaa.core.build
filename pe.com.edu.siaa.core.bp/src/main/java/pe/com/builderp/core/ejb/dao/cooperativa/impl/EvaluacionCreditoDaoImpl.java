package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.EvaluacionCreditoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.EvaluacionCredito;
import pe.com.builderp.core.model.vo.cooperativa.EvaluacionCreditoDTO;
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
public class EvaluacionCreditoDaoImpl extends  GenericFacturacionDAOImpl<String, EvaluacionCredito> implements EvaluacionCreditoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ClienteDaoLocal#listarCliente(pe.com.builderp.core.facturacion.model.jpa.venta.Cliente)
     */  
    @Override	 
    public List<EvaluacionCredito> listarEvaluacionCredito(EvaluacionCreditoDTO EvaluacionCredito) {
        Query query = generarQueryListaEvaluacionCredito(EvaluacionCredito, false);
        query.setFirstResult(EvaluacionCredito.getStartRow());
        query.setMaxResults(EvaluacionCredito.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista EvaluacionCredito.
     *
     * @param EvaluacionCreditoDTO el EvaluacionCredito
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaEvaluacionCredito(EvaluacionCreditoDTO EvaluacionCredito, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idEvaluacionCredito) from EvaluacionCredito o where 1=1 ");
        } else {
            jpaql.append(" select o from EvaluacionCredito o  left join o.cliente where 1=1 ");           
        }
		if (!StringUtils.isNullOrEmpty(EvaluacionCredito.getSearch())) {
	          jpaql.append(" and upper(o.codigo) like :search )");
	          parametros.put("search", "%" + EvaluacionCredito.getSearch().toUpperCase() + "%");
	    }
        if (!esContador) {
            //jpaql.append(" ORDER BY o.nombre,o.apellidoPaterno asc ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.EvaluacionCreditoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.EvaluacionCreditoDTO)
     */
	@Override
    public int contarListarEvaluacionCredito(EvaluacionCreditoDTO EvaluacionCredito) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaEvaluacionCredito(EvaluacionCredito, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.EvaluacionCreditoDaoLocal#generarIdEvaluacionCredito()
     */
	 @Override
    public String generarIdEvaluacionCredito() {
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
	    public String generarNuemeroEvaluacionCredito() {
	        String resultado = "EVA-00001";
			 Query query = createQuery("select max(h.codigo) from EvaluacionCredito h ", null);
		//	 query.setParameter("idPlanPagos", idPlanPagos);
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
	    public String generarCodigoEvaluacionCredito() {
	        String resultado = "00001";
			 Query query = createQuery("select max(h.codigo) from EvaluacionCredito h ", null);
		//	 query.setParameter("idPlanPagos", idPlanPagos);
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
}