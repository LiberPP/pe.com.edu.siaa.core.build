package pe.com.builderp.core.facturacion.ejb.dao.venta.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.facturacion.model.dto.venta.AvalDTO;
import pe.com.builderp.core.facturacion.model.jpa.venta.Aval;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;

/**
 * La Class AvalDaoLocal.
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
public interface AvalDaoLocal  extends GenericDAOLocal<String,Aval> {
	/**
	 * Listar Aval.
	 *
	 * @param AvalDatos el AvalDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Aval> listarAval(AvalDTO aval) throws Exception;
	
	/**
	 * contar lista Aval.
	 *
	 * @param AvalDatos el Aval
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarAval(AvalDTO aval);
	/**
	 * Generar id Aval.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdAval() throws Exception;
}