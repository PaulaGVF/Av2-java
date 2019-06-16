package sistemaDeGerenciamentoDeAnimaisParaAdocao.controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Adotante;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.AdotanteTableModel;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao.AdotanteDAO;

public class InserirAdotante extends JFrame{
	private AdotanteTableModel modelo;
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbCpf;
    private JLabel lbTelefone;
    private JLabel lbIdAnimal;
    private JLabel lbEmail;
    private JLabel lbEndereco;
    private JTextField txNome;
    private JTextField txCpf;
    private JTextField txTelefone;
    private JTextField txIdAnimal;
    private JTextField txEmail;
    private JTextField txEndereco;
    //
    public InserirAdotante(AdotanteTableModel md) {
        super("Adotantes");
        criaJanela();
        modelo = md;
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("         Nome.:   ");
        lbCpf = new JLabel("         CPF.:   ");
        lbTelefone = new JLabel("         Telefone.:   ");
        lbIdAnimal = new JLabel("         IdAnimal.:   ");
        lbEmail = new JLabel("         Email.:   ");
        lbEndereco = new JLabel("         Endereço.:   ");
        
        txNome = new JTextField(100);
        txCpf = new JTextField(100);
        txTelefone= new JTextField(100);
        txIdAnimal = new JTextField(10);
        txEmail = new JTextField(100);
        txEndereco = new JTextField(100);
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(8, 1, 2, 4));
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(lbCpf);
        painelFundo.add(txCpf);
        painelFundo.add(lbTelefone);
        painelFundo.add(txTelefone);
        painelFundo.add(lbIdAnimal);
        painelFundo.add(txIdAnimal);
        painelFundo.add(lbEmail);
        painelFundo.add(txEmail);
        painelFundo.add(lbEndereco);
        painelFundo.add(txEndereco);
  
        painelFundo.add(btLimpar);
        painelFundo.add(btSalvar);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
        btSalvar.addActionListener(new BtSalvarListener());
        btLimpar.addActionListener(new BtLimparListener());
    }

    private class BtSalvarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Adotante a = new Adotante();
            a.setNome(txNome.getText());
            a.setCpf(txCpf.getText());
            a.setTelefone(txTelefone.getText());
            a.setIdAnimal(Integer.parseInt(txIdAnimal.getText()));
            a.setEmail(txEmail.getText());
            a.setEndereco(txEndereco.getText());
            AdotanteDAO dao = new AdotanteDAO();
            dao.inserir(a);
            pesquisar(a);
            modelo.addAdotante(pesquisar(a));
            setVisible(false);
        }
    }

    public Adotante pesquisar(Adotante co) {
        AdotanteDAO dao = new AdotanteDAO();
        return new Adotante();
    }

    private class BtLimparListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            txNome.setText("");
            txCpf.setText("");
            txTelefone.setText("");
            txIdAnimal.setText("");
            txEmail.setText("");
            txEndereco.setText("");
        }
    }

}
