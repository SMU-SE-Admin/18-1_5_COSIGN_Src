package cosign;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Delete extends JFrame {

	private JPanel contentPane;

	public Delete() {}
	
	public Delete(String cont) {
		setBounds(100, 100, 426, 165);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				try {
					Mainframe mf = new Mainframe();
					mf.setVisible(true);
					dispose();
					} catch (IOException e2) {
						e2.printStackTrace();
						}
				}
			});
			
		//삭제 확인
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);

		JLabel delIMG = new JLabel("삭제하시겠습니까?");
		delIMG.setBounds(105, 10, 200, 40);
		delIMG.setFont(new Font("맑은고딕", Font.BOLD, 23));
		delIMG.setForeground(new Color(128, 128, 128));

		JButton delBtn = new JButton("확인");
		delBtn.setBounds(65, 65, 105, 40);
		delBtn.setFont(new Font("맑은고딕", Font.BOLD, 20));
		delBtn.setForeground(new Color(128, 128, 128));
		
		//삭제 기능
		String cont1 = " " + cont;
		delBtn.addActionListener(new ActionListener() {
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
				try {
					Mainframe mf = new Mainframe();
					mf.setVisible(true);
				} catch (IOException e_1) {
					e_1.printStackTrace();
				}
				dispose();
			}
		});

		//취소
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(240, 65, 105, 40);
		cancelBtn.setFont(new Font("맑은고딕", Font.BOLD, 20));
		cancelBtn.setForeground(new Color(128, 128, 128));
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          	 try {
							Mainframe mf = new Mainframe();
							mf.setVisible(true);
							dispose();
						} catch (IOException e_1) {
							e_1.printStackTrace();
						}
				dispose();
			}
		});
		contentPane.add(delIMG);
		contentPane.add(delBtn);
		contentPane.add(cancelBtn);
	}
	public static void main(String[] args) {
		Delete fr = new Delete();
		fr.setVisible(true);
	}
}