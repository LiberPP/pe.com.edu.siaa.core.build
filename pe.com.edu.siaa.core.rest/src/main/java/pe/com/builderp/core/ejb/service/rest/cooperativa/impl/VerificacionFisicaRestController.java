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
import pe.com.builderp.core.model.vo.cooperativa.EvaluacionCreditoDTO;
import pe.com.builderp.core.model.vo.cooperativa.VerificacionFisicaDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.HibernateUtil;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.type.AccionType;
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
@Path("/verificacionFisicaRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class VerificacionFisicaRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient CooperativaServiceLocal cooperativaServiceLocal;
	
	@POST
	public ResultadoRestVO<VerificacionFisicaDTO> crear(@Context HttpHeaders httpHeaders,VerificacionFisicaDTO verificacionFisica) throws Exception {
		ResultadoRestVO<VerificacionFisicaDTO> resultado = new ResultadoRestVO<VerificacionFisicaDTO>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		String ip = httpHeaders.getHeaderString( AppHTTPHeaderNames.ORIGIN );
		verificacionFisica.setServiceKey(serviceKey);
		verificacionFisica.setAuthToken(authToken);
		verificacionFisica.setIp(ip);
		 try { 
			 cooperativaServiceLocal.registrarVerificacionFisica(verificacionFisica);  
			 HibernateUtil.setListaNull(resultado.getObjetoResultado());
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
			resultado.setMensajeError("Error ==> " + e.getMessage());
		}
		return resultado;
	}
	@PUT
	public ResultadoRestVO<VerificacionFisicaDTO> modificar(VerificacionFisicaDTO VerificacionFisica) throws Exception {
		return controladorAccion(VerificacionFisica,AccionType.MODIFICAR);
	}
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<VerificacionFisicaDTO> eliminar(@PathParam("id") String idVerificacionFisica) throws Exception {
		VerificacionFisicaDTO VerificacionFisica = new VerificacionFisicaDTO();
		VerificacionFisica.setIdVerificacionFisica(idVerificacionFisica);		
		return controladorAccion(VerificacionFisica,AccionType.ELIMINAR);
	}
	private ResultadoRestVO<VerificacionFisicaDTO> controladorAccion(VerificacionFisicaDTO VerificacionFisica, AccionType accionType){
		ResultadoRestVO<VerificacionFisicaDTO> resultado = new ResultadoRestVO<VerificacionFisicaDTO>();
		 try {
    		resultado.setObjetoResultado(cooperativaServiceLocal.controladorAccionVerificacionFisica(VerificacionFisica,accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
	@Path("/get/{id}")
	public ResultadoRestVO<VerificacionFisicaDTO> finById(@PathParam("id") String idVerificacionFisica) throws Exception {
		VerificacionFisicaDTO VerificacionFisica = new VerificacionFisicaDTO();
		VerificacionFisica.setIdVerificacionFisica(idVerificacionFisica);
		return controladorAccion(VerificacionFisica,AccionType.FIND_BY_ID);
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<VerificacionFisicaDTO> listarVerificacionFisica(@Context UriInfo info){
		ResultadoRestVO<VerificacionFisicaDTO> resultado = new ResultadoRestVO<VerificacionFisicaDTO>();
		VerificacionFisicaDTO VerificacionFisica = transferUriInfo(info);
		 try {
			resultado.setListaResultado(cooperativaServiceLocal.listarVerificacionFisica(VerificacionFisica));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<VerificacionFisicaDTO> contarVerificacionFisica(@Context UriInfo info){
		ResultadoRestVO<VerificacionFisicaDTO> resultado = new ResultadoRestVO<VerificacionFisicaDTO>();
		VerificacionFisicaDTO VerificacionFisica = transferUriInfo(info);
		 try {
			 resultado.setContador(cooperativaServiceLocal.contarListarVerificacionFisica(VerificacionFisica));
			 if (resultado.isData()) {
				resultado.setListaResultado(cooperativaServiceLocal.listarVerificacionFisica(VerificacionFisica));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/")
	public ResultadoRestVO<VerificacionFisicaDTO> inicializarVerificacionFisica(@Context UriInfo info) throws Exception {
	     VerificacionFisicaDTO VerificacionFisica = transferUriInfo(info);
		 ResultadoRestVO<VerificacionFisicaDTO> resultado = new ResultadoRestVO<VerificacionFisicaDTO>();
		 try {
    		resultado.setObjetoResultado(VerificacionFisica);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	private VerificacionFisicaDTO transferUriInfo(@Context UriInfo info) {
		VerificacionFisicaDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,VerificacionFisicaDTO.class);
		return resultado;
	}
}