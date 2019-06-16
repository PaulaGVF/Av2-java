package sistemaDeGerenciamentoDeAnimaisParaAdocao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conexao {
    
    
     public Connection con = null;
     public Statement stmt = null;
     public ResultSet resultset = null;
     String servidor = "jdbc:mysql://localhost:3306/sgaa"; 
     String usuario = "root";
     String senha = "130996"; 
     String driver = "com.mysql.jdbc.Driver";
    
    
    public Connection AbrirConexao() {
        
        try {
            
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(servidor, usuario, senha);
            stmt = con.createStatement();
            System.out.println("Conexão aberta com sucesso");
            
            
        } catch ( Exception e) { System.out.println("erro ao acessar banco de dados");
        e.printStackTrace();
        }
        return con;
            
    }

        public void FecharConexao() {
        try {
            con.close();
            System.out.println("Conexão finalizada com sucesso");
            
        } catch (Exception e ) { System.out.println("Erro ao encerrar conexão" + e.getMessage());
        
        }  
    }
}   
