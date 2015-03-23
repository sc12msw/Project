package com.watson.jersey.cfmed;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.*;

@Path("/cfmed")
public class RestLogic {

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
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public File getXML() throws IOException {
		File file = new File("templates/cfInfo.xml");
		/* Uncomment to create a structured xml file of the objects
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
		return file;
	}

//This method returns html instead of xml to view in web browser. Using the path rest/cfmed/html
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public File getHTML()  {
		//Gets the template for the HTML.
		String htmlString = null;
		BufferedWriter out = null;
		File file = new File("templates/template2.html");
		 
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("templates/template.html"));
			  StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		     htmlString = sb.toString();
		     br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Fills the template with data.
		CFInfo cfInfo = createObj();
		ArrayList <String> tempArray = new ArrayList<String>();
		String tempString = "";
		String row = "";
		String title = "Cystic Fybrosis Information";
		ArrayList <DrugInfo> array = cfInfo.getDrug();
		for (int i=0 ; i < array.size() ; i++){
		DrugInfo drugInfo = array.get(i);
		AdultInfo adultInfo = drugInfo.getAdult();
		AdminDose adultOral = adultInfo.getOral();
		PaediatricInfo pInfo = drugInfo.getPaediatric();
		AdminDose pOral = pInfo.getOral();
		tempArray = drugInfo.getBrandName();
		for (int j=0; j<tempArray.size(); j++){
			String temp2 = tempArray.get(j);
			tempString = tempString +" "+ temp2;
		}
		//Puts all drugs into a table
		row =row + "<tr> <td>"+drugInfo.getName()+"</td>"+"<td>"+tempString+"</td>"+"<td>"+drugInfo.getIndication()+"</td>"+"<td>"+adultOral.getAdministration()+"</td>"+"<td>"+adultOral.getDose()+"</td>"+"<td>"+pOral.getAdministration()+"</td>"+"<td>"+pOral.getDose()+"</td>"+"<td>"+drugInfo.getInteractions()+"</td></tr>";
		tempString = "";
		}
		htmlString = htmlString.replace("$title", title);
		htmlString = htmlString.replace("$tablerow", row);
		
		//Writes the new html back to the file
		 FileWriter fstream;
		try {
			fstream = new FileWriter(file, false);
			out = new BufferedWriter(fstream);
			out.write(htmlString);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		    
		return file;
	}
	
	
	
	
	
}