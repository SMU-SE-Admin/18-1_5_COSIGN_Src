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

public class ToDoList extends JFrame {
	private JPanel contentPane;
	String inputStr[] = new String[5];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDoList todolist = new ToDoList();
					todolist.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ToDoList() {
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		//테이블 구성
		String header[]= {"완료여부","할일","마감기한","실제마감","중요도"};
		String contents[][] = {
				{"","소공","5/23","5/25","상"},
				{"","구현","5/18","5/20","중"}
		};
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//입력창 구성
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
		
		JButton completeBtn = new JButton("완료");
		completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getValueAt(table.getSelectedRow(), 0)== "V")
					table.setValueAt("", table.getSelectedRow(), 0);
				else
					table.setValueAt("V", table.getSelectedRow(), 0);
			}
		});

		JButton hideBtn = new JButton("숨기기");
		hideBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				int row = table.getRowCount();

				if(hideBtn.getText().equals("숨기기")) {
					hideBtn.setText("보이기");
					
						for(int i=0;i<row;i++) {
							if(table.getValueAt(i,0)=="V")
								table.setRowHeight(i,1);
							}
						}
				
				else if(hideBtn.getText().equals("보이기")) {
					hideBtn.setText("숨기기");
					
						for(int i=0;i<row;i++) {
							if(table.getValueAt(i,0)=="V")
								table.setRowHeight(i,15);
							}
						}
				}
			});

		JButton comDelBtn = new JButton("완료삭제");
		comDelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getRowCount();

						for(int i=0;i<row;i++) {
							if(table.getValueAt(i,0)=="V")
								model.removeRow(i);
							}
						}
			});
		
		btnPanel.add(enrollBtn);
		btnPanel.add(removeBtn);
		btnPanel.add(completeBtn);
		btnPanel.add(hideBtn);
		btnPanel.add(comDelBtn);
		
		mainPanel.add(btnPanel);
		mainPanel.add(panel);
		
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		getContentPane().add(mainPanel, BorderLayout.SOUTH);
	}
}
