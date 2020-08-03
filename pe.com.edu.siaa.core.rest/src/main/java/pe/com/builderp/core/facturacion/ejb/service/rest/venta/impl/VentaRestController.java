	package pe.com.builderp.core.facturacion.ejb.service.rest.venta.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import pe.com.builderp.core.contabilidad.model.vo.RegistroAsientoFiltroVO;
import pe.com.builderp.core.facturacion.ejb.service.venta.impl.VentaServiceImpl;
import pe.com.builderp.core.facturacion.ejb.service.venta.local.VentaServiceLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.DetalleVentaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.VentaDTO;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.ejb.util.cache.AppAuthenticator;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class VentaRestController.
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
@Path("/ventaRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class VentaRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient VentaServiceLocal ventaServiceLocal;
	
	@POST
	public ResultadoRestVO<VentaDTO> registrarVenta(@Context HttpHeaders httpHeaders,VentaDTO venta) throws Exception {
		ResultadoRestVO<VentaDTO> resultado = new ResultadoRestVO<VentaDTO>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		String ip = httpHeaders.getHeaderString( AppHTTPHeaderNames.ORIGIN );
		venta.setIpAcceso(ip);
		venta.setServiceKey(serviceKey);
		venta.setAuthToken(authToken);		
		 try {
			 resultado.setObjetoResultado(ventaServiceLocal.registrarVenta(venta));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@DELETE
	@Path("/{id}")
	public ResultadoRestVO<VentaDTO> eliminar(@PathParam("id") String idVenta) throws Exception {
		ResultadoRestVO<VentaDTO> resultado = new ResultadoRestVO<VentaDTO>();
		VentaDTO venta = new VentaDTO();
		venta.setIdVenta(idVenta);		
		return resultado;
	}
	
	@GET
    @Path("/listar")
	public ResultadoRestVO<VentaDTO> listarVenta(@Context UriInfo info){
		ResultadoRestVO<VentaDTO> resultado = new ResultadoRestVO<VentaDTO>();
		VentaDTO venta = transferUriInfo(info);
		 try {
			resultado.setListaResultado(ventaServiceLocal.listarVenta(venta));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	@GET
    @Path("/contar")
	public ResultadoRestVO<VentaDTO> contarVenta(@Context UriInfo info){
		ResultadoRestVO<VentaDTO> resultado = new ResultadoRestVO<VentaDTO>();
		VentaDTO venta = transferUriInfo(info);
		 try {
			 resultado.setContador(ventaServiceLocal.contarListarVenta(venta));
			 if (resultado.isData()) {
				resultado.setListaResultado(ventaServiceLocal.listarVenta(venta));
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
    @Path("/")
	public ResultadoRestVO<VentaDTO> inicializarVenta(@Context UriInfo info) throws Exception {
	     VentaDTO venta = transferUriInfo(info);
		 ResultadoRestVO<VentaDTO> resultado = new ResultadoRestVO<VentaDTO>();
		 try {
    		resultado.setObjetoResultado(venta);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
    @Path("/generarReporteRegistroVenta")
	public ResultadoRestVO<String> generarReporteRegistroVenta(@Context HttpHeaders httpHeaders,RegistroAsientoFiltroVO registroVentaFiltro){
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		registroVentaFiltro.setAuthToken(authToken);
		registroVentaFiltro.setServiceKey(serviceKey);
		 try {
    		resultado.setObjetoResultado(ventaServiceLocal.generarReporteRegistroVenta(registroVentaFiltro));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
    @Path("/generarReporteRegistroVentaTXT")
	public ResultadoRestVO<String> generarReporteRegistroVentaTXT(@Context HttpHeaders httpHeaders,RegistroAsientoFiltroVO registroVentaFiltro){
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		registroVentaFiltro.setAuthToken(authToken);
		registroVentaFiltro.setServiceKey(serviceKey);
		 try {
    		resultado.setObjetoResultado(ventaServiceLocal.generarReporteRegistroVentaTXT(registroVentaFiltro));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
    @Path("/listarDetalleVenta")
	public ResultadoRestVO<DetalleVentaDTO> listarDetalleVenta(@Context UriInfo info){
		ResultadoRestVO<DetalleVentaDTO> resultado = new ResultadoRestVO<DetalleVentaDTO>();
		DetalleVentaDTO detalleVenta = transferUriInfoDetalle(info);
		 try {
			resultado.setListaResultado(ventaServiceLocal.listarDetalleVenta(detalleVenta));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	private DetalleVentaDTO transferUriInfoDetalle(@Context UriInfo info) {
		DetalleVentaDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,DetalleVentaDTO.class);
		return resultado;
	}
	
	private VentaDTO transferUriInfo(@Context UriInfo info) {
		VentaDTO resultado = TransferDataObjectUtil.transferObjetoEntityGetRestDTO(info,VentaDTO.class);
		return resultado;
	}
	//add
	@GET
    @Path("/generarReportePago/{idVenta}/{idCliente}")
	public ResultadoRestVO<String> generarReportePago(@Context HttpHeaders httpHeaders,@PathParam("idVenta") String idVenta,@PathParam("idCliente") String idCliente){
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		String serviceKey = httpHeaders.getHeaderString( AppHTTPHeaderNames.SERVICE_KEY );
		String authToken = httpHeaders.getHeaderString( AppHTTPHeaderNames.AUTH_TOKEN );
		 try {
			 String userName = AppAuthenticator.getInstance().getUserName(authToken);
			 resultado.setObjetoResultado(ventaServiceLocal.generarReportePago(idVenta, idCliente, userName));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/consultaDocumentoSunat/{nroDoc}")
    public ResultadoRestVO<String>  consultaDocumentoSunat(@PathParam("nroDoc")String nroDoc) throws Exception{
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			if(nroDoc.length() <= 8){
				resultado.setListaResultado(this.consultarReniecDni(nroDoc));
			}else{
				resultado.setListaResultado(this.consultarRUC(nroDoc));
			}
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}

		return resultado;
	}
	
	public List<String> consultarReniecDni(String nrodni) throws Exception
	 {    
		 final String USER_AGENT = "Mozilla/5.0";
	   	    List<String> consulta_dni= new ArrayList<String>();
	        String url = "https://dniruc.apisperu.com/api/v1/dni/"+nrodni+"?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImtyaXNzLnJlYmlsQGdtYWlsLmNvbSJ9.uq92gVngaARZDf0rG6Ju82WBZcvd0fec32R_h2Va0iE";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			//System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject Jobj = new JSONObject(response.toString());
		 
		    for(int i = 0 ; i < Jobj.length() ; i++){
		      consulta_dni.add(Jobj.getString("nombres"));
		      consulta_dni.add(Jobj.getString("apellidoPaterno"));
		      consulta_dni.add(Jobj.getString("apellidoMaterno"));
		    }
	 
			/*String dem =consulta_dni.get(0)+" "+consulta_dni.get(1)+" "+consulta_dni.get(2);
			consulta_dni= new ArrayList<String>();
			consulta_dni.add(dem); */
			return consulta_dni;
	   }
	 
	 
	 
	 public List<String> consultarRUC(String ruc) throws Exception
	 {    
		 final String USER_AGENT = "Mozilla/5.0";
	   	    List<String> consulta_dni= new ArrayList<String>();
	        String url = "https://dniruc.apisperu.com/api/v1/ruc/"+ruc+"?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImtyaXNzLnJlYmlsQGdtYWlsLmNvbSJ9.uq92gVngaARZDf0rG6Ju82WBZcvd0fec32R_h2Va0iE";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			//System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject Jobj = new JSONObject(response.toString());
		 
		    for(int i = 0 ; i < Jobj.length() ; i++){
		      consulta_dni.add(Jobj.getString("ruc"));
		      consulta_dni.add(Jobj.getString("razonSocial"));
		      consulta_dni.add(Jobj.getString("direccion"));
		    }
	 
			/*String dem =consulta_dni.get(0)+" "+consulta_dni.get(1)+" "+consulta_dni.get(2);
			consulta_dni= new ArrayList<String>();
			consulta_dni.add(dem); */
			return consulta_dni;
	   }
	
}