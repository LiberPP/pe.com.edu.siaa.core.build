package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.ImagenAdjuntoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.ImagenAdjunto;
import pe.com.builderp.core.model.vo.cooperativa.ImagenAdjuntoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class ImagenAdjuntoDaoImpl.
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
public class ImagenAdjuntoDaoImpl extends  GenericFacturacionDAOImpl<String, ImagenAdjunto> implements ImagenAdjuntoDaoLocal  {

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ImagenAdjuntoDaoLocal#listarImagenAdjunto(pe.com.builderp.core.facturacion.model.jpa.venta.ImagenAdjunto)
     */  
    @Override	 
    public List<ImagenAdjunto> listarImagenAdjunto(ImagenAdjuntoDTO ImagenAdjunto) {
        Query query = generarQueryListaImagenAdjunto(ImagenAdjunto, false);
        query.setFirstResult(ImagenAdjunto.getStartRow());
        query.setMaxResults(ImagenAdjunto.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista ImagenAdjunto.
     *
     * @param ImagenAdjuntoDTO el ImagenAdjunto
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaImagenAdjunto(ImagenAdjuntoDTO ImagenAdjunto, boolean esContador) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idImagenAdjunto) from ImagenAdjunto o where 1=1 ");
        } else {
            jpaql.append(" select o from ImagenAdjunto o left join fetch o.verificacionFisica    where 1=1 ");           
        }
        
        if(!StringUtils.isNullOrEmpty(ImagenAdjunto.getId())) {
	          jpaql.append(" and o.verificacionFisica.idVerificacionFisica =:idUsuario ");
	          parametros.put("idUsuario",ImagenAdjunto.getId());
        }
        
		if (!StringUtils.isNullOrEmpty(ImagenAdjunto.getSearch())) {
			ImagenAdjunto.setSearch(ImagenAdjunto.getSearch().replace(" ", "+"));
	          jpaql.append(" and fts('english', o.nombre, :search) = true or fts('english', o.nroDoc, :search) = true  ");
	          parametros.put("search", ImagenAdjunto.getSearch().toUpperCase()+":*");  
	    } else {
			if (!StringUtils.isNullOrEmpty(ImagenAdjunto.getNombre())) {
				jpaql.append(" and upper(o.nombre) like :nombre ");
				parametros.put("nombre", "%" + ImagenAdjunto.getNombre().toUpperCase() + "%");
			} 
		}
        if (!esContador) {
            jpaql.append(" ORDER BY o.nombre asc ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ImagenAdjuntoDaoLocal#contarListar{entity.getClassName()}(pe.com.builderp.core.facturacion.model.jpa.venta.ImagenAdjuntoDTO)
     */
	@Override
    public int contarListarImagenAdjunto(ImagenAdjuntoDTO ImagenAdjunto) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaImagenAdjunto(ImagenAdjunto, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.builderp.core.facturacion.ejb.dao.venta.local.ImagenAdjuntoDaoLocal#generarIdImagenAdjunto()
     */
	 @Override
    public String generarIdImagenAdjunto() {
		 return UUIDUtil.generarElementUUID();
       /* String resultado = "1";
        Query query = createQuery("select max(o.idImagenAdjunto) from ImagenAdjunto o", null);
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
    public boolean eliminarImagenAdjunto(String idVerificacionFisica) throws Exception {
    	boolean resultado = false;
    	Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        jpaql.append(" delete from ImagenAdjunto o where  o.verificacionFisica.idVerificacionFisica=:idVerificacionFisica ");
        parametros.put("idVerificacionFisica", idVerificacionFisica);
        Query query = createQuery(jpaql.toString(), parametros);
        query.executeUpdate();
        return resultado;
    }
	    
}