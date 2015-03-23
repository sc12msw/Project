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


@Path ("/addDrug")
public class RestAddDrug {
	


	// This method returns the xml of the objects created on the server. Using JAXB
	@GET
	@Produces({MediaType.TEXT_HTML})
	public File getHTML() throws IOException {
		File file = new File("templates/adddrugform.html");
		return file;
	}



	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newDrugs(@FormParam("name") String name,
			@FormParam("brand") String brand,
			@FormParam("brand1") String brand1,
			@FormParam("brand2") String brand2,
			@FormParam("brand3") String brand3,
			@FormParam("brand4") String brand4,
			@FormParam("sideEffects") String sideEffects,
			@FormParam("indication") String indication,
			@FormParam("interactions") String interactions,

			@FormParam("oralAdultAdmin") String oralAdultAdmin,
			@FormParam("iVAdultAdmin") String iVAdultAdmin,
			@FormParam("inhaledAdultAdmin") String inhaledAdultAdmin,
			@FormParam("iMAdultAdmin") String iMAdultAdmin,
			@FormParam("pRAdultAdmin") String pRAdultAdmin,
			@FormParam("sCAdultAdmin") String sCAdultAdmin,

			@FormParam("oralAdultDose") String oralAdultDose,
			@FormParam("iVAdultDose") String iVAdultDose,
			@FormParam("inhaledAdultDose") String inhaledAdultDose,
			@FormParam("iMAdultDose") String iMAdultDose,
			@FormParam("pRAdultDose") String pRAdultDose,
			@FormParam("sCAdultDose") String sCAdultDose,

			@FormParam("oralPaedAdmin") String oralPaedAdmin,
			@FormParam("iVPaedAdmin") String iVPaedAdmin,
			@FormParam("inhaledPaedAdmin") String inhaledPaedAdmin,
			@FormParam("iMPaedAdmin") String iMPaedAdmin,
			@FormParam("pRPaedAdmin") String pRPaedAdmin,
			@FormParam("sCPaedAdmin") String sCPaedAdmin,

			@FormParam("oralPaedDose") String oralPaedDose,
			@FormParam("iVPaedDose") String iVPaedDose,
			@FormParam("inhaledPaedDose") String inhaledPaedDose,
			@FormParam("iMPaedDose") String iMPaedDose,
			@FormParam("pRPaedDose") String pRPaedDose,
			@FormParam("sCPaedDose") String sCPaedDose,
			@Context HttpServletResponse servletResponse) throws IOException {

	
		
		//Create object from form strings
		DrugInfo newDrug = new DrugInfo();
		AdultInfo adult = new AdultInfo();
		PaediatricInfo paed = new PaediatricInfo();
		ArrayList <String> brandNames = new ArrayList<String>();

		//This try block is to avoid errors where the user has submitted an error in the form.
		//These are optional fields in the form.
		try {
			if(brand != null && !brand.isEmpty()){
				brandNames.add(brand);
			}

			if(brand1 != null && !brand1.isEmpty()){
				brandNames.add(brand1);
			}
			if(brand2 != null && !brand2.isEmpty()){
				brandNames.add(brand2);
			}
			if(brand3 != null && !brand3.isEmpty()){
				brandNames.add(brand3);
			}
			if(brand4 != null && !brand4.isEmpty()){
				brandNames.add(brand4);
			}
			if ( interactions != null && !interactions.isEmpty()){
				newDrug.setInteractions(interactions);
			}
			if ( sideEffects != null && !sideEffects.isEmpty()){
			newDrug.setSideEffect(sideEffects);
			}
			if ( oralAdultAdmin != null && !oralAdultAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(oralAdultAdmin);
				adminDose.setDose(oralAdultDose);
				adult.setOral(adminDose);
			}
			if ( iVAdultAdmin != null && !iVAdultAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(iVAdultAdmin);
				adminDose.setDose(iVAdultDose);
				adult.setIV(adminDose);
			}
			if ( inhaledAdultAdmin != null && !inhaledAdultAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(inhaledAdultAdmin);
				adminDose.setDose(inhaledAdultDose);
				adult.setInhaled(adminDose);
			}
			if ( iMAdultAdmin != null && !iMAdultAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(iMAdultAdmin);
				adminDose.setDose(iMAdultDose);
				adult.setIM(adminDose);
			}
			if ( pRAdultAdmin != null && !pRAdultAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(pRAdultAdmin);
				adminDose.setDose(pRAdultDose);
				adult.setPR(adminDose);
			}
			if ( sCAdultAdmin != null && !sCAdultAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(sCAdultAdmin);
				adminDose.setDose(sCAdultDose);
				adult.setSC(adminDose);
			}

			if ( oralPaedAdmin != null && !oralPaedAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(oralPaedAdmin);
				adminDose.setDose(oralPaedDose);
				paed.setOral(adminDose);
			}
			if ( iVPaedAdmin != null && !iVPaedAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(iVPaedAdmin);
				adminDose.setDose(iVPaedDose);
				paed.setIV(adminDose);
			}
			if ( inhaledPaedAdmin != null && !inhaledPaedAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(inhaledPaedAdmin);
				adminDose.setDose(inhaledPaedDose);
				paed.setInhaled(adminDose);
			}
			if ( iMPaedAdmin != null && !iMPaedAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(iMPaedAdmin);
				adminDose.setDose(iMPaedDose);
				paed.setIM(adminDose);
			}
			if ( pRPaedAdmin != null && !pRPaedAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(pRPaedAdmin);
				adminDose.setDose(pRPaedDose);
				paed.setPR(adminDose);
			}
			if ( sCPaedAdmin != null && !sCPaedAdmin.isEmpty()){
				AdminDose adminDose = new AdminDose();
				adminDose.setAdministration(sCPaedAdmin);
				adminDose.setDose(sCPaedDose);
				paed.setSC(adminDose);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//set the object
		newDrug.setIndication(indication);
		newDrug.setName(name);
		newDrug.setAdult(adult);
		newDrug.setPaediatric(paed);
		newDrug.setBrandName(brandNames);
		DBManager db = new DBManager();
		db.addDrug(newDrug);
	
		/*
		try{

			JAXBContext jaxbContext = JAXBContext.newInstance(CFInfo.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(cfInfo, file);
			jaxbMarshaller.marshal(cfInfo, System.out);


		}catch (JAXBException e) {
			e.printStackTrace();
		}
		*/
		servletResponse.sendRedirect("../rest/cfmed");
	}
}