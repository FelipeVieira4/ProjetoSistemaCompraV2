package ferramentas;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import produto.*;

public class SistemaCompra extends ArrayList<CompraProduto>{
	private static final long serialVersionUID = 1L;

	public float getValor() {
		
		float f = 0.0f;
		for(CompraProduto i: this) {
			f+=i.getPrecoTotal();
		}
		return f;
	}

}
