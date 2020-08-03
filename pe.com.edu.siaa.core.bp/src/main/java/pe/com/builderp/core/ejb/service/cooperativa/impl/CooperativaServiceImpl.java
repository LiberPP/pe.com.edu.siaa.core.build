package pe.com.builderp.core.ejb.service.cooperativa.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ch.qos.logback.core.net.server.Client;
import pe.com.builderp.core.ejb.dao.cooperativa.local.AvalDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.CajaDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.CobranzaDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.CreditoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.DetCobranzaDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.DocumentoRequeridoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.EgresoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.EvaluacionCreditoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.FraccionamientoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.InformacionLaboralDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.IngresoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.PrestamoInternoDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.ReferenciaPersonalDaoLocal;
import pe.com.builderp.core.ejb.dao.cooperativa.local.VerificacionFisicaDaoLocal;
import pe.com.builderp.core.ejb.service.cooperativa.local.CooperativaServiceLocal;
import pe.com.builderp.core.facturacion.ejb.service.venta.local.VentaServiceLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.ClienteDTO;
import pe.com.builderp.core.model.jpa.cooperativa.Aval;
import pe.com.builderp.core.model.jpa.cooperativa.Caja;
import pe.com.builderp.core.model.jpa.cooperativa.Cobranza;
import pe.com.builderp.core.model.jpa.cooperativa.Credito;
import pe.com.builderp.core.model.jpa.cooperativa.DetCobranza;
import pe.com.builderp.core.model.jpa.cooperativa.DocumentoRequerido;
import pe.com.builderp.core.model.jpa.cooperativa.Egreso;
import pe.com.builderp.core.model.jpa.cooperativa.EvaluacionCredito;
import pe.com.builderp.core.model.jpa.cooperativa.Fraccionamiento;
import pe.com.builderp.core.model.jpa.cooperativa.InformacionLaboral;
import pe.com.builderp.core.model.jpa.cooperativa.Ingreso;
import pe.com.builderp.core.model.jpa.cooperativa.PrestamoInterno;
import pe.com.builderp.core.model.jpa.cooperativa.ReferenciaPersonal;
import pe.com.builderp.core.model.jpa.cooperativa.VerificacionFisica;
import pe.com.builderp.core.model.vo.cooperativa.AvalDTO;
import pe.com.builderp.core.model.vo.cooperativa.CajaDTO;
import pe.com.builderp.core.model.vo.cooperativa.CobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.ConceptoCobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.CreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.DetCobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.DocumentoRequeridoDTO;
import pe.com.builderp.core.model.vo.cooperativa.EgresoDTO;
import pe.com.builderp.core.model.vo.cooperativa.EvaluacionCreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.FraccionamientoDTO;
import pe.com.builderp.core.model.vo.cooperativa.InformacionLaboralDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoVoDTO;
import pe.com.builderp.core.model.vo.cooperativa.PrestamoInternoDTO;
import pe.com.builderp.core.model.vo.cooperativa.ReferenciaPersonalDTO;
import pe.com.builderp.core.model.vo.cooperativa.VerificacionFisicaDTO;
import pe.com.edu.siaa.core.ejb.dao.seguridad.local.UsuarioDaoLocal;
import pe.com.edu.siaa.core.ejb.factory.CollectionUtil;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.service.local.GenerarReporteServiceLocal;
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
import pe.com.edu.siaa.core.ejb.util.cache.AppAuthenticator;
import pe.com.edu.siaa.core.ejb.util.cache.SelectItemServiceCacheUtil;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.ejb.util.log.Logger;
import pe.com.edu.siaa.core.model.dto.common.ItemDTO;
import pe.com.edu.siaa.core.model.dto.seguridad.UsuarioDTO;
import pe.com.edu.siaa.core.model.estate.EstadoGeneralState;
import pe.com.edu.siaa.core.model.jpa.common.Item;
import pe.com.edu.siaa.core.model.jpa.seguridad.Usuario;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.model.type.FlagConceptoPagoFraccionadoType;
import pe.com.edu.siaa.core.model.type.NombreReporteType;
import pe.com.edu.siaa.core.model.type.TipoReporteGenerarType;
import pe.com.edu.siaa.core.model.util.NumerosUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;
import pe.com.edu.siaa.core.model.vo.ParametroReporteVO;
import pe.com.edu.siaa.core.model.vo.SelectItemVO;


/**
 * La Class VentaServiceImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:52 COT 2017
 * @since SIAA-CORE 2.1
 */
 @Stateless
public class CooperativaServiceImpl implements CooperativaServiceLocal {
	 
	 
	 private Logger log = Logger.getLogger(CooperativaServiceImpl.class);
	/** El servicio categoria dao impl. */
	@EJB
	private DocumentoRequeridoDaoLocal documentoRequeridoDaoImpl; 
	
	/** El servicio cliente dao impl. */
	@EJB
	private EvaluacionCreditoDaoLocal evaluacionCreditoDaoImpl; 
	
	/** El servicio cliente dao impl. */
	@EJB
	private ReferenciaPersonalDaoLocal referenciaPersonalDaoImpl; 
	
	
	/** El servicio cliente dao impl. */
	@EJB
	private VerificacionFisicaDaoLocal verificacionFisicaDaoImpl; 

	/** El servicio cliente dao impl. */
	@EJB
	private InformacionLaboralDaoLocal informacionLaboralDaoImpl; 
	
	/** El servicio fraccionamiento dao impl. */
	@EJB
	private FraccionamientoDaoLocal fraccionamientoDaoImpl; 
	
	/** El servicio fraccionamiento dao impl. */
	@EJB
	private CreditoDaoLocal creditoDaoImpl; 

	@EJB
	private CobranzaDaoLocal cobranzaDaoImpl; 
	
	@EJB
	private DetCobranzaDaoLocal detCobranzaDaoImpl; 
	
	@EJB
	private UsuarioDaoLocal usuarioServiceImpl; 
	
	@EJB
	private GenerarReporteServiceLocal	 generarReporteServiceImpl;
	
	//add
	@EJB
	private VentaServiceLocal ventaServiceImpl; 
	
	@EJB
	private CajaDaoLocal cajaDaoImpl;
	
	@EJB
	private EgresoDaoLocal egresoDaoImpl;
	
	@EJB
	private IngresoDaoLocal ingresoDaoImpl;
	
	@EJB
	private PrestamoInternoDaoLocal prestamoInternoDaoImpl;
	
	@EJB
	private AvalDaoLocal avalDaoImpl;
	 
	@Override
	public DocumentoRequeridoDTO controladorAccionDocumentoRequerido(DocumentoRequeridoDTO documentoRequerido,
			AccionType accionType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentoRequeridoDTO> listarDocumentoRequerido(String idEvaluacionCredito)throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.documentoRequeridoDaoImpl.listarDocumentoRequerido(idEvaluacionCredito),DocumentoRequeridoDTO.class,"itemByDocumento");

	}

	@Override
	public int contarListarDocumentoRequerido(DocumentoRequeridoDTO DocumentoRequerido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EvaluacionCreditoDTO controladorAccionEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito,
			AccionType accionType) throws Exception {
		EvaluacionCreditoDTO resultado = null;
		EvaluacionCredito resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				evaluacionCredito.setIdEvaluacionCredito(this.evaluacionCreditoDaoImpl.generarIdEvaluacionCredito());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(evaluacionCredito, EvaluacionCredito.class,"cliente@PK@","itemByTipoCredito@PK@");
				this.evaluacionCreditoDaoImpl.save(resultadoEntity);	
				resultado = evaluacionCredito;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(evaluacionCredito, EvaluacionCredito.class,"cliente@PK@","itemByTipoCredito@PK@");
				this.evaluacionCreditoDaoImpl.update(resultadoEntity);
				resultado = evaluacionCredito;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.evaluacionCreditoDaoImpl.find(EvaluacionCredito.class, evaluacionCredito.getIdEvaluacionCredito());
				this.evaluacionCreditoDaoImpl.delete(resultadoEntity);
				resultado = evaluacionCredito;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.evaluacionCreditoDaoImpl.find(EvaluacionCredito.class, evaluacionCredito.getIdEvaluacionCredito());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,EvaluacionCreditoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.asignaPlanEstudioDaoImpl.findByNombre(asignaPlanEstudio),AsignaPlanEstudioDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}

	@Override
	public List<EvaluacionCreditoDTO> listarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) throws Exception {
		List<EvaluacionCreditoDTO> resultado = new ArrayList<EvaluacionCreditoDTO>();
		List<EvaluacionCredito> listaTemo = evaluacionCreditoDaoImpl.listarEvaluacionCredito(evaluacionCredito);
		for (EvaluacionCredito evaluacionCredito2 : listaTemo) {
			EvaluacionCreditoDTO evaluacionCreditoDTO = TransferDataObjectUtil.transferObjetoEntityDTO(evaluacionCredito2,EvaluacionCreditoDTO.class,"cliente");
			evaluacionCreditoDTO.setCliente(TransferDataObjectUtil.transferObjetoEntityDTO(evaluacionCredito2.getCliente(), ClienteDTO.class ,"itemByEstadoCivil","itemByCategoriaCliente","itemByTipoDocumentoIdentidad"));
			List<DocumentoRequeridoDTO> listaDocumentoRequerido = listarDocumentoRequerido(evaluacionCredito2.getIdEvaluacionCredito());
			for (DocumentoRequeridoDTO documentoRequeridoDTO : listaDocumentoRequerido) {
				evaluacionCreditoDTO.getListaDocumentoRequerido().add(new SelectItemVO(documentoRequeridoDTO.getItemByDocumento()));
			}	
			
			resultado.add(evaluacionCreditoDTO);
		}
		listaTemo = null;
		return resultado;
	}

	@Override
	public int contarListarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		return this.evaluacionCreditoDaoImpl.contarListarEvaluacionCredito(evaluacionCredito);
	}

 
	public ReferenciaPersonalDTO controladorAccionReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal,EvaluacionCredito evaluacionCredito,AccionType accionType) throws Exception {
		ReferenciaPersonalDTO resultado = null;
		ReferenciaPersonal resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				referenciaPersonal.setIdReferenciaPersonal(referenciaPersonalDaoImpl.generarIdReferenciaPersonal());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(referenciaPersonal, ReferenciaPersonal.class);
				resultadoEntity.setEvaluacionCredito(evaluacionCredito);
				this.referenciaPersonalDaoImpl.save(resultadoEntity);	
				resultado = referenciaPersonal;
				break;				
			case MODIFICAR:
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(referenciaPersonal, ReferenciaPersonal.class,"itemByCargo");
				resultadoEntity.setEvaluacionCredito(evaluacionCredito);
				this.referenciaPersonalDaoImpl.update(resultadoEntity);
				resultado = referenciaPersonal;	 
				break;
				
			case ELIMINAR:
				resultadoEntity = this.referenciaPersonalDaoImpl.find(ReferenciaPersonal.class, referenciaPersonal.getIdReferenciaPersonal());
				this.referenciaPersonalDaoImpl.delete(resultadoEntity);
				resultado = referenciaPersonal;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.referenciaPersonalDaoImpl.find(ReferenciaPersonal.class, referenciaPersonal.getIdReferenciaPersonal());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ReferenciaPersonalDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.detalleVentaDaoImpl.findByNombre(detalleVenta),DetalleVentaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}

	@Override
	public List<ReferenciaPersonalDTO> listarReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal)throws Exception {
		// TODO Auto-generated method stub
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.referenciaPersonalDaoImpl.listarReferenciaPersonal(referenciaPersonal),ReferenciaPersonalDTO.class,"evaluacionCredito");
	}

	@Override
	public int contarListarReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	public InformacionLaboralDTO controladorAccionInformacionLaboral(InformacionLaboralDTO informacionLaboral,EvaluacionCredito evaluacionCredito,AccionType accionType) throws Exception {
		InformacionLaboralDTO resultado = null;
		InformacionLaboral resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				informacionLaboral.setIdInformacionLaboral(informacionLaboralDaoImpl.generarIdInformacionLaboral());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(informacionLaboral, InformacionLaboral.class,"itemByCargo","entidad");
				resultadoEntity.setEvaluacionCredito(evaluacionCredito);
				this.informacionLaboralDaoImpl.save(resultadoEntity);
				resultado = informacionLaboral;
				break;				
			case MODIFICAR:
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(informacionLaboral, InformacionLaboral.class,"itemByCargo","entidad");
				resultadoEntity.setEvaluacionCredito(evaluacionCredito);
				this.informacionLaboralDaoImpl.update(resultadoEntity);
				resultado = informacionLaboral;	 
				break;
				
			case ELIMINAR:
				resultadoEntity = this.informacionLaboralDaoImpl.find(InformacionLaboral.class, informacionLaboral.getIdInformacionLaboral());
				this.informacionLaboralDaoImpl.delete(resultadoEntity);
				resultado = informacionLaboral;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.informacionLaboralDaoImpl.find(InformacionLaboral.class, informacionLaboral.getIdInformacionLaboral());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,InformacionLaboralDTO.class);
				break;
			default:
				break;
		} 
		return resultado;
	}

	@Override
	public List<InformacionLaboralDTO> listarInformacionLaboral(InformacionLaboralDTO InformacionLaboral)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarListarInformacionLaboral(InformacionLaboralDTO InformacionLaboral) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VerificacionFisicaDTO controladorAccionVerificacionFisica(VerificacionFisicaDTO VerificacionFisica,
			AccionType accionType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VerificacionFisicaDTO> listarVerificacionFisica(VerificacionFisicaDTO verificacionFisica)throws Exception {
		List<VerificacionFisicaDTO> resultado = new ArrayList<VerificacionFisicaDTO>();
		List<VerificacionFisica> listaTemo = verificacionFisicaDaoImpl.listarVerificacionFisica(verificacionFisica);
		for (VerificacionFisica verificacionFisicaDTO2 : listaTemo) {
			VerificacionFisicaDTO verificacionFisicaDTO = TransferDataObjectUtil.transferObjetoEntityDTO(verificacionFisicaDTO2,VerificacionFisicaDTO.class,"evaluacionCredito:{cliente}","verificador");
			verificacionFisicaDTO.setEvaluacionCredito(TransferDataObjectUtil.transferObjetoEntityDTO(verificacionFisicaDTO2.getEvaluacionCredito(), EvaluacionCreditoDTO.class, "cliente"));
			verificacionFisicaDTO.getEvaluacionCredito().setCliente(TransferDataObjectUtil.transferObjetoEntityDTO(verificacionFisicaDTO2.getEvaluacionCredito().getCliente(), ClienteDTO.class ,"itemByEstadoCivil","itemByCategoriaCliente","itemByTipoDocumentoIdentidad"));
			List<DocumentoRequeridoDTO> listaDocumentoRequerido = listarDocumentoRequerido(verificacionFisicaDTO2.getEvaluacionCredito().getIdEvaluacionCredito());
			verificacionFisicaDTO.getEvaluacionCredito().setListaDocumentoRequeridoPer(listaDocumentoRequerido);
			resultado.add(verificacionFisicaDTO);
		}
		listaTemo = null;
		return resultado;
	}

	@Override
	public int contarListarVerificacionFisica(VerificacionFisicaDTO VerificacionFisica) {
		// TODO Auto-generated method stub
		return this.verificacionFisicaDaoImpl.contarListarVerificacionFisica(VerificacionFisica);
	}

	@Override
	public CreditoDTO controladorAccionCredito(CreditoDTO Credito, AccionType accionType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditoDTO> listarCredito(CreditoDTO credito) throws Exception {
		//List<CreditoDTO> resultado = TransferDataObjectUtil.transferObjetoEntityDTOList(this.creditoDaoImpl.listarCredito(credito),CreditoDTO.class,"verificacionFisica:{verificador}");
		List<CreditoDTO> resultado = new ArrayList<CreditoDTO>();
		List<Credito> listaTemo = creditoDaoImpl.listarCredito(credito);
		for (Credito creditoDTO2 : listaTemo) {
			CreditoDTO creditoDTO = TransferDataObjectUtil.transferObjetoEntityDTO(creditoDTO2,CreditoDTO.class,"verificacionFisica");
			creditoDTO.setVerificacionFisica(TransferDataObjectUtil.transferObjetoEntityDTO(creditoDTO2.getVerificacionFisica(), VerificacionFisicaDTO.class, "evaluacionCredito:{cliente}","verificador"));
			creditoDTO.getVerificacionFisica().setEvaluacionCredito(TransferDataObjectUtil.transferObjetoEntityDTO(creditoDTO2.getVerificacionFisica().getEvaluacionCredito(), EvaluacionCreditoDTO.class, "cliente"));
			creditoDTO.getVerificacionFisica().getEvaluacionCredito().setCliente(TransferDataObjectUtil.transferObjetoEntityDTO(creditoDTO2.getVerificacionFisica().getEvaluacionCredito().getCliente(), ClienteDTO.class ,"itemByEstadoCivil","itemByCategoriaCliente","itemByTipoDocumentoIdentidad"));

			resultado.add(creditoDTO);
		}
	
		List<String> listaDetPlanPagos = new ArrayList<String>();
		for (CreditoDTO objData : resultado) {
		//	objData.getVerificacionFisica().setEvaluacionCredito(TransferDataObjectUtil.transferObjetoEntityDTO(credito.getVerificacionFisica().getEvaluacionCredito(), EvaluacionCreditoDTO.class, "cliente"));
			if (FlagConceptoPagoFraccionadoType.SI.getKey().equals(objData.getFlagFraccionado())) {
				listaDetPlanPagos.add(objData.getIdCredito());			
			}
		}
		Map<String,List<Fraccionamiento>> fraccionamientoMap = fraccionamientoDaoImpl.obtenerListaFraccionamientoMap(listaDetPlanPagos, false);
		for (CreditoDTO objData : resultado) {
			if (FlagConceptoPagoFraccionadoType.SI.getKey().equals(objData.getFlagFraccionado())) {
				if (fraccionamientoMap.containsKey(objData.getIdCredito())) {
					List<FraccionamientoDTO> listaFraccionamiento = TransferDataObjectUtil.transferObjetoEntityDTOList(fraccionamientoMap.get(objData.getIdCredito()),FraccionamientoDTO.class);
					objData.setListaFraccionamientos(listaFraccionamiento);
				}
			}
		}
		


		listaTemo=null;
		return resultado;
		/*List<CreditoDTO> resultado = new ArrayList<CreditoDTO>();
		List<Credito> listaTemo = creditoDaoImpl.listarCredito(credito);
		for (Credito creditoDTO2 : listaTemo) {
			CreditoDTO creditoDTO = TransferDataObjectUtil.transferObjetoEntityDTO(creditoDTO2,CreditoDTO.class,"verificacionFisica");
			creditoDTO.setVerificacionFisica(TransferDataObjectUtil.transferObjetoEntityDTO(creditoDTO2.getVerificacionFisica(), VerificacionFisicaDTO.class, "evaluacionCredito:{cliente}","verificador"));
			resultado.add(creditoDTO);
		}
		listaTemo = null;
		return resultado;*/
	}

	@Override
	public int contarListarCredito(CreditoDTO Credito) {
		// TODO Auto-generated method stub
		return this.creditoDaoImpl.contarListarCredito(Credito);
	}

	@Override
	public void registrarEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) throws Exception {
		String userName = AppAuthenticator.getInstance().getUserName(evaluacionCredito.getAuthToken());
		EvaluacionCredito evaluacionCreditoPersist = null; 
		boolean isCrearOtros = false;
		AccionType accionType=null;
		if (!StringUtils.isNotNullOrBlank(evaluacionCredito.getIdEvaluacionCredito())) {
			if(StringUtils.isNullOrEmpty(evaluacionCredito.getFechaEvaluacion())) {
				evaluacionCredito.setFechaEvaluacion(FechaUtil.obtenerFecha());
			}
			evaluacionCredito.setIdEvaluacionCredito(evaluacionCreditoDaoImpl.generarIdEvaluacionCredito());
			evaluacionCredito.setDescripcion(evaluacionCreditoDaoImpl.generarNuemeroEvaluacionCredito());
			evaluacionCredito.setCodigo(evaluacionCreditoDaoImpl.generarCodigoEvaluacionCredito());
			evaluacionCreditoPersist = TransferDataObjectUtil.transferObjetoEntity(evaluacionCredito, EvaluacionCredito.class,"cliente");
			this.evaluacionCreditoDaoImpl.save(evaluacionCreditoPersist);
			accionType = AccionType.CREAR;
			isCrearOtros=true;
			
		}else {
			evaluacionCreditoPersist = TransferDataObjectUtil.transferObjetoEntity(evaluacionCredito, EvaluacionCredito.class,"cliente");
			this.evaluacionCreditoDaoImpl.update(evaluacionCreditoPersist);	
			accionType = AccionType.MODIFICAR;
			isCrearOtros=true;
		}
		
		if(isCrearOtros) {
			if(!CollectionUtil.isEmpty(evaluacionCredito.getInformacionLaboralList())) {
				for(InformacionLaboralDTO informacionLaboral :evaluacionCredito.getInformacionLaboralList()) {
					if (StringUtils.isNullOrEmpty(informacionLaboral.getIdInformacionLaboral())) {
						controladorAccionInformacionLaboral(informacionLaboral,evaluacionCreditoPersist,AccionType.CREAR);
					} else {
						controladorAccionInformacionLaboral(informacionLaboral,evaluacionCreditoPersist,AccionType.MODIFICAR);
					} 	
				}
				//registrarInformacionLaboral(userName,evaluacionCreditoPersist,evaluacionCredito.getInformacionLaboralList().get(0));
			}
			if(!CollectionUtil.isEmpty(evaluacionCredito.getReferenciaPersonalDTOList())) {
				for(ReferenciaPersonalDTO referenciaPersonalDTO : evaluacionCredito.getReferenciaPersonalDTOList()) {
					if (!evaluacionCredito.isEsEliminado()) {
						if (StringUtils.isNullOrEmpty(referenciaPersonalDTO.getIdReferenciaPersonal())) {
							controladorAccionReferenciaPersonal(referenciaPersonalDTO,evaluacionCreditoPersist,AccionType.CREAR);
						} else {
							controladorAccionReferenciaPersonal(referenciaPersonalDTO,evaluacionCreditoPersist,AccionType.MODIFICAR);
						} 
					} else {
						controladorAccionReferenciaPersonal(referenciaPersonalDTO,evaluacionCreditoPersist, AccionType.ELIMINAR);
					}
					//registrarReferenciaPersonal(evaluacionCreditoPersist,referenciaPersonalDTO);
				}
			}
			
			if(!CollectionUtil.isEmpty(evaluacionCredito.getAvalList())) {
				for(AvalDTO avalDTO : evaluacionCredito.getAvalList()) {
					if (!avalDTO.isEsEliminado()) {
						if (StringUtils.isNullOrEmpty(avalDTO.getIdAval())) {
							controladorAccionAval(avalDTO,evaluacionCreditoPersist,AccionType.CREAR);
						} else {
							controladorAccionAval(avalDTO,evaluacionCreditoPersist,AccionType.MODIFICAR);
						} 
					} else {
						controladorAccionAval(avalDTO,evaluacionCreditoPersist, AccionType.ELIMINAR);
					}
					//registrarReferenciaPersonal(evaluacionCreditoPersist,referenciaPersonalDTO);
				}
			}
			
			if(!CollectionUtil.isEmpty(evaluacionCredito.getListaDocumentoRequerido())) {
				crearDocumentoRequerido(evaluacionCreditoPersist, evaluacionCredito.getListaDocumentoRequerido(),accionType);	
			}
		}
	} 
	
	/*private void registrarInformacionLaboral(String userName,EvaluacionCredito evaluacionCredito, InformacionLaboralDTO informacionLaboral) throws Exception {
		InformacionLaboral resultadoEntity = null;
		if (!StringUtils.isNotNullOrBlank(informacionLaboral.getIdInformacionLaboral())) {
			informacionLaboral.setIdInformacionLaboral(informacionLaboralDaoImpl.generarIdInformacionLaboral());
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(informacionLaboral, InformacionLaboral.class,"itemByCargo","entidad");
			resultadoEntity.setEvaluacionCredito(evaluacionCredito);
			this.informacionLaboralDaoImpl.save(resultadoEntity);	
		} else { 
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(informacionLaboral, InformacionLaboral.class,"itemByCargo","entidad");
			resultadoEntity.setEvaluacionCredito(evaluacionCredito);
			this.informacionLaboralDaoImpl.update(resultadoEntity);
		}	 
	}
	
	private void registrarReferenciaPersonal(EvaluacionCredito evaluacionCredito, ReferenciaPersonalDTO referenciaPersonal) throws Exception {
		ReferenciaPersonal resultadoEntity = null;
		if (!StringUtils.isNotNullOrBlank(referenciaPersonal.getIdReferenciaPersonal())) {
			referenciaPersonal.setIdReferenciaPersonal(referenciaPersonalDaoImpl.generarIdReferenciaPersonal());
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(referenciaPersonal, ReferenciaPersonal.class);
			resultadoEntity.setEvaluacionCredito(evaluacionCredito);
			this.referenciaPersonalDaoImpl.save(resultadoEntity);	
		} else { 
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(referenciaPersonal, ReferenciaPersonal.class,"itemByCargo");
			resultadoEntity.setEvaluacionCredito(evaluacionCredito);
			this.referenciaPersonalDaoImpl.update(resultadoEntity);
		}	 
	}*/
	
	
	private void crearDocumentoRequerido(EvaluacionCredito evaluacionCredito,List<SelectItemVO> listaTipoDocumentoRequeridoTemp,AccionType accionType) throws Exception {
		//List<ItemDTO> listaTipoDocumentoRequerido = SelectItemServiceCacheUtil.getInstance().converItemDTO(listaTipoDocumentoRequeridoTemp);
		if (AccionType.MODIFICAR.getKey().equals(accionType.getKey())) {
			//ya que tiene uuid
			documentoRequeridoDaoImpl.eliminarDocumentoRequerido(evaluacionCredito.getIdEvaluacionCredito());
		}				
		for (SelectItemVO objItem : listaTipoDocumentoRequeridoTemp) {
			if (objItem.isChecked()) {
				DocumentoRequerido objPersist = new DocumentoRequerido();
				objPersist.setEvaluacionCredito(evaluacionCredito);
				Long id = Long.valueOf(objItem.getId() + "");
				objPersist.setItemByDocumento(TransferDataObjectUtil.transferObjetoEntityPK(SelectItemServiceCacheUtil.getInstance().obtenerItem(id), Item.class));
				objPersist.setIdDocumentoRequerido(UUIDUtil.generarElementUUID());
				objPersist.setDescripcionOtro(objItem.getNombre());
				documentoRequeridoDaoImpl.save(objPersist);
			}			
		}
	}

	@Override
	public InformacionLaboralDTO informacionLaboralBy(String idEvaluacionCredito) throws Exception {
		InformacionLaboralDTO resultado = new InformacionLaboralDTO();
		InformacionLaboral usuario = informacionLaboralDaoImpl.findByInformacionLaboralID(idEvaluacionCredito);
		resultado = TransferDataObjectUtil.transferObjetoEntityDTO(usuario,InformacionLaboralDTO.class,"entidad","itemByCargo");
		usuario = null;
		return resultado;
	}


	@Override
	public void registrarVerificacionFisica(VerificacionFisicaDTO verificacionFisica) throws Exception { 
		VerificacionFisica verificacionFisicaPersist = null; 
		boolean isCrearOtros = false; 
		if (!StringUtils.isNotNullOrBlank(verificacionFisica.getIdVerificacionFisica())) {
			if(StringUtils.isNullOrEmpty(verificacionFisica.getFechaVerificacion())) {
				verificacionFisica.setFechaVerificacion(FechaUtil.obtenerFecha());
			}
			verificacionFisica.setHora(FechaUtil.obtenerHoraMinutos());
			verificacionFisica.setFechaCreacion(FechaUtil.obtenerFecha());
			verificacionFisica.setIdVerificacionFisica(verificacionFisicaDaoImpl.generarIdVerificacionFisica()); 
			verificacionFisica.setCodigo(verificacionFisicaDaoImpl.generarNuemeroVerificacionFisica());
			verificacionFisicaPersist = TransferDataObjectUtil.transferObjetoEntity(verificacionFisica, VerificacionFisica.class,"verificador","evaluacionCredito");
			this.verificacionFisicaDaoImpl.save(verificacionFisicaPersist);
			isCrearOtros=true;
			
		}else {
			verificacionFisica.setHora(FechaUtil.obtenerHoraMinutos()); 
			verificacionFisicaPersist = TransferDataObjectUtil.transferObjetoEntity(verificacionFisica, VerificacionFisica.class,"verificador","evaluacionCredito");
			this.verificacionFisicaDaoImpl.update(verificacionFisicaPersist);	
			isCrearOtros=true;
		}
		
		if(isCrearOtros) {
			/*if(!CollectionUtil.isEmpty(verificacionFisica.getInformacionLaboralList())) {
				
			}*/
		}	
	}
 
	private void registrarFraccionamiento(String userName,FraccionamientoDTO fraccionamiento, Credito credito) throws Exception {
		//TODO:RECUPERAR		
		if (StringUtils.isNullOrEmpty(fraccionamiento.getIdFraccionamiento())) {
			fraccionamiento.setIdFraccionamiento(this.fraccionamientoDaoImpl.generarIdFraccionamiento(credito.getIdCredito()));
			Fraccionamiento resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(fraccionamiento, Fraccionamiento.class,"detPlanPagos@PK@");
			resultadoEntity.setCredito(credito);
			resultadoEntity.setEstado("PENDIENTE");
			resultadoEntity.setFechaCreacion(FechaUtil.obtenerFecha());
			resultadoEntity.setUsuarioCreacion(userName);
			this.fraccionamientoDaoImpl.save(resultadoEntity);	
		} else {
			Fraccionamiento resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(fraccionamiento, Fraccionamiento.class,"detPlanPagos@PK@");
			resultadoEntity.setCredito(credito);
			this.fraccionamientoDaoImpl.update(resultadoEntity);	
		}
		
	}

	@Override
	public CreditoDTO registrarCredito(CreditoDTO credito) throws Exception {
		CreditoDTO resultado = null;
		Credito resultadoEntity = null;
		String userName = AppAuthenticator.getInstance().getUserName(credito.getAuthToken());
		credito.setFlagFraccionado(FlagConceptoPagoFraccionadoType.NO.getKey());
		if (!CollectionUtil.isEmpty(credito.getListaFraccionamientos())) {
			credito.setFlagFraccionado(FlagConceptoPagoFraccionadoType.SI.getKey());
		}
		if (!StringUtils.isNotNullOrBlank(credito.getIdCredito())) {
			credito.setDescripcion(this.creditoDaoImpl.generarCodigo());
			credito.setIdCredito(this.creditoDaoImpl.generarIdCredito());
			credito.setUsuarioCreacion(userName);
			credito.setFechaCreacion(FechaUtil.obtenerFecha());
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(credito, Credito.class,"verificacionFisica");
			this.creditoDaoImpl.save(resultadoEntity);	
		} else {
			credito.setUsuarioModificacion(userName);
			credito.setFechaModificacion(FechaUtil.obtenerFecha());
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(credito, Credito.class,"verificacionFisica");
			this.creditoDaoImpl.update(resultadoEntity);
			fraccionamientoDaoImpl.eliminarFraccionamiento(credito.getIdCredito());
		}	
		if (!CollectionUtil.isEmpty(credito.getListaFraccionamientos())) {
			for (FraccionamientoDTO fraccionamientoDTO : credito.getListaFraccionamientos()) {
				registrarFraccionamiento(userName,fraccionamientoDTO, resultadoEntity);
			}
		}
		
		return resultado;
	}

	@Override
	public List<CobranzaDTO> listarCobranza(CobranzaDTO cobranza) throws Exception {
		//return TransferDataObjectUtil.transferObjetoEntityDTOList(this.controlPagoDaoImpl.listarControlPago(controlPago),ControlPagoDTO.class,"tipoDocSunat","anhoSemestre","tipoDocSunat","itemByTipoMoneda","cliente");
		List<CobranzaDTO> resultado = new ArrayList<CobranzaDTO>();
		List<Cobranza> listaTemo = cobranzaDaoImpl.listarCobranza(cobranza);
		for (Cobranza cobranza2 : listaTemo) {
			CobranzaDTO cobranzaDTO = TransferDataObjectUtil.transferObjetoEntityDTO(cobranza2,CobranzaDTO.class,"tipoDocSunat","anhoSemestre","tipoDocSunat","itemByTipoMoneda","cliente");
			//List<DetControlPago> listaTemoa = listarDetControlPago(controlPago2.getIdControlPago());
			List<DetCobranzaDTO> ListarDetControlPago = verDetalleCobranzaRealizados(cobranza2.getIdCobranza());
			cobranzaDTO.setControlPagoDetControlPagoList(ListarDetControlPago);
			resultado.add(cobranzaDTO);
		}
		listaTemo = null;
		return resultado;
	}
	
	@Override
	public List<DetCobranzaDTO> verDetalleCobranzaRealizados(String idCobranza) throws Exception {
		List<DetCobranzaDTO> resultado = new ArrayList<DetCobranzaDTO>();
		List<DetCobranza> listaTemo = detCobranzaDaoImpl.listaDetCobranza(idCobranza);
		for (DetCobranza detCobranza : listaTemo) {
			DetCobranzaDTO detControlPagoDTO = TransferDataObjectUtil.transferObjetoEntityDTO(detCobranza, DetCobranzaDTO.class,"fraccionamiento","cobranza");
			resultado.add(detControlPagoDTO);
		}
		listaTemo = null;
		return resultado;
	}
	
	@Override
	public CobranzaDTO controladorAccionCobranza(CobranzaDTO cobranza, AccionType accionType) throws Exception {
		CobranzaDTO resultado = null;
		Cobranza resultadoEntity = null;
		List<String> idCobranza=new ArrayList<String>();
		switch (accionType) {
			case CREAR:
				cobranza.setIdCobranza(this.cobranzaDaoImpl.generarIdCobranza());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(cobranza, Cobranza.class,"tipoDocSunat@PK@","itemByTipoMoneda@PK@","empresa@PK@");
				this.cobranzaDaoImpl.save(resultadoEntity);	
				resultado = cobranza;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(cobranza, Cobranza.class,"tipoDocSunat@PK@","itemByTipoMoneda@PK@","empresa@PK@");
				this.cobranzaDaoImpl.update(resultadoEntity);
				resultado = cobranza;	
				break;
				
			case ELIMINAR:
				//idCobranza=this.listarDetCobranzaDelectid(Cobranza.getIdCobranza());
				//this.detCobranzaDaoImpl.deleteDetCobranza(idCobranza);
				resultadoEntity = this.cobranzaDaoImpl.find(Cobranza.class, cobranza.getIdCobranza());
				this.cobranzaDaoImpl.delete(resultadoEntity);
				resultado = cobranza;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.cobranzaDaoImpl.find(Cobranza.class, cobranza.getIdCobranza());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,CobranzaDTO.class, "cliente");
				List<DetCobranza> listaTemo = detCobranzaDaoImpl.listarDetCobranza(cobranza.getIdCobranza());
				List<DetCobranzaDTO> ListarDetCobranza = new ArrayList<DetCobranzaDTO>();
				for (DetCobranza detControlPag : listaTemo) {
					DetCobranzaDTO detCobranzaDTO = TransferDataObjectUtil.transferObjetoEntityDTO(detControlPag, DetCobranzaDTO.class,"cobranza:{cliente}");
					ListarDetCobranza.add(detCobranzaDTO);
				}
				resultado.setControlPagoDetControlPagoList(ListarDetCobranza);
				
				
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.CobranzaDaoImpl.findByNombre(controlPago),ControlPagoDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	
	@Override
	public int contarListarCobranza(CobranzaDTO cobranza){
		return  this.cobranzaDaoImpl.contarListarCobranza(cobranza);
	}
	
	
	@Override
	public void registrarCobranza(CobranzaDTO cobranza) throws Exception {
		String userName = AppAuthenticator.getInstance().getUserName(cobranza.getAuthToken());
		Cobranza controlPagoPersist = null;
		List<ConceptoCobranzaDTO> listaConceptoPagoDTO = cobranza.getListaConceptoPagoDTO();
		
		if (!StringUtils.isNotNullOrBlank(cobranza.getIdCobranza())) {
			cobranza.setFechaCreacion(FechaUtil.obtenerFecha());
			if (!StringUtils.isNotNullOrBlank(cobranza.getFechaPago())) { 
				cobranza.setFechaPago(FechaUtil.obtenerFecha());
			}
		
			cobranza.setUsuarioCreacion(userName);
			cobranza.setIdCobranza(cobranzaDaoImpl.generarIdCobranza());
			controlPagoPersist = TransferDataObjectUtil.transferObjetoEntity(cobranza, Cobranza.class,"itemByTipoMoneda@PK@","cliente@PK@");
			controlPagoPersist = cobranzaDaoImpl.save(controlPagoPersist);
		} else {
			cobranza.setFechaModificacion(FechaUtil.obtenerFecha());
			cobranza.setUsuarioModificacion(userName);
			controlPagoPersist = TransferDataObjectUtil.transferObjetoEntity(cobranza, Cobranza.class,"itemByTipoMoneda@PK@","cliente@PK@");
			controlPagoPersist.setMontoTotal(cobranza.getMontoTotal());
			controlPagoPersist = cobranzaDaoImpl.update(controlPagoPersist); 
		}
		if (listaConceptoPagoDTO == null) {
			listaConceptoPagoDTO = new ArrayList<ConceptoCobranzaDTO>();
		}
		Map<String,BigDecimal> montoPagoFraccionadoMap = new HashMap<String, BigDecimal>();
		//registrando detalle de pago y actualizando montos restantes
		for (ConceptoCobranzaDTO conceptoPagoDTO : listaConceptoPagoDTO) {
			if (conceptoPagoDTO.isCheck()) {
				DetCobranza detCobranza = new DetCobranza();
				detCobranza.setCobranza(controlPagoPersist);
				if (conceptoPagoDTO.isEsFraccionado()) {
					BigDecimal montoPago = conceptoPagoDTO.getMontoTotal().subtract(conceptoPagoDTO.getMontoResta());
					if (montoPagoFraccionadoMap.containsKey(conceptoPagoDTO.getIdPadre())) {
						BigDecimal montoPagoMap =  montoPagoFraccionadoMap.get(conceptoPagoDTO.getIdPadre());
						montoPago = montoPago.add(montoPagoMap);
					}
					montoPagoFraccionadoMap.put(conceptoPagoDTO.getIdPadre(), montoPago);
					Fraccionamiento fraccionamiento = new Fraccionamiento();
					fraccionamiento.setIdFraccionamiento(conceptoPagoDTO.getId() + "");
					fraccionamiento.setMontoFraccionadoResta(conceptoPagoDTO.getMontoResta());
					int i1;
					i1 = fraccionamiento.getMontoFraccionadoResta().intValue();
					if(i1 == 0.00) {
						fraccionamiento.setEstado("CANCELADO");
					}else {
						fraccionamiento.setEstado("PENDIENTE");
					}
					detCobranza.setNroCuota(conceptoPagoDTO.getNroCuota());
					fraccionamientoDaoImpl.actualizarMontoResta(fraccionamiento);
				} else {
					if (conceptoPagoDTO.getId() != null && !conceptoPagoDTO.getId().toString().contains("Artificio")) {
					//	DetPlanPagos detPlanPagos = new DetPlanPagos();
						System.out.println("Ids:: " +conceptoPagoDTO.getId() +" - " +conceptoPagoDTO.getIdCuotaConcepto());
						Credito credito = creditoDaoImpl.find(Credito.class, conceptoPagoDTO.getIdCuotaConcepto()+""); 
						credito.setMontoResta(conceptoPagoDTO.getMontoResta());
						creditoDaoImpl.update(credito);
						//detPlanPagosDaoImpl.actualizarMontoResta(detPlanPagos);
					}
				}
				
				if(conceptoPagoDTO.isChecked()) {
					
				}
				
				detCobranza.setCredito(new Credito());
				detCobranza.getCredito().setIdCredito(conceptoPagoDTO.getIdCuotaConcepto()  + "");
				detCobranza.setMonto(conceptoPagoDTO.getMonto().subtract(conceptoPagoDTO.getMontoResta()));
				detCobranza.setDescripcionConcepto(conceptoPagoDTO.getDescripcion());
				detCobranza.setIdDetCobranza(detCobranzaDaoImpl.generarIdDetCobranza(controlPagoPersist.getIdCobranza()));
				
				detCobranza.setUsuarioCreacion(cobranza.getUsuarioCreacion());
				detCobranza.setFechaCreacion(cobranza.getFechaCreacion());
				detCobranza.setIp(cobranza.getIp());
				detCobranza.setEstado(EstadoGeneralState.ACTIVO.getKey());
				
				detCobranza = detCobranzaDaoImpl.save(detCobranza);
			}
		}
		//actualizando los datos del padre
		for (Map.Entry<String,BigDecimal> entryMap : montoPagoFraccionadoMap.entrySet()) {
			Credito credito = creditoDaoImpl.find(Credito.class, entryMap.getKey());
			BigDecimal sumaMonto = detCobranzaDaoImpl.listarSumaControlpagoByDetplanpagos(credito.getIdCredito());
			BigDecimal montoRestaFraccionamiento = fraccionamientoDaoImpl.listarSumaFraccionamientoByDetplanpagos(credito.getIdCredito());
			sumaMonto = sumaMonto.subtract(entryMap.getValue());
			BigDecimal montoPago = new BigDecimal("0");
			if(montoRestaFraccionamiento.intValue() == 0) {
				credito.setMontoResta(new BigDecimal("0"));
			}else {
				if (credito.getMontoResta() != null) {
					//montoPago = detPlanPagos.getMontoResta();
					montoPago = credito.getMontoTotal();
					montoPago= montoPago.subtract(sumaMonto);
				} else {
					montoPago = credito.getMontoTotal();
				}
				credito.setMontoResta(montoPago.subtract(entryMap.getValue()));
			}
			creditoDaoImpl.update(credito);
		}
	}
	
	@Override
	public String generarReportePagoCliente(String idCobranza, String idCliente, String usuario) throws Exception {
		String fileName = UUIDUtil.generarElementUUID();
		String codigoGeneradoReporte = fileName;
		UsuarioDTO resultado = null;
		Usuario resultadoEntity = null;
		try {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setIdCliente(idCliente);		
			cliente = this.ventaServiceImpl.controladorAccionCliente(cliente, AccionType.FIND_BY_ID); 
			Map<String, Object> parametros = new HashMap<String, Object>();
			String[] subreportes;
			subreportes = new String[0];	
			parametros.put("nombreCliente", cliente.getNombre() + " " +  cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());
			parametros.put("ruta", "");
			parametros.put("nroDocCli", cliente.getNroDoc());
			parametros.put("direccion", cliente.getDireccion());
			//parametros.put("tipodocCliente", cliente.getItemByTipoDocumentoIdentidad().getNombre());
			
			List<CobranzaDTO> listaControlPagoGenerar = new ArrayList<CobranzaDTO>();
			CobranzaDTO cobranzaReporte = new CobranzaDTO();
			cobranzaReporte.setIdCobranza(idCobranza);
			cobranzaReporte.setIdPadreView(idCliente);
			cobranzaReporte.setCliente(cliente);

			cobranzaReporte = this.listarCobranza(cobranzaReporte).get(0);
			if (cobranzaReporte.getCliente() == null || cobranzaReporte.getCliente().getIdCliente() == null) {
				cobranzaReporte.setCliente(new ClienteDTO());
			}
			
			resultadoEntity= this.usuarioServiceImpl.findUsuario(cobranzaReporte.getUsuarioCreacion());
			resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,UsuarioDTO.class);
			parametros.put("nombreCajero", resultado.getNombre()+ " " + resultado.getApellidoPaterno()+ " " +resultado.getApellidoMaterno());
			NumerosUtil numLetra= new NumerosUtil();
			parametros.put("montoLetra", numLetra.Convertir(cobranzaReporte.getMontoTotal().toString(), true));
			
			cobranzaReporte.setCliente(cliente);
			List<DetCobranzaDTO> listaDetControlPago = verDetalleCobranzaRealizados(idCobranza);
			cobranzaReporte.setControlPagoDetControlPagoList(listaDetControlPago);
			listaControlPagoGenerar.add(cobranzaReporte);
			NombreReporteType reporte = NombreReporteType.JR_REP_BOLETA_PAGOS_REALIZADOS_CLIENTE;
			ParametroReporteVO parametroReporteVO = new ParametroReporteVO(parametros, listaControlPagoGenerar, reporte, subreportes, null, true, "", "");
			parametroReporteVO.setFormato(TipoReporteGenerarType.PDF.getKey());
			parametroReporteVO.setUserName(usuario);
			parametroReporteVO.setFileName(fileName);
			codigoGeneradoReporte = generarReporteServiceImpl.obtenerParametroReporteBigMemory(parametroReporteVO);
			return codigoGeneradoReporte;
		} catch (Exception e) {
			log.error(e);
		}
		return codigoGeneradoReporte;
	}
	
	@Override
	public List<CreditoDTO> listarConceptoPagoCliente(String idCliente,boolean flagFaltaMontoResta) throws Exception {
		List<CreditoDTO> resultado = new ArrayList<CreditoDTO>();
		List<Credito> resultadoTemp = creditoDaoImpl.listarConceptoPagoCliente(idCliente, flagFaltaMontoResta);
		List<String> listaDetPlanPagos = new ArrayList<String>();
		for (Credito objData : resultadoTemp) {
			if (FlagConceptoPagoFraccionadoType.SI.getKey().equals(objData.getFlagFraccionado())) {
				listaDetPlanPagos.add(objData.getIdCredito());			
			}
			CreditoDTO credito = TransferDataObjectUtil.transferObjetoEntityDTO(objData, CreditoDTO.class);
		 	VerificacionFisicaDTO verificacionFisica = TransferDataObjectUtil.transferObjetoEntityDTO(objData.getVerificacionFisica(), VerificacionFisicaDTO.class, "evaluacionCredito");
		 	EvaluacionCreditoDTO evaluacionCredito = TransferDataObjectUtil.transferObjetoEntityDTO(objData.getVerificacionFisica().getEvaluacionCredito(), EvaluacionCreditoDTO.class, "cliente");
		 	ClienteDTO cliente= TransferDataObjectUtil.transferObjetoEntityDTO(objData.getVerificacionFisica().getEvaluacionCredito().getCliente(), ClienteDTO.class,"itemByEstadoCivil","itemByCategoriaCliente","itemByTipoDocumentoIdentidad");
		 	credito.setVerificacionFisica(verificacionFisica);
		 	credito.getVerificacionFisica().setEvaluacionCredito(evaluacionCredito);
		 	credito.getVerificacionFisica().getEvaluacionCredito().setCliente(cliente);
			resultado.add(credito);
		}
		Map<String,List<Fraccionamiento>> fraccionamientoMap = fraccionamientoDaoImpl.obtenerListaFraccionamientoMap(listaDetPlanPagos, flagFaltaMontoResta);
		for (CreditoDTO objData : resultado) {
			if (FlagConceptoPagoFraccionadoType.SI.getKey().equals(objData.getFlagFraccionado())) {
				if (fraccionamientoMap.containsKey(objData.getIdCredito())) {
					List<FraccionamientoDTO> listaFraccionamiento = TransferDataObjectUtil.transferObjetoEntityDTOList(fraccionamientoMap.get(objData.getIdCredito()),FraccionamientoDTO.class,"credito");
					objData.setListaFraccionamientos(listaFraccionamiento);
				}
			}
		}
		
		return resultado;
	}
	
	@Override
	public CreditoDTO findByPrestamoDatos (String idCliente) throws Exception {
		CreditoDTO resultado = new CreditoDTO();
		Credito credito = creditoDaoImpl.findByPrestamoDatos(idCliente);
		resultado = TransferDataObjectUtil.transferObjetoEntityDTO(credito,CreditoDTO.class,"verificacionFisica");
	
		credito = null;
		return resultado;
	}

	@Override
	public CajaDTO controladorAccionCaja(CajaDTO caja, AccionType accionType) throws Exception {
		String userName = AppAuthenticator.getInstance().getUserName(caja.getAuthToken());
		CajaDTO resultado = null;
		Caja resultadoEntity = null;
			switch (accionType) {
			case CREAR:
				caja.setIdCaja(this.cajaDaoImpl.generarIdCaja());
				caja.setHoraApertura(FechaUtil.obtenerHoraMinutos());
				caja.setDescripcion(FechaUtil.obtenerFechaFormatoPersonalizado(caja.getFechaCreacion(), "dd/MM/yyyy"));
				//caja.setFechaCreacion(FechaUtil.obtenerFecha());
				caja.setEstado(EstadoGeneralState.ABIERTO.getKey());
				caja.setUsuarioCreacion(userName);
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(caja, Caja.class,"usuario");
				this.cajaDaoImpl.save(resultadoEntity);	
				resultado = caja;
				break;				
			case MODIFICAR:
				//caja.setFechaModificacion(FechaUtil.obtenerFecha());
				if(!StringUtils.isNotNullOrBlank(caja.getHoraCierre())) {
					caja.setEstado(EstadoGeneralState.ABIERTO.getKey());
				}else {
					caja.setEstado(EstadoGeneralState.CERRADO.getKey());	
				}
		
				caja.setUsuarioModificacion(userName);
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(caja, Caja.class,"usuario");
				this.cajaDaoImpl.update(resultadoEntity);
				resultado = caja;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.cajaDaoImpl.find(Caja.class, caja.getIdCaja());
				this.cajaDaoImpl.delete(resultadoEntity);
				resultado = caja;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.cajaDaoImpl.find(Caja.class, caja.getIdCaja());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,CajaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.categoriaDaoImpl.findByNombre(categoria),CategoriaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}

	@Override
	public List<CajaDTO> listarCaja(CajaDTO caja) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.cajaDaoImpl.listarCaja(caja),CajaDTO.class,"usuario");
	}

	@Override
	public int contarListarCaja(CajaDTO caja) {
		return this.cajaDaoImpl.contarListarCaja(caja);
	}

	@Override
	public CajaDTO findByCaja(String idUsuario) throws Exception {
		CajaDTO resultado = new CajaDTO();
		Caja caja = cajaDaoImpl.findByCaja(idUsuario);
		resultado = TransferDataObjectUtil.transferObjetoEntityDTO(caja,CajaDTO.class,"usuario");
		caja = null;
		return resultado;
	}
	
	@Override
	public CajaDTO findByCajaFecha(String idUsuario,Date fecha) throws Exception {
		CajaDTO resultado = new CajaDTO();
		Caja caja = cajaDaoImpl.findByCajaFecha(idUsuario, fecha);
		resultado = TransferDataObjectUtil.transferObjetoEntityDTO(caja,CajaDTO.class,"usuario");
		caja = null;
		return resultado;
	}
	
	@Override
	public String iniciarAperturaCaja() throws Exception { 
		String codigoGeneradoReporte = "";
		CajaDTO caja = new CajaDTO();
		caja.setId("primaKey");
		List<CajaDTO> listadoCaj =this.listarCaja(caja); 
		if(listadoCaj.size() > 0) { 
			
		}else {
			CajaDTO cajaC = new CajaDTO(); 
			int montoApertuera = 0;
			cajaC.setMontoApertuera(new BigDecimal(montoApertuera));
			cajaC.setDescripcion(FechaUtil.obtenerFechaFormatoPersonalizado(FechaUtil.obtenerFechaActual(), "dd/MM/yyyy"));
			this.controladorAccionCaja(cajaC, AccionType.CREAR);
		}		
		return codigoGeneradoReporte;
	}
	
	@Override
	public CajaDTO findByCaja() throws Exception {
		CajaDTO resultado = new CajaDTO();
		Caja caja = cajaDaoImpl.findByCaja();
		resultado = TransferDataObjectUtil.transferObjetoEntityDTO(caja,CajaDTO.class);

		caja = null;
		return resultado;
	}
	
	@Override
	public void updateVentaCierre(String idUsuario,Date fecha) throws Exception{

		Usuario usraio = this.usuarioServiceImpl.find(Usuario.class, idUsuario); 
		
		//BigDecimal montoTotalVenta=ventaDaoImpl.contarMontoTotalVenta(usraio.getUserName(), fecha);
		BigDecimal montoTotalCobranza = cobranzaDaoImpl.contarMontoTotalCobranza(usraio.getUserName(), fecha);
		BigDecimal contador = montoTotalCobranza;

 
		CajaDTO cajaBy = findByCajaFecha(idUsuario,fecha);
		cajaBy.setMontoTotal(contador.add(cajaBy.getMontoApertuera()));
		cajaBy.setMontoCiere(contador);
		cajaBy.setFechaActual(fecha);
		cajaBy.setAdmin(usraio.getUserName());
		this.cajaDaoImpl.updateCajaCierre(cajaBy); 
		//this.ventaDaoImpl.updateVentaCierre(cajaBy.getIdCaja(),cajaBy.getUsuario().getUserName()); 
		//return codigoGeneradoReporte;
	}
	
	
	@Override
	public List<IngresoVoDTO> listarIngresos(IngresoVoDTO filtro) throws Exception { 
		List<IngresoVoDTO> listaIngreso = cobranzaDaoImpl.listarIngresos(filtro);
		return listaIngreso;	
	}

	@Override
	public EgresoDTO controladorAccionEgreso(EgresoDTO egreso, AccionType accionType) throws Exception {
		String userName = AppAuthenticator.getInstance().getUserName(egreso.getAuthToken());
		EgresoDTO resultado = null;
		Egreso resultadoEntity = null;
			switch (accionType) {
			case CREAR:
				egreso.setIdEgreso(this.egresoDaoImpl.generarIdEgreso());
				egreso.setHora(FechaUtil.obtenerHoraMinutos()); 
				egreso.setFechaCreacion(FechaUtil.obtenerFecha());
				egreso.setEstado(EstadoGeneralState.ABIERTO.getKey());
				egreso.setUsuarioCreacion(userName);
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(egreso, Egreso.class,"usuario@PK@","itemByCategoria@PK@");
				this.egresoDaoImpl.save(resultadoEntity);	
				resultado = egreso;
				break;				
			case MODIFICAR:
				egreso.setFechaModificacion(FechaUtil.obtenerFecha()); 
				egreso.setUsuarioModificacion(userName);
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(egreso, Egreso.class,"usuario@PK@","itemByCategoria@PK@");
				this.egresoDaoImpl.update(resultadoEntity);
				resultado = egreso;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.egresoDaoImpl.find(Egreso.class, egreso.getIdEgreso());
				this.egresoDaoImpl.delete(resultadoEntity);
				resultado = egreso;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.egresoDaoImpl.find(Egreso.class, egreso.getIdEgreso());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,EgresoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.categoriaDaoImpl.findByNombre(categoria),CategoriaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}

	@Override
	public List<EgresoDTO> listarEgreso(EgresoDTO egreso) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.egresoDaoImpl.listarEgreso(egreso),EgresoDTO.class,"usuario","itemByCategoria");
	}

	@Override
	public int contarListarEgreso(EgresoDTO egreso) {
		return this.egresoDaoImpl.contarListarEgreso(egreso);
	}
	
	

	@Override
	public IngresoDTO controladorAccionIngreso(IngresoDTO ingreso, AccionType accionType) throws Exception {
		String userName = AppAuthenticator.getInstance().getUserName(ingreso.getAuthToken());
		IngresoDTO resultado = null;
		Ingreso resultadoEntity = null;
			switch (accionType) {
			case CREAR:
				ingreso.setIdIngreso(this.ingresoDaoImpl.generarIdIngreso());
				ingreso.setHora(FechaUtil.obtenerHoraMinutos()); 
				ingreso.setFechaCreacion(FechaUtil.obtenerFecha());
				ingreso.setEstado(EstadoGeneralState.ABIERTO.getKey());
				ingreso.setUsuarioCreacion(userName);
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(ingreso, Ingreso.class,"usuario@PK@","itemByCategoria@PK@");
				this.ingresoDaoImpl.save(resultadoEntity);	
				resultado = ingreso;
				break;				
			case MODIFICAR:
				ingreso.setFechaModificacion(FechaUtil.obtenerFecha()); 
				ingreso.setUsuarioModificacion(userName);
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(ingreso, Ingreso.class,"usuario@PK@","itemByCategoria@PK@");
				this.ingresoDaoImpl.update(resultadoEntity);
				resultado = ingreso;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.ingresoDaoImpl.find(Ingreso.class, ingreso.getIdIngreso());
				this.ingresoDaoImpl.delete(resultadoEntity);
				resultado = ingreso;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.ingresoDaoImpl.find(Ingreso.class, ingreso.getIdIngreso());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,IngresoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.categoriaDaoImpl.findByNombre(categoria),CategoriaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}

	@Override
	public List<IngresoDTO> listarIngreso(IngresoDTO ingreso) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.ingresoDaoImpl.listarIngreso(ingreso),IngresoDTO.class,"usuario","itemByCategoria");
	}

	@Override
	public int contarListarIngreso(IngresoDTO ingreso) { 
		return this.ingresoDaoImpl.contarListarIngreso(ingreso);
	}

	//prestamoInterno
	@Override
	public PrestamoInternoDTO controladorAccionPrestamoInterno(PrestamoInternoDTO prestamoInterno,AccionType accionType) throws Exception {
		String userName = AppAuthenticator.getInstance().getUserName(prestamoInterno.getAuthToken());
		PrestamoInternoDTO resultado = null;
		PrestamoInterno resultadoEntity = null;
		switch (accionType) {
		case CREAR:
			prestamoInterno.setIdPrestamoInterno(this.prestamoInternoDaoImpl.generarIdPrestamoInterno());
			prestamoInterno.setHora(FechaUtil.obtenerHoraMinutos()); 
			prestamoInterno.setFechaCreacion(FechaUtil.obtenerFecha());
			if(StringUtils.isNotNullOrBlank(prestamoInterno.getFechaPrestamo())) {
				prestamoInterno.setFechaPrestamo(FechaUtil.obtenerFecha());
			}
			prestamoInterno.setEstado(EstadoGeneralState.ABIERTO.getKey());
			prestamoInterno.setUsuarioCreacion(userName);
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(prestamoInterno, PrestamoInterno.class,"usuario@PK@");
			this.prestamoInternoDaoImpl.save(resultadoEntity);	
			resultado = prestamoInterno;
			break;				
		case MODIFICAR:
			prestamoInterno.setFechaModificacion(FechaUtil.obtenerFecha()); 
			prestamoInterno.setUsuarioModificacion(userName);
		    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(prestamoInterno, PrestamoInterno.class,"usuario@PK@");
			this.prestamoInternoDaoImpl.update(resultadoEntity);
			resultado = prestamoInterno;	
			break;
			
		case ELIMINAR:
			resultadoEntity = this.prestamoInternoDaoImpl.find(PrestamoInterno.class, prestamoInterno.getIdPrestamoInterno());
			this.prestamoInternoDaoImpl.delete(resultadoEntity);
			resultado = prestamoInterno;
			break;
			
		case FIND_BY_ID:
			resultadoEntity = this.prestamoInternoDaoImpl.find(PrestamoInterno.class, prestamoInterno.getIdPrestamoInterno());
			resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,PrestamoInternoDTO.class);
			break;
			
		/*case FIND_BY_NOMBRE:
			resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.categoriaDaoImpl.findByNombre(categoria),CategoriaDTO .class);
			break;*/
			
		default:
			break;
	}
	
	return resultado;
	}

	@Override
	public List<PrestamoInternoDTO> listarPrestamoInterno(PrestamoInternoDTO prestamoInterno) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.prestamoInternoDaoImpl.listarPrestamoInterno(prestamoInterno),PrestamoInternoDTO.class,"usuario");
	}

	@Override
	public int contarListarPrestamoInterno(PrestamoInternoDTO prestamoInterno) {
		return this.prestamoInternoDaoImpl.contarListarPrestamoInterno(prestamoInterno);
	}
	
	
	@Override
	public String generarReporteCronogramaPago(String idCredito) throws Exception {
		Credito credito= this.creditoDaoImpl.find(Credito.class, idCredito);
		//System.out.println(credito.getDescripcion() +" "+credito.getVerificacionFisica().getEvaluacionCredito().getCliente().getNombre());
		//UUIDUtil.generarElementUUID()
		String fileName = credito.getDescripcion() +" " +credito.getVerificacionFisica().getEvaluacionCredito().getCliente().getNombre();
		String codigoGeneradoReporte = fileName;
		Map<String, Object> parametros = new HashMap<String, Object>();
		String[] subreportes;
		subreportes = new String[0];	
		parametros.put("idCredito", idCredito);
		parametros.put("ruta", ""); 
		
		NombreReporteType reporte = NombreReporteType.JR_REP_REPORTE_CUOTA_PRESTAMO;
		ParametroReporteVO parametroReporteVO = new ParametroReporteVO(parametros, null, reporte, subreportes, null, false, "", "");
		parametroReporteVO.setFormato(TipoReporteGenerarType.PDF.getKey());
		parametroReporteVO.setFileName(fileName);
		codigoGeneradoReporte = generarReporteServiceImpl.obtenerParametroReporteBigMemory(parametroReporteVO);
		return codigoGeneradoReporte;
	} 
	
	
	//
	
	@Override
	public void eliminarControlPago(String idControlPago,String userName) throws Exception {
		//Eliminado detcontrolpago
		 eliminarControlPagos(idControlPago,true);
	}
	
	private void eliminarControlPagos(String idControlPago, boolean isAll) throws Exception {
		if (StringUtils.isNotNullOrBlank(idControlPago)) {
			BigDecimal montoQuitar = new BigDecimal("0");
			Map<String,BigDecimal>  cuotaMonto = new HashMap<String, BigDecimal>();
			List<DetCobranza> listaDetControlPago = detCobranzaDaoImpl.listaDetCobranza(idControlPago);
			for (DetCobranza detControlPagoMonto : listaDetControlPago) {
				cuotaMonto.put(detControlPagoMonto.getNroCuota(), detControlPagoMonto.getMonto());
				montoQuitar =montoQuitar.add(detControlPagoMonto.getMonto());
			}
			
			if (!CollectionUtil.isEmpty(listaDetControlPago)) {
				Credito detPlanpagos = creditoDaoImpl.find(Credito.class, listaDetControlPago.get(0).getCredito().getIdCredito());
				detPlanpagos.setMontoResta(detPlanpagos.getMontoResta().add(montoQuitar));
				creditoDaoImpl.update(detPlanpagos); 
				
				List<Fraccionamiento> listaFraccionamiento = fraccionamientoDaoImpl.listarFraccionamientoByDetPl(listaDetControlPago.get(0).getCredito().getIdCredito());
				for(Fraccionamiento fraccionamiento:listaFraccionamiento) {
					for (Map.Entry<String,BigDecimal> entryMap : cuotaMonto.entrySet()) {
						if(entryMap.getKey().equals(fraccionamiento.getNro())) {
							Fraccionamiento frm =  fraccionamientoDaoImpl.find(Fraccionamiento.class, fraccionamiento.getIdFraccionamiento());
							frm.setMontoFraccionadoResta(fraccionamiento.getMontoFraccionadoResta().add(entryMap.getValue() ));
							frm.setEstado("PENDIENTE");
							fraccionamientoDaoImpl.update(frm);
						}
					}
				}	
				for (DetCobranza detControlPagoDelete : listaDetControlPago) {
					detCobranzaDaoImpl.delete(detControlPagoDelete);
				}	
			}

			if (isAll) {
				Cobranza controlPagoEliminar = cobranzaDaoImpl.find(Cobranza.class, idControlPago);
				cobranzaDaoImpl.delete(controlPagoEliminar);
			}
		}
	}
	
	@Override
	public void eliminarDetControlPago(String idDetControlPago,String userName) throws Exception {
		//Eliminado detcontrolpago
		 eliminarDetControlPagos(idDetControlPago);
	}
	
	private void eliminarDetControlPagos(String idDetControlPago) throws Exception {
		if (StringUtils.isNotNullOrBlank(idDetControlPago)) {
			BigDecimal montoQuitar = new BigDecimal("0");
			Map<String,BigDecimal>  cuotaMonto = new HashMap<String, BigDecimal>();
			//List<DetControlPago> listaDetControlPago = detControlPagoDaoImpl.listaDetControlPago(idControlPago);
			DetCobranza detControlPago = detCobranzaDaoImpl.find(DetCobranza.class, idDetControlPago);
			cuotaMonto.put(detControlPago.getNroCuota(), detControlPago.getMonto());
			montoQuitar =montoQuitar.add(detControlPago.getMonto());
			/*for (DetControlPago detControlPagoMonto : listaDetControlPago) {
				cuotaMonto.put(detControlPagoMonto.getNroCuota(), detControlPagoMonto.getMonto());
				montoQuitar =montoQuitar.add(detControlPagoMonto.getMonto());
			}*/
				Credito detPlanpagos = creditoDaoImpl.find(Credito.class, detControlPago.getCredito().getIdCredito());
				detPlanpagos.setMontoResta(detPlanpagos.getMontoResta().add(montoQuitar));
				creditoDaoImpl.update(detPlanpagos); 
				List<Fraccionamiento> listaFraccionamiento = fraccionamientoDaoImpl.listarFraccionamientoByDetPl(detControlPago.getCredito().getIdCredito());
				for(Fraccionamiento fraccionamiento:listaFraccionamiento) {
					for (Map.Entry<String,BigDecimal> entryMap : cuotaMonto.entrySet()) {
						if(entryMap.getKey().equals(fraccionamiento.getNro())) {
							Fraccionamiento frm =  fraccionamientoDaoImpl.find(Fraccionamiento.class, fraccionamiento.getIdFraccionamiento());
							frm.setMontoFraccionadoResta(fraccionamiento.getMontoFraccionadoResta().add(entryMap.getValue() ));
							frm.setEstado("PENDIENTE");
							fraccionamientoDaoImpl.update(frm);
						}
					}
				}	
				Cobranza controlPago = cobranzaDaoImpl.find(Cobranza.class, detControlPago.getCobranza().getIdCobranza());
				controlPago.setMontoTotal(controlPago.getMontoTotal().subtract(montoQuitar));
				controlPago.setSubMontoTotal(controlPago.getMontoTotal());
				detCobranzaDaoImpl.delete(detControlPago);
		}
	}
	
	
	@Override
	public CreditoDTO eliminarDetPlanPagos(CreditoDTO credito) throws Exception { 
		Credito resultadoEntity = this.creditoDaoImpl.find(Credito.class, credito.getIdCredito());
	 
		
		List<String>idDetPlanPagosDTO=new ArrayList<String>(); 
		idDetPlanPagosDTO.add(resultadoEntity.getIdCredito());  

		DetCobranzaDTO detControlPago = new DetCobranzaDTO();
		detControlPago.setId(resultadoEntity.getIdCredito());
		List<DetCobranza> lisDetControlPago = detCobranzaDaoImpl.listarDetCobranza(detControlPago);
		
		List<String>listaIdControlPago=new ArrayList<String>(); 
		
		for(DetCobranza detCon: lisDetControlPago){
			listaIdControlPago.add(detCon.getCobranza().getIdCobranza());
			DetCobranza detControl = detCobranzaDaoImpl.find(DetCobranza.class,detCon.getIdDetCobranza());
			detCobranzaDaoImpl.delete(detControl);
		}
		

		CobranzaDTO controlPago= new CobranzaDTO();
		controlPago.setListidEgresados(listaIdControlPago);
		if(listaIdControlPago.size() > 0) {
			List<Cobranza> listaControlPago = cobranzaDaoImpl.listarCobranza(controlPago);
			for(Cobranza control: listaControlPago) {
				Cobranza cont = cobranzaDaoImpl.find(Cobranza.class, control.getIdCobranza());
				cobranzaDaoImpl.delete(cont);
			}
		}
		
		for (Fraccionamiento objFracc : resultadoEntity.getDetPlanPagosFraccionamientoList()) {
			fraccionamientoDaoImpl.delete(objFracc);
		}
		this.creditoDaoImpl.delete(resultadoEntity);
		return credito;
	}
	
	public AvalDTO controladorAccionAval(AvalDTO aval,EvaluacionCredito evaluacionCredito,AccionType accionType) throws Exception {
		AvalDTO resultado = null;
		Aval resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				aval.setIdAval(avalDaoImpl.generarIdAval());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(aval, Aval.class,"persona@PK@","evaluacionCredito@PK@");
				resultadoEntity.setEvaluacionCredito(evaluacionCredito);
				this.avalDaoImpl.save(resultadoEntity);	
				resultado = aval;
				break;				
			case MODIFICAR:
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(aval, Aval.class,"persona@PK@","evaluacionCredito@PK@");
				resultadoEntity.setEvaluacionCredito(evaluacionCredito);
				this.avalDaoImpl.update(resultadoEntity);
				resultado = aval;	 
				break;
				
			case ELIMINAR:
				resultadoEntity = this.avalDaoImpl.find(Aval.class, aval.getIdAval());
				this.avalDaoImpl.delete(resultadoEntity);
				resultado = aval;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.avalDaoImpl.find(Aval.class, aval.getIdAval());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,AvalDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.detalleVentaDaoImpl.findByNombre(detalleVenta),DetalleVentaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	
	@Override
	public AvalDTO avalBy(String idEvaluacionCredito) throws Exception {
		AvalDTO resultado = new AvalDTO();
		Aval aval = avalDaoImpl.findByAval(idEvaluacionCredito);
		resultado = TransferDataObjectUtil.transferObjetoEntityDTO(aval,AvalDTO.class,"persona");
		aval = null;
		return resultado;
	}
}