package interfaz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import datos.CatPersonas;
import negocio.Controlador;
import entidades.Persona;

import java.awt.ScrollPane;
import javax.swing.UIManager;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField dnif;
	private JTextField emailf;
	private JTextField nombref;
	private JTextField apellidof;


	private Controlador controla = new Controlador();


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
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(35, 124, 32, 14);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 92, 42, 14);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(39, 59, 28, 14);

		dnif = new JTextField();
		dnif.setBounds(77, 56, 242, 20);
		dnif.setColumns(10);

		emailf = new JTextField();
		emailf.setBounds(77, 121, 346, 20);
		emailf.setColumns(10);

		nombref = new JTextField();
		nombref.setBounds(77, 89, 150, 20);
		nombref.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(237, 92, 49, 14);

		apellidof = new JTextField();
		apellidof.setBounds(282, 89, 141, 20);
		apellidof.setColumns(10);

		JButton button = new JButton("Borrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar();
			}
		});
		button.setBounds(275, 152, 65, 23);

		JButton button_1 = new JButton("Guardar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guardar();
			}
		});
		button_1.setBounds(350, 152, 73, 23);

		JButton button_2 = new JButton("Buscar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
			}
		});
		button_2.setBounds(329, 55, 94, 23);
		panel.setLayout(null);
		panel.add(lblEmail);
		panel.add(lblNombre);
		panel.add(lblDni);
		panel.add(dnif);
		panel.add(emailf);
		panel.add(nombref);
		panel.add(lblApellido);
		panel.add(apellidof);
		panel.add(button);
		panel.add(button_1);
		panel.add(button_2);



	}







	protected void Guardar() {
		controla.agregarPersona(Integer.parseInt(dnif.getText()), nombref.getText(), apellidof.getText(), emailf.getText());
		JOptionPane.showMessageDialog(null, "Datos recibidos.");
	}


	protected void Borrar() {
		if (controla.quitarPersona((Integer.parseInt(dnif.getText())))){
			JOptionPane.showMessageDialog(null, "Persona eliminada.");
		}else {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar a la persona.");
		}
	}



	protected void Buscar(){
		Persona p = controla.buscarPersona((Integer.parseInt(dnif.getText())));
		if (p == null){
			JOptionPane.showMessageDialog(null, "Persona no encontrada.");
		}
		else{
			nombref.setText(p.getNombre());
			apellidof.setText(p.getApellido());
			emailf.setText(p.getEmail());
		}
	}

}
