package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.EvaluacionCredito;
import pe.com.builderp.core.model.vo.cooperativa.EvaluacionCreditoDTO;
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
public interface EvaluacionCreditoDaoLocal  extends GenericDAOLocal<String,EvaluacionCredito> {
	/**
	 * Listar cliente.
	 *
	 * @param cliente el clienteDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<EvaluacionCredito> listarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) throws Exception;
	
	/**
	 * contar lista EvaluacionCredito.
	 *
	 * @param EvaluacionCredito el EvaluacionCredito
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito);
	/**
	 * Generar id EvaluacionCredito.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdEvaluacionCredito() throws Exception;
	
	String generarNuemeroEvaluacionCredito() throws Exception;
	
	String generarCodigoEvaluacionCredito() throws Exception;
}