/* File:          Home.java
Date: 09/03/21
Description:cLASSE responsavel pela interfasse da pagina principal da aplicação
Author:Luiz da Silva Moura.
Modifications:
*/
package View;

import java.util.ArrayList;

import DataBase.ClientesBD;
import DataBase.Connect;
import DataBase.VendedoresBD;
import Only.Cliente;
import Only.Vendedor;

public class Home extends javax.swing.JFrame {
	// VARIAVEIS UTILIZADAS
	private javax.swing.JButton AddClient;
	private javax.swing.JButton AddVendedor;
	private javax.swing.JButton EditClient;
	private javax.swing.JButton EditVendedor;
	private javax.swing.JLabel Imagehome;
	private javax.swing.JScrollPane ListClient;
	private javax.swing.JScrollPane ListVendedor;
	private javax.swing.JList<String> SelectClient;
	private javax.swing.JList<String> SelectVendedor;
	private javax.swing.JLabel Text_Clientes;
	private javax.swing.JLabel Text_Vendedor;
	private javax.swing.JPanel backscreen;

	private int IndexVend;
	private int IndexCliente;
	private ArrayList<Vendedor> Vendedores;
	private ArrayList<Cliente> Clientes = null;
	private int sizeClientes = 0;

	// CONTRUTORES
	public Home() {
		VendedoresBD VendedoresDados = new VendedoresBD();
		Vendedores = VendedoresDados.List();
		initComponents();
		Connect.Disconect();

	}

	// INICIALIZAÇÃO DOS COMPONENTES
	private void initComponents() {

		backscreen = new javax.swing.JPanel();
		Imagehome = new javax.swing.JLabel();
		Text_Vendedor = new javax.swing.JLabel();
		ListVendedor = new javax.swing.JScrollPane();
		SelectVendedor = new javax.swing.JList<>();
		EditVendedor = new javax.swing.JButton();
		AddVendedor = new javax.swing.JButton();
		Text_Clientes = new javax.swing.JLabel();
		ListClient = new javax.swing.JScrollPane();
		SelectClient = new javax.swing.JList<>();
		EditClient = new javax.swing.JButton();
		AddClient = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Home");
		setName("Home");
		setResizable(false);

		backscreen.setBackground(new java.awt.Color(35, 33, 33));
		backscreen.setName("backscreen"); // NOI18N

		Imagehome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

		Text_Vendedor.setFont(new java.awt.Font("Scene Std", 0, 30)); // NOI18N
		Text_Vendedor.setForeground(new java.awt.Color(255, 255, 255));
		Text_Vendedor.setText("Vendedor");

		SelectVendedor.setBackground(new java.awt.Color(229, 244, 248));
		SelectVendedor.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		SelectVendedor.setModel(new javax.swing.AbstractListModel<String>() {
			public int getSize() {
				return Vendedores.size();
			}

			public String getElementAt(int i) {
				return Vendedores.get(i).getDSNOME();
			}
		});
		SelectVendedor.setFocusCycleRoot(true);
		SelectVendedor.setFocusable(false);
		SelectVendedor.setName("ListVendedor"); // NOI18N
		SelectVendedor.setSelectionBackground(new java.awt.Color(0, 159, 227));
		SelectVendedor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				SelectVendedorValueChanged(evt);
			}
		});

		ListVendedor.setViewportView(SelectVendedor);

		EditVendedor.setBackground(new java.awt.Color(35, 33, 33));
		EditVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonEdit.png"))); // NOI18N
		EditVendedor.setBorderPainted(false);
		EditVendedor.setContentAreaFilled(false);
		EditVendedor.setName("EditVEndedor"); // NOI18N
		EditVendedor.setEnabled(false);
		EditVendedor.setNextFocusableComponent(EditVendedor);
		EditVendedor.setPreferredSize(new java.awt.Dimension(40, 40));
		EditVendedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonEditClick.png"))); // NOI18N
		EditVendedor.setRequestFocusEnabled(false);
		EditVendedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonEditOn.png"))); // NOI18N
		EditVendedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EditVendedorActionPerformed(evt);
			}
		});

		AddVendedor.setBackground(new java.awt.Color(35, 33, 33));
		AddVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAdd.png"))); // NOI18N
		AddVendedor.setBorderPainted(false);
		AddVendedor.setPreferredSize(new java.awt.Dimension(40, 40));
		AddVendedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddClick.png"))); // NOI18N
		AddVendedor.setRequestFocusEnabled(false);
		AddVendedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddOn.png"))); // NOI18N
		AddVendedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddVendedorActionPerformed(evt);
			}
		});

		Text_Clientes.setFont(new java.awt.Font("Scene Std", 0, 30)); // NOI18N
		Text_Clientes.setForeground(new java.awt.Color(255, 255, 255));
		Text_Clientes.setText("Clientes");

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
		SelectClient.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				SelectClientValueChanged(evt);
			}
		});
		ListClient.setViewportView(SelectClient);
		SelectClient.getAccessibleContext().setAccessibleName("Lista de Clientes");
		SelectClient.getAccessibleContext().setAccessibleDescription("Lista contendo os Clientes");

		EditClient.setBackground(new java.awt.Color(35, 33, 33));
		EditClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonEdit.png"))); // NOI18N
		EditClient.setBorderPainted(false);
		EditClient.setContentAreaFilled(false);
		EditClient.setName("EditClient"); // NOI18N
		EditClient.setEnabled(false);
		EditClient.setNextFocusableComponent(EditVendedor);
		EditClient.setPreferredSize(new java.awt.Dimension(40, 40));
		EditClient.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonEditClick.png"))); // NOI18N
		EditClient.setRequestFocusEnabled(false);
		EditClient.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonEditOn.png"))); // NOI18N
		EditClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EditClientActionPerformed(evt);
			}
		});

		AddClient.setBackground(new java.awt.Color(35, 33, 33));
		AddClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAdd.png"))); // NOI18N
		AddClient.setBorderPainted(false);
		AddClient.setName("AddClient"); // NOI18N
		AddClient.setPreferredSize(new java.awt.Dimension(40, 40));
		AddClient.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddClick.png"))); // NOI18N
		AddClient.setRequestFocusEnabled(false);
		AddClient.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddOn.png"))); // NOI18N
		AddClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddClientActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout backscreenLayout = new javax.swing.GroupLayout(backscreen);
		backscreen.setLayout(backscreenLayout);
		backscreenLayout
				.setHorizontalGroup(
						backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(backscreenLayout.createSequentialGroup().addGap(361, 361, 361)
										.addComponent(Text_Vendedor).addGap(196, 196, 196).addComponent(Text_Clientes)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backscreenLayout
										.createSequentialGroup().addContainerGap(295, Short.MAX_VALUE)
										.addGroup(backscreenLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(backscreenLayout
														.createSequentialGroup().addComponent(Imagehome)
														.addGap(360, 360, 360))
												.addGroup(backscreenLayout.createSequentialGroup()
														.addGroup(backscreenLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addGroup(backscreenLayout.createSequentialGroup()
																		.addComponent(AddVendedor,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				57,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(10, 10, 10)
																		.addComponent(EditVendedor,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				58,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addComponent(ListVendedor))
														.addGroup(backscreenLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(backscreenLayout.createSequentialGroup()
																		.addGap(239, 239, 239)
																		.addComponent(AddClient,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				57,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(10, 10, 10).addComponent(EditClient,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				58,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(backscreenLayout.createSequentialGroup()
																		.addGap(18, 18, 18).addComponent(ListClient,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				342,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(356, 356, 356)))));
		backscreenLayout.setVerticalGroup(backscreenLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(backscreenLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(Imagehome)
						.addGap(50, 50, 50)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(backscreenLayout.createSequentialGroup().addGroup(
										backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(Text_Vendedor, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(Text_Clientes))
										.addGap(18, 18, 18)
										.addGroup(backscreenLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(ListClient, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(ListVendedor, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 192,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(backscreenLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(AddVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(EditVendedor, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 57,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(AddClient, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 61,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(EditClient, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(55, Short.MAX_VALUE)));

		Imagehome.getAccessibleContext().setAccessibleName("LDXPS");
		Imagehome.getAccessibleContext().setAccessibleDescription("Titulo");
		EditVendedor.getAccessibleContext().setAccessibleName("Editar vendedor");
		AddVendedor.getAccessibleContext().setAccessibleName("Adicionar vendedor");
		EditClient.getAccessibleContext().setAccessibleName("Editar cliente");
		AddClient.getAccessibleContext().setAccessibleName("Adicionar Cliente");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(backscreen,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(backscreen,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
	// METODOS DE RESPOSTAS A INTERAÇÃO DO USARIO COM A INTERFASSE

	private void EditVendedorActionPerformed(java.awt.event.ActionEvent evt) {
		CadastroVendedor PEV = new CadastroVendedor(Vendedores.get(IndexVend));
		PEV.setVisible(true);
		setVisible(false);

	}

	private void EditClientActionPerformed(java.awt.event.ActionEvent evt) {
		CadastroCliente PEC = new CadastroCliente(Clientes.get(IndexCliente));
		PEC.setVisible(true);
		setVisible(false);

	}

	private void AddVendedorActionPerformed(java.awt.event.ActionEvent evt) {
		CadastroVendedor PCV = new CadastroVendedor();
		PCV.setVisible(true);
		setVisible(false);
	}

	private void AddClientActionPerformed(java.awt.event.ActionEvent evt) {
		CadastroCliente PCC = new CadastroCliente();
		PCC.setVisible(true);
		setVisible(false);
	}

	private void SelectVendedorValueChanged(javax.swing.event.ListSelectionEvent evt) {
		EditVendedor.setEnabled(true);
		IndexVend = SelectVendedor.getSelectedIndex();
		ClientesBD ClientesDados = new ClientesBD();
		Clientes = ClientesDados.List(Vendedores.get(IndexVend).getCDVEND());
		sizeClientes = Clientes.size();
		if (sizeClientes == 0)
			EditClient.setEnabled(false);
		else
			EditClient.setEnabled(true);
		ListClient.setViewportView(SelectClient);
	}

	private void SelectClientValueChanged(javax.swing.event.ListSelectionEvent evt) {
		EditClient.setEnabled(true);
		IndexCliente = SelectClient.getSelectedIndex();
	}

	public static void main(String args[]) {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				break;
			}
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Home().setVisible(true);
			}
		});
	}
}
