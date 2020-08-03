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
import pe.com.builderp.core.model.vo.cooperativa.PrestamoInternoDTO; 
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
@Path("/prestamoInternoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class PrestamoInternoRestController extends GenericServiceRestImpl {
	 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<PrestamoInternoDTO> crear(@Context HttpHeaders httpHeaders,PrestamoInternoDTO PrestamoInterno) throws Exception {
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		PrestamoInterno.setAuthToken(authToken);
	    return controladorAccion(PrestamoInterno,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<PrestamoInternoDTO> modificar(PrestamoInternoDTO PrestamoInterno) throws Exception {
		return controladorAccion(PrestamoInterno,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<PrestamoInternoDTO> eliminar(@PathParam("id") String idPrestamoInterno) throws Exception {
		PrestamoInternoDTO PrestamoInterno = new PrestamoInternoDTO();
		PrestamoInterno.setIdPrestamoInterno(idPrestamoInterno);		
		return controladorAccion(PrestamoInterno,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<PrestamoInternoDTO> controladorAccion(PrestamoInternoDTO PrestamoInterno, AccionType accionType){
		ResultadoRestVO<PrestamoInternoDTO> resultado = new ResultadoRestVO<PrestamoInternoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionPrestamoInterno(PrestamoInterno,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<PrestamoInternoDTO> finById(@PathParam("id") String idPrestamoInterno) throws Exception {
		PrestamoInternoDTO PrestamoInterno = new PrestamoInternoDTO();
		PrestamoInterno.setIdPrestamoInterno(idPrestamoInterno);
		return controladorAccion(PrestamoInterno,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<PrestamoInternoDTO> listarPrestamoInterno(@Context UriInfo info){
		ResultadoRestVO<PrestamoInternoDTO> resultado = new ResultadoRestVO<PrestamoInternoDTO>();
		PrestamoInternoDTO PrestamoInterno = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarPrestamoInterno(PrestamoInterno));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<PrestamoInternoDTO> contarPrestamoInterno(@Context UriInfo info){
		ResultadoRestVO<PrestamoInternoDTO> resultado = new ResultadoRestVO<PrestamoInternoDTO>();
		PrestamoInternoDTO PrestamoInterno = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarPrestamoInterno(PrestamoInterno));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarPrestamoInterno(PrestamoInterno));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<PrestamoInternoDTO> inicializarPrestamoInterno(@Context UriInfo info) throws Exception {
	     PrestamoInternoDTO PrestamoInterno = transferUriInfo(info);
		 ResultadoRestVO<PrestamoInternoDTO> resultado = new ResultadoRestVO<PrestamoInternoDTO>();
		 try {
    		resultado.setObjetoResultado(PrestamoInterno);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private PrestamoInternoDTO transferUriInfo(@Context UriInfo info) {
		PrestamoInternoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,PrestamoInternoDTO.class);
		return resultado;
	}	
 
}