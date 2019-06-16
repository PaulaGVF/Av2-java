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

public class AtualizarAnimal extends JFrame{
	private AnimalTableModel modelo;
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbId;
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
    private JTextField txId;
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
    Animal animal;
    private int linhaSelecionada;

    public AtualizarAnimal(AnimalTableModel md, int id, int linha) {
        super("Animals");
        criaJanela();
        modelo = md;
        AnimalDAO dao = new AnimalDAO();
        animal = dao.getAnimalById(id);
        txId.setText(Integer.toString(animal.getId()));
        txNome.setText(animal.getNome());
        txEspecie.setText(animal.getEspecie());
        txRaca.setText(animal.getRaca());
        txIdade.setText(Integer.toString(animal.getIdade()));
        txCor.setText(animal.getCor());
        txSexo.setText(animal.getSexo());
        txCastrado.setText(Boolean.toString(animal.isCastrado()));
        txVacinado.setText(Boolean.toString(animal.isVacinado()));
        txDoencas.setText(animal.getDoencas());
        txDescricao.setText(animal.getDescricao());
        txSituacao.setText(animal.getSituacao());
        linhaSelecionada = linha;  
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbId = new JLabel("         Id.:   ");
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
        
        txId = new JTextField(4);
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
        txId.setEditable(false);

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(14, 1, 2, 4));
        painelFundo.add(lbId);
        painelFundo.add(txId);
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
        setSize(600, 600);
        setVisible(true);

        btSalvar.addActionListener(new AtualizarAnimal.BtSalvarListener());
        btLimpar.addActionListener(new AtualizarAnimal.BtLimparListener());
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
		dao.atualizar(a);

		modelo.updateAnimal(linhaSelecionada, a);
		setVisible(false);
	}
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
