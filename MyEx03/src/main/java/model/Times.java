package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings("unused")



public class Times implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String tecnico;
	private String pais;
	
	public Times() {
		id = 0;
		nome = "###";
		tecnico = "###";
		pais = "###";
	}
	
	public Times(int id, String nome, String tecnico, String pais) {
		this.id = id;
		this.nome = nome;
		this.tecnico = tecnico;
		this.pais = pais;
	}
	
	public void SetId(int id) {
		this.id = id;
	}
	
	public void SetNome(String nome) {
		this.nome = nome;
	}
	
	public void SetTecnico(String tecnico) {
		this.tecnico = tecnico;
		
	}
	
	public void SetPais(String pais) {
		this.pais = pais;
		
	}
	
	public int GetId() {
		return id;
	}
	
	public String GetNome() {
		return nome;
	}
	
	public String GetTecnico() {
		return tecnico;
	}
	
	public String GetPais() {
		return pais;
	}
	


}
