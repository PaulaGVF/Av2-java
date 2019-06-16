package sistemaDeGerenciamentoDeAnimaisParaAdocao.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.controller.AtualizarAdotante;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.controller.InserirAdotante;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Adotante;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.AdotanteTableModel;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao.AdotanteDAO;


public class TelaAdotantes extends JFrame{
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
	private AdotanteTableModel modelo;
	
    public TelaAdotantes(ResultSet adotantes) throws SQLException {
    	super("Adotantes");
        criaJTable();
    	criaJanela();
    }
    
    public void criaJanela() {
        btInserir = new JButton("Inserir");
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);

       btInserir.addActionListener(new BtInserirListener());
       btEditar.addActionListener(new BtEditarListener());
       btExcluir.addActionListener(new BtExcluirListener());	
    }
    
    private void criaJTable() {
        tabela = new JTable(modelo);
        pesquisar();
     
    }
     
    private void pesquisar() {
    	AdotanteDAO adoDao = new AdotanteDAO();
    	List<Adotante> adotantes = adoDao.getAdotantes();
        modelo = new AdotanteTableModel(adotantes);
        tabela.setModel(modelo);      
    }
    
    private class BtInserirListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
                InserirAdotante ic = new InserirAdotante(modelo);
                ic.setVisible(true);
            }
        }

        private class BtEditarListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idAdotante = (int) tabela.getValueAt(linhaSelecionada, 0);
                    AtualizarAdotante ic = new AtualizarAdotante(modelo, idAdotante, linhaSelecionada);
                    ic.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "E necessario selecionar uma linha.");
                }
            }
        }

        private class BtExcluirListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idAdotante = (int) tabela.getValueAt(linhaSelecionada, 0);
                    AdotanteDAO aniDao = new AdotanteDAO();
                    aniDao.remover(idAdotante);

                    modelo.removeAdotante(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(null, "E necessario selecionar uma linha.");
                }
            }
        }
}
