package pe.com.builderp.core.facturacion.ejb.dao.venta.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.AvalDTO;
import pe.com.builderp.core.facturacion.model.jpa.venta.Aval;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class AvalDaoImpl.
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
public class AvalDaoImpl extends  GenericFacturacionDAOImpl<String, Aval> implements AvalDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal#listarAval(pe.com.builderp.core.facturacion.model.jpa.venta.Aval)
     */  
    @Override	 
    public List<Aval> listarAval(AvalDTO Aval) {
        Query query = generarQueryListaAval(Aval, false);
        query.setFirstResult(Aval.getStartRow());
        query.setMaxResults(Aval.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista Aval.
     *
     * @param AvalDatosDTO el Aval
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaAval(AvalDTO Aval, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idAval) from Aval o where 1=1 ");
        } else {
            jpaql.append(" select o from Aval o left join fetch o.itemByTipoDocumentoIdentidad left join fetch o.itemByEstadoCivil  where 1=1 ");           
        }
		if (!StringUtils.isNullOrEmpty(Aval.getSearch())) {
	          jpaql.append(" and (TRANSLATE(UPPER(o.nombre || ' ' || o.apellidoPaterno || ' ' || o.apellidoMaterno ), :discriminaTildeMAC, :discriminaTildeMAT) like UPPER(translate(:search, :discriminaTildeMIC, :discriminaTildeMIT))  or (upper(o.nroDoc) like :search) )");
				parametros.putAll(obtenerParametroDiscriminarTilde());	
	          parametros.put("search", "%" + Aval.getSearch().toUpperCase() + "%");
	    } else {
			if (!StringUtils.isNullOrEmpty(Aval.getNombre())) {
				jpaql.append(" and upper(o.nombre) like :nombre ");
				parametros.put("nombre", "%" + Aval.getNombre().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getApellidoPaterno())) {
				jpaql.append(" and upper(o.apellidoPaterno) like :apellidoPaterno ");
				parametros.put("apellidoPaterno", "%" + Aval.getApellidoPaterno().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getApellidoMaterno())) {
				jpaql.append(" and upper(o.apellidoMaterno) like :apellidoMaterno ");
				parametros.put("apellidoMaterno", "%" + Aval.getApellidoMaterno().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getNroDoc())) {
				jpaql.append(" and upper(o.nroDoc) like :nroDoc ");
				parametros.put("nroDoc", "%" + Aval.getNroDoc().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getEmail())) {
				jpaql.append(" and upper(o.email) like :email ");
				parametros.put("email", "%" + Aval.getEmail().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getTelefono())) {
				jpaql.append(" and upper(o.telefono) like :telefono ");
				parametros.put("telefono", "%" + Aval.getTelefono().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getCelular())) {
				jpaql.append(" and upper(o.celular) like :celular ");
				parametros.put("celular", "%" + Aval.getCelular().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getPaginaWeb())) {
				jpaql.append(" and upper(o.paginaWeb) like :paginaWeb ");
				parametros.put("paginaWeb", "%" + Aval.getPaginaWeb().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getDireccion())) {
				jpaql.append(" and upper(o.direccion) like :direccion ");
				parametros.put("direccion", "%" + Aval.getDireccion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(Aval.getEstado())) {
				jpaql.append(" and upper(o.estado) like :estado ");
				parametros.put("estado", "%" + Aval.getEstado().toUpperCase() + "%");
			}
		}
        if (!esContador) {
            jpaql.append(" ORDER BY o.nombre,o.apellidoPaterno asc ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.AvalDTO)
     */
	@Override
    public int contarListarAval(AvalDTO Aval) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaAval(Aval, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal#generarIdAval()
     */
	 @Override
    public String generarIdAval() {
		 return UUIDUtil.generarElementUUID(); 
    }
   
}