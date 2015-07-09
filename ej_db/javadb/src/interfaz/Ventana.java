package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;






import javax.swing.UIManager;

import entidades.Persona;
import negocio.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Ventana extends JFrame {


	private Controlador controlador = new Controlador();


	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setTitle("Conexi\u00F3n con MySql");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDni = new JTextField();
		txtDni.setBounds(124, 76, 148, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(124, 107, 148, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(124, 138, 148, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(124, 169, 148, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(68, 79, 46, 14);
		contentPane.add(lblDni);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(68, 110, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(68, 141, 46, 14);
		contentPane.add(lblApellido);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(68, 172, 46, 14);
		contentPane.add(lblEmail);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					agregarPersona();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(181, 203, 91, 23);
		contentPane.add(btnGuardar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar(txtDni.getText());
			}
		});
		btnBuscar.setBounds(282, 75, 91, 23);
		contentPane.add(btnBuscar);

		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(68, 48, 46, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(124, 45, 46, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnCargarDesdeServidor = new JButton("Descargar datos desde servidor");
		btnCargarDesdeServidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					updateFromDB();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCargarDesdeServidor.setBounds(181, 277, 187, 23);
		contentPane.add(btnCargarDesdeServidor);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDni, txtNombre, txtApellido, txtEmail, btnGuardar}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDni, txtNombre, txtApellido, txtEmail, btnGuardar}));
	}





	public void agregarPersona() throws ClassNotFoundException, SQLException{
		txtId.setText(controlador.agregarPersona(txtDni.getText(), txtNombre.getText(), txtApellido.getText(), txtEmail.getText()));
	}


	public void buscar(String dni){
		Persona per = controlador.getPersona(dni);
		if (per != null) {
			txtId.setText(per.getId());
			txtDni.setText(per.getDni());
			txtNombre.setText(per.getNombre());
			txtApellido.setText(per.getApellido());
			txtEmail.setText(per.getEmail());
		} else {
			txtId.setText("NULL!");
		};
	}	


	public void updateFromDB() throws ClassNotFoundException, SQLException{
		controlador.getAll();
	}


}
