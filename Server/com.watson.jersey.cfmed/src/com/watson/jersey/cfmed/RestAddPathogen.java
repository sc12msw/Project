
package com.watson.jersey.cfmed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


@Path ("/addPathogen")
public class RestAddPathogen {
	public CFInfo createObj(){

		//This fills the objects with data. At the moment there is no database so it just fills the object array with the same strings.
		CFInfo cfInfo = new CFInfo();
		PathogenInfo pathoInfo = new PathogenInfo();
		DrugInfo drugInfo = new DrugInfo();
		AdultInfo adultInfo = new AdultInfo();
		PaediatricInfo paediatricInfo = new PaediatricInfo();
		AdminDose adminDose = new AdminDose();
		adminDose.setAdministration("take tablet");
		adminDose.setDose("10mg");
		adultInfo.setOral(adminDose);
		adultInfo.setInhaled(adminDose);
		paediatricInfo.setOral(adminDose);
		paediatricInfo.setInhaled(adminDose);
		drugInfo.setAdult(adultInfo);
		drugInfo.setPaediatric(paediatricInfo);
		drugInfo.setName("Drug name");
		drugInfo.setIndication("For this disease");
		drugInfo.setInteractions("This drug interacts with : 1drug 2drug etc");
		drugInfo.setSideEffect("This is a side effect");
		ArrayList <String> brands = new ArrayList <String>();
		brands.add("brand 1");
		brands.add("brand 2");
		drugInfo.setBrandName(brands);

		pathoInfo.setName("Bacteria");
		pathoInfo.setDescription("I am a bacteria");
		ArrayList <String> firstline = new ArrayList <String>();
		ArrayList <String> secondline = new ArrayList <String>();
		String fLDrug = "im a first line drug";
		String sLDrug = "im a first line drug";
		firstline.add(fLDrug);
		secondline.add(sLDrug);
		pathoInfo.setFirstline(firstline);
		pathoInfo.setSecondline(secondline);
		ArrayList<PathogenInfo> pathoArray = new ArrayList<PathogenInfo>();
		pathoArray.add(pathoInfo);
		ArrayList<DrugInfo> drugArray = new ArrayList<DrugInfo>();
		drugArray.add(drugInfo);
		cfInfo.setDrug(drugArray);
		cfInfo.setPathogen(pathoArray);
		return cfInfo;
	}


	// This method returns the xml of the objects created on the server. Using JAXB
	@GET
	@Produces({MediaType.TEXT_HTML})
	public File getHTML() throws IOException {
		File file = new File("templates/addpathogenform.html");
		return file;
	}



	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newPathogen(@FormParam("name") String name,
			
			@FormParam("fLDrug") String fLDrug,
			@FormParam("fLDrug1") String fLDrug1,
			@FormParam("fLDrug2") String fLDrug2,
			@FormParam("fLDrug3") String fLDrug3,
			@FormParam("fLDrug4") String fLDrug4,
			@FormParam("fLDrug5") String fLDrug5,
			@FormParam("fLDrug6") String fLDrug6,
			@FormParam("fLDrug7") String fLDrug7,
			@FormParam("fLDrug8") String fLDrug8,
			@FormParam("fLDrug9") String fLDrug9,
			
			@FormParam("sLDrug") String sLDrug,
			@FormParam("sLDrug1") String sLDrug1,
			@FormParam("sLDrug2") String sLDrug2,
			@FormParam("sLDrug3") String sLDrug3,
			@FormParam("sLDrug4") String sLDrug4,
			@FormParam("sLDrug5") String sLDrug5,
			@FormParam("sLDrug6") String sLDrug6,
			@FormParam("sLDrug7") String sLDrug7,
			@FormParam("sLDrug8") String sLDrug8,
			@FormParam("sLDrug9") String sLDrug9,
		
			@FormParam("description") String description,
			@Context HttpServletResponse servletResponse) throws IOException {

		//This line is to create dummy data when complete this will be data pull from database
		CFInfo cfInfo = createObj();
		//
		
		//Create object from form strings
		ArrayList <String> fLArray = new ArrayList <String> ();
		ArrayList <String> sLArray = new ArrayList <String> ();
		ArrayList <PathogenInfo> pathogenArray = cfInfo.getPathogen();
		PathogenInfo newPathogen = new PathogenInfo();
		
		if(fLDrug != null && !fLDrug.isEmpty()){
			fLArray.add(fLDrug);
		}
		if(fLDrug1 != null && !fLDrug1.isEmpty()){
			fLArray.add(fLDrug1);
		}
		if(fLDrug2 != null && !fLDrug2.isEmpty()){
			fLArray.add(fLDrug2);
		}
		if(fLDrug3 != null && !fLDrug3.isEmpty()){
			fLArray.add(fLDrug3);
		}
		if(fLDrug4 != null && !fLDrug4.isEmpty()){
			fLArray.add(fLDrug4);
		}
		if(fLDrug5 != null && !fLDrug5.isEmpty()){
			fLArray.add(fLDrug5);
		}
		if(fLDrug6 != null && !fLDrug6.isEmpty()){
			fLArray.add(fLDrug6);
		}
		if(fLDrug7 != null && !fLDrug7.isEmpty()){
			fLArray.add(fLDrug7);
		}
		if(fLDrug8 != null && !fLDrug8.isEmpty()){
			fLArray.add(fLDrug8);
		}
		if(fLDrug9 != null && !fLDrug9.isEmpty()){
			fLArray.add(fLDrug9);
		}
		
		if(sLDrug != null && !sLDrug.isEmpty()){
			sLArray.add(sLDrug);
		}
		if(sLDrug1 != null && !sLDrug1.isEmpty()){
			sLArray.add(sLDrug1);
		}
		if(sLDrug2 != null && !sLDrug2.isEmpty()){
			sLArray.add(sLDrug2);
		}
		if(sLDrug3 != null && !sLDrug3.isEmpty()){
			sLArray.add(sLDrug3);
		}
		if(sLDrug4 != null && !sLDrug4.isEmpty()){
			sLArray.add(sLDrug4);
		}
		if(sLDrug5 != null && !sLDrug5.isEmpty()){
			sLArray.add(sLDrug5);
		}
		if(sLDrug6 != null && !sLDrug6.isEmpty()){
			sLArray.add(sLDrug6);
		}
		if(sLDrug7 != null && !sLDrug7.isEmpty()){
			sLArray.add(sLDrug7);
		}
		if(sLDrug8 != null && !sLDrug8.isEmpty()){
			sLArray.add(sLDrug8);
		}
		if(sLDrug9 != null && !sLDrug9.isEmpty()){
			sLArray.add(sLDrug9);
		}
		
		newPathogen.setFirstline(fLArray);
		if (!sLArray.isEmpty()){
			newPathogen.setSecondline(sLArray);
		}
		newPathogen.setName(name);
		newPathogen.setDescription(description);
		pathogenArray.add(newPathogen);
		cfInfo.setPathogen(pathogenArray);
		//Write to output xml
		File file = new File("templates/cfInfo.xml");

		try{

			JAXBContext jaxbContext = JAXBContext.newInstance(CFInfo.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(cfInfo, file);
			jaxbMarshaller.marshal(cfInfo, System.out);


		}catch (JAXBException e) {
			e.printStackTrace();
		}

		servletResponse.sendRedirect("../rest/cfmed");
		}
	}
