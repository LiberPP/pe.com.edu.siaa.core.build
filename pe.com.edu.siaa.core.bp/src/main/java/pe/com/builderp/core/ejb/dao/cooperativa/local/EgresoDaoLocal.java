package pe.com.builderp.core.ejb.dao.cooperativa.local;
 
import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.Egreso;
import pe.com.builderp.core.model.vo.cooperativa.EgresoDTO;
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
public interface EgresoDaoLocal  extends GenericDAOLocal<String,Egreso> {
	/**
	 * Listar proforma.
	 *
	 * @param proforma el proformaDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Egreso> listarEgreso(EgresoDTO Egreso) throws Exception;
	
	/**
	 * contar lista Egreso.
	 *
	 * @param Egreso el Egreso
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarEgreso(EgresoDTO Egreso);
	/**
	 * Generar id Egreso.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdEgreso() throws Exception;
}