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

import sistemaDeGerenciamentoDeAnimaisParaAdocao.controller.AtualizarAnimal;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.controller.InserirAnimal;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Animal;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.AnimalTableModel;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao.AnimalDAO;

public class TelaAnimais extends JFrame{
	
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
	private AnimalTableModel modelo;
	
    public TelaAnimais(ResultSet animais) throws SQLException {
    	super("Animais");
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
    	AnimalDAO aniDao = new AnimalDAO();
    	List<Animal> animais = aniDao.getAnimals();
        modelo = new AnimalTableModel(animais);
        tabela.setModel(modelo);      
    }
    
    private class BtInserirListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
                InserirAnimal ic = new InserirAnimal(modelo);
                ic.setVisible(true);
            }
        }

        private class BtEditarListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idAnimal = (int) tabela.getValueAt(linhaSelecionada, 0);
                    AtualizarAnimal ic = new AtualizarAnimal(modelo, idAnimal, linhaSelecionada);
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
                    int idAnimal = (int) tabela.getValueAt(linhaSelecionada, 0);
                    AnimalDAO aniDao = new AnimalDAO();
                    aniDao.remover(idAnimal);

                    modelo.removeAnimal(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha.");
                }
            }
        }

}
