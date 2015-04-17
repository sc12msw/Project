package com.watson.jersey.cfmed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;

@Path("/")
public class RestHomePage {

//This just returns the home page html file.
	@GET
	@Produces(MediaType.TEXT_HTML)
	public File getHome()  {
		File file = new File("templates/index.html");
		return file;
	}
}
