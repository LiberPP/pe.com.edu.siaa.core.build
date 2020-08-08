package pe.com.builderp.core.ejb.dao.cooperativa.local;
 
import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.CompromisoPago;
import pe.com.builderp.core.model.vo.cooperativa.CompromisoPagoDTO;
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
public interface CompromisoPagoDaoLocal  extends GenericDAOLocal<String,CompromisoPago> {
	/**
	 * Listar proforma.
	 *
	 * @param proforma el proformaDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<CompromisoPago> listarCompromisoPago(CompromisoPagoDTO CompromisoPago) throws Exception;
	
	/**
	 * contar lista CompromisoPago.
	 *
	 * @param CompromisoPago el CompromisoPago
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCompromisoPago(CompromisoPagoDTO CompromisoPago);
	/**
	 * Generar id CompromisoPago.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdCompromisoPago() throws Exception;

	
}