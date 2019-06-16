package sistemaDeGerenciamentoDeAnimaisParaAdocao.controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Adotante;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.AdotanteTableModel;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao.AdotanteDAO;

public class AtualizarAdotante extends JFrame{
	private AdotanteTableModel modelo;
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbId;
    private JLabel lbNome;
    private JLabel lbCpf;
    private JLabel lbTelefone;
    private JLabel lbEndereco;
    private JLabel lbEmail;
    private JLabel lbIdAnimal;
   
    private JTextField txId;
    private JTextField txNome;
    private JTextField txCpf;
    private JTextField txTelefone;
    private JTextField txEndereco;
    private JTextField txEmail;
    private JTextField txIdAnimal;
    
    Adotante adotante;
    private int linhaSelecionada;

    public AtualizarAdotante(AdotanteTableModel md, int id, int linha) {
        super("Adotantes");
        criaJanela();
        modelo = md;
        AdotanteDAO dao = new AdotanteDAO();
        adotante = dao.getAdotanteById(id);
        txId.setText(Integer.toString(adotante.getId()));
        txNome.setText(adotante.getNome());
        txCpf.setText(adotante.getCpf());
        txTelefone.setText(adotante.getTelefone());
        txEndereco.setText(adotante.getEndereco());
        txEmail.setText(adotante.getEmail());
        txIdAnimal.setText(Integer.toString(adotante.getIdAnimal()));
       
     
        linhaSelecionada = linha;  
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbId = new JLabel("         Id.:   ");
        lbNome = new JLabel("         Nome.:   ");
        lbCpf = new JLabel("         Espécie.:   ");
        lbTelefone = new JLabel("         Raça.:   ");
        lbEndereco = new JLabel("         Endereco.:   ");
        lbEmail = new JLabel("         Email.:   ");
        lbIdAnimal = new JLabel("         IdAnimal.:   ");
        
        txId = new JTextField(4);
        txNome = new JTextField(100);
        txCpf = new JTextField(100);
        txTelefone= new JTextField(100);
        txEndereco = new JTextField(10);
        txEmail = new JTextField(100);
        txIdAnimal = new JTextField(100);
        txId.setEditable(false);

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(9, 1, 2, 4));
        painelFundo.add(lbId);
        painelFundo.add(txId);
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(lbCpf);
        painelFundo.add(txCpf);
        painelFundo.add(lbTelefone);
        painelFundo.add(txTelefone);
        painelFundo.add(lbEndereco);
        painelFundo.add(txEndereco);
        painelFundo.add(lbEmail);
        painelFundo.add(txEmail);
        painelFundo.add(lbIdAnimal);
        painelFundo.add(txIdAnimal);

        painelFundo.add(btLimpar);
        painelFundo.add(btSalvar);
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        btSalvar.addActionListener(new AtualizarAdotante.BtSalvarListener());
        btLimpar.addActionListener(new AtualizarAdotante.BtLimparListener());
    }

    private class BtSalvarListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Adotante a = new Adotante();
		a.setNome(txNome.getText());
        a.setCpf(txCpf.getText());
        a.setTelefone(txTelefone.getText());
        a.setEndereco(txEndereco.getText());
        a.setEmail(txEmail.getText());
        a.setIdAnimal(Integer.parseInt(txIdAnimal.getText()));
        
        
		AdotanteDAO dao = new AdotanteDAO();
		dao.atualizar(a);

		modelo.updateAdotante(linhaSelecionada, a);
		setVisible(false);
	}
}


    private class BtLimparListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	txNome.setText("");
            txCpf.setText("");
            txTelefone.setText("");
            txEndereco.setText("");
            txEmail.setText("");
            txIdAnimal.setText("");
        }
    }

}
