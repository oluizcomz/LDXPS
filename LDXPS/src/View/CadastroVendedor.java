/* File:          CADASTROvENDEDOR.java
Date: 09/03/21
Description: Classe responsavel pela interfasse da pagina de cadastro do vendedor
Author:Luiz da Silva Moura.
Modifications:
*/
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import DataBase.ClientesBD;
import DataBase.Connect;
import DataBase.VendedoresBD;
import Only.*;

public class CadastroVendedor extends javax.swing.JFrame {
//VARIAVEIS UTILIZADAS
	private javax.swing.JLabel ImageCadVendedor;
	private javax.swing.JTextField NomeVend;
	private javax.swing.JTextField Codpreco;
	private javax.swing.JFormattedTextField DataNasc;
	private javax.swing.JScrollPane ListClient;
	private javax.swing.JButton AddClient;
	private javax.swing.JButton ConfirmSeller;
	private javax.swing.JButton DeletSeller;

	private javax.swing.JLabel Text_Cliente;
	private javax.swing.JLabel Text_CodPreco;
	private javax.swing.JLabel Text_NomeVend;
	private javax.swing.JLabel Text_atanasc;
	private javax.swing.JPanel backscreen;
	private javax.swing.JList<String> SelectClient;
	private String NomeVendedor = "";
	private String CodPreco = "";
	private String codvend = "";
	private ArrayList<Cliente> Clientes = null;
	private int sizeClientes = 0;
	private String datanas = "##/##/####";
	private boolean addclient = true;

//COSSTRUTORES
	public CadastroVendedor() {
		initComponents();
	}
	public CadastroVendedor(boolean editcliente) {
		addclient = editcliente;
		initComponents();
	}

	public CadastroVendedor(Vendedor edit) {
		ClientesBD ClientesDados = new ClientesBD();
		Clientes = ClientesDados.List(edit.getCDVEND());
		sizeClientes = Clientes.size();
		NomeVendedor = edit.getDSNOME();
		CodPreco = "" + edit.getCDTAB();
		codvend = edit.getCDVEND();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		datanas = format.format(edit.getDTNASC()); 
		

		initComponents();
	}

//INICIALIZAÇÃO DA INTERFASSE
	private void initComponents() {

		backscreen = new javax.swing.JPanel();
		ImageCadVendedor = new javax.swing.JLabel();
		Text_CodPreco = new javax.swing.JLabel();
		Text_Cliente = new javax.swing.JLabel();
		Text_NomeVend = new javax.swing.JLabel();
		Text_atanasc = new javax.swing.JLabel();
		NomeVend = new javax.swing.JTextField();
		ListClient = new javax.swing.JScrollPane();
		SelectClient = new javax.swing.JList<>();
		Codpreco = new javax.swing.JTextField();
		AddClient = new javax.swing.JButton();
		ConfirmSeller = new javax.swing.JButton();
		DeletSeller = new javax.swing.JButton();
		DataNasc = new javax.swing.JFormattedTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Cadastro vendedor");
		setName("Tela Cadastro vendedor"); // NOI18N
		setResizable(false);

		backscreen.setBackground(new java.awt.Color(35, 33, 33));
		backscreen.setName("backscreen"); // NOI18N

		ImageCadVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegisterSaller.png"))); // NOI18N
		ImageCadVendedor.setName("CadVendedor"); // NOI18N

		Text_CodPreco.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_CodPreco.setForeground(new java.awt.Color(255, 255, 255));
		Text_CodPreco.setText("Código de preço:");

		Text_Cliente.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_Cliente.setForeground(new java.awt.Color(255, 255, 255));
		Text_Cliente.setText("Cliente:");
		Text_Cliente.setName("NmVendedor"); // NOI18N

		Text_NomeVend.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_NomeVend.setForeground(new java.awt.Color(255, 255, 255));
		Text_NomeVend.setText("Nome vendedor:");
		Text_NomeVend.setName("NmVendedor"); // NOI18N

		Text_atanasc.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_atanasc.setForeground(new java.awt.Color(255, 255, 255));
		Text_atanasc.setText("Data de nascimento:");

		NomeVend.setBackground(new java.awt.Color(229, 244, 248));
		NomeVend.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		NomeVend.setText(NomeVendedor);

		SelectClient.setBackground(new java.awt.Color(229, 244, 248));
		SelectClient.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		SelectClient.setModel(new javax.swing.AbstractListModel<String>() {

			public int getSize() {
				return sizeClientes;
			}

			public String getElementAt(int i) {
				return Clientes.get(i).getDSNOME();
			}
		});
		SelectClient.setName("ListClient"); // NOI18N
		SelectClient.setSelectionBackground(new java.awt.Color(0, 159, 227));

		ListClient.setViewportView(SelectClient);

		Codpreco.setBackground(new java.awt.Color(229, 244, 248));
		Codpreco.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		Codpreco.setText(CodPreco);

		AddClient.setBackground(new java.awt.Color(35, 33, 33));
		AddClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAdd.png"))); // NOI18N
		AddClient.setBorderPainted(false);
		AddClient.setName("AddClient");
		AddClient.setEnabled(addclient);
		AddClient.setPreferredSize(new java.awt.Dimension(40, 40));
		AddClient.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddClick.png"))); // NOI18N
		AddClient.setRequestFocusEnabled(false);
		AddClient.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddOn.png"))); // NOI18N
		AddClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddClientActionPerformed(evt);
			}
		});

		ConfirmSeller.setBackground(new java.awt.Color(35, 33, 33));
		ConfirmSeller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonV.png"))); // NOI18N
		ConfirmSeller.setBorderPainted(false);
		ConfirmSeller.setContentAreaFilled(false);
		ConfirmSeller.setName("ConfVen"); // NOI18N
		ConfirmSeller.setPreferredSize(new java.awt.Dimension(40, 40));
		ConfirmSeller.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonVClick.png"))); // NOI18N
		ConfirmSeller.setRequestFocusEnabled(false);
		ConfirmSeller.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonVOn.png"))); // NOI18N
		ConfirmSeller.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ConfirmSellerActionPerformed(evt);
			}
		});

		DeletSeller.setBackground(new java.awt.Color(35, 33, 33));
		DeletSeller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonX.png"))); // NOI18N
		DeletSeller.setBorderPainted(false);
		DeletSeller.setContentAreaFilled(false);
		DeletSeller.setName("ExcluirVendedor"); // NOI18N
		DeletSeller.setPreferredSize(new java.awt.Dimension(40, 40));
		DeletSeller.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonXClick.png"))); // NOI18N
		DeletSeller.setRequestFocusEnabled(false);
		DeletSeller.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonXOn.png"))); // NOI18N
		DeletSeller.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeletSellerActionPerformed(evt);
			}
		});

		DataNasc.setBackground(new java.awt.Color(229, 244, 248));
		try {
			DataNasc.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter(datanas)));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		DataNasc.setSelectionColor(new java.awt.Color(0, 159, 227));

		javax.swing.GroupLayout backscreenLayout = new javax.swing.GroupLayout(backscreen);
		backscreen.setLayout(backscreenLayout);
		backscreenLayout.setHorizontalGroup(backscreenLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(backscreenLayout.createSequentialGroup().addGap(349, 349, 349).addGroup(backscreenLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(AddClient, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(Text_NomeVend).addComponent(Text_Cliente)
								.addGroup(backscreenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(NomeVend, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(ListClient, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))))
						.addGap(30, 30, 30)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(Text_CodPreco)
								.addComponent(Text_atanasc, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
								.addComponent(DataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(Codpreco))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backscreenLayout.createSequentialGroup()
						.addContainerGap(467, Short.MAX_VALUE)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										backscreenLayout.createSequentialGroup().addComponent(ImageCadVendedor)
												.addGap(425, 425, 425))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										backscreenLayout.createSequentialGroup()
												.addComponent(ConfirmSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(DeletSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(298, 298, 298)))));
		backscreenLayout.setVerticalGroup(backscreenLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(backscreenLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(ImageCadVendedor)
						.addGap(27, 27, 27)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Text_NomeVend).addComponent(Text_atanasc))
						.addGap(18, 18, 18)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(DataNasc, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NomeVend))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Text_Cliente).addComponent(Text_CodPreco))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(ListClient, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(Codpreco, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(AddClient, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(ConfirmSeller, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(DeletSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(74, Short.MAX_VALUE)));

		ImageCadVendedor.getAccessibleContext().setAccessibleName("Cadatro de vendedor");
		ImageCadVendedor.getAccessibleContext().setAccessibleDescription("Titulo");
		ConfirmSeller.getAccessibleContext().setAccessibleName("Confirmar alterações");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				backscreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(backscreen, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE));

		pack();
	}

	// METODOS DE RESPOSTAS A INTERAÇÃO DO USARIO COM A INTERFASSE
	private void AddClientActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AddClientActionPerformed
		if (Cadastrar() == true) {
			CadastroCliente PCC = new CadastroCliente(true);
			PCC.setVisible(true);
			setVisible(false);
		}
	}

	private boolean Cadastrar() {
		if (NomeVend.getText().equals(""))// colocar poppup
			JOptionPane.showMessageDialog(null, "Nome do vendedor está incorreto");
		else if (Codpreco.getText().equals("") || Codpreco.getText().length() > 36)
			JOptionPane.showMessageDialog(null, "Código do preço invalido");
		else if (DataNasc.getText().equals("  /  /    "))
			JOptionPane.showMessageDialog(null, "Data de nascimento incorreta");
		else {
			System.out.println("data"+DataNasc.getText());

			try {
				SimpleDateFormat formatin = new SimpleDateFormat("dd/MM/yyyy");
				Date datnasc = formatin.parse(DataNasc.getText());
				VendedoresBD cadastro = new VendedoresBD();
				if (codvend == "") {
					cadastro.Insert(NomeVend.getText(), Integer.parseInt(Codpreco.getText()), datnasc);
					JOptionPane.showMessageDialog(null, "Cadastro completo");
				} else {
					cadastro.edit(codvend, NomeVend.getText(), Integer.parseInt(Codpreco.getText()), datnasc);
					JOptionPane.showMessageDialog(null, "Dados atualizados");
				}
				Connect.Disconect();

			} catch (ParseException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;

	}

	private void ConfirmSellerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ConfirmSellerActionPerformed
		if (Cadastrar() == true) {
			Home PH = new Home();
			PH.setVisible(true);
			setVisible(false);
		}
	}

	private void DeletSellerActionPerformed(java.awt.event.ActionEvent evt) {
		if (codvend != "") {
			ClientesBD deleteC = new ClientesBD();
			VendedoresBD deleteV = new VendedoresBD();
			deleteC.deleteVendedor(codvend);
			deleteV.delete(codvend);
		}

		Home PH = new Home();
		PH.setVisible(true);
		setVisible(false);
	}

	public static void main(String args[]) {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				break;
			}
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CadastroVendedor().setVisible(true);
			}
		});
	}
}
