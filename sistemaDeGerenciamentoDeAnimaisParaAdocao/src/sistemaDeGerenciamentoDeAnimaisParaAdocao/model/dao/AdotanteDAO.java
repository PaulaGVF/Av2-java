package sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.jdbc.conexao;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Adotante;

public class AdotanteDAO {
	private final String INSERT = "INSERT INTO ADOTANTE (NOME,CPF,TELEFONE,ENDERECO,EMAIL,ID_ANIMAL) VALUES (?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE ADOTANTE SET NOME=?, CPF=?, TELEFONE=?, ENDERECO=?, EMAIL=?, ID_ANIMAL=? WHERE ID=?";
	private final String DELETE = "DELETE FROM ADOTANTE WHERE ID =?";
	private final String LIST = "SELECT * FROM ADOTANTE";
	private final String LISTBYID = "SELECT * FROM ADOTANTE WHERE ID=?";
	conexao conexao= new conexao();
	
	public List<Adotante> getAdotantes() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet ad = null;
		ArrayList<Adotante> adotantes = new ArrayList<Adotante>();
		try {
			conn = conexao.AbrirConexao();
			pstm = conn.prepareStatement(LIST);
			ad = pstm.executeQuery();
	        while(ad.next()) {
	        	int id = ad.getInt("id");
	        	String nome = ad.getString("nome");
	        	String cpf = ad.getString("cpf");
	        	String telefone = ad.getString("telefone");
	        	String endereco = ad.getString("endereco");
	        	String email = ad.getString("email");
	        	int idAnimal = ad.getInt("id_animal");

	        	Adotante adotante = new Adotante(id,nome,cpf,telefone,endereco,email,idAnimal);
	        	adotantes.add(adotante);
	        }
			conexao.FecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar ad" + e.getMessage());
		}
		return adotantes;
	}

	public void inserir(Adotante adotante) {
		if (adotante != null) {
			Connection conn = null;
			try {
				conn = conexao.AbrirConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);

				pstm.setString(1, adotante.getNome());
				pstm.setString(2, adotante.getCpf());
				pstm.setString(3, adotante.getTelefone());
				pstm.setString(4, adotante.getEndereco());
				pstm.setString(5, adotante.getEmail());
				pstm.setInt(6, adotante.getIdAnimal());
				

				pstm.execute();
				JOptionPane.showMessageDialog(null, "Adotante cadastrado com sucesso");
				conexao.FecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir adotante no banco de "
						+ "dados " + e.getMessage());
			}
		} else {
			System.out.println("O adotante enviado por parâmetro está vazio");
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
			JOptionPane.showMessageDialog(null, "Erro ao excluir adotante do banco de "
					+ "dados " + e.getMessage());
		}
	}
	
	public Adotante getAdotanteById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Adotante adotante = new Adotante();
		try {
			conn = conexao.AbrirConexao();
			pstm = conn.prepareStatement(LISTBYID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				adotante.setId(rs.getInt("id"));
				adotante.setNome(rs.getString("nome"));
				adotante.setCpf(rs.getString("cpf"));
				adotante.setTelefone(rs.getString("telefone"));
				adotante.setEndereco(rs.getString("endereco"));
				adotante.setEmail(rs.getString("email"));
				adotante.setIdAnimal(rs.getInt("id_animal"));
			
			}
			conexao.FecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar adotantes" + e.getMessage());
		}
		return adotante;
	}
	
	public void atualizar(Adotante adotante) {
		if (adotante != null) {
			Connection conn = null;
			try {
				conn = conexao.AbrirConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(UPDATE);
				
				pstm.setString(1, adotante.getNome());
				pstm.setString(2, adotante.getCpf());
				pstm.setString(3, adotante.getTelefone());
				pstm.setString(4, adotante.getEndereco());
				pstm.setString(5, adotante.getEmail());
				pstm.setInt(6, adotante.getIdAnimal());
				pstm.setInt(7, adotante.getId());


				pstm.execute();
				JOptionPane.showMessageDialog(null, "Adotante alterado com sucesso");
				conexao.FecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar adotante no banco de "
						+ "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O adotante enviado por parametro esta vazio");
		}


	}

}
