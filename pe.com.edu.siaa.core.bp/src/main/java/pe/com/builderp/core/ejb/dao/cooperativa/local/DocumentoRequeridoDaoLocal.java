package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.DocumentoRequerido;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;

/**
 * La Class CategoriaDaoLocal.
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
public interface DocumentoRequeridoDaoLocal  extends GenericDAOLocal<String,DocumentoRequerido> {
	/**
	 * Listar documento requerido.
	 *
	 * @param documentoRequerido el documento requeridoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<DocumentoRequerido> listarDocumentoRequerido(String idEvaluacionCredito) throws Exception;
	
	boolean eliminarDocumentoRequerido(String idEvaluacionCredito) throws Exception;
	
	/**
	 * Generar id documentoRequerido.
	 *
	 * @return the Long
	 * @throws Exception the exception
	 */
	Long generarIdDocumentoRequerido() throws Exception;
}