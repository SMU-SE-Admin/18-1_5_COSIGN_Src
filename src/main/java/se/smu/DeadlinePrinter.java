package se.smu;

// Ư�� Todo�� �������� �޾� ���� ��¥�κ��� ���� ���� ����ؼ� ����ϴ� ��ü
public class DeadlinePrinter { 
	
	Calendar rNow = Calendar.getInstance();
	int rYear = rNow.get(Calendar.YEAR);
	int rMonth = rNow.get(Calendar.MONTH);
	int rDate = rNow.get(Calendar.DATE);
	
	Calendar cal = Calendar.getInstance(); 
    cal.set(Calendar.DATE, ExampleToDo.Deadline_Date); 
    cal.set(Calendar.MONTH, ExampleToDo.Deadline_Month); 
    cal.set(Calendar.YEAR, ExampleToDo.Deadline_Year);
	
    long difference = cal.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
    long date = difference/(1000 * 60 * 60 * 24);
	
 public DeadlinePrinter ( long arg )
	{
		date = arg;

 if (date < 0)
 {
 	System.out.println("ToDo��" + date*-1 +"�� �ʰ��߽��ϴ�.");
 }
 else if (date >= 0)
 {
 	System.out.println("ToDo��" + date +"�� ���ҽ��ϴ�.");
 }
	}
	
}