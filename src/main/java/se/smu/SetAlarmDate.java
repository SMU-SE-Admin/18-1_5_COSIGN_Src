package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.GregorianCalendar; 
import java.util.Locale;


public class SetAlarmDate extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

		// 특정 Todo에 마감일 Data를 입력받아 저장하는 객체
	public static void main(String[] args) {
		
		TodoData ExampleToDo = new TodoData(0,0,0); 
		// ToDo에 설정된 예시 마감일
		CallDeadLine ExampleCall = new CallDeadLine(ExampleToDo.Deadline_Year,ExampleToDo.Deadline_Month,ExampleToDo.Deadline_Date);
	    DeadlinePrinter ExampleDeadLine = new DeadlinePrinter(date);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetAlarmDate frame = new SetAlarmDate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// UI 설정 파트
	public SetAlarmDate() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 236, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 236, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(305, 236, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
	// 알람 데이터 버튼 입력 파트
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBounds(387, 235, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExampleToDo.Deadline_Year = textField.getText();
				ExampleToDo.Deadline_Month = textField_1.getText();
				ExampleToDo.Deadline_Date = textField_2.getText();
			}
		}
		contentPane.add(btnNewButton);
	}
}
