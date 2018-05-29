package todoex;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

public class Subject extends JFrame {
	private JPanel contentPane;
	String inputStr[] = new String[5];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subject subject = new Subject();
					subject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Subject() {
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		String header[]= {"과목이름","담당교수님","수강요일","수업시간","수강연도","수강학기"}; 
		String contents[][] = {
				{"소프트웨어공학","한혁수","월요일","15시","2018","1"},
				{"이산수학","이석필","화요일","14시","2018","1"}
		};
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//패널 구성
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTextField complete = new JTextField(6);
		JTextField todo = new JTextField(6);
		JTextField deadline = new JTextField(6);
		JTextField realDL = new JTextField(6);
		JTextField importance = new JTextField(6);
		
		complete.setEnabled(false);
		
		panel.add(complete);
		panel.add(todo);
		panel.add(deadline);
		panel.add(realDL);
		panel.add(importance);
		
		//버튼 구성
				JPanel btnPanel = new JPanel();
				btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
				
				JButton enrollBtn = new JButton("등록");
				enrollBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						inputStr[1] = todo.getText();
						inputStr[2] = deadline.getText();
						inputStr[3] = realDL.getText();
						inputStr[4] = importance.getText();
						model.addRow(inputStr);
						
						complete.setText("");
						todo.setText("");
						deadline.setText("");
						realDL.setText("");
						importance.setText("");
						}
					});
				
				JButton removeBtn = new JButton("삭제");
				removeBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(table.getSelectedRow()==-1)
							return;
						else
							model.removeRow(table.getSelectedRow());
					}
				});
				
				btnPanel.add(enrollBtn);
				btnPanel.add(removeBtn);
				
				mainPanel.add(btnPanel);
				mainPanel.add(panel);
				
				getContentPane().add(scrollpane, BorderLayout.CENTER);
				getContentPane().add(mainPanel, BorderLayout.SOUTH);
	}
}