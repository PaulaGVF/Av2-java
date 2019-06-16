package sistemaDeGerenciamentoDeAnimaisParaAdocao.controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.Animal;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.AnimalTableModel;
import sistemaDeGerenciamentoDeAnimaisParaAdocao.model.dao.AnimalDAO;



public class InserirAnimal extends JFrame{
	private AnimalTableModel modelo;
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbEspecie;
    private JLabel lbRaca;
    private JLabel lbIdade;
    private JLabel lbCor;
    private JLabel lbSexo;
    private JLabel lbCastrado;
    private JLabel lbVacinado;
    private JLabel lbDoencas;
    private JLabel lbDescricao;
    private JLabel lbSituacao;
    private JTextField txNome;
    private JTextField txEspecie;
    private JTextField txRaca;
    private JTextField txIdade;
    private JTextField txCor;
    private JTextField txSexo;
    private JTextField txCastrado;
    private JTextField txVacinado;
    private JTextField txDoencas;
    private JTextField txDescricao;
    private JTextField txSituacao;
    //
    public InserirAnimal(AnimalTableModel md) {
        super("Animals");
        criaJanela();
        modelo = md;
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("         Nome.:   ");
        lbEspecie = new JLabel("         Espécie.:   ");
        lbRaca = new JLabel("         Raça.:   ");
        lbIdade = new JLabel("         Idade.:   ");
        lbCor = new JLabel("         Cor.:   ");
        lbSexo = new JLabel("         Sexo.:   ");
        lbCastrado = new JLabel("         Castrado.:   ");
        lbVacinado = new JLabel("         Vacinado.:   ");
        lbDoencas = new JLabel("         Doenças.:   ");
        lbDescricao = new JLabel("         Descrição.:   ");
        lbSituacao = new JLabel("         Situação.:   ");
        
        txNome = new JTextField(100);
        txEspecie = new JTextField(100);
        txRaca= new JTextField(100);
        txIdade = new JTextField(10);
        txCor = new JTextField(100);
        txSexo = new JTextField(100);
        txCastrado = new JTextField(100);
        txVacinado = new JTextField(100);
        txDoencas = new JTextField(100);
        txDescricao = new JTextField(100);
        txSituacao = new JTextField(100);
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(14, 1, 2, 4));
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(lbEspecie);
        painelFundo.add(txEspecie);
        painelFundo.add(lbRaca);
        painelFundo.add(txRaca);
        painelFundo.add(lbIdade);
        painelFundo.add(txIdade);
        painelFundo.add(lbCor);
        painelFundo.add(txCor);
        painelFundo.add(lbSexo);
        painelFundo.add(txSexo);
        painelFundo.add(lbCastrado);
        painelFundo.add(txCastrado);
        painelFundo.add(lbVacinado);
        painelFundo.add(txVacinado);
        painelFundo.add(lbDoencas);
        painelFundo.add(txDoencas);
        painelFundo.add(lbDescricao);
        painelFundo.add(txDescricao);
        painelFundo.add(lbSituacao);
        painelFundo.add(txSituacao);
  
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
            Animal a = new Animal();
            a.setNome(txNome.getText());
            a.setEspecie(txEspecie.getText());
            a.setRaca(txRaca.getText());
            a.setIdade(Integer.parseInt(txIdade.getText()));
            a.setCor(txCor.getText());
            a.setSexo(txSexo.getText());
            a.setCastrado(Boolean.parseBoolean(txCastrado.getText()));
            a.setVacinado(Boolean.parseBoolean(txVacinado.getText()));
            a.setDoencas(txDoencas.getText());
            a.setDescricao(txDescricao.getText());
            a.setSituacao(txSituacao.getText());
            AnimalDAO dao = new AnimalDAO();
            dao.inserir(a);
            pesquisar(a);
            modelo.addAnimal(pesquisar(a));
            setVisible(false);
        }
    }

    public Animal pesquisar(Animal co) {
        AnimalDAO dao = new AnimalDAO();
        return new Animal();
    }

    private class BtLimparListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            txNome.setText("");
            txEspecie.setText("");
            txRaca.setText("");
            txIdade.setText("");
            txCor.setText("");
            txSexo.setText("");
            txCastrado.setText("");
            txVacinado.setText("");
            txDoencas.setText("");
            txDescricao.setText("");
            txSituacao.setText("");
        }
    }

}
