package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.PrestamoInterno; 
import pe.com.builderp.core.model.vo.cooperativa.PrestamoInternoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;

/**
 * La Class ProformaDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:24 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface PrestamoInternoDaoLocal  extends GenericDAOLocal<String,PrestamoInterno> {
	/**
	 * Listar proforma.
	 *
	 * @param proforma el proformaDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<PrestamoInterno> listarPrestamoInterno(PrestamoInternoDTO PrestamoInterno) throws Exception;
	
	/**
	 * contar lista PrestamoInterno.
	 *
	 * @param PrestamoInterno el PrestamoInterno
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarPrestamoInterno(PrestamoInternoDTO PrestamoInterno);
	/**
	 * Generar id PrestamoInterno.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdPrestamoInterno() throws Exception;
}