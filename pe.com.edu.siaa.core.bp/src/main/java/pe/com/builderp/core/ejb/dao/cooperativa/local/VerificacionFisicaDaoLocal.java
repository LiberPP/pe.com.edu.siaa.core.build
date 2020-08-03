package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.VerificacionFisica;
import pe.com.builderp.core.model.vo.cooperativa.VerificacionFisicaDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;

/**
 * La Class ClienteDaoLocal.
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
public interface VerificacionFisicaDaoLocal  extends GenericDAOLocal<String,VerificacionFisica> {
	/**
	 * Listar cliente.
	 *
	 * @param cliente el clienteDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<VerificacionFisica> listarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica) throws Exception;
	
	/**
	 * contar lista VerificacionFisica.
	 *
	 * @param VerificacionFisica el VerificacionFisica
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica);
	/**
	 * Generar id VerificacionFisica.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdVerificacionFisica() throws Exception;
	
	String generarNuemeroVerificacionFisica() throws Exception;
}