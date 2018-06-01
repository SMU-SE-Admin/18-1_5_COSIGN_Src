package cosign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;

	//Launch the application.
	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);
	}
	
	 //Create the frame.
	 public Login() {
		 setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		 this.addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e) { 
            	 try {
						Mainframe ma = new Mainframe();
						ma.setVisible(true);
						dispose();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
             }
		 });
		 
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 184, 88));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		JLabel lblNewLabel1 = new JLabel("\uACFC\uBAA9 List");
		lblNewLabel1.setIcon(new ImageIcon("Resource/UI1_Background.png"));
		//lblNewLabel1.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 25));
		//lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel1.setBounds(0, -80, 500, 800);
		contentPane.add(lblNewLabel1);
		
		JButton btnNewButton2 = new JButton();
		btnNewButton2.setBackground(new Color(250,184,88));
		btnNewButton2.setIcon(new ImageIcon("resource/UI1_Login.png"));
		btnNewButton2.setBounds(184, 650, 135, 70);
		contentPane.add(btnNewButton2);
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
		{
			try {
				Mainframe ma = new Mainframe();
				ma.setVisible(true);
				dispose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
			});
		
	 }
	 
}