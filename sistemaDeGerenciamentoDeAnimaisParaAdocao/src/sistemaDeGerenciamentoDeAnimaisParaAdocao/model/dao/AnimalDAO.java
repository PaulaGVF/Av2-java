package sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.jdbc.conexao;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Animal;

public class AnimalDAO {
	
	private final String INSERT = "INSERT INTO ANIMAL (NOME,ESPECIE,RACA,IDADE,COR,SEXO,CASTRADO,VACINACAO,DOENCA,DESCRICAO,SITUACAO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE ANIMAL SET NOME=?, ESPECIE=?, RACA=?, IDADE=?, COR=?, SEXO=?, CASTRADO=?, VACINACAO=?, DOENCA=?, DESCRICAO=?, SITUACAO=? WHERE ID=?";
	private final String DELETE = "DELETE FROM ANIMAL WHERE ID =?";
	private final String LIST = "SELECT * FROM ANIMAL";
	private final String LISTBYID = "SELECT * FROM ANIMAL WHERE ID=?";
	conexao conexao= new conexao();
	
	public List<Animal> getAnimals() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet animais = null;
		ArrayList<Animal> animals = new ArrayList<Animal>();
		try {
			conn = conexao.AbrirConexao();
			pstm = conn.prepareStatement(LIST);
			animais = pstm.executeQuery();
	        while(animais.next()) {
	        	String id = animais.getString("id");
	        	String nome = animais.getString("nome");
	        	String especie = animais.getString("especie");
	        	String raca = animais.getString("raca");
	        	String idade = animais.getString("idade");
	        	String cor = animais.getString("cor");
	        	String sexo = animais.getString("sexo");
	        	String castrado = animais.getString("castrado");
	        	String vacinado = animais.getString("vacinacao");
	        	String doencas = animais.getString("doenca");
	        	String descricao = animais.getString("descricao");
	        	String situacao = animais.getString("situacao");
	        	if(castrado.contentEquals("1")) {
	        		castrado = "true";
	        	}
	        	if(vacinado.contentEquals("1")) {
	        		vacinado = "true";
	        	}

	        	Animal animal = new Animal(Integer.parseInt(id),nome,especie,raca,Integer.parseInt(idade),cor,sexo,Boolean.parseBoolean(castrado),Boolean.parseBoolean(vacinado),doencas,descricao,situacao);
	        	animals.add(animal);
	        }
			conexao.FecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar animais" + e.getMessage());
		}
		return animals;
	}

	public void inserir(Animal animal) {
		if (animal != null) {
			Connection conn = null;
			try {
				conn = conexao.AbrirConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);

				pstm.setString(1, animal.getNome());
				pstm.setString(2, animal.getEspecie());
				pstm.setString(3, animal.getRaca());
				pstm.setInt(4, animal.getIdade());
				pstm.setString(5, animal.getCor());
				pstm.setString(6, animal.getSexo());
				pstm.setBoolean(7, animal.isCastrado());
				pstm.setBoolean(8, animal.isVacinado());
				pstm.setString(9, animal.getDoencas());
				pstm.setString(10, animal.getDescricao());
				pstm.setString(11, animal.getSituacao());

				pstm.execute();
				JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso");
				conexao.FecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir animal no banco de "
						+ "dados " + e.getMessage());
			}
		} else {
			System.out.println("O animal enviado por parâmetro está vazio");
		}

	}
	
	
	public void remover(int id) {
		Connection conn = null;
		try {
			conn = conexao.AbrirConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE);

			pstm.setInt(1, id);

			pstm.execute();
			conexao.FecharConexao();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir animal do banco de "
					+ "dados " + e.getMessage());
		}
	}
	
	public Animal getAnimalById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Animal animal = new Animal();
		try {
			conn = conexao.AbrirConexao();
			pstm = conn.prepareStatement(LISTBYID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				animal.setId(rs.getInt("id"));
				animal.setNome(rs.getString("nome"));
				animal.setEspecie(rs.getString("especie"));
				animal.setRaca(rs.getString("raca"));
				animal.setIdade(rs.getInt("idade"));
				animal.setCor(rs.getString("cor"));
				animal.setSexo(rs.getString("sexo"));
				animal.setCastrado(rs.getBoolean("castrado"));
				animal.setVacinado(rs.getBoolean("vacinacao"));
				animal.setDoencas(rs.getString("doenca"));
				animal.setDescricao(rs.getString("descricao"));
				animal.setSituacao(rs.getString("situacao"));
			}
			conexao.FecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar animals" + e.getMessage());
		}
		return animal;
	}
	
	public void atualizar(Animal animal) {
		if (animal != null) {
			Connection conn = null;
			try {
				conn = conexao.AbrirConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(UPDATE);
				
				pstm.setString(1, animal.getNome());
				pstm.setString(2, animal.getEspecie());
				pstm.setString(3, animal.getRaca());
				pstm.setInt(4, animal.getIdade());
				pstm.setString(5, animal.getCor());
				pstm.setString(6, animal.getSexo());
				pstm.setBoolean(7, animal.isCastrado());
				pstm.setBoolean(8, animal.isVacinado());
				pstm.setString(9, animal.getDoencas());
				pstm.setString(10, animal.getDescricao());
				pstm.setString(11, animal.getSituacao());
				pstm.setInt(12, animal.getId());


				pstm.execute();
				JOptionPane.showMessageDialog(null, "Animal alterado com sucesso");
				conexao.FecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar animal no banco de "
						+ "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O animal enviado por parametro esta vazio");
		}


	}


}
