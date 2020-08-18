package pe.com.builderp.core.ejb.service.cooperativa.local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.vo.cooperativa.AvalDatosDTO;
import pe.com.builderp.core.model.vo.cooperativa.CajaDTO;
import pe.com.builderp.core.model.vo.cooperativa.CobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.CompromisoPagoDTO;
import pe.com.builderp.core.model.vo.cooperativa.CreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.DetCobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.DocumentoRequeridoDTO;
import pe.com.builderp.core.model.vo.cooperativa.EgresoDTO;
import pe.com.builderp.core.model.vo.cooperativa.EvaluacionCreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.ImagenAdjuntoDTO;
import pe.com.builderp.core.model.vo.cooperativa.InformacionLaboralDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoVoDTO;
import pe.com.builderp.core.model.vo.cooperativa.PrestamoInternoDTO;
import pe.com.builderp.core.model.vo.cooperativa.ReferenciaPersonalDTO;
import pe.com.builderp.core.model.vo.cooperativa.VerificacionFisicaDTO;
import pe.com.edu.siaa.core.model.type.AccionType;

/**
 * La Class VentaServiceLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:52 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface CooperativaServiceLocal{
	/**
	 * Controlador accion categoria.
	 *
	 * @param categoria el categoria
	 * @param accionType el accion type
	 * @return the categoria
	 * @throws Exception the exception
	 */
	DocumentoRequeridoDTO controladorAccionDocumentoRequerido(DocumentoRequeridoDTO documentoRequerido,AccionType accionType) throws Exception; 
	
	/**
	 * Listar DocumentoRequerido.
	 *
	 * @param DocumentoRequerido el DocumentoRequerido
	 * @return the list
	 * @throws Exception the exception
	 */
	List<DocumentoRequeridoDTO> listarDocumentoRequerido(String idEvaluacionCredito) throws Exception;
	
	
	List<DocumentoRequeridoDTO> listarDocumentoRequeridoVerificacionFisica(String idAvalDatos) throws Exception;
	
	/**
	 * contar lista DocumentoRequerido.
	 *
	 * @param DocumentoRequerido el DocumentoRequerido
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarDocumentoRequerido(DocumentoRequeridoDTO DocumentoRequerido);
	
	/**
	 * Controlador accion cliente.
	 *
	 * @param cliente el cliente
	 * @param accionType el accion type
	 * @return the cliente
	 * @throws Exception the exception
	 */
	EvaluacionCreditoDTO controladorAccionEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito,AccionType accionType) throws Exception; 
	
	/**
	 * Listar EvaluacionCredito.
	 *
	 * @param EvaluacionCredito el EvaluacionCredito
	 * @return the list
	 * @throws Exception the exception
	 */
	List<EvaluacionCreditoDTO> listarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) throws Exception;
	
	/**
	 * contar lista EvaluacionCredito.
	 *
	 * @param EvaluacionCredito el EvaluacionCredito
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito);
	
	/**
	 * Controlador accion cliente.
	 *
	 * @param cliente el cliente
	 * @param accionType el accion type
	 * @return the cliente
	 * @throws Exception the exception
	 */
	//ReferenciaPersonalDTO controladorAccionReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal,AccionType accionType) throws Exception; 
	
	/**
	 * Listar ReferenciaPersonal.
	 *
	 * @param ReferenciaPersonal el ReferenciaPersonal
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ReferenciaPersonalDTO> listarReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal) throws Exception;
	
	/**
	 * contar lista ReferenciaPersonal.
	 *
	 * @param ReferenciaPersonal el ReferenciaPersonal
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal);
	
	
	/**
	 * Controlador accion cliente.
	 *
	 * @param cliente el cliente
	 * @param accionType el accion type
	 * @return the cliente
	 * @throws Exception the exception
	 */
	//InformacionLaboralDTO controladorAccionInformacionLaboral(InformacionLaboralDTO InformacionLaboral,AccionType accionType) throws Exception; 
	
	/**
	 * Listar InformacionLaboral.
	 *
	 * @param InformacionLaboral el InformacionLaboral
	 * @return the list
	 * @throws Exception the exception
	 */
	List<InformacionLaboralDTO> listarInformacionLaboral(InformacionLaboralDTO InformacionLaboral) throws Exception;
	
	/**
	 * contar lista InformacionLaboral.
	 *
	 * @param InformacionLaboral el InformacionLaboral
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarInformacionLaboral(InformacionLaboralDTO InformacionLaboral);
	
	InformacionLaboralDTO informacionLaboralBy(String idEvaluacionCredito) throws Exception;
	
	InformacionLaboralDTO informacionLaboralAvalDatos(String idAvalDatos) throws Exception;
	
	
	VerificacionFisicaDTO controladorAccionVerificacionFisica(VerificacionFisicaDTO VerificacionFisica,AccionType accionType) throws Exception; 
	/**
	 * Listar VerificacionFisica.
	 *
	 * @param VerificacionFisica el VerificacionFisica
	 * @return the list
	 * @throws Exception the exception
	 */
	List<VerificacionFisicaDTO> listarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica) throws Exception;
	/**
	 * contar lista VerificacionFisica.
	 *
	 * @param VerificacionFisica el VerificacionFisica
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica);
	
 
	CreditoDTO controladorAccionCredito(CreditoDTO Credito,AccionType accionType) throws Exception; 
	
	/**
	 * Listar Credito.
	 *
	 * @param Credito el Credito
	 * @return the list
	 * @throws Exception the exception
	 */
	List<CreditoDTO> listarCredito(CreditoDTO Credito) throws Exception;
	
	/**
	 * contar lista Credito.
	 *
	 * @param Credito el Credito
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCredito(CreditoDTO Credito);
	
	void registrarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) throws Exception;
	
	void registrarVerificacionFisica(VerificacionFisicaDTO verificacionFisica) throws Exception;
	
	CreditoDTO registrarCredito(CreditoDTO credito) throws Exception; 
	
	void registrarCobranza(CobranzaDTO cobranza) throws Exception;
	
	String generarReportePagoCliente(String idCobranza, String idCliente, String usuario) throws Exception;
	
	List<CobranzaDTO> listarCobranza(CobranzaDTO cobranza) throws Exception;
	
	List<DetCobranzaDTO> verDetalleCobranzaRealizados(String idCobranza) throws Exception;
	
	CobranzaDTO controladorAccionCobranza(CobranzaDTO cobranza, AccionType accionType) throws Exception;
	
	int contarListarCobranza(CobranzaDTO cobranza) throws Exception;
	
	List<CreditoDTO> listarConceptoPagoCliente(String idCliente,boolean flagFaltaMontoResta) throws Exception;
	
	CreditoDTO findByPrestamoDatos (String idCliente) throws Exception;
	
	//caja
	
    CajaDTO controladorAccionCaja(CajaDTO Caja,AccionType accionType) throws Exception; 

	List<CajaDTO> listarCaja(CajaDTO Caja) throws Exception;
	
	int contarListarCaja(CajaDTO Caja);
	
	CajaDTO findByCaja(String idUsuario) throws Exception;
	 
	CajaDTO findByCajaFecha(String idUsuario,Date fecha) throws Exception;
	 
	String iniciarAperturaCaja() throws Exception;

	CajaDTO findByCaja() throws Exception;
	 
	
	List<IngresoVoDTO> listarIngresos(IngresoVoDTO filtro) throws Exception;
	
	//egreso
    EgresoDTO controladorAccionEgreso(EgresoDTO egreso,AccionType accionType) throws Exception; 

	List<EgresoDTO> listarEgreso(EgresoDTO egreso) throws Exception;
	
	int contarListarEgreso(EgresoDTO egreso);
	
	//ingreso
    IngresoDTO controladorAccionIngreso(IngresoDTO ingreso,AccionType accionType) throws Exception; 

	List<IngresoDTO> listarIngreso(IngresoDTO ingreso) throws Exception;
	
	int contarListarIngreso(IngresoDTO ingreso);
	
	//prestamoIntyerno
    PrestamoInternoDTO controladorAccionPrestamoInterno(PrestamoInternoDTO prestamoInterno,AccionType accionType) throws Exception; 

	List<PrestamoInternoDTO> listarPrestamoInterno(PrestamoInternoDTO prestamoInterno) throws Exception;
	
	int contarListarPrestamoInterno(PrestamoInternoDTO prestamoInterno);
	
	
	String generarReporteCronogramaPago(String idCredito) throws Exception;
	
	void eliminarControlPago(String idControlPago,String userName) throws Exception;
	
	void eliminarDetControlPago(String idDetControlPago,String userName) throws Exception;
	
	CreditoDTO eliminarDetPlanPagos(CreditoDTO credito) throws Exception;
	
	AvalDatosDTO avalBy(String idEvaluacionCredito) throws Exception;
	
	//
	
	CompromisoPagoDTO controladorAccionCompromisoPago(CompromisoPagoDTO compromisoPago,AccionType accionType) throws Exception; 
	
	/**
	 * Listar DocumentoRequerido.
	 *
	 * @param DocumentoRequerido el DocumentoRequerido
	 * @return the list
	 * @throws Exception the exception
	 */
	List<CompromisoPagoDTO> listarCompromisoPago(CompromisoPagoDTO compromisoPago) throws Exception;
	
	/**
	 * contar lista DocumentoRequerido.
	 *
	 * @param DocumentoRequerido el DocumentoRequerido
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCompromisoPago(CompromisoPagoDTO compromisoPago);
	
	List<ImagenAdjuntoDTO> listarImagenAdjunto(ImagenAdjuntoDTO imagenAdjunto) throws Exception;
	
	String cerrarCaja(String userName,Date fecha)throws Exception;
	
	void updateCobranzaCierre(String idUsuario,Date fecha) throws Exception;
	
}