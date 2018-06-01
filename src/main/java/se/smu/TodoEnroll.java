package cosign;

import cosign.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cosign.Mainframe;
import cosign.TodoEnroll;

public class TodoEnroll extends JFrame {

	   private JPanel contentPane;
	   private JTextField textField;
	   private JTextField textField_1;

	   //Launch the application.
	   public static void main(String[] args) throws IOException {
	      TodoEnroll frame = new TodoEnroll();
	      frame.setVisible(true);
	   }

	    //Create the frame.
	   public TodoEnroll() throws IOException {
	      
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
		   
	      /////////////////////////////////////할일 추가창 전체 프레임
	      setBounds(100, 100, 500, 800);
	      contentPane = new JPanel();
	      contentPane.setBackground(new Color(255, 255, 255));
	      contentPane.setLayout(null);
	      setContentPane(contentPane);
	      
	      

			JLabel lblNewLabel1 = new JLabel("\uACFC\uBAA9 List");
			lblNewLabel1.setIcon(new ImageIcon("Resource/UI5_Banner_Todo.png"));
			lblNewLabel1.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 25));
			//lblNewLabel.setForeground(new Color(128, 128, 128));
			lblNewLabel1.setBounds(0, 0, 500, 55);
			contentPane.add(lblNewLabel1);
	      
	      //할일 명 레이블
	      JLabel lblTodo = new JLabel("TODO\uBA85");
	      lblTodo.setForeground(new Color(128, 128, 128));
	      lblTodo.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      lblTodo.setBounds(14, 90, 112, 32);
	      contentPane.add(lblTodo);
	      
	      //할일 명 텍스트 필드
	      textField_1 = new JTextField();
	      textField_1.setBounds(133, 90, 116, 32);
	      contentPane.add(textField_1);
	      textField_1.setColumns(10);	      
	      
	      //과목 선택 레이블
	      JLabel label = new JLabel("\uACFC\uBAA9 \uC120\uD0DD");
	      label.setForeground(new Color(128, 128, 128));
	      label.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label.setBounds(14, 140, 112, 32);
	      contentPane.add(label);
	      
	      //과목 선택 콤보 박스
	      JComboBox comboBox = new JComboBox();
	      comboBox.setBounds(133, 140, 119, 32);
	      contentPane.add(comboBox);
	      comboBox.addItem(" ");
	      
	      //파일 읽고 콤보 박스에 출력
	      File data = new File("data.dt");
	      BufferedReader in = new BufferedReader(new FileReader(data));
	      String s;
	      String s1;
	      while ((s = in.readLine()) != null) {
	         s1 = "";
	         for(int i=6;i<s.length();i++){
	            if(s.charAt(i+1)=='<' && s.charAt(i+2)=='b' && s.charAt(i+3)=='r'&&s.charAt(i+4)=='>'){
	               break;
	            }
	            s1 = s1 + s.charAt(i+1);
	         }
	         comboBox.addItem(s1);
	      }
	      in.close();
	      
	      
	      
	      
	      //마감 기한 레이블
	      JLabel label_1 = new JLabel("\uB9C8\uAC10 \uAE30\uD55C");
	      label_1.setForeground(new Color(128, 128, 128));
	      label_1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label_1.setBounds(14, 200, 112, 32);
	      contentPane.add(label_1);
	      
	      //마감기한 1번 콤보박스(번호 대신에 무엇이 들어가는지 알아서 주석 수정 할 것)
	      JComboBox comboBox_1 = new JComboBox();
	      for(int i = 1; i<13;i++){
	         comboBox_1.addItem(i);
	      }
	      comboBox_1.setBounds(133, 200, 59, 31);
	      contentPane.add(comboBox_1);
	      
	      //월
	      JLabel month = new JLabel("\uC6D4");
	      month.setForeground(new Color(128, 128, 128));
	      month.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      month.setBounds(195, 200, 30, 30);
	      contentPane.add(month);
	            
	      //마감 기한 2번 콤보박스
	      JComboBox comboBox_2 = new JComboBox();
	      GregorianCalendar cal = new GregorianCalendar();
	      for(int i=1;i<= cal.getActualMaximum(cal.DAY_OF_MONTH);i++){
	         comboBox_2.addItem(i);
	      }
	      comboBox_2.setBounds(222, 200, 59, 31);
	      contentPane.add(comboBox_2);
	      
	      //일
	      JLabel day = new JLabel("\uC77C");
	      day.setForeground(new Color(128, 128, 128));
	      day.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      day.setBounds(284, 200, 30, 30);
	      contentPane.add(day);
	      
	      //마감 기한 3번 콤보박스
	      JComboBox comboBox_7 = new JComboBox();
	      comboBox_7.setBounds(311, 200, 59, 31);
	      for(int i = 0;i<24;i++){
	         comboBox_7.addItem(i);
	      }
	      contentPane.add(comboBox_7);
	      
	      //시
	      JLabel hour = new JLabel("\uC2DC");
	      hour.setForeground(new Color(128, 128, 128));
	      hour.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      hour.setBounds(373, 200, 30, 30);
	      contentPane.add(hour);
	            
	            
	            
	      
	      
	      
	      //실제 마감일 레이블
	      JLabel label_2 = new JLabel("\uC2E4\uC81C\uB9C8\uAC10\uC77C");
	      label_2.setForeground(new Color(128, 128, 128));
	      label_2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label_2.setBounds(14, 270, 125, 32);
	      contentPane.add(label_2);
	      
	      //실제마감일  1번 콤보박스(번호 대신에 무엇이 들어가는지 알아서 주석 수정 할 것)
	      JComboBox comboBox_3 = new JComboBox();
	      for(int i = 1; i<13;i++){
	         comboBox_3.addItem(i);
	      }
	      comboBox_3.setBounds(133, 270, 59, 31);
	      contentPane.add(comboBox_3);
	      
	      //월
	      JLabel month1 = new JLabel("\uC6D4");
	      month1.setForeground(new Color(128, 128, 128));
	      month1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      month1.setBounds(195, 270, 30, 30);
	      contentPane.add(month1);
	               
	      //실제 마감일 2번 콤보박스
	      JComboBox comboBox_4 = new JComboBox();
	      comboBox_4.setBounds(222, 270, 59, 31);
	      for(int i=1;i<= cal.getActualMaximum(cal.DAY_OF_MONTH);i++){
	         comboBox_4.addItem(i);
	      }
	      contentPane.add(comboBox_4);
	      
	      //일
	      JLabel day1 = new JLabel("\uC77C");
	      day1.setForeground(new Color(128, 128, 128));
	      day1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      day1.setBounds(284, 270, 30, 30);
	      contentPane.add(day1);
	      
	      //실제 마감일 3번 콤보박스
	      JComboBox comboBox_8 = new JComboBox();
	      comboBox_8.setBounds(311, 270, 59, 31);
	      for(int i = 0;i<24;i++){
	         comboBox_8.addItem(i);
	      }
	      contentPane.add(comboBox_8);
	      
	      //시
	      JLabel hour1 = new JLabel("\uC2DC");
	      hour1.setForeground(new Color(128, 128, 128));
	      hour1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      hour1.setBounds(373, 270, 30, 30);
	      contentPane.add(hour1);
	      
	   
	      
	      
	      
	      //알림 기능 레이블
	      JLabel label_3 = new JLabel("\uC54C\uB9BC \uAE30\uB2A5");
	      label_3.setForeground(new Color(128, 128, 128));
	      label_3.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label_3.setBounds(14, 340, 112, 32);
	      contentPane.add(label_3);
	      
	      //알림기능  1번 콤보박스(번호 대신에 무엇이 들어가는지 알아서 주석 수정 할 것)
	      JComboBox comboBox_5 = new JComboBox();
	      for(int i = 0; i<13;i++){
	         comboBox_5.addItem(i);
	      }
	      comboBox_5.setBounds(133, 340, 59, 31);
	      contentPane.add(comboBox_5);
	         
	      //월
	      JLabel month2 = new JLabel("\uC6D4");
	      month2.setForeground(new Color(128, 128, 128));
	      month2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      month2.setBounds(195, 340, 30, 30);
	      contentPane.add(month2);
	               
	      //알림기능 2번 콤보박스
	      JComboBox comboBox_6 = new JComboBox();
	      comboBox_6.setBounds(222, 340, 59, 31);
	      for(int i=0;i<= cal.getActualMaximum(cal.DAY_OF_MONTH);i++){
	         comboBox_6.addItem(i);
	      }
	      contentPane.add(comboBox_6);
	      
	      //일
	      JLabel day2 = new JLabel("\uC77C");
	      day2.setForeground(new Color(128, 128, 128));
	      day2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      day2.setBounds(284, 340, 30, 30);
	      contentPane.add(day2);
	         
	      //알림기능 3번 콤보박스
	      JComboBox comboBox_9 = new JComboBox();
	      comboBox_9.setBounds(311, 340, 59, 31);
	      for(int i = 0;i<24;i++){
	         comboBox_9.addItem(i);
	      }
	      contentPane.add(comboBox_9);
	         
	      //시
	      JLabel hour2 = new JLabel("\uC2DC");
	      hour2.setForeground(new Color(128, 128, 128));
	      hour2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      hour2.setBounds(373, 340, 30, 30);
	      contentPane.add(hour2);
	      
	            
	            
	            
	            
	            
	      //세부 사항 레이블
	      JLabel label_4 = new JLabel("\uC138\uBD80 \uC0AC\uD56D");
	      label_4.setForeground(new Color(128, 128, 128));
	      label_4.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label_4.setBounds(14, 413, 112, 32);
	      contentPane.add(label_4);
	      
	      //세부사항 텍스트 입력창
	      textField = new JTextField();
	      textField.setBounds(133, 405, 270, 54);
	      contentPane.add(textField);
	      textField.setColumns(10);
	      
	      
	      
	      
	      
	      //완료여부 레이블
	      JLabel label_5 = new JLabel("\uC644\uB8CC \uC5EC\uBD80");
	      label_5.setForeground(new Color(128, 128, 128));
	      label_5.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label_5.setBounds(14, 486, 112, 32);
	      contentPane.add(label_5);
	      
	      //완료여부 체크박스
	      JCheckBox chckbxNewCheckBox = new JCheckBox("");
	      chckbxNewCheckBox.setForeground(new Color(240, 255, 240));
	      chckbxNewCheckBox.setBounds(133, 486, 25, 27);
	      contentPane.add(chckbxNewCheckBox);
	            
	           
	            
	      
	      //중요여부 레이블
	      JLabel label_6 = new JLabel("\uC911\uC694 \uC5EC\uBD80");
	      label_6.setForeground(Color.GRAY);
	      label_6.setFont(new Font("맑은 고딕", Font.BOLD, 21));
	      label_6.setBounds(186, 486, 96, 32);
	      contentPane.add(label_6);
	      
	   
	      
	      JComboBox comboBox_10 = new JComboBox();
	      comboBox_10.setBounds(295, 489, 80, 32);
	      comboBox_10.addItem("上");
	      comboBox_10.addItem("中");
	      comboBox_10.addItem("下");
	      contentPane.add(comboBox_10);
	      
	      
	      //확인 버튼
	      JButton button = new JButton();
	      button.setIcon(new ImageIcon("Resource/UI3_Button_Save.png"));
	      button.setForeground(Color.BLACK);
	      button.setBackground(Color.WHITE);
	      button.setBounds (66, 650, 135, 70);
	      contentPane.add(button);
	      button.addActionListener(new ActionListener() {//버튼 클릭시 수행 동작
	         public void actionPerformed(ActionEvent e) {
	            try {
	               File data = new File("datatd.dt");
	               File alarm = new File("alarmtime.dt");
	               FileWriter fw = new FileWriter(data, true);
	               FileWriter fw2 = new FileWriter(alarm, true);
	               if(textField_1.getText()!=null){
	                  fw.write(" <html>");
	                  fw.write(textField_1.getText());
	                  fw.write("::");
	               }
	               if(comboBox.getSelectedItem().toString() != null){
	                  fw.write(comboBox.getSelectedItem().toString());
	               }
	               if(comboBox_1.getSelectedItem().toString() != null){
	                  fw.write("<br>마감기한 : ");
	                  fw.write(comboBox_1.getSelectedItem().toString());
	               }
	               if(comboBox_2.getSelectedItem().toString() != null){
	                  fw.write("월 ");
	                  fw.write(comboBox_2.getSelectedItem().toString());
	               }
	               if(comboBox_7.getSelectedItem().toString() != null){
	                  fw.write("일 ");
	                  fw.write(comboBox_7.getSelectedItem().toString());
	                  fw.write("시::");
	               }
	               if(comboBox_3.getSelectedItem().toString() != null){
	                  fw.write("실제 마감일 : ");
	                  fw.write(comboBox_3.getSelectedItem().toString());
	               }
	               if(comboBox_4.getSelectedItem().toString() != null){
	                  fw.write("월 ");
	                  fw.write(comboBox_4.getSelectedItem().toString());
	               }
	               if(comboBox_8.getSelectedItem().toString() != null){
	                  fw.write("일 ");
	                  fw.write(comboBox_8.getSelectedItem().toString());
	                  fw.write("시<br>");
	               }
	               if(comboBox_5.getSelectedItem().toString().equals("0")&&comboBox_6.getSelectedItem().toString().equals("0")){
	                  fw.write("알림 꺼짐::");
	               }
	               else{
	                  if(!(comboBox_5.getSelectedItem().toString().equals("0"))){
	                     fw.write("알림 시간 : ");
	                     fw.write(comboBox_5.getSelectedItem().toString());
	                     fw2.write(comboBox_5.getSelectedItem().toString()+"\t");
	                  }
	                  if(!(comboBox_6.getSelectedItem().toString().equals("0"))){
	                     fw.write("월 ");
	                     fw.write(comboBox_6.getSelectedItem().toString());
	                     fw2.write(comboBox_6.getSelectedItem().toString()+"\t");
	                     fw.write("일 ");
	                     fw.write(comboBox_9.getSelectedItem().toString());
	                     fw2.write(comboBox_9.getSelectedItem().toString()+"\t");
	                     fw.write("시::");
	                  }
	               }
	               if(chckbxNewCheckBox.isSelected()){
	                  fw.write("완료::");
	                  fw.write(comboBox_10.getSelectedItem().toString()+":::");
	               }
	               else{
	                  fw.write("진행중::");
	                  fw.write(comboBox_10.getSelectedItem().toString()+":::");
	               }
	               fw.write(textField.getText());
	               fw.write("</html>");
	               fw.write("\n");
	               fw.flush();
	               fw2.write("\n");
	               fw2.flush();
	            } catch (IOException e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	            try {
	               Mainframe ma = new Mainframe();
	               ma.setVisible(true);
	               dispose();//창닫기
	            } catch (IOException e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	           
	         }
	      });
	      
			JButton btnNewButton2 = new JButton();
			btnNewButton2.setForeground(new Color(0, 0, 0));
			btnNewButton2.setBackground(new Color(255, 255, 255));
			btnNewButton2.setIcon(new ImageIcon("resource/UI3_Button_Cancel.png"));
			btnNewButton2.setBounds(300, 650, 135, 70);
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
