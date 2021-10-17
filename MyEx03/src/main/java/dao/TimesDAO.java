package dao;

import model.Times;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

	


@SuppressWarnings("unused")
public class TimesDAO {
	private List <Times> times;

	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public TimesDAO(String nomeArq) throws IOException, ClassNotFoundException {
		file = new File(nomeArq);
		times = new ArrayList<Times>();
		
		if(file.exists()) {
			this.readFromFile();
		}
} 	//ADICIONAR
	public void add(Times time) {
			try {
				times.add(time);
				 saveToFile();
			}
			catch(Exception e) {
				System.out.print("ERRO AO GRAVAR OS DADOS !!!!");
			}
	
	
}
//FAZER BUSCA
	public Times get (int id) { 
		for(Times clube : times){
			if(id == clube.GetId()) {
				
				return clube;
			}	
		}
		
		return null;
}
//UPDATE
	public void update(Times t) {
		int index = times.indexOf(t);
		if (index != -1) {
			times.set(index, t);
			this.saveToFile();
		}
		
		
}
//REMOVER UM ITEM
	public void remove(Times t) {
		int index = times.indexOf(t);
		if (index != -1) {
			times.remove(index);
			this.saveToFile();
		}

}
//MOSTRAR TUDO 
	public List<Times> getAll(){
		return times;
	}

//#########
	private List<Times> readFromFile() throws ClassNotFoundException, IOException{
		times.clear();
		Times time = null;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)){
		
			while (fis.available() > 0) {
				time = (Times) inputFile.readObject();
				times.add(time);
				
			}
		}
			catch(Exception e){
				System.out.println("ERRO ao gravar produto no disco!");
				e.printStackTrace();}
		
		return times;
		
		}
		

//#################
private void saveToFile() {
	
	try {
		fos = new FileOutputStream(file, false);
		outputFile = new ObjectOutputStream(fos);
		
		for(Times club : times) {
			outputFile.writeObject(club);
			
		}
		outputFile.flush();
		this.close();
	}
	catch(Exception e) {
		System.out.println("ERRO AO GRAVAR OS DADOS !!");
		e.printStackTrace();
	}
	
	
} 
//##############
	private void close() throws IOException {
		outputFile.close();
		fos.close();
		
}
//###################
	
	


protected void finalizar() {
	try {
		this.saveToFile();
		this.close();
		
	}
	catch(Exception e) {
		System.out.println("ERRO ao salvar a base de dados no disco!");
		e.printStackTrace();
	}
	
	
}

//AGORA É O SERVICE VACILAO














}
