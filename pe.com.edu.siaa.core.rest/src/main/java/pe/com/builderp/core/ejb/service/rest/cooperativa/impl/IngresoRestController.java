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
import pe.com.builderp.core.model.vo.cooperativa.IngresoDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoVoDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
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
@Path("/ingresoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class IngresoRestController extends GenericServiceRestImpl {
	 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<IngresoDTO> crear(@Context HttpHeaders httpHeaders,IngresoDTO ingreso) throws Exception {
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		ingreso.setAuthToken(authToken);
		System.out.println("Fecha Metodo:: " +FechaUtil.obtenerFecha() +" fecha22:: " +ingreso.getFechaIngreso());
		return controladorAccion(ingreso,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<IngresoDTO> modificar(IngresoDTO ingreso) throws Exception {
		return controladorAccion(ingreso,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<IngresoDTO> eliminar(@PathParam("id") String idIngreso) throws Exception {
		IngresoDTO ingreso = new IngresoDTO();
		ingreso.setIdIngreso(idIngreso);		
		return controladorAccion(ingreso,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<IngresoDTO> controladorAccion(IngresoDTO ingreso, AccionType accionType){
		ResultadoRestVO<IngresoDTO> resultado = new ResultadoRestVO<IngresoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionIngreso(ingreso,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<IngresoDTO> finById(@PathParam("id") String idIngreso) throws Exception {
		IngresoDTO Ingreso = new IngresoDTO();
		Ingreso.setIdIngreso(idIngreso);
		return controladorAccion(Ingreso,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<IngresoDTO> listarIngreso(@Context UriInfo info){
		ResultadoRestVO<IngresoDTO> resultado = new ResultadoRestVO<IngresoDTO>();
		IngresoDTO Ingreso = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarIngreso(Ingreso));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<IngresoDTO> contarIngreso(@Context UriInfo info){
		ResultadoRestVO<IngresoDTO> resultado = new ResultadoRestVO<IngresoDTO>();
		IngresoDTO Ingreso = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarIngreso(Ingreso));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarIngreso(Ingreso));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<IngresoDTO> inicializarIngreso(@Context UriInfo info) throws Exception {
	     IngresoDTO Ingreso = transferUriInfo(info);
		 ResultadoRestVO<IngresoDTO> resultado = new ResultadoRestVO<IngresoDTO>();
		 try {
    		resultado.setObjetoResultado(Ingreso);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private IngresoDTO transferUriInfo(@Context UriInfo info) {
		IngresoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,IngresoDTO.class);
		return resultado;
	}	
	
	
	
	
	@GET
    @Path("/listarIngresos")
	public ResultadoRestVO<IngresoVoDTO> listarIngresos(@Context UriInfo info) throws Exception {
		 ResultadoRestVO<IngresoVoDTO> resultado = new ResultadoRestVO<IngresoVoDTO>();
		 IngresoVoDTO filtro = transferUriInfoFiltroVO(info);
		 try {
			 resultado.setListaResultado(cooperativaServiceLocal.listarIngresos(filtro));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private IngresoVoDTO transferUriInfoFiltroVO(@Context UriInfo info) {
		IngresoVoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,IngresoVoDTO.class);
		return resultado;
	}
	
}