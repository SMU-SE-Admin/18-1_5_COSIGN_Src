package se.smu;

// 특정 Todo의 마감일을 받아 현재 날짜로부터 남은 날을 계산해서 출력하는 객체
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
 	System.out.println("ToDo가" + date*-1 +"일 초과했습니다.");
 }
 else if (date >= 0)
 {
 	System.out.println("ToDo가" + date +"일 남았습니다.");
 }
	}
	
}