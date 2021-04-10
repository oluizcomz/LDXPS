/* File:          CADASTROCLIENTE.java
Date: 09/03/21
Description: Classe responsavel pela interfasse da pagina de cadastro do CLIENTE
Author:Luiz da Silva Moura.
Modifications:
*/
package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DataBase.ClientesBD;
import DataBase.VendedoresBD;
import Only.*;

public class CadastroCliente extends javax.swing.JFrame {
	// VARIAVEIS UTILIZADAS
	private javax.swing.JButton AddVendedor;
	private javax.swing.JButton ConfirmClient;
	private javax.swing.JTextField Credito;
	private javax.swing.JButton DeletClient;
	private javax.swing.JLabel ImageCadVendedor;
	private javax.swing.JScrollPane ListVendedor;
	private javax.swing.JTextField NomeClient;
	private javax.swing.JList<String> SelectVendedor;
	private javax.swing.JLabel Text_Creito;
	private javax.swing.JLabel Text_NomeCliente;
	private javax.swing.JLabel Text_Vendedor;
	private javax.swing.JLabel Text_tipes;
	private javax.swing.JComboBox<String> TipePessoa;
	private javax.swing.JPanel backscreen;

	private String NomeCliente = "";
	private String ValueCredito = "";
	private int IndexVend = -1;
	private VendedoresBD VendedoresDados = new VendedoresBD();
	private ArrayList<Vendedor> Vendedores = VendedoresDados.List();
	private boolean addVendedor = true;
	private String codcliente = "";
	private int TiPes = 0;

	public CadastroCliente() {
		ValueCredito = "000.00";
		initComponents();
	}

	public CadastroCliente(Cliente edit) {

		NomeCliente = edit.getDSNOME();
		ValueCredito = "" + edit.getDSLIM();
		codcliente = edit.getCDCL();
		for (int i = 0; i < Vendedores.size(); i++) {
			if (edit.getCDVEND().equals(Vendedores.get(i).getCDVEND())) {
				IndexVend = i;
			}
			
		}
		if(edit.getIDTIPO().equals("PJ"))
			TiPes=1;
		initComponents();

	}

	public CadastroCliente(boolean edit) {
		addVendedor = false;
		ValueCredito = "000.00";
		initComponents();
	}

	private void initComponents() {

		backscreen = new javax.swing.JPanel();
		ImageCadVendedor = new javax.swing.JLabel();
		Text_Creito = new javax.swing.JLabel();
		Text_Vendedor = new javax.swing.JLabel();
		Text_NomeCliente = new javax.swing.JLabel();
		Text_tipes = new javax.swing.JLabel();
		NomeClient = new javax.swing.JTextField();
		Credito = new javax.swing.JTextField();
		AddVendedor = new javax.swing.JButton();
		ConfirmClient = new javax.swing.JButton();
		DeletClient = new javax.swing.JButton();
		TipePessoa = new javax.swing.JComboBox<>();
		ListVendedor = new javax.swing.JScrollPane();
		SelectVendedor = new javax.swing.JList<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Cadastro Cliente");
		setName("Tela cadastro cliente"); // NOI18N
		setResizable(false);

		backscreen.setBackground(new java.awt.Color(35, 33, 33));
		backscreen.setName("backscreen"); // NOI18N

		ImageCadVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegisterClient.png"))); // NOI18N
		ImageCadVendedor.setName("CadVendedor"); // NOI18N

		Text_Creito.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_Creito.setForeground(new java.awt.Color(255, 255, 255));
		Text_Creito.setText("Limite de credito:");

		Text_Vendedor.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_Vendedor.setForeground(new java.awt.Color(255, 255, 255));
		Text_Vendedor.setText("Vendedor:");
		Text_Vendedor.setName("NmVendedor"); // NOI18N

		Text_NomeCliente.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_NomeCliente.setForeground(new java.awt.Color(255, 255, 255));
		Text_NomeCliente.setText("Nome cliente:");
		Text_NomeCliente.setName("NmVendedor"); // NOI18N

		Text_tipes.setFont(new java.awt.Font("Scene Std", 0, 18)); // NOI18N
		Text_tipes.setForeground(new java.awt.Color(255, 255, 255));
		Text_tipes.setText("Tipo de pessoa:");

		NomeClient.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		NomeClient.setText(this.NomeCliente);

		Credito.setBackground(new java.awt.Color(229, 244, 248));
		Credito.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		Credito.setText(ValueCredito);

		AddVendedor.setBackground(new java.awt.Color(35, 33, 33));
		AddVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAdd.png"))); // NOI18N
		AddVendedor.setBorderPainted(false);
		AddVendedor.setName("AddVendedor"); // NOI18N
		AddVendedor.setEnabled(addVendedor);
		AddVendedor.setPreferredSize(new java.awt.Dimension(40, 40));
		AddVendedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddClick.png"))); // NOI18N
		AddVendedor.setRequestFocusEnabled(false);
		AddVendedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonAddOn.png"))); // NOI18N
		AddVendedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddVendedorActionPerformed(evt);
			}
		});

		ConfirmClient.setBackground(new java.awt.Color(35, 33, 33));
		ConfirmClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonV.png"))); // NOI18N
		ConfirmClient.setBorderPainted(false);
		ConfirmClient.setContentAreaFilled(false);
		ConfirmClient.setName("ConfVen"); // NOI18N
		ConfirmClient.setPreferredSize(new java.awt.Dimension(40, 40));
		ConfirmClient.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonVClick.png"))); // NOI18N
		ConfirmClient.setRequestFocusEnabled(false);
		ConfirmClient.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonVOn.png")));
		ConfirmClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ConfirmClientActionPerformed(evt);
			}
		});

		DeletClient.setBackground(new java.awt.Color(35, 33, 33));
		DeletClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonX.png")));
		DeletClient.setBorderPainted(false);
		DeletClient.setContentAreaFilled(false);
		DeletClient.setName("ExcluirVendedor"); // NOI18N
		DeletClient.setPreferredSize(new java.awt.Dimension(40, 40));
		DeletClient.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonXClick.png")));
		DeletClient.setRequestFocusEnabled(false);
		DeletClient.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ButtonXOn.png")));
		DeletClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeletClientActionPerformed(evt);
			}
		});

		TipePessoa.setBackground(new java.awt.Color(229, 244, 248));
		TipePessoa.setFont(new java.awt.Font("Scene Std", 0, 14)); // NOI18N
		TipePessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF", "PJ" }));
		TipePessoa.setFocusable(false);
		TipePessoa.setSelectedIndex(TiPes);

		SelectVendedor.setBackground(new java.awt.Color(229, 244, 248));
		SelectVendedor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				SelectVendedorValueChanged(evt);
			}
		});
		SelectVendedor.setFont(new java.awt.Font("Scene Std", 0, 14));
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
		if (IndexVend >= 0)
			SelectVendedor.setSelectedIndex(IndexVend);
		//System.out.println(""+edit.getCDVEND()+" == "+Vendedores.get(i).getCDVEND()+" index"+IndexVend);
		ListVendedor.setViewportView(SelectVendedor);
		

		javax.swing.GroupLayout backscreenLayout = new javax.swing.GroupLayout(backscreen);
		backscreen.setLayout(backscreenLayout);
		backscreenLayout
				.setHorizontalGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(backscreenLayout.createSequentialGroup().addGap(349, 349, 349)
								.addGroup(backscreenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(AddVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(Text_NomeCliente, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(Text_Vendedor, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(NomeClient, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
										.addComponent(ListVendedor, javax.swing.GroupLayout.Alignment.LEADING))
								.addGap(30, 30, 30)
								.addGroup(backscreenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(Text_tipes, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Credito)
										.addGroup(backscreenLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(TipePessoa, javax.swing.GroupLayout.Alignment.LEADING, 0,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(Text_Creito, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backscreenLayout.createSequentialGroup()
								.addContainerGap(467, Short.MAX_VALUE)
								.addGroup(backscreenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												backscreenLayout.createSequentialGroup().addComponent(ImageCadVendedor)
														.addGap(425, 425, 425))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backscreenLayout
												.createSequentialGroup()
												.addComponent(ConfirmClient, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(DeletClient, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(298, 298, 298)))));
		backscreenLayout.setVerticalGroup(backscreenLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(backscreenLayout.createSequentialGroup().addGap(60, 60, 60).addComponent(ImageCadVendedor)
						.addGap(27, 27, 27)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Text_NomeCliente).addComponent(Text_tipes))
						.addGap(18, 18, 18)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(NomeClient, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(TipePessoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Text_Vendedor).addComponent(Text_Creito))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(Credito, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(ListVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(AddVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(39, 39, 39)
						.addGroup(backscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(ConfirmClient, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(DeletClient, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(29, Short.MAX_VALUE)));

		ImageCadVendedor.getAccessibleContext().setAccessibleName("Cadatro de cliente");
		ImageCadVendedor.getAccessibleContext().setAccessibleDescription("Titulo");
		ConfirmClient.getAccessibleContext().setAccessibleName("Confirmar alterações");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				backscreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(backscreen,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void AddVendedorActionPerformed(java.awt.event.ActionEvent evt) {
		CadastroVendedor PCV = new CadastroVendedor(false);
		PCV.setVisible(true);
		setVisible(false);
	}

	private void SelectVendedorValueChanged(javax.swing.event.ListSelectionEvent evt) {
		IndexVend = SelectVendedor.getSelectedIndex();
	}

	private void ConfirmClientActionPerformed(java.awt.event.ActionEvent evt) {

		if (NomeClient.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Nome do cliente está incorreto");
		else if (Credito.getText().equals("000.00") || Credito.getText().length() > 18)
			JOptionPane.showMessageDialog(null, "Valor de credito invalido");
		else if (IndexVend == -1)
			JOptionPane.showMessageDialog(null, "Selecione um vendedor");
		else {
			String TP = "PF";
			if (TipePessoa.getSelectedIndex() == 1)
				TP = "PJ";
			ClientesBD cliente = new ClientesBD();
			if (codcliente == "") {
				cliente.Insert(Vendedores.get(IndexVend).getCDVEND(), NomeClient.getText(), TP,
						Double.parseDouble(Credito.getText()));
				JOptionPane.showMessageDialog(null, "Cadastro completo");
			} else {
				cliente.edit(codcliente, Vendedores.get(IndexVend).getCDVEND(), NomeClient.getText(), TP,
						Double.parseDouble(Credito.getText()));
				JOptionPane.showMessageDialog(null, "Cadastro atualizado");
			}

			Home PH = new Home();
			PH.setVisible(true);

			setVisible(false);
		}
	}

	private void DeletClientActionPerformed(java.awt.event.ActionEvent evt) {

		if (codcliente != "") {
			ClientesBD deleteC = new ClientesBD();
			deleteC.delete(codcliente);
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
				new CadastroCliente().setVisible(true);
			}
		});
	}

}
