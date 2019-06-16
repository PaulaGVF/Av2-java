package sistemaDeGerenciamentoDeAnimaisParaAdocao.model;

public class Animal {
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private int idade;
	private String cor;
	private String sexo;
	private boolean castrado;
	private boolean vacinado;
	private String doencas;
	private String descricao;
	private String situacao;
	
	public Animal() {
		
	}
	
	public Animal(int id, String nome, String especie, String raca, int idade, String cor, String sexo, boolean castrado, boolean vacinado, String doencas, String descricao,  String situacao) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.cor = cor;
		this.sexo = sexo;
		this.castrado = castrado;
		this.vacinado = vacinado;
		this.doencas  = doencas;
		this.descricao = descricao;
		this.situacao = situacao;
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public boolean isCastrado() {
		return castrado;
	}
	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	public boolean isVacinado() {
		return vacinado;
	}
	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}
	public String getDoencas() {
		return doencas;
	}
	public void setDoencas(String doencas) {
		this.doencas = doencas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
}
