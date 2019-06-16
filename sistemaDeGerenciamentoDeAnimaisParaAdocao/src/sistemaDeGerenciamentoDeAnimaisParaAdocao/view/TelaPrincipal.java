package sistemaDeGerenciamentoDeAnimaisParaAdocao.view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.jdbc.conexao;

public class TelaPrincipal extends JFrame{
	
	private JPanel contentPane;
	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal frame = new TelaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    conexao banco = new conexao();
    
    
    public TelaPrincipal() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sistema de Gerenciamento de Animais para Adoção");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 426, 212);
        
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.window);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblIdentificao = new JLabel("Sistema de Gerenciamento de Animais para Adoção");
        lblIdentificao.setBounds(50, 0, 400, 39);
        contentPane.add(lblIdentificao);
        
        JButton btnAnimais = new JButton("Animais");
        btnAnimais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                banco.AbrirConexao();
                try {
					banco.stmt= banco.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String query = "SELECT * FROM animal";
                    banco.resultset = banco.stmt.executeQuery(query); 
                    TelaAnimais telaA = new TelaAnimais(banco.resultset); 
                    
                    
                    telaA.setVisible(true); //Torna a tela Principal visível
                    dispose();// faz com que a tela de login desapareça após abrir tela principal 
                    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
        btnAnimais.setBounds(66, 136, 117, 25);
        
        contentPane.add(btnAnimais);
 
        JButton btnAdotantes = new JButton("Adotantes");
        btnAdotantes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                banco.AbrirConexao();
                try {
					banco.stmt= banco.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String query = "SELECT * FROM adotante";
                    banco.resultset = banco.stmt.executeQuery(query); 
                    TelaAdotantes telaA = new TelaAdotantes(banco.resultset); 
                    
                    
                    telaA.setVisible(true); //Torna a tela Principal visível
                    dispose();// faz com que a tela de login desapareça após abrir tela principal 
                    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
        
        btnAdotantes.setBounds(266, 136, 117, 25);
        contentPane.add(btnAdotantes);
 
    }
}
