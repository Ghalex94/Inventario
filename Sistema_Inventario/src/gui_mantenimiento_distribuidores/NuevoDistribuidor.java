package gui_mantenimiento_distribuidores;

import javax.swing.JButton;
import javax.swing.JDialog;
import mysql.consultas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import gui_mantenimiento_usuarios.MantenimientoUsuarios;

import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class NuevoDistribuidor extends JDialog implements ActionListener, WindowListener {
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTipo;
	private JComboBox cbTipo;
	private JTextField txtPass;
	private JButton btnCrear;
	private JTextField txtAgregarUsuario;
	private JButton btnCancelar;
	
	ResultSet rs;
	consultas model = new consultas();
	MantenimientoDistribuidores mantenimientoDistribuidores;
	
	
	public static void main(String[] args) {
		try {
			NuevoDistribuidor dialog = new NuevoDistribuidor(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public NuevoDistribuidor(MantenimientoDistribuidores mantenimientoDistribuidores) {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		this.mantenimientoDistribuidores = mantenimientoDistribuidores;
		
		setResizable(false);
		addWindowListener(this);
		setBounds(100, 100, 400, 453);
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setFont(new Font("Candara", Font.BOLD, 20));
		lblUsuario.setBounds(10, 131, 138, 38);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(SystemColor.windowBorder);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(10, 167, 370, 34);
		getContentPane().add(txtUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setVerticalAlignment(SwingConstants.BOTTOM);
		lblContrasea.setForeground(Color.DARK_GRAY);
		lblContrasea.setFont(new Font("Candara", Font.BOLD, 20));
		lblContrasea.setBounds(10, 201, 205, 34);
		getContentPane().add(lblContrasea);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Candara", Font.BOLD, 20));
		lblNombre.setBounds(10, 61, 138, 38);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setForeground(SystemColor.windowBorder);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(10, 99, 370, 34);
		getContentPane().add(txtNombre);
		
		lblTipo = new JLabel("Tipo de usuario:");
		lblTipo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTipo.setForeground(Color.DARK_GRAY);
		lblTipo.setFont(new Font("Candara", Font.BOLD, 20));
		lblTipo.setBounds(10, 290, 150, 38);
		getContentPane().add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		cbTipo.setBackground(Color.WHITE);
		cbTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Vendedor"}));
		cbTipo.setBounds(158, 290, 222, 36);
		getContentPane().add(cbTipo);
		
		txtPass = new JTextField();
		txtPass.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		txtPass.setHorizontalAlignment(SwingConstants.LEFT);
		txtPass.setForeground(SystemColor.windowBorder);
		txtPass.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBackground(Color.WHITE);
		txtPass.setBounds(10, 233, 370, 34);
		getContentPane().add(txtPass);
		
		btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(this);
		btnCrear.setForeground(SystemColor.menu);
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCrear.setBackground(new Color(30, 144, 255));
		btnCrear.setBounds(205, 360, 175, 38);
		getContentPane().add(btnCrear);
		cbTipo.setSelectedIndex(-1);
		
		txtAgregarUsuario = new JTextField();
		txtAgregarUsuario.setText("CREAR DISTRIBUIDOR");
		txtAgregarUsuario.setRequestFocusEnabled(false);
		txtAgregarUsuario.setIgnoreRepaint(true);
		txtAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgregarUsuario.setForeground(Color.WHITE);
		txtAgregarUsuario.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtAgregarUsuario.setFocusable(false);
		txtAgregarUsuario.setFocusTraversalKeysEnabled(false);
		txtAgregarUsuario.setEditable(false);
		txtAgregarUsuario.setColumns(10);
		txtAgregarUsuario.setBackground(Color.DARK_GRAY);
		txtAgregarUsuario.setBounds(0, 0, 394, 50);
		getContentPane().add(txtAgregarUsuario);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnCancelar(arg0);
			}
		});
		btnCancelar.setForeground(SystemColor.menu);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBackground(new Color(220, 20, 60));
		btnCancelar.setBounds(10, 360, 175, 38);
		getContentPane().add(btnCancelar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNombre, txtUsuario, txtPass, cbTipo, btnCrear}));
		
		cargar();
	}
	
	private void cargar(){
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCrear) {
			actionPerformedBtnCrear(arg0);
		}
	}
	protected void actionPerformedBtnCrear(ActionEvent arg0) {
		try {
			if(txtUsuario.getText().length() == 0 || txtPass.getText().length() == 0 || txtNombre.getText().length() == 0 ||cbTipo.getSelectedIndex() == -1 ){
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos correctamente");
			}
			else{
				rs = model.crearUsuario(txtUsuario.getText(), txtPass.getText(), txtNombre.getText(), cbTipo.getSelectedIndex());
				mantenimientoDistribuidores.cargar();
				
				try {
					ResultSet rs = model.cargarUltimoUsuario();
					rs.next();
					int idusuario = rs.getInt("idusuario");
					mantenimientoDistribuidores.selecionarUsuario(""+idusuario);
				} catch (SQLException e) {
				}
				dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al crear usuario: " + e);
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
		mantenimientoDistribuidores.setEnabled(true);
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		this.dispose();
	}
}
