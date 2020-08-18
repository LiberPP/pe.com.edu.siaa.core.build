package pe.com.builderp.core.facturacion.ejb.service.rest.venta.impl;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import pe.com.builderp.core.facturacion.ejb.service.venta.local.VentaServiceLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.AvalDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class AvalRestController.
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
@Path("/avalRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class AvalRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient VentaServiceLocal ventaServiceLocal;
	
	@POST
	public ResultadoRestVO<AvalDTO> crear(AvalDTO Aval) throws Exception {
		return controladorAccion(Aval,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<AvalDTO> modificar(AvalDTO Aval) throws Exception {
		return controladorAccion(Aval,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<AvalDTO> eliminar(@PathParam("id") String idAval) throws Exception {
		AvalDTO Aval = new AvalDTO();
		Aval.setIdAval(idAval);		
		return controladorAccion(Aval,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<AvalDTO> controladorAccion(AvalDTO Aval, AccionType accionType){
		ResultadoRestVO<AvalDTO> resultado = new ResultadoRestVO<AvalDTO>();
		 try {
    		resultado.setObjetoResultado(ventaServiceLocal.controladorAccionAval(Aval,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<AvalDTO> finById(@PathParam("id") String idAval) throws Exception {
		AvalDTO Aval = new AvalDTO();
		Aval.setIdAval(idAval);
		return controladorAccion(Aval,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<AvalDTO> listarAval(@Context UriInfo info){
		ResultadoRestVO<AvalDTO> resultado = new ResultadoRestVO<AvalDTO>();
		AvalDTO Aval = transferUriInfo(info);
		 try {
			resultado.setListaResultado(ventaServiceLocal.listarAval(Aval));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<AvalDTO> contarAval(@Context UriInfo info){
		ResultadoRestVO<AvalDTO> resultado = new ResultadoRestVO<AvalDTO>();
		AvalDTO Aval = transferUriInfo(info);
		 try {
			 resultado.setContador(ventaServiceLocal.contarListarAval(Aval));
			 if (resultado.isData()) {
				resultado.setListaResultado(ventaServiceLocal.listarAval(Aval));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<AvalDTO> inicializarAval(@Context UriInfo info) throws Exception {
	     AvalDTO Aval = transferUriInfo(info);
		 ResultadoRestVO<AvalDTO> resultado = new ResultadoRestVO<AvalDTO>();
		 try {
    		resultado.setObjetoResultado(Aval);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private AvalDTO transferUriInfo(@Context UriInfo info) {
		AvalDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,AvalDTO.class);
		return resultado;
	}
}