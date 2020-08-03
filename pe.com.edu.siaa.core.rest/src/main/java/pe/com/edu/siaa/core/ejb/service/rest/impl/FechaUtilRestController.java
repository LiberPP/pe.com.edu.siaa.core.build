package pe.com.edu.siaa.core.ejb.service.rest.impl;
 
import java.util.Date; 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;


/**
 * La Class LoginController.
 * <ul>
 * <li>Copyright 2016 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Mon Jan 16 21:01:47 COT 2017
 * @since ERP-CRIS 1.0
 */
@Path("/fechaUtilRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class FechaUtilRestController extends GenericServiceRestImpl {
 
	 
	@GET
	@Path("/dateToString/{date}/{formato}")
	public String  dateToString(@PathParam("date") Date date,@PathParam("formato") String formato ) {
        return FechaUtil.dateToString(date,formato);
	}
	
	@GET
	@Path("/obtenerFechaFormato/{formato}")
	public String obtenerFechaFormato(@PathParam("formato") String formato ) {
        return FechaUtil.obtenerFechaFormato(formato);
	}
	
	@POST
	@Path("/obtenerFecha")
	public Date obtenerFecha() {
        return FechaUtil.obtenerFecha();
	}
	
	@GET
	@Path("/obtenerFechaFormatoCompleto/{date}")
	public String obtenerFechaFormatoCompleto(@PathParam("date") Date date ) {
        return FechaUtil.obtenerFechaFormatoCompleto(date);
	}
	
	@GET
	@Path("/obtenerFechaFormatoSimple/{date}")
	public String obtenerFechaFormatoSimple(@PathParam("date") Date date ) {
        return FechaUtil.obtenerFechaFormatoSimple(date);
	}
}