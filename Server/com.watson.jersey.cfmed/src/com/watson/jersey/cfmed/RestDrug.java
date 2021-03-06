package com.watson.jersey.cfmed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secure/drugs")
public class RestDrug {
//This method returns html instead of xml to view in web browser. Using the path rest/secure/drugs
	@GET
	@Produces(MediaType.TEXT_HTML)
	public File getHTML()  {
		
		//Gets the template for the HTML and loads it into buffer.
		String htmlString = null;
		BufferedWriter out = null;
		File file = new File("templates/drugs.html");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("templates/drugsTemplate.html"));
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

		DBManager db = new DBManager();
		ArrayList <DrugInfo> drugArray = db.databaseToDrugObject();
		ArrayList <String> tempArray = new ArrayList<String>();
		String tempString = "";
		String row = "";
		String title = "Cystic Fybrosis Information";
		for (int i=0 ; i < drugArray.size() ; i++){
		DrugInfo drugInfo = drugArray.get(i);
		tempArray = drugInfo.getBrandName();
		for (int j=0; j<tempArray.size(); j++){
			String temp2 = tempArray.get(j);
			tempString = tempString +" "+ temp2;
		}
		//Puts all drugs into a table
		Map <String, String> interactions = drugInfo.getInteractions();
		String interactionString = "";
		for (Map.Entry <String, String> entry: interactions.entrySet()){
			interactionString = interactionString + entry.getKey() + "<br> Description: " + entry.getValue()+"<br><br>";	
		}
		row =row + "<tr> <td>"+drugInfo.getName()+"</td>"+ "<td>"+drugInfo.getType()+"</td>" +"<td>"+tempString+"</td>"
				+ "<td>"+drugInfo.getIndication()+"</td>"+"<td>"+interactionString
				+"</td><td width=\"75px\"><input class=\"btn btn-primary\""
				+ "onclick=\"deleteDrug("+drugInfo.getId()+");\" type=\"button\" value=\"Delete\"> </td></tr>";
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
	
	
	@DELETE
	@Path ("{id}")
	public File deleteDrug(@PathParam("id") int id){
		DBManager db = new DBManager();
		db.deleteDrug(id);
		File file = new File("templates/cfInfo.xml");
		return file;
	}
	
}
