package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import produto.*;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dados.CrudDados;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PrincipalScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	

	private ArrayList<CompraProduto> lista_compra = new ArrayList<CompraProduto>();
	
	//Componentes Interface
	private JTextField precoTF_cadastro;
	private JTextField nomeTX_cadastro;
	private JTextField localTF_cadastro;
	private JTextField distribuidoraTF_cadastro;
	private JTable table_Lista;
	private JTextField codigoTF_buscar;
	private JTextField contatoTF_buscar;
	private JTextField localTF_buscar;
	private JTextField categoriasTF_buscar;
	private JTextField precoTF_buscar;
	private JTextField nomeTF_buscar;
	private JTextField codigoTF_deleta;
	private JTextField codigoTF_Compra;
	private JTable tableCompra;
	private JTextField precoTF_compra;
	private JTextField qtdaTF_compra;
	private JTextField removerTF_compra;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField codigoTF_editar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalScreen frame = new PrincipalScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalScreen() {
		setTitle("Trabalho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 606, 363);
		contentPane.add(tabbedPane);
		
		
		
		JPanel cadastroPanel = new JPanel();
		tabbedPane.addTab("Cadastro Produto", null, cadastroPanel, null);
		cadastroPanel.setLayout(null);
		
		JLabel lblPreco_cadastro = new JLabel("preço");
		lblPreco_cadastro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco_cadastro.setBounds(0, 180, 57, 18);
		cadastroPanel.add(lblPreco_cadastro);
		
		precoTF_cadastro = new JTextField();
		precoTF_cadastro.setColumns(10);
		precoTF_cadastro.setBounds(47, 180, 86, 20);
		cadastroPanel.add(precoTF_cadastro);
		
		JLabel lbNome_cadastro = new JLabel("nome");
		lbNome_cadastro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome_cadastro.setBounds(0, 148, 57, 18);
		cadastroPanel.add(lbNome_cadastro);
		
		nomeTX_cadastro = new JTextField();
		nomeTX_cadastro.setColumns(10);
		nomeTX_cadastro.setBounds(47, 148, 196, 20);
		cadastroPanel.add(nomeTX_cadastro);
		
		JLabel lbLocalProduzido_cadastro = new JLabel("Local Produzido");
		lbLocalProduzido_cadastro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLocalProduzido_cadastro.setBounds(0, 242, 120, 18);
		cadastroPanel.add(lbLocalProduzido_cadastro);
		
		localTF_cadastro = new JTextField();
		localTF_cadastro.setColumns(10);
		localTF_cadastro.setBounds(154, 242, 187, 20);
		cadastroPanel.add(localTF_cadastro);
		
		JLabel lblContato_cadastro = new JLabel("Contato Distribuidora");
		lblContato_cadastro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContato_cadastro.setBounds(0, 271, 149, 18);
		cadastroPanel.add(lblContato_cadastro);
		
		distribuidoraTF_cadastro = new JTextField();
		distribuidoraTF_cadastro.setColumns(10);
		distribuidoraTF_cadastro.setBounds(154, 271, 187, 20);
		cadastroPanel.add(distribuidoraTF_cadastro);
		
		JTextPane descricaoTextPane = new JTextPane();
		descricaoTextPane.setBounds(279, 24, 322, 142);
		cadastroPanel.add(descricaoTextPane);
		
		
		JLabel lblDescricao_cadastro = new JLabel("Descrição Produto");
		lblDescricao_cadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cadastroPanel.add(lblDescricao_cadastro);
		
		JLabel lblfoto_cadastro = new JLabel("");
 		lblfoto_cadastro.setBounds(0, 11, 150, 120);
 		cadastroPanel.add(lblfoto_cadastro);
 		
 		JComboBox<Categorias> categoriaCB_cadastro = new JComboBox<Categorias>();
 		categoriaCB_cadastro.setModel(new DefaultComboBoxModel<Categorias>(Categorias.values()));
 		categoriaCB_cadastro.setBounds(154, 212, 187, 26);
 		cadastroPanel.add(categoriaCB_cadastro);
 		
		JButton runButton_cadastro = new JButton("ADD");
		runButton_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto p = new Produto();
				
				String precoString = precoTF_cadastro.getText();
				if(!precoString.isBlank() && precoString.matches("[0-9.]*")) {
					p.setPreco(Float.parseFloat(precoTF_cadastro.getText()));
				}
				
				p.setNome(nomeTX_cadastro.getText());
								
				p.setContatoDistribuidora(distribuidoraTF_cadastro.getText());

				
				p.setLocalProduzido(localTF_cadastro.getText());
				p.setDecricao(descricaoTextPane.getText());				
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(getParent());
				
				File file = fileChooser.getSelectedFile();
				
				if(file!=null) {
					ImageIcon img= new ImageIcon(file.toString());//Carrega imagem

					lblfoto_cadastro.setIcon(new ImageIcon((Image)img.getImage().getScaledInstance(lblfoto_cadastro.getWidth(),lblfoto_cadastro.getHeight(),Image.SCALE_SMOOTH)));
					
					
					p.setPatchIcon(fileChooser.getSelectedFile().toString());
				}
				
				p.setCategoria(Categorias.valueOf(categoriaCB_cadastro.getSelectedItem().toString()));
				CrudDados.salvar(p);
			}
		});
		runButton_cadastro.setBounds(520, 303, 71, 32);
		cadastroPanel.add(runButton_cadastro);
 		lblDescricao_cadastro.setBounds(279, 0, 122, 25);
 		
 		JLabel lblCategorias = new JLabel("Categorias");
 		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
 		lblCategorias.setBounds(0, 215, 120, 18);
 		cadastroPanel.add(lblCategorias);
 		

 		
 		JPanel listaPanel = new JPanel();
 		tabbedPane.addTab("Lista Produto", null, listaPanel, null);
 		listaPanel.setLayout(null);
 		
 		table_Lista = new JTable();
 		table_Lista.setModel(new DefaultTableModel(
 			new Object[][] {
 				{null, null, null},
 			},
 			new String[] {
 				"CÓDIGO", "NOME", "PREÇO"
 			}
 		));
 		table_Lista.setBounds(0, 48, 601, 288);
 		listaPanel.add(table_Lista);
 		
 		JButton btnAtualizarTabela = new JButton("Atualizar");
 		btnAtualizarTabela.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 
 					ArrayList<Produto> p = CrudDados.buscaLista();
	
 					
 					//table_Lista.removeAll();
 					DefaultTableModel modelo =(DefaultTableModel) table_Lista.getModel();
 					
 					modelo.setRowCount(0);//limpa todas as colunas do modelo
 					
 					//loop adicionar lista_produto ao modelo
	 				for (Produto produto: p) {
	 					modelo.addRow(new Object[] {produto.getCodigo(),produto.getNome(),produto.getPreco()});
						
	 		        }
	 				table_Lista.setModel(modelo);

	 							
 				
 				
 			}
 		});
 		btnAtualizarTabela.setBounds(-1, 5, 89, 23);
 		listaPanel.add(btnAtualizarTabela);
 		
 		JLabel lbl_idLista = new JLabel("ID");
 		lbl_idLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
 		lbl_idLista.setBounds(9, 28, 107, 14);
 		listaPanel.add(lbl_idLista);
 		
 		JLabel lbl_nomeLista = new JLabel("NOME");
 		lbl_nomeLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
 		lbl_nomeLista.setBounds(198, 28, 107, 14);
 		listaPanel.add(lbl_nomeLista);
 		
 		JLabel lbl_precoLista = new JLabel("PREÇO");
 		lbl_precoLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
 		lbl_precoLista.setBounds(400, 30, 107, 14);
 		listaPanel.add(lbl_precoLista);
 		
 		JPanel buscaPanel = new JPanel();
 		tabbedPane.addTab("Buscar Produto", null, buscaPanel, null);
 		buscaPanel.setLayout(null);
 		
 		JLabel lblCodigo = new JLabel("Código");
 		lblCodigo.setFont(new Font("Monospaced", Font.BOLD, 13));
 		lblCodigo.setBounds(0, 33, 55, 15);
 		buscaPanel.add(lblCodigo);
 		
 		codigoTF_buscar = new JTextField();
 		codigoTF_buscar.setBounds(51, 31, 104, 19);
 		buscaPanel.add(codigoTF_buscar);
 		codigoTF_buscar.setColumns(10);
 		
 		contatoTF_buscar = new JTextField();
 		contatoTF_buscar.setEditable(false);
 		contatoTF_buscar.setColumns(10);
 		contatoTF_buscar.setBounds(154, 274, 187, 20);
 		buscaPanel.add(contatoTF_buscar);
 		
 		JLabel lblContato_buscar = new JLabel("Contato Distribuidora");
 		lblContato_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblContato_buscar.setBounds(0, 274, 149, 18);
 		buscaPanel.add(lblContato_buscar);
 		
 		JLabel lbLocalProduzido_buscar = new JLabel("Local Produzido");
 		lbLocalProduzido_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbLocalProduzido_buscar.setBounds(0, 245, 120, 18);
 		buscaPanel.add(lbLocalProduzido_buscar);
 		
 		localTF_buscar = new JTextField();
 		localTF_buscar.setEditable(false);
 		localTF_buscar.setColumns(10);
 		localTF_buscar.setBounds(154, 245, 187, 20);
 		buscaPanel.add(localTF_buscar);
 		
 		categoriasTF_buscar = new JTextField();
 		categoriasTF_buscar.setEditable(false);
 		categoriasTF_buscar.setColumns(10);
 		categoriasTF_buscar.setBounds(154, 218, 187, 20);
 		buscaPanel.add(categoriasTF_buscar);
 		
 		JLabel lblCategorias_buscar = new JLabel("Categoria");
 		lblCategorias_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblCategorias_buscar.setBounds(0, 218, 120, 18);
 		buscaPanel.add(lblCategorias_buscar);
 		
 		JLabel lblPreco_buscar = new JLabel("preço");
 		lblPreco_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblPreco_buscar.setBounds(0, 183, 57, 18);
 		buscaPanel.add(lblPreco_buscar);
 		
 		precoTF_buscar = new JTextField();
 		precoTF_buscar.setEditable(false);
 		precoTF_buscar.setColumns(10);
 		precoTF_buscar.setBounds(51, 183, 86, 20);
 		buscaPanel.add(precoTF_buscar);
 		
 		JLabel lbNome_buscar = new JLabel("nome");
 		lbNome_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbNome_buscar.setBounds(0, 151, 57, 18);
 		buscaPanel.add(lbNome_buscar);
 		
 		nomeTF_buscar = new JTextField();
 		nomeTF_buscar.setEditable(false);
 		nomeTF_buscar.setColumns(10);
 		nomeTF_buscar.setBounds(51, 151, 187, 20);
 		buscaPanel.add(nomeTF_buscar);
 		
 		JLabel lblfoto_buscar = new JLabel("");
 		lblfoto_buscar.setBounds(165, 11, 176, 128);
 		buscaPanel.add(lblfoto_buscar);
 		
 		JButton btnProcurar_buscar = new JButton("Procurar");
 		btnProcurar_buscar.setBounds(10, 60, 98, 25);
 		buscaPanel.add(btnProcurar_buscar);
 		
 		JTextPane descricaoTP_buscar = new JTextPane();
 		descricaoTP_buscar.setEditable(false);
 		descricaoTP_buscar.setBounds(362, 84, 229, 211);
 		buscaPanel.add(descricaoTP_buscar);
 		
 		JLabel lblDescricao_1 = new JLabel("Descrição Produto");
 		lblDescricao_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
 		lblDescricao_1.setBounds(362, 58, 129, 25);
 		buscaPanel.add(lblDescricao_1);
 		
 		btnProcurar_buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(codigoTF_buscar.getText().matches("[0-9]*")) {
					Produto p = CrudDados.busca(Integer.parseInt(codigoTF_buscar.getText()));
					
					nomeTF_buscar.setText(p.getNome());
					precoTF_buscar.setText(String.valueOf(p.getPreco()));
					
					contatoTF_buscar.setText(p.getContatoDistribuidora());
					localTF_buscar.setText(p.getLocalProduzido());
					
					categoriasTF_buscar.setText(String.valueOf(p.getCategoria()));
					
					descricaoTP_buscar.setText(p.getDecricao());
					
					ImageIcon img= new ImageIcon(p.getPatchIcon());//Carrega imagem
					lblfoto_buscar.setIcon(new ImageIcon((Image)img.getImage().getScaledInstance(lblfoto_cadastro.getWidth(),lblfoto_cadastro.getHeight(),Image.SCALE_SMOOTH)));	
				}
			}
 			
 		});
 		
 		JPanel deletePanel = new JPanel();
 		tabbedPane.addTab("Deleta", null, deletePanel, null);
 		deletePanel.setLayout(null);
 		
 		JLabel lblCodigo_deleta = new JLabel("Codigo Produto");
 		lblCodigo_deleta.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblCodigo_deleta.setBounds(10, 11, 126, 26);
 		deletePanel.add(lblCodigo_deleta);
 		
 		codigoTF_deleta = new JTextField();
 		codigoTF_deleta.setBounds(146, 16, 47, 20);
 		deletePanel.add(codigoTF_deleta);
 		codigoTF_deleta.setColumns(10);
 		
 		JButton btnDeletaProduto_deleta = new JButton("DELETAR");
 		btnDeletaProduto_deleta.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if(codigoTF_deleta.getText().matches("[0-9]*"))CrudDados.remove(Integer.parseInt(codigoTF_deleta.getText()));
 			}
 		});
 		btnDeletaProduto_deleta.setFont(new Font("Tahoma", Font.PLAIN, 12));
 		btnDeletaProduto_deleta.setBounds(20, 48, 89, 34);
 		deletePanel.add(btnDeletaProduto_deleta);
 		
 		JPanel updatePanel = new JPanel();
 		tabbedPane.addTab("Editar Produto", null, updatePanel, null);
 		updatePanel.setLayout(null);
 		
 		JLabel lbNome_1 = new JLabel("nome");
 		lbNome_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbNome_1.setBounds(12, 136, 50, 18);
 		updatePanel.add(lbNome_1);
 		
 		textField = new JTextField();
 		textField.setColumns(10);
 		textField.setBounds(59, 136, 196, 20);
 		updatePanel.add(textField);
 		
 		textField_1 = new JTextField();
 		textField_1.setColumns(10);
 		textField_1.setBounds(59, 168, 86, 20);
 		updatePanel.add(textField_1);
 		
 		JLabel lblPreco_1 = new JLabel("preço");
 		lblPreco_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblPreco_1.setBounds(12, 168, 50, 18);
 		updatePanel.add(lblPreco_1);
 		
 		JLabel lblCategorias_1 = new JLabel("Categorias");
 		lblCategorias_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblCategorias_1.setBounds(12, 203, 73, 18);
 		updatePanel.add(lblCategorias_1);
 		
 		textField_2 = new JTextField();
 		textField_2.setColumns(10);
 		textField_2.setBounds(166, 203, 187, 20);
 		updatePanel.add(textField_2);
 		
 		textField_3 = new JTextField();
 		textField_3.setColumns(10);
 		textField_3.setBounds(166, 230, 187, 20);
 		updatePanel.add(textField_3);
 		
 		JLabel lbLocalProduzido_1 = new JLabel("Local Produzido");
 		lbLocalProduzido_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbLocalProduzido_1.setBounds(12, 230, 111, 18);
 		updatePanel.add(lbLocalProduzido_1);
 		
 		JLabel lblContato_1 = new JLabel("Contato Distribuidora");
 		lblContato_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblContato_1.setBounds(12, 259, 149, 18);
 		updatePanel.add(lblContato_1);
 		
 		textField_4 = new JTextField();
 		textField_4.setColumns(10);
 		textField_4.setBounds(166, 259, 187, 20);
 		updatePanel.add(textField_4);
 		
 		JLabel lblCodigo_editar = new JLabel("Codigo");
 		lblCodigo_editar.setFont(new Font("Dialog", Font.BOLD, 15));
 		lblCodigo_editar.setBounds(12, 12, 58, 26);
 		updatePanel.add(lblCodigo_editar);
 		
 		codigoTF_editar = new JTextField();
 		codigoTF_editar.setBounds(74, 16, 50, 21);
 		updatePanel.add(codigoTF_editar);
 		codigoTF_editar.setColumns(10);
 		
 		JButton btnNewButton = new JButton("EDITAR");
 		btnNewButton.setBounds(12, 50, 86, 27);
 		updatePanel.add(btnNewButton);
 		
 		JPanel listaCompraPanel = new JPanel();
 		tabbedPane.addTab("Compra", null, listaCompraPanel, null);
 		listaCompraPanel.setLayout(null);
 		
 		JLabel lblNewLabel = new JLabel("Código");
 		lblNewLabel.setBounds(413, 19, 73, 22);
 		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
 		listaCompraPanel.add(lblNewLabel);
 		
 		codigoTF_Compra = new JTextField();
 		codigoTF_Compra.setBounds(413, 39, 86, 20);
 		listaCompraPanel.add(codigoTF_Compra);
 		codigoTF_Compra.setColumns(10);
 		
 		tableCompra = new JTable();
 		tableCompra.setBounds(10, 23, 393, 204);
 		tableCompra.setModel(new DefaultTableModel(
 			new Object[][] {
 				{null, null, null, null},
 			},
 			new String[] {
 				"New column", "New column", "New column", "New column"
 			}
 		));
 		listaCompraPanel.add(tableCompra);
 		
 		
 		JButton bntAdicionar_produto = new JButton("ADD");
 		bntAdicionar_produto.setBounds(413, 159, 73, 34);
 		bntAdicionar_produto.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 				if(qtdaTF_compra.getText().matches("[0-9]*") && codigoTF_Compra.getText().matches("[0-9]*")) {
 					
 					Produto p =CrudDados.busca(Integer.parseInt(codigoTF_Compra.getText()));
 					
 					if(p.getCodigo()!=null) {
 						CompraProduto cp = new CompraProduto(p,Integer.parseInt(qtdaTF_compra.getText()));
 	 					
 						cp.setPrecoTotal();
	 					lista_compra.add(cp);
	 					
	 					
	 					
	 					//Adicionar informaçoes do produto na Tabela
	 					DefaultTableModel modelo =(DefaultTableModel) tableCompra.getModel();
	 					modelo.addRow(new Object[] {cp.getProduto().getNome(),cp.getQtda(),cp.getPrecoTotal(),lista_compra.size()-1});
	 					tableCompra.setModel(modelo);
 					}
 					
 					
 				}
 			}
 		});
 		bntAdicionar_produto.setFont(new Font("Tahoma", Font.BOLD, 12));
 		listaCompraPanel.add(bntAdicionar_produto);
 		

 		JLabel lblNewLabel_1 = new JLabel("Preço");
 		lblNewLabel_1.setBounds(451, 301, 49, 22);
 		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
 		listaCompraPanel.add(lblNewLabel_1);
 		
 		precoTF_compra = new JTextField();
 		precoTF_compra.setBounds(503, 303, 86, 20);
 		precoTF_compra.setEditable(false);
 		listaCompraPanel.add(precoTF_compra);
 		precoTF_compra.setColumns(10);
 		
 		JLabel lblQtda_compra = new JLabel("QTDA");
 		lblQtda_compra.setBounds(413, 87, 49, 22);
 		lblQtda_compra.setFont(new Font("Tahoma", Font.BOLD, 14));
 		listaCompraPanel.add(lblQtda_compra);
 		
 		qtdaTF_compra = new JTextField();
 		qtdaTF_compra.setBounds(413, 107, 86, 20);
 		qtdaTF_compra.setColumns(10);
 		listaCompraPanel.add(qtdaTF_compra);
 		
 		removerTF_compra = new JTextField();
 		removerTF_compra.setBounds(80, 272, 86, 20);
 		removerTF_compra.setColumns(10);
 		listaCompraPanel.add(removerTF_compra);
 		
 		JLabel lblQtda_compra_1 = new JLabel("Código");
 		lblQtda_compra_1.setBounds(10, 271, 71, 22);
 		lblQtda_compra_1.setFont(new Font("Tahoma", Font.BOLD, 14));
 		listaCompraPanel.add(lblQtda_compra_1);
 		
 		JButton bntRemover_compra = new JButton("Remover");
 		bntRemover_compra.setBounds(10, 295, 102, 34);
 		bntRemover_compra.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 							
 				if((removerTF_compra.getText().matches("[0-9]*") && !removerTF_compra.getText().isBlank())&& lista_compra.size()>Integer.parseInt(removerTF_compra.getText()) && Integer.parseInt(removerTF_compra.getText())>=0){
 					lista_compra.remove(Integer.parseInt(removerTF_compra.getText()));
 					
 					DefaultTableModel modelo = (DefaultTableModel) tableCompra.getModel();
 					
 					modelo.setRowCount(0); //Limpar tabela
 					
 					for(int i=0;i<lista_compra.size();i++) {
 						modelo.addRow(new Object[] {lista_compra.get(i).getProduto().getNome(),
 													lista_compra.get(i).getQtda(),
					 								lista_compra.get(i).getPrecoTotal(),
					 								i
 												}
 						);

 	 				}
 					tableCompra.setModel(modelo);
 					
 				}
 			}
 		});
 		bntRemover_compra.setFont(new Font("Tahoma", Font.BOLD, 12));
 		listaCompraPanel.add(bntRemover_compra);
 		
 		JLabel lblNewLabel_2 = new JLabel("Código");
 		lblNewLabel_2.setBounds(324, 2, 49, 17);
 		listaCompraPanel.add(lblNewLabel_2);
 		
 		JLabel lblNewLabel_2_1 = new JLabel("Preço");
 		lblNewLabel_2_1.setBounds(240, 2, 40, 17);
 		listaCompraPanel.add(lblNewLabel_2_1);
 		
 		JLabel lblNewLabel_2_1_1 = new JLabel("Unidades");
 		lblNewLabel_2_1_1.setBounds(127, 2, 58, 17);
 		listaCompraPanel.add(lblNewLabel_2_1_1);
 		
 		JLabel lblNewLabel_2_1_1_1 = new JLabel("Nome");
 		lblNewLabel_2_1_1_1.setBounds(23, 2, 58, 17);
 		listaCompraPanel.add(lblNewLabel_2_1_1_1);
 		
	}
}
