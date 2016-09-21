package org.prutha.rest.messanger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	public String getDemo(@MatrixParam("param") String matrixParam, 
						  @HeaderParam("customHeaderName") String header,
						  @CookieParam("cookieName") String cookie) {
		return "Matrix Param : " + matrixParam 
				+ "\nCustom Header Param : " + header
				+ "\nCookie value : " + cookie;
	}

}
