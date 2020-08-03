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
import pe.com.builderp.core.model.vo.cooperativa.EgresoDTO;
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
@Path("/egresoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class EgresoRestController extends GenericServiceRestImpl {
	 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<EgresoDTO> crear(@Context HttpHeaders httpHeaders,EgresoDTO egreso) throws Exception {
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		egreso.setAuthToken(authToken);
		return controladorAccion(egreso,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<EgresoDTO> modificar(EgresoDTO egreso) throws Exception {
		return controladorAccion(egreso,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<EgresoDTO> eliminar(@PathParam("id") String idEgreso) throws Exception {
		EgresoDTO egreso = new EgresoDTO();
		egreso.setIdEgreso(idEgreso);		
		return controladorAccion(egreso,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<EgresoDTO> controladorAccion(EgresoDTO egreso, AccionType accionType){
		ResultadoRestVO<EgresoDTO> resultado = new ResultadoRestVO<EgresoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionEgreso(egreso,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<EgresoDTO> finById(@PathParam("id") String idEgreso) throws Exception {
		EgresoDTO egreso = new EgresoDTO();
		egreso.setIdEgreso(idEgreso);
		return controladorAccion(egreso,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<EgresoDTO> listarEgreso(@Context UriInfo info){
		ResultadoRestVO<EgresoDTO> resultado = new ResultadoRestVO<EgresoDTO>();
		EgresoDTO egreso = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarEgreso(egreso));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<EgresoDTO> contarEgreso(@Context UriInfo info){
		ResultadoRestVO<EgresoDTO> resultado = new ResultadoRestVO<EgresoDTO>();
		EgresoDTO egreso = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarEgreso(egreso));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarEgreso(egreso));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<EgresoDTO> inicializarEgreso(@Context UriInfo info) throws Exception {
	     EgresoDTO egreso = transferUriInfo(info);
		 ResultadoRestVO<EgresoDTO> resultado = new ResultadoRestVO<EgresoDTO>();
		 try {
    		resultado.setObjetoResultado(egreso);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private EgresoDTO transferUriInfo(@Context UriInfo info) {
		EgresoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,EgresoDTO.class);
		return resultado;
	}	
}