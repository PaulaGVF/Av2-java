package sistemaDeGerenciamentoDeAnimaisParaAdocao.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AdotanteTableModel extends AbstractTableModel{
	private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_CPF = 2;
    private static final int COL_TELEFONE = 3;
    private static final int COL_ENDERECO = 4;
    private static final int COL_EMAIL = 5;
    private static final int COL_IDANIMAL = 6;

    
    List<Adotante> linhas;
    
    String[] colunas = new String[]{"id","nome","cpf","telefone", "endereco","email","id animal"};
	
    
    public AdotanteTableModel(List<Adotante> linhas) {
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
    	 
        Adotante m = linhas.get(row);
 
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNome();
        } else if (column == COL_CPF) {
            return m.getCpf();
        } else if (column == COL_TELEFONE) {
            return m.getTelefone();
        } else if (column == COL_ENDERECO) {
            return m.getEndereco();
        } else if (column == COL_EMAIL) {
            return m.getEmail();
        } else if (column == COL_IDANIMAL) {
            return m.getIdAnimal();
        }
        return "";
    }
	
	public void setValueAt(Object aValue, int row, int column) {
        Adotante m = linhas.get(row);
        
        if (column == COL_ID) {
            m.setId((Integer)aValue);
        } else if (column == COL_NOME) {
            m.setNome(aValue.toString());
        } else if (column == COL_CPF) {
            m.setCpf(aValue.toString());
        } else if (column == COL_TELEFONE) {
            m.setTelefone(aValue.toString());
        } else if (column == COL_ENDERECO) {
        	m.setEndereco(aValue.toString());
        } else if (column == COL_EMAIL) {
            m.setEmail(aValue.toString());
        } else if (column == COL_IDANIMAL) {
            m.setIdAnimal((Integer)aValue);
        }    
    }
    public Adotante getAdotante(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    public void addAdotante(Adotante Adotante) {
        linhas.add(Adotante);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, 
        ultimoIndice);
 
    }
    public void updateAdotante(int indiceLinha, Adotante marca) {
        linhas.set(indiceLinha, marca);
        fireTableRowsUpdated(indiceLinha, 
        indiceLinha);
 
    }
    public void removeAdotante(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, 
        indiceLinha);
 
    }
}
