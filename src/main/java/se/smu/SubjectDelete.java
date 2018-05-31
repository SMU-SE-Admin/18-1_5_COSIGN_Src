package cosign;

import cosign.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class SubjectDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public SubjectDelete() {}

	public SubjectDelete(String cont) {
		setBounds(100, 100, 435, 570);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		 this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) { 
           	 try {
						Mainframe mf = new Mainframe();
						mf.setVisible(true);
						dispose();
					} catch (IOException e_1) {
						e_1.printStackTrace();
					}
            }
		 });
		
		String cont1 = " " + cont;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//label
		JLabel label = new JLabel("\uACFC\uBAA9 \uBA85");
		label.setBounds(40, 35, 110, 30);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label.setForeground(Color.GRAY);
		label.setToolTipText(" ");

		JLabel label_1 = new JLabel("\uB2F4\uB2F9 \uAD50\uC218");
		label_1.setBounds(40, 130, 110, 30);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_1.setForeground(Color.GRAY);

		JLabel label_2 = new JLabel("\uC694\uC77C/\uC2DC\uAC04");
		label_2.setBounds(40, 225, 110, 30);
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_2.setForeground(Color.GRAY);

		JLabel label_3 = new JLabel("\uB144\uB3C4/\uD559\uAE30");
		label_3.setBounds(40, 320, 110, 30);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_3.setForeground(Color.GRAY);

		JLabel label_4 = new JLabel("\uC138\uBD80 \uC0AC\uD56D");
		label_4.setBounds(40, 415, 110, 30);
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_4.setForeground(Color.GRAY);

		//textField
		JTextField textField = new JTextField();
		textField.setBounds(220, 30, 155, 45);
		textField.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);

		textField_1 = new JTextField();
		textField_1.setBounds(220, 125, 155, 45);
		textField_1.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(220, 220, 155, 45);
		textField_2.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(220, 320, 155, 45);
		textField_3.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(220, 410, 155, 45);
		textField_4.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		textField_4.setColumns(10);

		//확인 버튼
		JButton OKbtn = new JButton("");
		OKbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = new String[1000];
				BufferedReader br = null;
				FileWriter fw = null;
				try {
					br = new BufferedReader(new FileReader("data.dt"));
					int i = 0;
					while ((str[i] = br.readLine()) != null) {
						i++;
					}
					br.close();
					for (int j = 0; j < i; j++) {
						if (cont1.equals(str[j])) {
							str[j] = "";
						}
					}
					fw = new FileWriter("data.dt");
					fw.flush();
					for (int j = 0; j < i; j++) {
						if (!("".equals(str[j]))) {
							fw.write(str[j] + "\n");
						}
					}
					fw.flush();
					fw.close();
				} catch (IOException e_1) {
					e_1.printStackTrace();
				} finally {
					if (br != null)
						try {
							br.close();
						} catch (IOException e_1) {
						}
				}

				int count = 0;
				try {
					File data = new File("data.dt");
					FileWriter fw_1 = new FileWriter(data, true);
					if (!(textField.getText().equals(""))) {
						fw_1.write(" <html>");
						count++;
						fw_1.write(textField.getText());
					}
					if (!(textField_1.getText().equals(""))) {
						fw_1.write("<br>");
						count++;
						fw_1.write(textField_1.getText());
					}
					if (!(textField_2.getText().equals(""))) {
						fw_1.write("::");
						count++;
						fw_1.write(textField_2.getText());
					}
					if (!(textField_3.getText().equals(""))) {
						fw_1.write(":::");
						count++;
						fw_1.write(textField_3.getText());
						fw_1.write("::::");
					}
					if (!(textField_4.getText().equals(""))) {
						fw_1.write(textField_4.getText());
						fw_1.write("</html>");
						fw_1.write("\n");
						fw_1.flush();
					} else {
						fw_1.write("</html>");
						fw_1.write("\n");
						fw_1.flush();
					}
				} catch (IOException e_1) {
					e_1.printStackTrace();
				}
				if (count != 4) {
					Warning warning = new Warning();
					warning.setVisible(true);
					count = 0;
				} else {
					try {
						Mainframe mf = new Mainframe();
						mf.setVisible(true);
						dispose();
					} catch (IOException e_1) {
						e_1.printStackTrace();
					}
					
				}
			}
		});
		OKbtn.setBounds(100, 475, 60, 40);
		OKbtn.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191838663.png"));
		OKbtn.setBackground(Color.WHITE);
		OKbtn.setForeground(Color.BLACK);

		JButton DelSubBtn = new JButton("");
		DelSubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete dl = new Delete(cont);
				dl.setVisible(true);
				dispose();
			}
		});
		DelSubBtn.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191824909.png"));
		DelSubBtn.setForeground(Color.BLACK);
		DelSubBtn.setBackground(Color.WHITE);
		DelSubBtn.setBounds(260, 475, 60, 40);
		contentPane.add(DelSubBtn);

		String str_1 = "";
		String str_2 = "";
		String str_3 = "";
		String str_4 = "";
		String str_5 = "";

		for (int i = 6; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':') && !(cont.charAt(i) == '<'); i++) {
			str_1 = str_1 + cont.charAt(i);
			textField.setText(str_1);
		}
		for (int i = cont.indexOf("<br>") + 4; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':'); i++) {
			str_2 = str_2 + cont.charAt(i);
			textField_1.setText(str_2);

		}
		for (int i = cont.indexOf("::") + 2; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':'); i++) {
			str_3 = str_3 + cont.charAt(i);
			textField_2.setText(str_3);
		}
		for (int i = cont.indexOf(":::") + 3; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':'); i++) {
			str_4 = str_4 + cont.charAt(i);
			textField_3.setText(str_4);
		}
		for (int i = cont.indexOf("::::") + 4; !(cont.charAt(i) == '<'); i++) {
			str_5 = str_5 + cont.charAt(i);
			textField_4.setText(str_5);
		}
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		
		contentPane.add(OKbtn);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}
}