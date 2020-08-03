package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;
import java.math.BigDecimal;
import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.DetCobranza;
import pe.com.builderp.core.model.vo.cooperativa.DetCobranzaDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal; 

/**
 * La Class DetCobranzaDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 11:25:17 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface DetCobranzaDaoLocal  extends GenericDAOLocal<String,DetCobranza> {
	
	/**
	 * Listar DetCobranza.
	 *
	 * @param DetCobranza el DetCobranza
	 * @return the list
	 * @throws Exception the exception
	 */
	List<DetCobranza> listarDetCobranza(String idControPago) throws Exception;
	
	List<DetCobranza> listarDetCobranzaByDetPlan(String idDetPlanpagos) throws Exception;
	
	BigDecimal listarSumaControlpagoByDetplanpagos(String idDetPlanpagos) throws Exception;
	
	/**
	 * Generar id DetCobranza.
	 *
	 * @param DetCobranza el cuota concepto
	 * @return the long
	 * @throws Exception the exception
	 */
	String generarIdDetCobranza(String idControlPago) throws Exception;
	/**
	 * Listar det control pago.
	 *
	 * @param DetCobranza el det control pagoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<DetCobranza> listarDetCobranza(DetCobranzaDTO detCobranza) throws Exception;
	
	/**
	 * contar lista det control pago.
	 *
	 * @param DetCobranza el det control pago
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarDetCobranza(DetCobranzaDTO detCobranza);
	/**
	 * Generar id DetCobranza.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdDetCobranza() throws Exception;
	
	
	List<DetCobranza> listaDetCobranza(String idControlPago) throws Exception;
	
	DetCobranza findByDetCobranza(String idDetPlanpagos) throws Exception;
	
	DetCobranza findByDetCobranzaByCon(String idControl) throws Exception;

}