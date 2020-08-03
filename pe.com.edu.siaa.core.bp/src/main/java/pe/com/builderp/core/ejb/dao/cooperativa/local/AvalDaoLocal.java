package pe.com.builderp.core.ejb.dao.cooperativa.local;
 
import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.Aval; 
import pe.com.builderp.core.model.vo.cooperativa.AvalDTO;
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
public interface AvalDaoLocal  extends GenericDAOLocal<String,Aval> {
	/**
	 * Listar proforma.
	 *
	 * @param proforma el proformaDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Aval> listarAval(AvalDTO Aval) throws Exception;
	
	/**
	 * contar lista Aval.
	 *
	 * @param Aval el Aval
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarAval(AvalDTO Aval);
	/**
	 * Generar id Aval.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdAval() throws Exception;
	
	Aval findByAval(String idEvaluacionCredito) throws Exception;
 
}