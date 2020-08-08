package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.ImagenAdjunto;
import pe.com.builderp.core.model.vo.cooperativa.ImagenAdjuntoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;

/**
 * La Class ImagenAdjuntoDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:21 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface ImagenAdjuntoDaoLocal  extends GenericDAOLocal<String,ImagenAdjunto> {
	/**
	 * Listar ImagenAdjunto.
	 *
	 * @param ImagenAdjunto el ImagenAdjuntoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ImagenAdjunto> listarImagenAdjunto(ImagenAdjuntoDTO ImagenAdjunto) throws Exception;
	
	/**
	 * contar lista ImagenAdjunto.
	 *
	 * @param ImagenAdjunto el ImagenAdjunto
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarImagenAdjunto(ImagenAdjuntoDTO ImagenAdjunto);
	/**
	 * Generar id ImagenAdjunto.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdImagenAdjunto() throws Exception;
	
	boolean eliminarImagenAdjunto(String idVerificacionFisica) throws Exception;
	 
}