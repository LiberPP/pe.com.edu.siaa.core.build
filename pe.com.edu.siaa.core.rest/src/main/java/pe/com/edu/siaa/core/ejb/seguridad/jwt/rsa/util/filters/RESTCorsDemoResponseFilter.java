package pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import pe.com.edu.siaa.core.ejb.seguridad.jwt.rsa.util.AppHTTPHeaderNames;
import pe.com.edu.siaa.core.ejb.util.log.Logger;

@Provider
@PreMatching
public class RESTCorsDemoResponseFilter implements ContainerResponseFilter {

    private final static Logger log = Logger.getLogger( RESTCorsDemoResponseFilter.class.getName() );

    @Override
    public void filter( ContainerRequestContext requestCtx, ContainerResponseContext responseCtx ) throws IOException {
        log.info( "Executing REST response filter" );

        /*responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        */
        
        responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseCtx.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, " + AppHTTPHeaderNames.SERVICE_KEY + " , " + AppHTTPHeaderNames.AUTH_TOKEN + "," + AppHTTPHeaderNames.VERSION + "");
        //responseCtx.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization," + AppHTTPHeaderNames.SERVICE_KEY + ", " + AppHTTPHeaderNames.AUTH_TOKEN);
        responseCtx.getHeaders().add("Access-Control-Allow-Credentials", "true");
        //responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD");
        responseCtx.getHeaders().add("Access-Control-Max-Age", "1209600");
        //responseCtx.getHeaders().add( "Access-Control-Allow-Headers", AppHTTPHeaderNames.SERVICE_KEY + ", " + AppHTTPHeaderNames.AUTH_TOKEN );
    }
}