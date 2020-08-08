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
import pe.com.builderp.core.model.vo.cooperativa.CompromisoPagoDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class ProformaRestController.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:24 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
@Path("/compromisoPagoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class CompromisoPagoRestController extends GenericServiceRestImpl {
	 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<CompromisoPagoDTO> crear(@Context HttpHeaders httpHeaders,CompromisoPagoDTO CompromisoPago) throws Exception {
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		CompromisoPago.setAuthToken(authToken);
		return controladorAccion(CompromisoPago,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<CompromisoPagoDTO> modificar(CompromisoPagoDTO CompromisoPago) throws Exception {
		return controladorAccion(CompromisoPago,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<CompromisoPagoDTO> eliminar(@PathParam("id") String idCompromisoPago) throws Exception {
		CompromisoPagoDTO CompromisoPago = new CompromisoPagoDTO();
		CompromisoPago.setIdCompromisoPago(idCompromisoPago);		
		return controladorAccion(CompromisoPago,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<CompromisoPagoDTO> controladorAccion(CompromisoPagoDTO CompromisoPago, AccionType accionType){
		ResultadoRestVO<CompromisoPagoDTO> resultado = new ResultadoRestVO<CompromisoPagoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionCompromisoPago(CompromisoPago,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<CompromisoPagoDTO> finById(@PathParam("id") String idCompromisoPago) throws Exception {
		CompromisoPagoDTO CompromisoPago = new CompromisoPagoDTO();
		CompromisoPago.setIdCompromisoPago(idCompromisoPago);
		return controladorAccion(CompromisoPago,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<CompromisoPagoDTO> listarCompromisoPago(@Context UriInfo info){
		ResultadoRestVO<CompromisoPagoDTO> resultado = new ResultadoRestVO<CompromisoPagoDTO>();
		CompromisoPagoDTO CompromisoPago = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarCompromisoPago(CompromisoPago));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<CompromisoPagoDTO> contarCompromisoPago(@Context UriInfo info){
		ResultadoRestVO<CompromisoPagoDTO> resultado = new ResultadoRestVO<CompromisoPagoDTO>();
		CompromisoPagoDTO CompromisoPago = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarCompromisoPago(CompromisoPago));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarCompromisoPago(CompromisoPago));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<CompromisoPagoDTO> inicializarCompromisoPago(@Context UriInfo info) throws Exception {
	     CompromisoPagoDTO CompromisoPago = transferUriInfo(info);
		 ResultadoRestVO<CompromisoPagoDTO> resultado = new ResultadoRestVO<CompromisoPagoDTO>();
		 try {
    		resultado.setObjetoResultado(CompromisoPago);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	private CompromisoPagoDTO transferUriInfo(@Context UriInfo info) {
		CompromisoPagoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,CompromisoPagoDTO.class);
		return resultado;
	}
	 
	
}