package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;
 
import pe.com.builderp.core.model.jpa.cooperativa.Credito;
import pe.com.builderp.core.model.vo.cooperativa.CreditoDTO; 
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
public interface CreditoDaoLocal  extends GenericDAOLocal<String,Credito> {
	/**
	 * Listar cliente.
	 *
	 * @param cliente el clienteDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Credito> listarCredito(CreditoDTO Credito) throws Exception;
	
	/**
	 * contar lista Credito.
	 *
	 * @param Credito el Credito
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCredito(CreditoDTO Credito);
	/**
	 * Generar id Credito.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdCredito() throws Exception;
	
	 String generarCodigo()  throws Exception;
	 
	 List<Credito> listarConceptoPagoCliente(String idCliente,boolean flagFaltaMontoResta) throws Exception;
	 
	 Credito findByPrestamoDatos(String idCliente) throws Exception;
}