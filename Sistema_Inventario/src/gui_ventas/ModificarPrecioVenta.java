package gui_ventas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gui_ventas.Ventas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ModificarPrecioVenta extends JFrame implements ActionListener, WindowListener, KeyListener, ItemListener{

	private JPanel contentPane;
	private JLabel txtTitulo;
	private JLabel lblNewLabel;
	private JLabel lblPrecioPorUnidad;
	private JLabel lblSubtotal;
	private JTextField txtCantidad;
	private JTextField txtPUnidad;
	private JTextField txtSTotal;
	private JButton btnCambiar;
	
	Ventas v;
	String producto;
	String cantidad;
	String preUnidad;
	String preSubTotal;
	String origen;
	private final JTextField textField = new JTextField();
	private JButton btnMenos1;
	private JButton btnMas1;
	private JButton btnEliminarProducto;
	private JTextField txtOrigen;
	private JCheckBox chckbxMostrar;
	private JLabel lblPromo1;
	private JTextField txtPromo1;
	private JLabel lblPromo2;
	private JTextField txtPromo2;
	private JComboBox cbPrecio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarPrecioVenta frame = new ModificarPrecioVenta(null, null, null, null, null,null);
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
	public ModificarPrecioVenta(Ventas temp, String temp2, String temp3, String temp4, String temp5, String temp6) {
		v = temp;
		producto = temp2;
		cantidad = temp3;
		preUnidad = temp4;
		preSubTotal = temp5;
		origen=temp6;
		
		setAlwaysOnTop(true);
		addWindowListener(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTitulo = new JLabel("TITULO");
		txtTitulo.setForeground(Color.WHITE);
		txtTitulo.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setBounds(10, 0, 507, 50);
		contentPane.add(txtTitulo);
		
		lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		lblNewLabel.setBounds(62, 124, 115, 31);
		contentPane.add(lblNewLabel);
		
		lblPrecioPorUnidad = new JLabel("Precio por unidad:");
		lblPrecioPorUnidad.setEnabled(false);
		lblPrecioPorUnidad.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		lblPrecioPorUnidad.setBounds(62, 214, 195, 31);
		contentPane.add(lblPrecioPorUnidad);
		
		lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		lblSubtotal.setBounds(62, 383, 115, 31);
		contentPane.add(lblSubtotal);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setFont(new Font("EngraversGothic BT", Font.BOLD, 15));
		txtCantidad.setBounds(260, 124, 212, 31);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtPUnidad = new JTextField();
		txtPUnidad.setEnabled(false);
		txtPUnidad.addKeyListener(this);
		txtPUnidad.setFont(new Font("EngraversGothic BT", Font.BOLD, 15));
		txtPUnidad.setColumns(10);
		txtPUnidad.setBounds(260, 214, 212, 31);
		contentPane.add(txtPUnidad);
		
		txtSTotal = new JTextField();
		txtSTotal.addKeyListener(this);
		txtSTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 15));
		txtSTotal.setColumns(10);
		txtSTotal.setBounds(260, 383, 212, 31);
		contentPane.add(txtSTotal);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setBackground(new Color(30, 144, 255));
		btnCambiar.addActionListener(this);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(0, 0, 529, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		btnCambiar.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnCambiar.setBounds(102, 425, 327, 52);
		contentPane.add(btnCambiar);
		
		btnMenos1 = new JButton("-1");
		btnMenos1.addActionListener(this);
		btnMenos1.setForeground(Color.WHITE);
		btnMenos1.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnMenos1.setBackground(new Color(244, 164, 96));
		btnMenos1.setBounds(300, 61, 86, 31);
		contentPane.add(btnMenos1);
		
		btnMas1 = new JButton("+1");
		btnMas1.addActionListener(this);
		btnMas1.setForeground(Color.WHITE);
		btnMas1.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnMas1.setBackground(new Color(60, 179, 113));
		btnMas1.setBounds(396, 61, 76, 31);
		contentPane.add(btnMas1);
		
		btnEliminarProducto = new JButton("Quitar Producto");
		btnEliminarProducto.addActionListener(this);
		btnEliminarProducto.setForeground(Color.WHITE);
		btnEliminarProducto.setFont(new Font("EngraversGothic BT", Font.BOLD, 18));
		btnEliminarProducto.setBackground(new Color(220, 20, 60));
		btnEliminarProducto.setBounds(63, 62, 227, 31);
		contentPane.add(btnEliminarProducto);
		
		JLabel lblPrecioOrigen = new JLabel("Precio Origen:\r\n");
		lblPrecioOrigen.setVisible(false);
		lblPrecioOrigen.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPrecioOrigen.setBounds(447, 446, 70, 31);
		contentPane.add(lblPrecioOrigen);
		
		txtOrigen = new JTextField();
		txtOrigen.setVisible(false);
		txtOrigen.setEditable(false);
		txtOrigen.setText("<dynamic>");
		txtOrigen.setFont(new Font("Dialog", Font.BOLD, 15));
		txtOrigen.setColumns(10);
		txtOrigen.setBounds(447, 414, 70, 31);
		contentPane.add(txtOrigen);
		
		chckbxMostrar = new JCheckBox("Mostrar");
		chckbxMostrar.setVisible(false);
		chckbxMostrar.addActionListener(this);
		chckbxMostrar.setFont(new Font("Dialog", Font.BOLD, 16));
		chckbxMostrar.setBounds(472, 394, 45, 23);
		contentPane.add(chckbxMostrar);
		
		lblPromo1 = new JLabel("Promo1:");
		lblPromo1.setEnabled(false);
		lblPromo1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPromo1.setBounds(62, 262, 195, 31);
		contentPane.add(lblPromo1);
		
		txtPromo1 = new JTextField();
		txtPromo1.setEnabled(false);
		txtPromo1.setText("<dynamic>");
		txtPromo1.setFont(new Font("Dialog", Font.BOLD, 15));
		txtPromo1.setColumns(10);
		txtPromo1.setBounds(260, 262, 212, 31);
		contentPane.add(txtPromo1);
		
		lblPromo2 = new JLabel("Promo2:");
		lblPromo2.setEnabled(false);
		lblPromo2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPromo2.setBounds(62, 308, 195, 31);
		contentPane.add(lblPromo2);
		
		txtPromo2 = new JTextField();
		txtPromo2.setEnabled(false);
		txtPromo2.setText("<dynamic>");
		txtPromo2.setFont(new Font("Dialog", Font.BOLD, 15));
		txtPromo2.setColumns(10);
		txtPromo2.setBounds(260, 308, 212, 31);
		contentPane.add(txtPromo2);
		
		cbPrecio = new JComboBox();
		cbPrecio.addItemListener(this);
		cbPrecio.setFont(new Font("Dialog", Font.BOLD, 16));
		cbPrecio.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un precio:", "Precio unitario", "Promoci\u00F3n 1", "Promoci\u00F3n 2"}));
		cbPrecio.setBounds(62, 172, 198, 31);
		contentPane.add(cbPrecio);
		
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtCantidad, txtPUnidad, txtSTotal, btnEliminarProducto, btnMenos1, btnMas1, btnCambiar}));
		cargar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == chckbxMostrar) {
			actionPerformedChckbxMostrar(arg0);
		}
		if (arg0.getSource() == btnEliminarProducto) {
			actionPerformedBtnEliminarProducto(arg0);
		}
		if (arg0.getSource() == btnMenos1) {
			actionPerformedBtnMenos1(arg0);
		}
		if (arg0.getSource() == btnMas1) {
			actionPerformedBtnMas1(arg0);
		}
		if (arg0.getSource() == btnCambiar) {
			actionPerformedBtnCambiar(arg0);
		}
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowClosingThis(arg0);
		}
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
	}
	protected void windowClosingThis(WindowEvent arg0) {
		v.setEnabled(true);
		v.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.dispose();
	}
	
	public void cargar(){
		this.setLocationRelativeTo(null);
		txtTitulo.setText(producto);
		txtCantidad.setText(cantidad);
		txtPUnidad.setText(preUnidad);
		txtOrigen.setText(origen);
		txtSTotal.setText(preSubTotal);
	}
	
	protected void actionPerformedBtnCambiar(ActionEvent arg0) {
		try {
			float cant = Float.parseFloat(txtCantidad.getText());
			float preu = Float.parseFloat(txtPUnidad.getText());
			float pret = Float.parseFloat(txtSTotal.getText());
			float preo = Float.parseFloat(txtOrigen.getText());
			if(cant <= 0 || preu <= 0 || preo < 0 || pret <=0){
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Ingrese valores v�lidos");
				this.setAlwaysOnTop(true);
			}
			else{
				v.actualizartabla(cant, preu, preo, pret);	
				v.setEnabled(true);
				this.dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
		}
		
	}
	
	public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtSTotal) {
			keyReleasedTxtSTotal(arg0);
		}
		if (arg0.getSource() == txtPUnidad) {
			keyReleasedTxtPUnidad(arg0);
		}
		if (arg0.getSource() == txtCantidad) {
			keyReleasedTxtCantidad(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtCantidad(KeyEvent arg0) {
		cantidad();
	}
	
	public void cantidad(){
		try {
			float cant = Float.parseFloat(txtCantidad.getText());
			float preu = Float.parseFloat(txtPUnidad.getText());
			float pret = Float.parseFloat(txtSTotal.getText());
			double stTemp = cant * preu;
			stTemp = redondearDecimales(stTemp,1);
			txtSTotal.setText(""+stTemp);
		} catch (Exception e) {
			txtSTotal.setText("0.00");
		}
	}
	
	protected void keyReleasedTxtPUnidad(KeyEvent arg0) {
		try {
			float cant = Float.parseFloat(txtCantidad.getText());
			float preu = Float.parseFloat(txtPUnidad.getText());
			float pret = Float.parseFloat(txtSTotal.getText());
			double stTemp = cant * preu;
			stTemp = redondearDecimales(stTemp,1);
			txtSTotal.setText(""+stTemp);
		} catch (Exception e) {
			txtSTotal.setText("0.00");
		}
	}
	
	protected void keyReleasedTxtSTotal(KeyEvent arg0) {
		try {
			float cant = Float.parseFloat(txtCantidad.getText());
			float preu = Float.parseFloat(txtPUnidad.getText());
			float pret = Float.parseFloat(txtSTotal.getText());
			double pu = pret/cant;
			pu = redondearDecimales(pu,1);
			txtPUnidad.setText(""+pu);
		} catch (Exception e) {
			txtPUnidad.setText("0.00");
		}
	}
	protected void actionPerformedBtnMas1(ActionEvent arg0) {
		try {
			txtCantidad.setText(""+(Float.parseFloat(txtCantidad.getText()) + 1));
			cantidad();
		} catch (Exception e) {
		}
	}
	protected void actionPerformedBtnMenos1(ActionEvent arg0) {
		try {
			float cant = Float.parseFloat(txtCantidad.getText());
			if(cant <= 0)
				txtCantidad.setText("0.00");
			else
				txtCantidad.setText("" + (cant-1));
			cantidad();
		} catch (Exception e) {
		}
	}
	protected void actionPerformedBtnEliminarProducto(ActionEvent arg0) {
		v.eliminarFila();
		v.setEnabled(true);
		this.dispose();
	}
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == chckbxMostrar) {
			propertyChangeChckbxMostrar(evt);
		}
	}
	protected void propertyChangeChckbxMostrar(PropertyChangeEvent evt) {

	}
	
	protected void actionPerformedChckbxMostrar(ActionEvent arg0) {
		if (chckbxMostrar.isSelected()) {
			txtOrigen.setVisible(true);
		}else {
			txtOrigen.setVisible(false);
		}
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cbPrecio) {
			itemStateChangedComboBox(arg0);
		}
	}
	
	protected void itemStateChangedComboBox(ItemEvent arg0) {
		if(cbPrecio.getSelectedIndex() == 0){
			lblPrecioPorUnidad.setEnabled(false);
			txtPUnidad.setEnabled(false);
			
			lblPromo1.setEnabled(false);
			txtPromo1.setEnabled(false);
			
			lblPromo2.setEnabled(false);
			txtPromo2.setEnabled(false);
		}
		if(cbPrecio.getSelectedIndex() == 1){
			lblPrecioPorUnidad.setEnabled(true);
			txtPUnidad.setEnabled(true);
			
			lblPromo1.setEnabled(false);
			txtPromo1.setEnabled(false);
			
			lblPromo2.setEnabled(false);
			txtPromo2.setEnabled(false);
		}
		if(cbPrecio.getSelectedIndex() == 2){
			lblPrecioPorUnidad.setEnabled(false);
			txtPUnidad.setEnabled(false);
			
			lblPromo1.setEnabled(true);
			txtPromo1.setEnabled(true);
			
			lblPromo2.setEnabled(false);
			txtPromo2.setEnabled(false);
		}
		if(cbPrecio.getSelectedIndex() == 3){
			lblPrecioPorUnidad.setEnabled(false);
			txtPUnidad.setEnabled(false);
			
			lblPromo1.setEnabled(false);
			txtPromo1.setEnabled(false);
			
			lblPromo2.setEnabled(true);			
			txtPromo2.setEnabled(true);
		}
	}
	
	
}
