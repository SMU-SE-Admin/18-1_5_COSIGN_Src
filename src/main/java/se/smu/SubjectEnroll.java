package todoex;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
 
public class SubjectEnroll
{
	// �ʿ��� �ʵ� ����
	//�۾� ������
	JFrame jFrame = new JFrame("���� ��� ȭ��");
	JDialog jDialog = new JDialog(jFrame, "JDialog Ÿ��Ʋ");
	JButton jButton = new JButton("Click");

	// GUI ���� ������
	public SubjectEnroll()
	{
		// ���̾�α׿� ��ư �߰�
		jDialog.add(jButton, "South");

		// �⺻ ������ ũ��� ���� ����
		jFrame.setSize(500, 800);
		jFrame.setVisible(true);
		//X��ư ������ ���α׷� ����
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���̾�α��� ũ��� ���� ����
		jDialog.setSize(100, 100);
		jDialog.setVisible(true);
		//��X��ư ������ ���̾�α׸� ����
		jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	

	public static void main(String[] args)
	{
		//����
		new SubjectEnroll();
	}

}
