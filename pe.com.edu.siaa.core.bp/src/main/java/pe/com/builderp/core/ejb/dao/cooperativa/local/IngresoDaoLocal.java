package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.Ingreso;
import pe.com.builderp.core.model.vo.cooperativa.IngresoDTO;
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
public interface IngresoDaoLocal  extends GenericDAOLocal<String,Ingreso> {
	/**
	 * Listar proforma.
	 *
	 * @param proforma el proformaDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Ingreso> listarIngreso(IngresoDTO Ingreso) throws Exception;
	
	/**
	 * contar lista Ingreso.
	 *
	 * @param Ingreso el Ingreso
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarIngreso(IngresoDTO Ingreso);
	/**
	 * Generar id Ingreso.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdIngreso() throws Exception;
}