package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
 
import pe.com.builderp.core.model.jpa.cooperativa.Cobranza;
import pe.com.builderp.core.model.vo.cooperativa.CobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoVoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal; 

/**
 * La Class CobranzaDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 11:25:13 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface CobranzaDaoLocal  extends GenericDAOLocal<String,Cobranza> {
	
	String generarNumeroOperacion(Integer anho) throws Exception;
	
	/**
	 * Generar id Cobranza.
	 *
	 * @param Cobranza el cuota concepto
	 * @return the long
	 * @throws Exception the exception
	 */
	String generarIdCobranza(String idAnhoSemestre) throws Exception;
	
	/**
	 * Listar control pago.
	 *
	 * @param Cobranza el control pagoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Cobranza> listarCobranza(CobranzaDTO cobranza) throws Exception;
	
	/**
	 * contar lista control pago.
	 *
	 * @param Cobranza el control pago
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCobranza(CobranzaDTO cobranza);
	/**
	 * Generar id Cobranza.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdCobranza() throws Exception;
		
	
	Cobranza findAlumnoByCobranza(String idDetCobranza) throws Exception ;
	
	BigDecimal contarMontoTotalCobranza(String userName,Date fecha) ;
	
	List<IngresoVoDTO> listarIngresos(IngresoVoDTO filtro) throws Exception;
}