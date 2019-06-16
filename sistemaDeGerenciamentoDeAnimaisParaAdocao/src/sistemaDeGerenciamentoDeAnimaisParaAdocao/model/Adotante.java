package sistemaDeGerenciamentoDeAnimaisParaAdocao.model;

import java.sql.Date;

public class Adotante {
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private String email;
	private int idAnimal;
	
	public Adotante() {
		
	}
	
	public Adotante(int id,String nome,String cpf,String telefone,String endereco,String email,int idAnimal) {
		this.id=id;
		this.nome=nome;
		this.cpf=cpf;
		this.telefone=telefone;
		this.endereco=endereco;
		this.email=email;
		this.idAnimal=idAnimal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	
	
}
