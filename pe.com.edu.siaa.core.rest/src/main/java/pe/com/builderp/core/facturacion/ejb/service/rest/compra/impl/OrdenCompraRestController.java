package pe.com.builderp.core.facturacion.ejb.service.rest.compra.impl;

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

import pe.com.builderp.core.facturacion.ejb.service.compra.local.CompraServiceLocal;
import pe.com.builderp.core.facturacion.model.dto.compra.OrdenCompraDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class OrdenCompraRestController.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:20 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
@Path("/ordenCompraRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class OrdenCompraRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient CompraServiceLocal compraServiceLocal;
	
	@POST
	public ResultadoRestVO<OrdenCompraDTO> crear(OrdenCompraDTO ordenCompra) throws Exception {
		return controladorAccion(ordenCompra,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<OrdenCompraDTO> modificar(OrdenCompraDTO ordenCompra) throws Exception {
		return controladorAccion(ordenCompra,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<OrdenCompraDTO> eliminar(@PathParam("id") String idOrdenCompra) throws Exception {
		OrdenCompraDTO ordenCompra = new OrdenCompraDTO();
		ordenCompra.setIdOrdenCompra(idOrdenCompra);		
		return controladorAccion(ordenCompra,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<OrdenCompraDTO> controladorAccion(OrdenCompraDTO ordenCompra, AccionType accionType){
		ResultadoRestVO<OrdenCompraDTO> resultado = new ResultadoRestVO<OrdenCompraDTO>();
		 try {
    		resultado.setObjetoResultado(compraServiceLocal.controladorAccionOrdenCompra(ordenCompra,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<OrdenCompraDTO> finById(@PathParam("id") String idOrdenCompra) throws Exception {
		OrdenCompraDTO ordenCompra = new OrdenCompraDTO();
		ordenCompra.setIdOrdenCompra(idOrdenCompra);
		return controladorAccion(ordenCompra,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<OrdenCompraDTO> listarOrdenCompra(@Context UriInfo info){
		ResultadoRestVO<OrdenCompraDTO> resultado = new ResultadoRestVO<OrdenCompraDTO>();
		OrdenCompraDTO ordenCompra = transferUriInfo(info);
		 try {
			resultado.setListaResultado(compraServiceLocal.listarOrdenCompra(ordenCompra));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<OrdenCompraDTO> contarOrdenCompra(@Context UriInfo info){
		ResultadoRestVO<OrdenCompraDTO> resultado = new ResultadoRestVO<OrdenCompraDTO>();
		OrdenCompraDTO ordenCompra = transferUriInfo(info);
		 try {
			 resultado.setContador(compraServiceLocal.contarListarOrdenCompra(ordenCompra));
			 if (resultado.isData()) {
				resultado.setListaResultado(compraServiceLocal.listarOrdenCompra(ordenCompra));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<OrdenCompraDTO> inicializarOrdenCompra(@Context UriInfo info) throws Exception {
	     OrdenCompraDTO ordenCompra = transferUriInfo(info);
		 ResultadoRestVO<OrdenCompraDTO> resultado = new ResultadoRestVO<OrdenCompraDTO>();
		 try {
    		resultado.setObjetoResultado(ordenCompra);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private OrdenCompraDTO transferUriInfo(@Context UriInfo info) {
		OrdenCompraDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,OrdenCompraDTO.class);
		return resultado;
	}
}