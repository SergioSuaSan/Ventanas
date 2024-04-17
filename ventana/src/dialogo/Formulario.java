package dialogo;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JButton Boton3puntos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Formulario frame = new Formulario();
					frame.setLocationRelativeTo(null);
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(126, 40, 223, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(45, 43, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setEditable(false);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(126, 96, 72, 20);
		contentPane.add(textFieldEdad);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(45, 99, 46, 14);
		contentPane.add(lblEdad);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnNewButton.setBounds(179, 179, 89, 23);
		contentPane.add(btnNewButton);
		
		Boton3puntos = new JButton("...");
		Boton3puntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsado3puntos();
			}
		});
		Boton3puntos.setBounds(208, 95, 33, 23);
		contentPane.add(Boton3puntos);
	}
	
	private void registrarse() {
		//revisar que los datos están correctos, si no, tendré que avisar 
		try {
			if (textFieldNombre.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo NOMBRE está vacío", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (textFieldEdad.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo EDAD está vacío", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt(textFieldEdad.getText()) < 0 || Integer.parseInt(textFieldEdad.getText()) > 100) {
				JOptionPane.showMessageDialog(this, "Revisa el campo EDAD", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				//Si todo está bien, guardaré los datos en la base de datos
				JOptionPane.showMessageDialog(this, "Datos guardados", "Correcto", JOptionPane.DEFAULT_OPTION);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "El diálogo se siente huérfano", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Edad incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void pulsado3puntos() {
		//Lanzar un diálogo para que teclee la edad
		String resultado = JOptionPane.showInputDialog(this, "Teclea la edad", "Edad", JOptionPane.INFORMATION_MESSAGE);
		textFieldEdad.setText(resultado);
	}
	
	
}
