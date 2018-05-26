import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class ToDoList extends JFrame {
	private JPanel contentPane;
	private JButton completeAskBtn;
	private JButton cancelAskBtn;
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
		setBounds(100, 100, 501, 489);
		
		//���̺� ����
		String header[]= {"�ϷῩ��","����","��������","��������","�߿䵵"};
		String contents[][] = {
				{"","�Ұ�","5/23","5/25","��"},
				{"","����","5/18","5/20","��"}
		};
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//�Է�â ����
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
		
		//��ư ����
		JButton enrollBtn = new JButton("���");
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
		
		JButton cancelBtn = new JButton("����");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1)
					return;
				else
					model.removeRow(table.getSelectedRow());
			}
		});
		
		JButton completeBtn = new JButton("�Ϸ�");
		completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getValueAt(table.getSelectedRow(), 0)== "V")
					table.setValueAt("", table.getSelectedRow(), 0);
				else
					table.setValueAt("V", table.getSelectedRow(), 0);
			}
		});

		JButton hideBtn = new JButton("�����");
		
		hideBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				int row = table.getRowCount();
				int column = table.getColumnCount();

				if(hideBtn.getText().equals("�����")) {
					hideBtn.setText("���̱�");
					
					for(int j=0;j<column;j++) {
						for(int i=0;i<row;i++) {
							if(table.getValueAt(i,0)=="V")
								table.setRowHeight(i,1);
							}
						}
					}
				
				else if(hideBtn.getText().equals("���̱�")) {
					hideBtn.setText("�����");
					
					for(int j=0;j<column;j++) {
						for(int i=0;i<row;i++) {
							if(table.getValueAt(i,0)=="V")
								table.setRowHeight(i,15);
							}
						}
					}
				}
			});

		panel.add(enrollBtn);
		panel.add(cancelBtn);
		panel.add(completeBtn);
		panel.add(hideBtn);
		
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
	}
}
