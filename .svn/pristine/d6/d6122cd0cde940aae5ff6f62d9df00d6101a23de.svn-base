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
import pe.com.builderp.core.facturacion.model.dto.venta.PedidoDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class PedidoRestController.
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
@Path("/pedidoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class PedidoRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient VentaServiceLocal ventaServiceLocal;
	
	@POST
	public ResultadoRestVO<PedidoDTO> crear(PedidoDTO pedido) throws Exception {
		return controladorAccion(pedido,AccionType.CREAR);
	}
	@PUT
	public ResultadoRestVO<PedidoDTO> modificar(PedidoDTO pedido) throws Exception {
		return controladorAccion(pedido,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<PedidoDTO> eliminar(@PathParam("id") String idPedido) throws Exception {
		PedidoDTO pedido = new PedidoDTO();
		pedido.setIdPedido(idPedido);		
		return controladorAccion(pedido,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<PedidoDTO> controladorAccion(PedidoDTO pedido, AccionType accionType){
		ResultadoRestVO<PedidoDTO> resultado = new ResultadoRestVO<PedidoDTO>();
		 try {
    		resultado.setObjetoResultado(ventaServiceLocal.controladorAccionPedido(pedido,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<PedidoDTO> finById(@PathParam("id") String idPedido) throws Exception {
		PedidoDTO pedido = new PedidoDTO();
		pedido.setIdPedido(idPedido);
		return controladorAccion(pedido,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<PedidoDTO> listarPedido(@Context UriInfo info){
		ResultadoRestVO<PedidoDTO> resultado = new ResultadoRestVO<PedidoDTO>();
		PedidoDTO pedido = transferUriInfo(info);
		 try {
			resultado.setListaResultado(ventaServiceLocal.listarPedido(pedido));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<PedidoDTO> contarPedido(@Context UriInfo info){
		ResultadoRestVO<PedidoDTO> resultado = new ResultadoRestVO<PedidoDTO>();
		PedidoDTO pedido = transferUriInfo(info);
		 try {
			 resultado.setContador(ventaServiceLocal.contarListarPedido(pedido));
			 if (resultado.isData()) {
				resultado.setListaResultado(ventaServiceLocal.listarPedido(pedido));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<PedidoDTO> inicializarPedido(@Context UriInfo info) throws Exception {
	     PedidoDTO pedido = transferUriInfo(info);
		 ResultadoRestVO<PedidoDTO> resultado = new ResultadoRestVO<PedidoDTO>();
		 try {
    		resultado.setObjetoResultado(pedido);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private PedidoDTO transferUriInfo(@Context UriInfo info) {
		PedidoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,PedidoDTO.class);
		return resultado;
	}
}