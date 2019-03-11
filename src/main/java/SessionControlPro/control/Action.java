package SessionControlPro.control;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Action implements Runnable{
	private long time=0;
	private static int limitTime=10;
	private Integer id;
	private static Set set=new HashSet();
	private static Map map=new HashMap();
	private static PrintStream ps=null;
	private static File file=new File("log.log");
	private static FileOutputStream fos=null;
	private String url;
	public Action(long time,int id){
		this.time=time;
		this.id=new Integer(id);
		url="http://localhost:8080/nbi/deliverysession?id="+id+" ";
		System.out.print("SessionId "+id+" is started at ");
		write("SessionId "+id+" is started at "+soutTime(time));
	}
	public void setMap(Map map){
		this.map=map;
		this.set=map.keySet();
	}
	public static void setLimitTime(int limitTime){
		Action.limitTime=limitTime;
		Iterator it = set.iterator();
		while(it.hasNext()){
			Action act=(Action)map.get((Integer)it.next());
			act.setTime(System.currentTimeMillis());
			break;
		}	
	}
	public void setTime(long time){
		this.time=time;
		write("����ʱ��������"+limitTime+"�����");
	}
	public void stop(){
//		System.out.println(id+"is started at"+endTime);
		if(set.contains(this.id)){
			set.remove(id);
		}
		if(set.isEmpty()){
			System.out.println("�Ự������");
			write("�Ự������");
		}else{
			System.out.println("����"+set.size()+"������");
			write("����"+set.size()+"������");
		}
	}
	public void write(String str){
		try {
			fos=new FileOutputStream(file,true);
//			ps=new PrintStream(file);
//			ps.append(str);
			byte[] b=(url+str).getBytes();
			fos.write(b);
			fos.write("\r\n".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void run(){
		while(System.currentTimeMillis()-time<Action.limitTime*1000){
			String str="SessionId "+this.id+" is alived begin at "+soutTime(time);
			System.out.println(str);
			write(str);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("SessionId "+this.id+" is stoped at ");
		write("SessionId "+this.id+" is stoped now "+soutTime(System.currentTimeMillis()));
		stop();
	}
	public  String soutTime(long time){
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);//24Сʱ��
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		System.out.println(year + "��" + (month + 1) + "��" + day + "��"
				+ hour + "ʱ" + minute + "��" + second + "��");
		
		return year + "��" + (month + 1) + "��" + day + "��"
		+ hour + "ʱ" + minute + "��" + second + "��";
	}
}
