package app;


import static spark.Spark.*;

import service.TimesService;

public class Aplicacao {

	public static TimesService TimesService = new TimesService();
	
	public static void main(String[] args) {
	
		  port(6782);
		  
		  post("/times", (request , response) -> TimesService.add(request, response));
		  
		  get("/times/:id", (request, response) -> TimesService.get(request, response));
		  
		  get("/times/update/:id", (request, response) -> TimesService.update(request, response));  
		  
		  get("/times/delete/:id", (request, response) -> TimesService.remove(request, response));
		  
		    get("/times", (request, response) -> TimesService.getAll(request, response));
            

	}

}
