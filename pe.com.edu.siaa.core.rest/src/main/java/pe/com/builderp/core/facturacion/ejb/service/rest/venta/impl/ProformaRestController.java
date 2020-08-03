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
import pe.com.builderp.core.facturacion.model.dto.venta.ProformaDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
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
@Path("/proformaRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class ProformaRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient VentaServiceLocal ventaServiceLocal;
	
	@POST
	public ResultadoRestVO<ProformaDTO> crear(ProformaDTO proforma) throws Exception {
		return controladorAccion(proforma,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<ProformaDTO> modificar(ProformaDTO proforma) throws Exception {
		return controladorAccion(proforma,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<ProformaDTO> eliminar(@PathParam("id") String idProforma) throws Exception {
		ProformaDTO proforma = new ProformaDTO();
		proforma.setIdProforma(idProforma);		
		return controladorAccion(proforma,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<ProformaDTO> controladorAccion(ProformaDTO proforma, AccionType accionType){
		ResultadoRestVO<ProformaDTO> resultado = new ResultadoRestVO<ProformaDTO>();
		 try {
    		resultado.setObjetoResultado(ventaServiceLocal.controladorAccionProforma(proforma,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<ProformaDTO> finById(@PathParam("id") String idProforma) throws Exception {
		ProformaDTO proforma = new ProformaDTO();
		proforma.setIdProforma(idProforma);
		return controladorAccion(proforma,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<ProformaDTO> listarProforma(@Context UriInfo info){
		ResultadoRestVO<ProformaDTO> resultado = new ResultadoRestVO<ProformaDTO>();
		ProformaDTO proforma = transferUriInfo(info);
		 try {
			resultado.setListaResultado(ventaServiceLocal.listarProforma(proforma));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<ProformaDTO> contarProforma(@Context UriInfo info){
		ResultadoRestVO<ProformaDTO> resultado = new ResultadoRestVO<ProformaDTO>();
		ProformaDTO proforma = transferUriInfo(info);
		 try {
			 resultado.setContador(ventaServiceLocal.contarListarProforma(proforma));
			 if (resultado.isData()) {
				resultado.setListaResultado(ventaServiceLocal.listarProforma(proforma));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<ProformaDTO> inicializarProforma(@Context UriInfo info) throws Exception {
	     ProformaDTO proforma = transferUriInfo(info);
		 ResultadoRestVO<ProformaDTO> resultado = new ResultadoRestVO<ProformaDTO>();
		 try {
    		resultado.setObjetoResultado(proforma);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private ProformaDTO transferUriInfo(@Context UriInfo info) {
		ProformaDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,ProformaDTO.class);
		return resultado;
	}
}