package pe.com.builderp.core.ejb.service.rest.cooperativa.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
 

import pe.com.builderp.core.ejb.service.cooperativa.local.CooperativaServiceLocal;
import pe.com.builderp.core.model.vo.cooperativa.AvalDatosDTO;
import pe.com.builderp.core.model.vo.cooperativa.EvaluacionCreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.InformacionLaboralDTO;
import pe.com.builderp.core.model.vo.cooperativa.ReferenciaPersonalDTO; 
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class CategoriaRestController.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:21 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
@Path("/evaluacionCreditoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class EvaluacionCreditoRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<EvaluacionCreditoDTO> crear(@Context HttpHeaders httpHeaders,EvaluacionCreditoDTO evaluacionCredito) throws Exception {
		ResultadoRestVO<EvaluacionCreditoDTO> resultado = new ResultadoRestVO<EvaluacionCreditoDTO>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		String ip = httpHeaders.getHeaderString( AppHTTPHeaderNames.ORIGIN );
		evaluacionCredito.setServiceKey(serviceKey);
		evaluacionCredito.setAuthToken(authToken);
		evaluacionCredito.setIp(ip);
		 try { 
			 cooperativaServiceLocal.registrarEvaluacionCredito(evaluacionCredito);   
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
			resultado.setMensajeError("Error ==> " + e.getMessage());
		}
		return resultado;
	}
	@PUT
	public ResultadoRestVO<EvaluacionCreditoDTO> modificar(EvaluacionCreditoDTO EvaluacionCredito) throws Exception {
		return controladorAccion(EvaluacionCredito,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<EvaluacionCreditoDTO> eliminar(@PathParam("id") String idEvaluacionCredito) throws Exception {
		EvaluacionCreditoDTO EvaluacionCredito = new EvaluacionCreditoDTO();
		EvaluacionCredito.setIdEvaluacionCredito(idEvaluacionCredito);		
		return controladorAccion(EvaluacionCredito,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<EvaluacionCreditoDTO> controladorAccion(EvaluacionCreditoDTO EvaluacionCredito, AccionType accionType){
		ResultadoRestVO<EvaluacionCreditoDTO> resultado = new ResultadoRestVO<EvaluacionCreditoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionEvaluacionCredito(EvaluacionCredito,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<EvaluacionCreditoDTO> finById(@PathParam("id") String idEvaluacionCredito) throws Exception {
		EvaluacionCreditoDTO EvaluacionCredito = new EvaluacionCreditoDTO();
		EvaluacionCredito.setIdEvaluacionCredito(idEvaluacionCredito);
		return controladorAccion(EvaluacionCredito,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<EvaluacionCreditoDTO> listarEvaluacionCredito(@Context UriInfo info){
		ResultadoRestVO<EvaluacionCreditoDTO> resultado = new ResultadoRestVO<EvaluacionCreditoDTO>();
		EvaluacionCreditoDTO EvaluacionCredito = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarEvaluacionCredito(EvaluacionCredito));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<EvaluacionCreditoDTO> contarEvaluacionCredito(@Context UriInfo info){
		ResultadoRestVO<EvaluacionCreditoDTO> resultado = new ResultadoRestVO<EvaluacionCreditoDTO>();
		EvaluacionCreditoDTO EvaluacionCredito = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarEvaluacionCredito(EvaluacionCredito));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarEvaluacionCredito(EvaluacionCredito));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<EvaluacionCreditoDTO> inicializarEvaluacionCredito(@Context UriInfo info) throws Exception {
	     EvaluacionCreditoDTO EvaluacionCredito = transferUriInfo(info);
		 ResultadoRestVO<EvaluacionCreditoDTO> resultado = new ResultadoRestVO<EvaluacionCreditoDTO>();
		 try {
    		resultado.setObjetoResultado(EvaluacionCredito);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private EvaluacionCreditoDTO transferUriInfo(@Context UriInfo info) {
		EvaluacionCreditoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,EvaluacionCreditoDTO.class);
		return resultado;
	}
	
	private ReferenciaPersonalDTO transferUriInfoReferencia(@Context UriInfo info) {
		ReferenciaPersonalDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,ReferenciaPersonalDTO.class);
		return resultado;
	}
	
	@GET
    @Path("/listarReferenciaPersonal")
	public ResultadoRestVO<ReferenciaPersonalDTO> listarReferenciaPersonal(@Context UriInfo info){
		ResultadoRestVO<ReferenciaPersonalDTO> resultado = new ResultadoRestVO<ReferenciaPersonalDTO>();
		ReferenciaPersonalDTO referencia = transferUriInfoReferencia(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarReferenciaPersonal(referencia));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
    @Path("/informacionLaboral/{idEvaluacionCredito}")
	public ResultadoRestVO<InformacionLaboralDTO> informacionLaboral(@Context UriInfo info,@PathParam("idEvaluacionCredito") String idEvaluacionCredito){
		ResultadoRestVO<InformacionLaboralDTO> resultado = new ResultadoRestVO<InformacionLaboralDTO>();
		//ReferenciaPersonalDTO referencia = transferUriInfoReferencia(info);
		 try {
			resultado.setObjetoResultado(cooperativaServiceLocal.informacionLaboralBy(idEvaluacionCredito));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
    @Path("/informacionLaboralAvalDatos/{idAvalDatos}")
	public ResultadoRestVO<InformacionLaboralDTO> informacionLaboralAvalDatos(@Context UriInfo info,@PathParam("idAvalDatos") String idAvalDatos){
		ResultadoRestVO<InformacionLaboralDTO> resultado = new ResultadoRestVO<InformacionLaboralDTO>();
		//ReferenciaPersonalDTO referencia = transferUriInfoReferencia(info);
		 try {
			resultado.setObjetoResultado(cooperativaServiceLocal.informacionLaboralAvalDatos(idAvalDatos));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
    @Path("/getaval/{idEvaluacionCredito}")
	public ResultadoRestVO<AvalDatosDTO> getaval(@Context UriInfo info,@PathParam("idEvaluacionCredito") String idEvaluacionCredito){
		ResultadoRestVO<AvalDatosDTO> resultado = new ResultadoRestVO<AvalDatosDTO>();
		//ReferenciaPersonalDTO referencia = transferUriInfoReferencia(info);
		 try {
			resultado.setObjetoResultado(cooperativaServiceLocal.avalBy(idEvaluacionCredito));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
}