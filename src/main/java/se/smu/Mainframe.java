package cosign;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.*;

public class Mainframe extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField textField;

	//// Launch the application.
	public static void main(String[] args) throws IOException, InterruptedException {
		Mainframe frame = new Mainframe();
		frame.setVisible(true);
		frame.setSize(500,800);
		/////�븣�엺
		
		File SetAlarmDate = new File("SetAlarmDatetime.dt");
		int month = 0, date = 0, hour = 0, counter = 0;
		
		while (true) {
			Calendar cal = Calendar.getInstance();
			FileReader SetAlarmDatedt = new FileReader(SetAlarmDate);
			
			//// �썡 援ы븯湲�
			for (int i = 0; i < 3; i++) {
				int alstd = SetAlarmDatedt.read();
				if (alstd == 9) {
					break;
				}
				alstd -= 48;
				month *= 10;
				month += alstd;
			}
			
			//// �씪 援ы븯湲�
			for (int i = 0; i < 3; i++) {
				int alstd = SetAlarmDatedt.read();
				if (alstd == 9) {
					break;
				}
				alstd -= 48;
				date *= 10;
				date += alstd;
			}
			
			//// �떆 援ы븯湲�
			for (int i = 0; i < 3; i++) {
				int alstd = SetAlarmDatedt.read();
				if (alstd == 10) {
					break;
				}
				if (alstd == 13) {
					break;
				}
				alstd -= 48;
				hour *= 10;
				hour += alstd;
			}
			
			int mon = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int ho = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			mon += 1;
			if (month == mon && date == day && hour == ho && min < 5) {
				SetAlarmDate SetAlarmDate1 = new SetAlarmDate();
				SetAlarmDate1.setVisible(true);
				Thread.sleep(300*1000);
			}
			month = 0;
			date = 0;
			hour = 0;
		}
	}

	//// Create the frame.
	public Mainframe() throws IOException {
		
		//// �쟾泥� �봽�젅�엫
		super("Cosign");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane.setBackground(new Color(250,250,230));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/////////////////////////////////// 怨쇰ぉ �뙣�꼸
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 50, 500, 350);
		panel.setLayout(null);
		contentPane.add(panel);
		
		//// 怨쇰ぉ 異붽� 踰꾪듉
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setIcon(new ImageIcon("Resource/UI2_Button_Add.png"));
		btnNewButton_3.setBackground(new Color(250, 184, 88));
		btnNewButton_3.setBounds(430, 10, 40, 40);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectEnroll nl = new SubjectEnroll();
				nl.setVisible(true);
				dispose();
			}
		});

		//// 怨쇰ぉ �젣紐� �젅�씠釉�
		JLabel lblNewLabel = new JLabel("\uACFC\uBAA9 List");
		lblNewLabel.setIcon(new ImageIcon("Resource/UI2_Banner_Subject.png"));
		lblNewLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 25));
		//lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setBounds(0, 0, 500, 55);
		panel.add(lblNewLabel);



		/////////// 怨쇰ぉ �몴�떆
		//// �뙣�꼸
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 500, 250);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1));
		panel_3.setForeground(new Color(255, 255, 240));
		panel_3.setBackground(new Color(255, 255, 240));
		panel_3.setBorder(new LineBorder(Color.black));

		// �뙆�씪 �씫怨� 異쒕젰
		File data = new File("data.dt");
		BufferedReader in = new BufferedReader(new FileReader(data));
		String s;
		while ((s = in.readLine()) != null) {
			s = s.replaceAll(" ", "");
			JButton cont = new JButton(s);
			cont.setBounds(0, 0, 356, 50);
			cont.setForeground(new Color(0, 0, 0));
			cont.setBorder(new LineBorder(Color.black));
			panel_3.add(cont);
			cont.addMouseListener(new MyMouseListener2() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						SubjectDelete DL = null;
						DL = new SubjectDelete(cont.getText());
						DL.setVisible(true);
						dispose();
					}
				}
			});
		}
		in.close();

		// 怨쇰ぉ 湲몄뼱진 �븣 �뒪�겕濡� 異붽�
		JScrollPane sp = new JScrollPane(panel_3, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(0, 53, 485, 300);
		panel.add(sp);

		////////////////////////////////////// �꽭遺��궗�빆 �뙣�꼸
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(250, 184, 88));
		panel_2.setBackground(new Color(250, 184, 88));
		panel_2.setBounds(500, 800, 500, 200);
		contentPane.add(panel_2);

		// �꽭遺��궗�빆 �젣紐� �젅�씠釉�
		JLabel lblTodolist_2 = new JLabel("TodoList \uC138\uBD80\uC0AC\uD56D");
		lblTodolist_2.setForeground(new Color(128, 128, 128));
		lblTodolist_2.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 25));
		lblTodolist_2.setBounds(263, 12, 244, 39);
		panel_2.add(lblTodolist_2);
		
		///////////// �븷�씪 �꽭遺��궗�빆 �몴�떆
		// �뙣�꼸
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 61, 746, 154);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1));
		panel_5.setForeground(new Color(250, 184, 88));
		panel_5.setBackground(new Color(250, 184, 88));
		panel_5.setBorder(new LineBorder(Color.black));

		JLabel jl = new JLabel();
		panel_5.add(jl);

		// 怨쇰ぉ 湲몄뼱진 �븣 �뒪�겕濡� 異붽�

		JScrollPane sptddt = new JScrollPane(panel_5, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sptddt.setBounds(0, 53, 485, 300);
		panel_2.add(sptddt);

		//////////////////////////////////////// to do �뙣�꼸
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(250, 184, 88));
		panel_1.setBackground(new Color(250, 184, 88));
		panel_1.setBounds(0, 400, 500, 400);
		// panel_1.setBorder(new LineBorder(Color.gray));
		contentPane.add(panel_1);

		// to do 異붽� 踰꾪듉
		JButton button = new JButton();
		button.setIcon(new ImageIcon("Resource/UI2_Button_Add.png"));// �븘�씠肄�
		
		// to do �젣紐� �씪踰�
		JLabel lblTodolist_1 = new JLabel("ToDoList");
		lblTodolist_1.setIcon(new ImageIcon("Resource/UI2_Banner_Todo.png"));
		// lblTodolist_1.setForeground(new Color(128, 128, 128));
		// lblTodolist_1.setBackground(new Color(30, 144, 255));
		lblTodolist_1.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 25));
		lblTodolist_1.setBounds(0, 0, 500, 50);
		panel_1.add(lblTodolist_1);
																					// �씠誘몄�
		button.setBackground(new Color(250, 184, 88));								// �쐞移�		
		button.setBounds(430, 10, 40, 40);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {// 踰꾪듉 �늻瑜쇱떆 �닔�뻾 �룞�옉
			public void actionPerformed(ActionEvent arg0) {
				TodoEnroll rf = null;
				try {
					rf = new TodoEnroll();
				} catch (IOException e) {
					e.printStackTrace();
				} // TodoEnroll�깮�꽦
				rf.setVisible(true);
				dispose();
			}
		});

		JCheckBox checkBox = new JCheckBox("\uC644\uB8CC\uD45C\uC2DC");
		checkBox.setBounds(257, 43, 90, 15);
		panel_1.add(checkBox);

		
		// to do �젙�젹湲곕뒫 諛뺤뒪
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(230, 10, 65, 30);
		comboBox_1.addItem("�쟾泥�");
		comboBox_1.addItem("吏꾪뻾以�");
		comboBox_1.addItem("�씠由�");
		comboBox_1.addItem("留덇컧�씪");
		comboBox_1.addItem("완猷�");
		comboBox_1.addItem("�걹�궦�씪");
		panel_1.add(comboBox_1);

		///////////// �븷�씪 �몴�떆
		// �뙣�꼸
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 480, 10);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1));
		panel_4.setForeground(new Color(255, 255, 240));
		panel_4.setBackground(new Color(255, 255, 240));
		panel_4.setBorder(new LineBorder(Color.black));

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String std;
		File datatd = new File("datatd.dt");
		String std1 = "";
		String str1[] = new String[1000];
		int k = 0;
		BufferedReader intd = new BufferedReader(new FileReader(datatd));
		while ((std = intd.readLine()) != null) {
			for (int i = 0; !(std.charAt(i) == ':' && std.charAt(i + 1) == ':' && std.charAt(i + 2) == ':'); i++) {
				std1 = std1 + std.charAt(i);
			}
			std1 = std1 + "</html>";
			if(!(checkBox.isSelected())){
				int countindex=0,goingindex=0;
				for (int i = 0; i < std1.length(); i++) {
					if (std1.charAt(i) == ':' && std1.charAt(i + 1) == ':') {
						countindex++;
					}
					if (countindex == 3) {
						goingindex = i;
						countindex = 0;
						break;
					}
				}
				if (std1.charAt(goingindex + 2) == '완') {
					std1 = std1.replaceFirst(" ", "a");
				}
			}
			str1[k] = std1;
			std1 = "";
			k++;
		}
		for (int a = 0; a < k; a++) {// �뙣�꼸 踰꾪듉異붽�
			if(str1[a].charAt(0)=='a'){
				continue;
			}
			str1[a] = str1[a].replaceAll(" ", "");
			JButton conttd = new JButton(str1[a]);
			conttd.setBounds(0, 0, 356, 50);
			conttd.setForeground(new Color(0, 0, 0));
			conttd.setBorder(new LineBorder(Color.black));
	         conttd.addMouseListener(new MyMouseListener(){
	       	  public void mouseClicked(MouseEvent e){
	    		  if(e.getClickCount() == 2){
	    	           TodoDelete DT = null;
	    	            try {
	    					DT = new TodoDelete(conttd.getText());
	    				} catch (IOException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    	            DT.setVisible(true);
	    	    		dispose();
	    		  }

	    	  }
	         });
			for(int i = 0; i<str1[a].length();i++){
				if(str1[a].charAt(i+1)=='<'&&str1[a].charAt(i+2)=='/'&&str1[a].charAt(i+3)=='h'&&str1[a].charAt(i+4)=='t'&&str1[a].charAt(i+5)=='m'&&str1[a].charAt(i+6)=='l'&&str1[a].charAt(i+7)=='>'){
					if(str1[a].charAt(i-2)=='우'&&str1[a].charAt(i)=='요'){
						conttd.setBackground(Color.RED);
						break;
					}
					else if(str1[a].charAt(i)=='요'){
						conttd.setBackground(Color.BLUE);
						break;
					}
					else{
						break;
					}
				}
			}
			conttd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String std, std1, std2;
					File datatd = new File("datatd.dt");
					try {
						std1 = " " + conttd.getText();
						BufferedReader intd = new BufferedReader(new FileReader(datatd));
						while ((std = intd.readLine()) != null) {
							int count = 0;
							int i = 0;
							for (i = 0; !(std1.charAt(i) == ':' && std1.charAt(i + 1) == ':'); i++) {
								if (std.charAt(i) == std1.charAt(i)) {
									count++;
								}
							}
							std2 = "";
							if (count == i) {
								count = 0;
								for (i = 3; i < std.length() - 7; i++) {
									if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'&& std.charAt(i - 1) == ':') {
										count++;
									}
									if (count > 0) {
										std2 = std2 + std.charAt(i);
									}
								}
								jl.setText(std2);
								panel_5.updateUI();
							}
						}
						intd.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			panel_4.add(conttd);
		}

		// �젙�젹踰꾪듉
		JButton btnSort = new JButton("SORT");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.removeAll();
				panel_4.updateUI();
				
				try {
					// �뙆�씪 �씫怨� 異쒕젰
					File datatd = new File("datatd.dt");
					BufferedReader intd = new BufferedReader(new FileReader(datatd));
					String std;
					String std1 = "";
					String std2 = "";
					String str1[] = new String[1000];
					String str2[] = new String[1000];
					String temp[] = new String[1000];
					int counter = 0;
					int countindex = 0;
					int goingindex = 0;
					int k = 0;
					int comboindex = 0;
					while ((std = intd.readLine()) != null) {
						for (int i = 0; !(std.charAt(i) == ':' && std.charAt(i + 1) == ':'&& std.charAt(i + 2) == ':'); i++) {
							std1 = std1 + std.charAt(i);
						}
						if(!(checkBox.isSelected())){
							countindex=0;goingindex=0;
							for (int i = 0; i < std1.length(); i++) {
								if (std1.charAt(i) == ':' && std1.charAt(i + 1) == ':') {
									countindex++;
								}
								if (countindex == 3) {
									goingindex = i;
									countindex = 0;
									break;
								}
							}
							if (std1.charAt(goingindex + 2) == '완') {
								std1 = std1.replaceFirst(" ", "a");
							}
						}
						std1 = std1 + "</html>";
						str1[k] = std1;
						std1 = "";
						k++;
					}
					if (comboBox_1.getSelectedItem() == "�쟾泥�") {
						comboindex = 0;
					} else if (comboBox_1.getSelectedItem() == "吏꾪뻾以�") {
						comboindex = 1;
					} else if (comboBox_1.getSelectedItem() == "�씠由�") {
						comboindex = 2;
					} else if (comboBox_1.getSelectedItem() == "留덇컧�씪") {
						comboindex = 3;
					} else if (comboBox_1.getSelectedItem() == "완猷�") {
						comboindex = 4;
					} else if (comboBox_1.getSelectedItem() == "�걹�궦�씪") {
						comboindex = 5;
					}
					switch (comboindex) {
						case 0:// �쟾泥�
							for (counter = 0; counter < k; counter++) {
								str2[counter] = str1[counter];
							}
							break;
							
						case 1:// 吏꾪뻾以�
							for (int j = 0; j < k; j++) {
								for (int i = 0; i < str1[j].length(); i++) {
									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (countindex == 3) {
										goingindex = i;
										countindex = 0;
										break;
									}
								}
								if (str1[j].charAt(goingindex + 2) == '진') {
									str2[counter] = str1[j];
									counter++;
								}
							}
							break;

						case 2:// �씠由꾩닚
							for (int j = 0; j < k; j++) {
								temp[j] = "";
								for (int i = 0; !(str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':'); i++) {
									temp[j] = temp[j] + str1[j].charAt(i);
								}
							}
							for (counter = 0; counter < k; counter++) {
								int j = 0;
								int acount = 0;
								for (int x = 0; x < k; x++) {
									if (temp[x].charAt(0) == 'a') {
										acount++;
										continue;
									}
									if (temp[j].compareTo(temp[x]) > 0) {
										j = x;
									}
									
								}
								if(acount==k){
									break;
								}
								str2[counter] = str1[j];
								temp[j] = temp[j].replaceFirst(" ", "a");
							}	
							break;

						case 3:// 留덇컧�씪
							for (int j = 0; j < k; j++) {
								temp[j] = " ";
								for (int i = 0; countindex < 2; i++) {
									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (str1[j].charAt(i) == '<' && str1[j].charAt(i + 1) == 'b'&& str1[j].charAt(i + 2) == 'r' && str1[j].charAt(i + 3) == '>') {
										temp[j] = temp[j] + str1[j].charAt(i);
									}
								}
							}
							for (counter = 0; counter < k; counter++) {
								int j = 0;
								while (temp[j].charAt(0) == 'a') {
									j++;
									if (j == k) {
										break;
									}
								}
								for (int x = 0; x < k; x++) {
									if (temp[x].charAt(0) == 'a') {
										continue;
									}
									if (temp[j].compareTo(temp[x]) < 0) {
										j = x;
									}
								}
								str2[counter] = str1[j];
								temp[j] = temp[j].replaceFirst(" ", "a");
							}	
							break;

						case 4: // 완猷�
							for (int j = 0; j < k; j++) {
								for (int i = 0; i < str1[j].length(); i++) {
									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (countindex == 3) {
										goingindex = i;
										countindex = 0;
										break;
									}
								}
								if (str1[j].charAt(goingindex + 2) == '완') {
									str1[j] = str1[j].replaceFirst("a", " ");
									str2[counter] = str1[j];
									counter++;
								}
							}
							break;

						case 5: // �떎�젣留덇컧�씪
							for (int j = 0; j < k; j++) {
								temp[j] = " ";
								goingindex = 0;
								countindex = 0;
								for (int i = 0; goingindex < 2; i++) {

									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (str1[j].charAt(i) == '<' && str1[j].charAt(i + 1) == 'b'&& str1[j].charAt(i + 2) == 'r' && str1[j].charAt(i + 3) == '>') {
										goingindex++;
									}
									if (countindex == 2) {
										temp[j] = temp[j] + str1[j].charAt(i);
									}
								}
							}
							for (counter = 0; counter < k; counter++) {
								int j = 0;
								for (int x = 0; x < k; x++) {
									if (temp[x].charAt(0) == 'a') {
										continue;
									}
									if (temp[j].compareTo(temp[x]) > 0) {
										j = x;
									}
								}
								str2[counter] = str1[j];
								temp[j] = temp[j].replaceFirst(" ", "a");
							}
							break;
						}
						for (int a = 0; a < counter; a++) {// �뙣�꼸 踰꾪듉異붽�
							if(str2[a].charAt(0)=='a'){
								continue;
							}
							str2[a] = str2[a].replaceAll(" ", "");
							JButton conttd = new JButton(str2[a]);
							conttd.setBounds(0, 0, 356, 50);
							conttd.setForeground(new Color(0, 0, 0));
							conttd.setBorder(new LineBorder(Color.black));
							for(int i = 0; i<str1[a].length();i++){
								if(str2[a].charAt(i+1)=='<'&&str2[a].charAt(i+2)=='/'&&str2[a].charAt(i+3)=='h'&&str2[a].charAt(i+4)=='t'&&str2[a].charAt(i+5)=='m'&&str2[a].charAt(i+6)=='l'&&str2[a].charAt(i+7)=='>'){
									if(str2[a].charAt(i-2)=='우'&&str2[a].charAt(i)=='요'){
										conttd.setBackground(Color.RED);
										break;
									}
									else if(str2[a].charAt(i)=='요'){
										conttd.setBackground(Color.BLUE);
										break;
									}
									else{
										break;
									}
								}
							}
							conttd.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									String std, std1, std2;
									File datatd = new File("datatd.dt");
									try {
										std1 = " " + conttd.getText();
										BufferedReader intd = new BufferedReader(new FileReader(datatd));
										while ((std = intd.readLine()) != null) {
											int count = 0;
											int i = 0;
											for (i = 0; !(std1.charAt(i) == ':' && std1.charAt(i + 1) == ':'); i++) {
												if (std.charAt(i) == std1.charAt(i)) {
													count++;
												}	
											}
											std2 = "";
											if (count == i) {
												count = 0;
												for (i = 3; i < std.length() - 7; i++) {
													if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'&& std.charAt(i - 1) == ':') {
														count++;
													}
													if (count > 0) {
														std2 = std2 + std.charAt(i);
													}
												}
												jl.setText(std2);
												panel_5.updateUI();
											}
										}
										intd.close();
									} catch (FileNotFoundException e) {
										e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
					         conttd.addMouseListener(new MyMouseListener(){
						       	  public void mouseClicked(MouseEvent e){
						    		  if(e.getClickCount() == 2){
						    	           TodoDelete DT = null;
						    	            try {
						    					DT = new TodoDelete(conttd.getText());
						    				} catch (IOException e1) {
						    					// TODO Auto-generated catch block
						    					e1.printStackTrace();
						    				}
						    	            DT.setVisible(true);
						    	    		dispose();
						    		  }

						    	  }
						         });
						panel_4.add(conttd);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSort.setBounds(303, 10, 70, 30);
		panel_1.add(btnSort);

		// 怨쇰ぉ 湲몄뼱진 �븣 �뒪�겕濡� 異붽�
		JScrollPane sptd = new JScrollPane(panel_4, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sptd.setBounds(0, 50, 485, 300);
		panel_1.add(sptd);
		

		///////////////////////////////////// 湲고� 硫붿씤 李�

		// 寃��깋李�
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(109, 6, 536, 45);
		contentPane.add(textField);
		textField.setColumns(10);// 湲곕뒫 援ы쁽�븯湲�

		// 寃��깋 醫낅쪟 �꽑�깮 諛뺤뒪
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(14, 10, 81, 37);
		comboBox.addItem("怨쇰ぉ");
		comboBox.addItem("�븷�씪");
		contentPane.add(comboBox);// 湲곕뒫 援ы쁽 �븯湲�

		// 寃��깋 踰꾪듉
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(659, 6, 36, 45);
		btnNewButton_1.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191846026.png"));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 寃��깋 湲곕뒫 援ы쁽 �븯湲�
				if (comboBox.getSelectedItem() == "怨쇰ぉ") {
					if (textField.getText().equals("")) {
						panel_3.removeAll();
						File data = new File("data.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s;
							while ((s = in.readLine()) != null) {
								s = s.replace(" ", "");
								JButton cont = new JButton(s);
								cont.setBounds(0, 0, 356, 50);
								cont.setForeground(new Color(0, 0, 0));
								cont.setBorder(new LineBorder(Color.black));
								panel_3.add(cont);
							}
							panel_3.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						panel_3.removeAll();
						panel_3.updateUI();
						File data = new File("data.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s, s2 = "";
							int count = 0;
							while ((s = in.readLine()) != null) {
								for (int i = 7; !(s.charAt(i) == '<' && s.charAt(i + 1) == 'b' && s.charAt(i + 2) == 'r'
										&& s.charAt(i + 3) == '>'); i++) {
									s2 = s2 + s.charAt(i);
								}
								if (s2.equals(textField.getText())) {
									count++;
									s = s.replaceAll(" ", "");
									JButton cont = new JButton(s);
									cont.setBounds(0, 0, 356, 50);
									cont.setForeground(new Color(0, 0, 0));
									cont.setBorder(new LineBorder(Color.black));
									panel_3.add(cont);
								} else {
									s2 = "";
								}
							}
							if (count == 0) {
								JLabel nothere = new JLabel("李얜뒗 �젙蹂닿� �뾾�뒿�땲�떎.");
								panel_3.add(nothere);
							} else {
								count = 0;
							}
							panel_3.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					if (textField.getText().equals("")) {
						panel_4.removeAll();
						panel_4.updateUI();
						File data = new File("datatd.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s, s2 = "";
							while ((s = in.readLine()) != null) {
								s2 = "";
								for (int i = 0; !(s.charAt(i) == ':' && s.charAt(i + 1) == ':'
										&& s.charAt(i + 2) == ':'); i++) {
									s2 = s2 + s.charAt(i);
								}
								s2 = s2.replace(" ", "");
								JButton cont = new JButton(s2);
								cont.setBounds(0, 0, 356, 50);
								cont.setForeground(new Color(0, 0, 0));
								cont.setBorder(new LineBorder(Color.black));

								cont.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										String std, std1, std2;
										File datatd = new File("datatd.dt");
										try {
											std1 = " " + cont.getText();
											BufferedReader intd = new BufferedReader(new FileReader(datatd));
											while ((std = intd.readLine()) != null) {
												int count = 0;
												int i = 0;
												for (i = 0; !(std1.charAt(i) == ':'
														&& std1.charAt(i + 1) == ':'); i++) {
													if (std.charAt(i) == std1.charAt(i)) {
														count++;
													}
												}
												std2 = "";
												if (count == i) {
													count = 0;
													for (i = 3; i < std.length() - 7; i++) {
														if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'
																&& std.charAt(i - 1) == ':') {
															count++;
														}
														if (count > 0) {
															std2 = std2 + std.charAt(i);
														}
													}
													jl.setText(std2);
													panel_5.updateUI();
												}
											}
											intd.close();
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});

								panel_4.add(cont);
							}
							panel_4.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						panel_4.removeAll();
						panel_4.updateUI();
						File data = new File("datatd.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s, s2 = "";
							int count = 0;
							while ((s = in.readLine()) != null) {
								for (int i = 7; !(s.charAt(i) == ':' && s.charAt(i + 1) == ':'); i++) {
									s2 = s2 + s.charAt(i);
								}
								if (s2.equals(textField.getText())) {
									s2 = "";
									count++;
									s = s.replaceAll(" ", "");
									for (int i = 0; !(s.charAt(i) == ':' && s.charAt(i + 1) == ':'
											&& s.charAt(i + 2) == ':'); i++) {
										s2 = s2 + s.charAt(i);
									}
									s2 = s2 + "</html>";
									JButton cont = new JButton(s2);
									cont.setBounds(0, 0, 356, 50);
									cont.setForeground(new Color(0, 0, 0));
									cont.setBorder(new LineBorder(Color.black));

									cont.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											String std, std1, std2;
											File datatd = new File("datatd.dt");
											try {
												std1 = " " + cont.getText();
												BufferedReader intd = new BufferedReader(new FileReader(datatd));
												while ((std = intd.readLine()) != null) {
													int count = 0;
													int i = 0;
													for (i = 0; !(std1.charAt(i) == ':'
															&& std1.charAt(i + 1) == ':'); i++) {
														if (std.charAt(i) == std1.charAt(i)) {
															count++;
														}
													}
													std2 = "";
													if (count == i) {
														count = 0;
														for (i = 3; i < std.length() - 7; i++) {
															if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'
																	&& std.charAt(i - 1) == ':') {
																count++;
															}
															if (count > 0) {
																std2 = std2 + std.charAt(i);
															}
														}
														jl.setText(std2);
														panel_5.updateUI();
													}
												}
												intd.close();
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});

									panel_4.add(cont);
								}
							}
							if (count == 0) {
								JLabel nothere = new JLabel("李얜뒗 �젙蹂닿� �뾾�뒿�땲�떎.");
								panel_4.add(nothere);
							}
							panel_4.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		
	}
}

class MyMouseListener extends MouseAdapter {

}

class MyMouseListener2 extends MouseAdapter {

}