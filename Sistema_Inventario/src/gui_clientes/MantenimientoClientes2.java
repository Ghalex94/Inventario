package gui_clientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mxrck.autocompleter.TextAutoCompleter;

import gui_configuracion.Configuraciones;
import gui_principal.VentanaPrincipal;
import mysql.consultas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ListSelectionModel;

public class MantenimientoClientes2 extends JInternalFrame {
	private JMenuBar menuBar;
	private JMenu mnCrearProducto;
	private JMenu mnModificarProducto;
	private JMenu mnNewMenu_2;
	private JButton btnX;
	private JScrollPane scrollPane;
	private TextAutoCompleter ac;
	private JTable tbCliente;

	public VentanaPrincipal vp;

	JTable tb;
	ResultSet rs;
	consultas model = new consultas();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoClientes2 frame = new MantenimientoClientes2(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MantenimientoClientes2(VentanaPrincipal vp) {
		this.vp = vp;

		getContentPane().setBackground(Color.WHITE);
		setTitle("DISTRIBUIDORES");
		setBounds(100, 100, 1134, 679);
		getContentPane().setLayout(null);

		btnX = new JButton("X");
		this.btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnX(arg0);
			}
		});
		btnX.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(220, 20, 60));
		btnX.setBounds(1030, 0, 63, 30);
		getContentPane().add(btnX);

		this.scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		this.scrollPane.setBounds(10, 41, 1083, 568);
		getContentPane().add(this.scrollPane);

		tbCliente = new JTable();
		tbCliente.setAutoCreateRowSorter(true);
		tbCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbCliente.setFont(new Font("Arial", Font.ITALIC, 14));
		tbCliente.setBackground(Color.WHITE);
		tbCliente.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		scrollPane.setViewportView(tbCliente);
		// tbProductos.getTableHeader().setResizingAllowed(false);
		tbCliente.getTableHeader().setReorderingAllowed(false);

		menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.setBackground(new Color(211, 211, 211));
		setJMenuBar(menuBar);

		mnCrearProducto = new JMenu("|Crear nuevo cliente| ");
		mnCrearProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedMnCrearProducto(arg0);
			}
		});
		mnCrearProducto.setForeground(new Color(65, 105, 225));
		mnCrearProducto.setBackground(SystemColor.control);
		mnCrearProducto.setFont(new Font("Arial", Font.BOLD, 22));
		menuBar.add(mnCrearProducto);

		mnModificarProducto = new JMenu("|Modificar cliente| ");
		mnModificarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedMnModificarProducto(e);
			}
		});
		mnModificarProducto.setForeground(new Color(60, 179, 113));
		mnModificarProducto.setBackground(SystemColor.control);
		mnModificarProducto.setFont(new Font("Arial", Font.BOLD, 22));
		menuBar.add(mnModificarProducto);

		mnNewMenu_2 = new JMenu("|Eliminar cliente| ");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedMnNewMenu_2(e);
			}
		});
		mnNewMenu_2.setForeground(new Color(220, 20, 60));
		mnNewMenu_2.setBackground(SystemColor.control);
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 22));
		menuBar.add(mnNewMenu_2);

		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null); // QUITA
																							// LA
																							// BARRA
																							// DE
																							// T�TULO

		cargar();
	}

	public void cargar() {
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbCliente;
		tb.setRowHeight(25);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[] { "ID", "NOMBRE", "TIPO DOC", "NRO DOCUMENTO", "DIRECCI�N",
				"TELEFONO", "CORREO" });
		consultas model = new consultas();
		rs = model.cargarClientes();
		try {
			while (rs.next()) {
				dtm.addRow(new Object[] { rs.getInt("idcliente"), rs.getString("nombre"), rs.getString("tipodoc"),
						rs.getString("nrodoc"), rs.getString("direccion"),
						rs.getString("telefono"), rs.getString("correo") });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al cargar usuarios: " + e.getMessage());
		}
		ajustarAnchoColumnas();
	}

	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	public void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(2)); //
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10)); //
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); //
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10)); //

	}

	protected void actionPerformedBtnX(ActionEvent arg0) {
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public void selecionarCliente(String id) {
		int cantDist = tbCliente.getRowCount();
		for (int i = 0; i < cantDist; i++) {
			if (id.equals(tbCliente.getValueAt(i, 0).toString())) {
				tbCliente.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	NuevoCliente2 nd = new NuevoCliente2(this);

	protected void mouseClickedMnCrearProducto(MouseEvent arg0) {
		try {
			if (nd.isShowing()) {
				// JOptionPane.showMessageDialog(null, "Ya tiene abierta la
				// ventana");
				nd.setExtendedState(0); // MOSTRAR VENTANA ABIERTA
				nd.setVisible(true);
			} else {
				nd = new NuevoCliente2(this);
				nd.setLocationRelativeTo(null);
				nd.setVisible(true);
			}
		} catch (Exception f) {
			JOptionPane.showMessageDialog(null, "Error: " + f);
		}
	}

	protected void mouseClickedMnModificarProducto(MouseEvent e) {
		try {
			DefaultTableModel tm = (DefaultTableModel) tbCliente.getModel();
			int idCli = Integer.parseInt(String.valueOf(tm.getValueAt(tbCliente.getSelectedRow(), 0)));
			ModificarCliente2 md = new ModificarCliente2(idCli, this);
			try {
				if (md.isShowing()) {
					// JOptionPane.showMessageDialog(null, "Ya tiene abierta la
					// ventana");
					md.setExtendedState(0); //MOSTRAR VENTANA ABIERTA
					md.setVisible(true);
				} else {
					md.setLocationRelativeTo(null);
					md.setVisible(true);
				}
			} catch (Exception f) {
				JOptionPane.showMessageDialog(null, "Error: " + f);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Seleccione el distribuidor a modificar");
		}
	}

	protected void mouseClickedMnNewMenu_2(MouseEvent e) {
		DefaultTableModel tm = (DefaultTableModel) tbCliente.getModel();
		int idCliente = Integer.parseInt(String.valueOf(tm.getValueAt(tbCliente.getSelectedRow(), 0)));
		int opc = JOptionPane.showConfirmDialog(null, "�Seguro de querer eliminar este cliente?", "Confirmaci�n",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0) {
			model.deshabilitarCliente(idCliente);
			cargar();
		} else {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
	}
}
