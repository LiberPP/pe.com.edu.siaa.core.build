package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.VerificacionFisicaDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.VerificacionFisica;
import pe.com.builderp.core.model.vo.cooperativa.VerificacionFisicaDTO;
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
public class VerificacionFisicaDaoImpl extends  GenericFacturacionDAOImpl<String, VerificacionFisica> implements VerificacionFisicaDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ClienteDaoLocal#listarCliente(pe.com.builderp.core.facturacion.model.jpa.venta.Cliente)
     */  
    @Override	 
    public List<VerificacionFisica> listarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica) {
        Query query = generarQueryListaVerificacionFisica(VerificacionFisica, false);
        query.setFirstResult(VerificacionFisica.getStartRow());
        query.setMaxResults(VerificacionFisica.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista VerificacionFisica.
     *
     * @param VerificacionFisicaDTO el VerificacionFisica
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaVerificacionFisica(VerificacionFisicaDTO VerificacionFisica, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idVerificacionFisica) from VerificacionFisica o where 1=1 ");
        } else {
            jpaql.append(" select o from VerificacionFisica o   where 1=1 ");           
        }
		if (!StringUtils.isNullOrEmpty(VerificacionFisica.getSearch())) {
	          jpaql.append(" and upper(o.codigo) like :search )");
	          parametros.put("search", "%" + VerificacionFisica.getSearch().toUpperCase() + "%");
	    }
        if (!esContador) {
            //jpaql.append(" ORDER BY o.nombre,o.apellidoPaterno asc ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.VerificacionFisicaDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.VerificacionFisicaDTO)
     */
	@Override
    public int contarListarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaVerificacionFisica(VerificacionFisica, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.VerificacionFisicaDaoLocal#generarIdVerificacionFisica()
     */
	 @Override
    public String generarIdVerificacionFisica() {
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
	    public String generarNuemeroVerificacionFisica() {
	        String resultado = "VERI-00001";
			 Query query = createQuery("select max(h.codigo) from VerificacionFisica h ", null);
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