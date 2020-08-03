package pe.com.builderp.core.ejb.dao.cooperativa.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.PrestamoInternoDaoLocal; 
import pe.com.builderp.core.model.jpa.cooperativa.PrestamoInterno; 
import pe.com.builderp.core.model.vo.cooperativa.PrestamoInternoDTO;
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
public class PrestamoInternoDaoImpl extends  GenericFacturacionDAOImpl<String, PrestamoInterno> implements PrestamoInternoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal#listarProforma(pe.com.builderp.core.facturacion.model.jpa.venta.Proforma)
     */  
    @Override	 
    public List<PrestamoInterno> listarPrestamoInterno(PrestamoInternoDTO PrestamoInterno) {
        Query query = generarQueryListaPrestamoInterno(PrestamoInterno, false);
        query.setFirstResult(PrestamoInterno.getStartRow());
        query.setMaxResults(PrestamoInterno.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista PrestamoInterno.
     *
     * @param PrestamoInternoDTO el PrestamoInterno
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaPrestamoInterno(PrestamoInternoDTO PrestamoInterno, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idPrestamoInterno) from PrestamoInterno o where 1=1 ");
        } else {
            jpaql.append(" select o from PrestamoInterno o where 1=1 ");           
        } 
		if (!StringUtils.isNullOrEmpty(PrestamoInterno.getSearch())) {
	          jpaql.append(" and upper(o.idPrestamoInterno) like :search ");
	          parametros.put("search", "%" + PrestamoInterno.getSearch().toUpperCase() + "%");
	    } 
        if (!esContador) {
            //jpaql.append(" ORDER BY 1 ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.PrestamoInternoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.PrestamoInternoDTO)
     */
	@Override
    public int contarListarPrestamoInterno(PrestamoInternoDTO PrestamoInterno) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaPrestamoInterno(PrestamoInterno, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.PrestamoInternoDaoLocal#generarIdPrestamoInterno()
     */
	 @Override
    public String generarIdPrestamoInterno() { 
		return UUIDUtil.generarElementUUID();
    }
 
 
}