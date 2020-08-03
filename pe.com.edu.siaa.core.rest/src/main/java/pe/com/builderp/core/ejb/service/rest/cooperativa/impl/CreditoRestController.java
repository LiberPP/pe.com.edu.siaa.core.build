package pe.com.builderp.core.ejb.service.rest.cooperativa.impl;

import java.util.ArrayList;
import java.util.List;

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
import pe.com.builderp.core.model.vo.cooperativa.ConceptoCobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.CreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.FraccionamientoDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
import pe.com.edu.siaa.core.ejb.util.date.FechaDateUtil;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.model.type.FlagConceptoPagoFraccionadoType;
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
@Path("/creditoRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class CreditoRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<CreditoDTO> crear(@Context HttpHeaders httpHeaders,CreditoDTO Credito) throws Exception {
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		Credito.setServiceKey(serviceKey);
		Credito.setAuthToken(authToken);
		ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.registrarCredito(Credito));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@PUT
	public ResultadoRestVO<CreditoDTO> modificar(CreditoDTO Credito) throws Exception {
		return controladorAccion(Credito,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<CreditoDTO> eliminar(@PathParam("id") String idCredito) throws Exception {
		ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		 try {
			 CreditoDTO detPlanPagos = new CreditoDTO();
			 detPlanPagos.setIdCredito(idCredito);	
			 resultado.setObjetoResultado(cooperativaServiceLocal.eliminarDetPlanPagos(detPlanPagos));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
		/*CreditoDTO Credito = new CreditoDTO();
		Credito.setIdCredito(idCredito);		
		return controladorAccion(Credito,AccionType.ELIMINAR);*/
	}
	private ResultadoRestVO<CreditoDTO> controladorAccion(CreditoDTO Credito, AccionType accionType){
		ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionCredito(Credito,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<CreditoDTO> finById(@PathParam("id") String idCredito) throws Exception {
		CreditoDTO Credito = new CreditoDTO();
		Credito.setIdCredito(idCredito);
		return controladorAccion(Credito,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<CreditoDTO> listarCredito(@Context UriInfo info){
		ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		CreditoDTO Credito = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarCredito(Credito));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<CreditoDTO> contarCredito(@Context UriInfo info){
		ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		CreditoDTO Credito = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarCredito(Credito));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarCredito(Credito));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<CreditoDTO> inicializarCredito(@Context UriInfo info) throws Exception {
	     CreditoDTO Credito = transferUriInfo(info);
		 ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		 try {
    		resultado.setObjetoResultado(Credito);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private CreditoDTO transferUriInfo(@Context UriInfo info) {
		CreditoDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,CreditoDTO.class);
		return resultado;
	}
	
	//add
	@GET
	@Path("/listarConceptoPagoCliente/{idCliente}/{flagFaltaMontoResta}")
	public ResultadoRestVO<ConceptoCobranzaDTO> listarConceptoPagoCliente(@PathParam("idCliente") String idCliente,@PathParam("flagFaltaMontoResta") boolean flagFaltaMontoResta) throws Exception {
		ResultadoRestVO<ConceptoCobranzaDTO> resultado = new ResultadoRestVO<ConceptoCobranzaDTO>();
		 try {
    		resultado.setListaResultado(listarConceptoPagoClienteSemestre(cooperativaServiceLocal.listarConceptoPagoCliente(idCliente, flagFaltaMontoResta)));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	//add
	public List<ConceptoCobranzaDTO> listarConceptoPagoClienteSemestre(List<CreditoDTO> listaDetPlanPagos) throws Exception {
		List<ConceptoCobranzaDTO> listaConceptoPagoDTO = new ArrayList<ConceptoCobranzaDTO>(); 
		for (CreditoDTO conceptoClientePago : listaDetPlanPagos) {
			if (conceptoClientePago.getFlagFraccionado().equals(FlagConceptoPagoFraccionadoType.NO.getKey())) {
				ConceptoCobranzaDTO conceptoPagoDTO = new ConceptoCobranzaDTO();
				conceptoPagoDTO.setIdCuotaConcepto(conceptoClientePago.getIdCredito());
				conceptoPagoDTO.setId(conceptoClientePago.getIdCredito());
				conceptoPagoDTO.setDescripcion("Codigo prestamo: "+conceptoClientePago.getDescripcion()+" - Cuota");
				conceptoPagoDTO.setFechaVencimiento(conceptoClientePago.getFechaVencimiento());
				if (conceptoClientePago.getMontoResta() != null) {
					conceptoPagoDTO.setMonto(conceptoClientePago.getMontoResta());
				}else {
					conceptoPagoDTO.setMonto(conceptoClientePago.getMontoTotal());
				}
				conceptoPagoDTO.setMontoTotalPrestamo(conceptoClientePago.getMontoTotal());
				conceptoPagoDTO.setMontoTotal(conceptoPagoDTO.getMonto());
				conceptoPagoDTO.setMontoResta(null);
				conceptoPagoDTO.setFlagFraccionadoDescripcion(conceptoClientePago.getFlagFraccionadoDescripcion());
				conceptoPagoDTO.setEsFraccionado(false);
				if (conceptoClientePago.getFechaVencimiento() != null) {
					conceptoPagoDTO.setNumeroDiasRetrazo(FechaDateUtil.restaFechas(conceptoClientePago.getFechaVencimiento(), FechaUtil.obtenerFecha()));
				}
				listaConceptoPagoDTO.add(conceptoPagoDTO);
			
			} else if (conceptoClientePago.getFlagFraccionado().equals(FlagConceptoPagoFraccionadoType.SI.getKey())) {
				for (FraccionamientoDTO fracConceoto : conceptoClientePago.getListaFraccionamientos()) {
					ConceptoCobranzaDTO conceptoPagoDTO = new ConceptoCobranzaDTO();
					conceptoPagoDTO.setIdCuotaConcepto(conceptoClientePago.getIdCredito());
					conceptoPagoDTO.setId(fracConceoto.getIdFraccionamiento());
					conceptoPagoDTO.setIdPadre(conceptoClientePago.getIdCredito());
					conceptoPagoDTO.setDescripcion("Codigo prestamo: "+fracConceoto.getCredito().getDescripcion()+" - Cuota" + " " + fracConceoto.getNro()  );
					conceptoPagoDTO.setNroCuota(fracConceoto.getNro());
					conceptoPagoDTO.setFechaVencimiento(fracConceoto.getFechaVencimiento());
					if (fracConceoto.getMontoFraccionadoResta() != null) {
						conceptoPagoDTO.setMonto(fracConceoto.getMontoFraccionadoResta());
					} else {
						conceptoPagoDTO.setMonto(fracConceoto.getCuotaFracionada());
					}
					conceptoPagoDTO.setMontoResta(null);
					conceptoPagoDTO.setFlagFraccionadoDescripcion(conceptoClientePago.getFlagFraccionadoDescripcion());
					conceptoPagoDTO.setEsFraccionado(true);
					if (fracConceoto.getFechaVencimiento() != null) {
						conceptoPagoDTO.setNumeroDiasRetrazo(FechaDateUtil.restaFechas(fracConceoto.getFechaVencimiento(), FechaUtil.obtenerFecha()));
					}
					conceptoPagoDTO.setMontoTotal(conceptoPagoDTO.getMonto());
					listaConceptoPagoDTO.add(conceptoPagoDTO);
				}
			}
		}
		return listaConceptoPagoDTO;
	}
	
	@GET
	@Path("/findByPrestamoDatos/{idCliente}")
	public ResultadoRestVO<CreditoDTO> findByPrestamoDatos(@PathParam("idCliente") String idCliente) throws Exception {
		ResultadoRestVO<CreditoDTO> resultado = new ResultadoRestVO<CreditoDTO>();
		 try {
   		resultado.setObjetoResultado(cooperativaServiceLocal.findByPrestamoDatos(idCliente));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
    @Path("/generarReporteCronogramaPago/{idCredito}")
	public ResultadoRestVO<String> generarReporteCronogramaPago(@Context HttpHeaders httpHeaders,@PathParam("idCredito") String idCredito){
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.generarReporteCronogramaPago(idCredito));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
}