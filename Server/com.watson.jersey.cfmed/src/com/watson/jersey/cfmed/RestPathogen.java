package com.watson.jersey.cfmed;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
@Path("secure/pathogens")
public class RestPathogen {

//This method returns html instead of xml to view in web browser. Using the path rest/cfmed/html
	@GET
	@Produces(MediaType.TEXT_HTML)
	public File getHTML()  {
		
		//Gets the template for the HTML and loads it into buffer.
		String htmlString = null;
		BufferedWriter out = null;
		File file = new File("templates/pathogens.html");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("templates/pathogensTemplate.html"));
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
		ArrayList <PathogenInfo> pathogenArray = db.databaseToPathogenObject();
		ArrayList <String> tempArray = new ArrayList<String>();
		String tempString = "";
		String row = "";
		String title = "Cystic Fybrosis Information";
		for (int i=0 ; i < pathogenArray.size() ; i++){
		PathogenInfo pathogenInfo = pathogenArray.get(i);
		tempArray = pathogenInfo.getFirstline();
		for (int j=0; j<tempArray.size(); j++){
			String temp2 = tempArray.get(j);
			tempString = tempString +" "+ temp2;
		}
		
		//Puts all pathogens into a table
		row =row + "<tr> <td>"+pathogenInfo.getName()+"</td>"+"<td>"+pathogenInfo.getDescription()+"</td>"
				+"<td>"+tempString+"</td>"+ "<td width=\"75px\">"
				+ "<input class=\"btn btn-primary\" onclick=\"deletePathogen("+pathogenInfo.getId()+");\" type=\"button\" value=\"Delete\"> </td></tr>";
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
	public File deletePathogen(@PathParam("id") int id){
		DBManager db = new DBManager();
		db.deletePathogen(id);
		File file = new File("templates/cfInfo.xml");
		return file;
	}
	
}
