package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import dao.TimesDAO;
import model.Times;
import spark.Request;
import spark.Response;




public class TimesService {
	
	private TimesDAO TimesDAO;

	public TimesService(){
		
	try {  	
		TimesDAO = new TimesDAO("Arquivo.dat");
	}
	catch(IOException e) {
		
		System.out.println(e.getMessage());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public Object add (Request request, Response response) {
		
		int id = Integer.parseInt(request.queryParams("id"));
		String nome = request.queryParams("nome");
		String tecnico = request.queryParams("tecnico");
		String pais = request.queryParams("pais");
		
		Times time = new Times (id, nome,tecnico,pais);
		
		TimesDAO.add(time);
		
		response.status(201); // 201 Created
		return id;
		
}
	
 public Object get(Request request, Response response) {
	
	 int id = Integer.parseInt(request.params(":id"));
	 	
	 Times time = (Times) TimesDAO.get(id);
		
	 if (time != null) {
 	    response.header("Content-Type", "application/xml");
 	    response.header("Content-Encoding", "UTF-8");
 	    
 	   return "<time>\n" + 
		"\t<id>" + time.GetId() + "</id>\n" +
		"\t<nome>" + time.GetNome() + "</nome>\n" +
		"\t<tecnico> " +time.GetTecnico() + "</tecnico>\n" +
		"\t<pais>" +time.GetPais() + "</pais>\n" +		
		"</time>\n";
 	    }
	 else {
		 response.status(404); // 404 Not found
         return "Times " + id + " nao foi encontrado.";
     }
		 
}
 public Object update(Request request, Response response) {
	 int id = Integer.parseInt(request.params(":id"));
	 
	 Times time = (Times) TimesDAO.get(id);
	 
	 if(time !=null) {
		 time.SetId(Integer.parseInt(request.queryParams("id")));
		 	time.SetNome(request.queryParams("nome"));
		 	time.SetTecnico(request.queryParams("tecnico"));
		 	time.SetPais(request.queryParams("pais"));
		
		 	TimesDAO.update(time);
		 	return id;
	 }
	 
	 else {
		  response.status(404); // 404 Not found
          return "Produto não encontrado.";
	 }
	 
	 
 }
 
 
 
 
 
 
 public Object remove(Request request,Response response) {
	   int id = Integer.parseInt(request.params(":id"));
	 
		Times time = (Times) TimesDAO.get(id);
		
		if(time != null) {
			
			TimesDAO.remove(time);
			 response.status(200); // success
	        return id;
		}
		else {
			 response.status(404); // 404 Not found
	            return "Produto não encontrado.";
			
		}
		
}
 
public Object getAll(Request request, Response response) {
	StringBuffer returnValue = new StringBuffer("<produtos type=\"array\">");
	
	for(Times time : TimesDAO.getAll()) {
		returnValue.append("\n<produto>\n" + 
        		"\t<id>" + time.GetId() + "</id>\n" +
        		"\t<descricao>" +time.GetNome() + "</descricao>\n" +
        		"\t<preco>" + time.GetTecnico() + "</preco>\n" +
        		"\t<quantidade>" + time.GetPais() + "</quantidade>\n" +
        		"</time>\n");
		
		
	}
	returnValue.append("</times>");
	response.header("Content-Type","application/xml");
	response.header("Content-Encoding", "UTF-8");
	return returnValue.toString();
	
}


	









}
