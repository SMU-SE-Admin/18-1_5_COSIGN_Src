package cosign;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import cosign.*;

import javax.swing.border.*;

public class setAlarmDate extends JFrame {

	private JPanel contentPane;

	public setAlarmDate() {
		setBounds(100, 100, 426, 165);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		
		JLabel alramIMG = new JLabel("");
		alramIMG.setBounds(15, 30, 60, 60);
		alramIMG.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191830116.png"));
		
		contentPane.add(alramIMG);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setAlarmDate fr = new setAlarmDate();
					fr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}