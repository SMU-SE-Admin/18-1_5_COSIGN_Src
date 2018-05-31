package cosign;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class DeleteTo extends JFrame {

	private JPanel contentPane;

	public DeleteTo() {}

	public DeleteTo(String cont) {
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
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);

		JLabel delLabel = new JLabel("삭제하시겠습니까?");
		delLabel.setBounds(105, 10, 200, 40);
		delLabel.setFont(new Font("맑은고딕", Font.BOLD, 23));
		delLabel.setForeground(new Color(128, 128, 128));

		JButton button = new JButton("확인");
		button.setBounds(65, 65, 105, 40);
		button.setFont(new Font("맑은고딕", Font.BOLD, 20));
		button.setForeground(new Color(128, 128, 128));
		
		//삭제 기능
		String cont1 = cont;
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] str = new String[1000];
				String[] str_1 = new String[1000];
				BufferedReader br = null;
				FileWriter fw = null;
				try {
					br = new BufferedReader(new FileReader("datatd.dt"));
					int i = 0;
					
					while ((str[i] = br.readLine()) != null) {
						str_1[i]="";
						for(int k=0; k<str[i].length()-2;k++){
							if(str[i].charAt(k)==':'&&str[i].charAt(k+1)==':'&&str[i].charAt(k+2)==':'){
								break;
							}
							str_1[i] = str_1[i] + str[i].charAt(k); 
						}
						str_1[i]=str_1[i] + "</html>";
						str_1[i] = str_1[i].replaceAll(" ", "");	
						i++;
					}
					br.close();
					for (int j = 0; j < i; j++) {
						if (cont1.equals(str_1[j])) {
							str[j] = "";
						}
					}
					fw = new FileWriter("datatd.dt");
					fw.flush();
					for (int j = 0; j < i; j++) {
						if (!("".equals(str[j]))) {
							fw.write(str[j] + "\n");
						}
					}
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null)
						try {
							br.close();
						} catch (IOException e) {
						}
				}
				try {
					Mainframe mf = new Mainframe();
					mf.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
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
		contentPane.add(delLabel);
		contentPane.add(button);
		contentPane.add(cancelBtn);
	}
	public static void main(String[] args) {
		DeleteTo fr = new DeleteTo();
		fr.setVisible(true);
	}
}