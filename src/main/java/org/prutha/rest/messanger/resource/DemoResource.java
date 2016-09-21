package org.prutha.rest.messanger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * This is a simple demo class for demoing the various other annnotations. e.g.
 * Matrix params which are like teh query params, but separated by ; instead of
 * ? e.g. Header params which let us write custom headers in the request
 * 
 * @author prutha
 *
 */

@Path("/demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)

public class DemoResource {

	@GET
	@Path("/annotations")
	public String getInfoUsingAnnotations(@MatrixParam("param") String matrixParam, 
						  @HeaderParam("customHeaderName") String header,
						  @CookieParam("cookieName") String cookie) {
		return "Matrix Param : " + matrixParam 
				+ "\nCustom Header Param : " + header
				+ "\nCookie value : " + cookie;
	}

	
	/**
	 *   The problem with the above annotations is what to do when you 
	 *   have too many headers or too many matrix params. The method definition
	 *   would get really tedious. Plus you will need to know all the names for 
	 *   each of the parameters. An alternative to this is using Context and 
	 *   BeanParam annotations.
	 *   
	 *   While annotations like MatrixParam, HeaderParam and CookieParam can 
	 *   be applied to any primitive datatype, the @Context annotation can only
	 *   be applied to specific object types, one of them being, the UriInfo class 
	 */
	@GET
	@Path("/context")
	public String getInfoUsingContext( @Context UriInfo uriInfo, 
									   @Context HttpHeaders headers){
		return "Path:" + uriInfo.getAbsolutePath() + "\n" +
				"Headers:" + headers.getMediaType().toString() + "\n" +
				"Cookies:" + headers.getCookies().toString();
	}
}
