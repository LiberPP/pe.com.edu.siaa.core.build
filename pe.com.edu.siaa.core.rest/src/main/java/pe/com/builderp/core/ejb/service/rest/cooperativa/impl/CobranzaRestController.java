package pe.com.builderp.core.ejb.service.rest.cooperativa.impl;
 
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import pe.com.builderp.core.ejb.service.cooperativa.local.CooperativaServiceLocal;
import pe.com.builderp.core.model.vo.cooperativa.CobranzaDTO; 
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames; 
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.ejb.util.cache.AppAuthenticator; 
import pe.com.edu.siaa.core.model.type.AccionType; 
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class CobranzaRestController.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 13:43:36 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
@Path("/cobranzaRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class CobranzaRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<CobranzaDTO> registrarPago(@Context HttpHeaders httpHeaders,CobranzaDTO cobranza) throws Exception {
		ResultadoRestVO<CobranzaDTO> resultado = new ResultadoRestVO<CobranzaDTO>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		String ip = httpHeaders.getHeaderString( AppHTTPHeaderNames.ORIGIN );
		cobranza.setServiceKey(serviceKey);
		cobranza.setAuthToken(authToken);
		cobranza.setIp(ip);
		 try { 
			 cooperativaServiceLocal.registrarCobranza(cobranza);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
			resultado.setMensajeError("Error al Registar Pago ==> " + e.getMessage());
		}
		return resultado;
	}
	
	  
	//add
	@GET
    @Path("/generarReportePagoCliente/{idCobranza}/{idCliente}")
	public ResultadoRestVO<String> generarReportePagoCliente(@Context HttpHeaders httpHeaders,@PathParam("idCobranza") String idCobranza,@PathParam("idCliente") String idCliente){
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>(); 
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		 try {
			 String userName = AppAuthenticator.getInstance().getUserName(authToken);
			 resultado.setObjetoResultado(cooperativaServiceLocal.generarReportePagoCliente(idCobranza, idCliente, userName));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<String> eliminar(@Context HttpHeaders httpHeaders,@PathParam("id") String idCobranza) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		 try {
			 String userName = AppAuthenticator.getInstance().getUserName(authToken);
			 cooperativaServiceLocal.eliminarControlPago(idCobranza,userName);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
		/*CobranzaDTO Cobranza = new CobranzaDTO();
		Cobranza.setIdCobranza(idCobranza);		
		return controladorAccion(Cobranza,AccionType.ELIMINAR);*/
	}
	private ResultadoRestVO<CobranzaDTO> controladorAccion(CobranzaDTO Cobranza, AccionType accionType){
		ResultadoRestVO<CobranzaDTO> resultado = new ResultadoRestVO<CobranzaDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionCobranza(Cobranza,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<CobranzaDTO> finById(@PathParam("id") String idCobranza) throws Exception {
		CobranzaDTO Cobranza = new CobranzaDTO();
		Cobranza.setIdCobranza(idCobranza);
		return controladorAccion(Cobranza,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<CobranzaDTO> listarCobranza(@Context UriInfo info){
		ResultadoRestVO<CobranzaDTO> resultado = new ResultadoRestVO<CobranzaDTO>();
		CobranzaDTO Cobranza = transferUriInfo(info);
		 try {
    		resultado.setListaResultado(cooperativaServiceLocal.listarCobranza(Cobranza));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<CobranzaDTO> contarListarCobranza(@Context UriInfo info){
		ResultadoRestVO<CobranzaDTO> resultado = new ResultadoRestVO<CobranzaDTO>();
		CobranzaDTO Cobranza = transferUriInfo(info);
		 try {
    		resultado.setContador(cooperativaServiceLocal.contarListarCobranza(Cobranza));
    		if (resultado.isData()) {
    			resultado.setListaResultado(cooperativaServiceLocal.listarCobranza(Cobranza));
    		}
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<CobranzaDTO> inicializarCobranza(@Context UriInfo info) throws Exception {
	     CobranzaDTO Cobranza = transferUriInfo(info);
		 ResultadoRestVO<CobranzaDTO> resultado = new ResultadoRestVO<CobranzaDTO>();
		 try {
    		resultado.setObjetoResultado(Cobranza);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private CobranzaDTO transferUriInfo(@Context UriInfo info) {
		CobranzaDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,CobranzaDTO.class);
		return resultado;
	}  

 
}