package sistemaDeGerenciamentoDeAnimaisParaAdocao.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AnimalTableModel extends AbstractTableModel{
	private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_ESPECIE = 2;
    private static final int COL_RACA = 3;
    private static final int COL_IDADE = 4;
    private static final int COL_COR = 5;
    private static final int COL_SEXO = 6;
    private static final int COL_CASTRADO = 7;
    private static final int COL_VACINADO = 8;
    private static final int COL_DOENCAS = 9;
    private static final int COL_DESCRICAO = 10;
    private static final int COL_SITUACAO = 11;
    
    List<Animal> linhas;
    
    String[] colunas = new String[]{"id","nome","espécie","raça", "idade","cor","sexo","castrado","vacinado","doenças","descrição","situação"};
	
    
    public AnimalTableModel(List<Animal> linhas) {
    	this.linhas = linhas;
    }
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}
	
	public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
 
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        }
        return String.class;
    }
 
    public boolean isCellEditable(int rowIndex, int
    columnIndex) {
        return false;
    }
	
	@Override
    public Object getValueAt(int row, int column) {
    	 
        Animal m = linhas.get(row);
 
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNome();
        } else if (column == COL_ESPECIE) {
            return m.getEspecie();
        } else if (column == COL_RACA) {
            return m.getRaca();
        } else if (column == COL_IDADE) {
            return m.getIdade();
        } else if (column == COL_COR) {
            return m.getCor();
        } else if (column == COL_SEXO) {
            return m.getSexo();
        } else if (column == COL_CASTRADO) {
            return m.isCastrado();
        } else if (column == COL_VACINADO) {
            return m.isVacinado();
        } else if (column == COL_DOENCAS) {
            return m.getDoencas();
        } else if (column == COL_DESCRICAO) {
            return m.getDescricao();
        } else if (column == COL_SITUACAO) {
            return m.getSituacao();
        }
        return "";
    }
	
	public void setValueAt(Object aValue, int row, int column) {
        Animal m = linhas.get(row);
        
        if (column == COL_ID) {
            m.setId((Integer)aValue);
        } else if (column == COL_NOME) {
            m.setNome(aValue.toString());
        } else if (column == COL_ESPECIE) {
            m.setEspecie(aValue.toString());
        } else if (column == COL_RACA) {
            m.setRaca(aValue.toString());
        } else if (column == COL_IDADE) {
            m.setIdade((Integer)aValue);
        } else if (column == COL_COR) {
            m.setCor(aValue.toString());
        } else if (column == COL_SEXO) {
            m.setSexo(aValue.toString());
        } else if (column == COL_CASTRADO) {
            m.setCastrado((Boolean)aValue);
        } else if (column == COL_VACINADO) {
            m.setVacinado((Boolean)aValue);
        } else if (column == COL_DOENCAS) {
            m.setDoencas(aValue.toString());
        } else if (column == COL_DESCRICAO) {
            m.setDescricao(aValue.toString());
        } else if (column == COL_SITUACAO) {
            m.setSituacao(aValue.toString());
        }    
    }
    public Animal getAnimal(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    public void addAnimal(Animal Animal) {
        linhas.add(Animal);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, 
        ultimoIndice);
 
    }
    public void updateAnimal(int indiceLinha, Animal marca) {
        linhas.set(indiceLinha, marca);
        fireTableRowsUpdated(indiceLinha, 
        indiceLinha);
 
    }
    public void removeAnimal(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, 
        indiceLinha);
 
    }
}
