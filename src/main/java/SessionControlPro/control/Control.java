package SessionControlPro.control;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {
	private static Set set=new HashSet<HttpBody>();
	@RequestMapping("/helloworld")
    public String helloworld(String name) {
        if(name!=null){
        	return name;
        }
		return "helloworld"+System.currentTimeMillis();
    }
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
	    return "error:"+e.getMessage();
	}
	@RequestMapping("/nbi/deliverysession")
	public String start(int id){
		HttpBody body=new HttpBody(id);
		Thread thread=new Thread(body.getAction());
		thread.start();
		return body.toString();
	}
	@RequestMapping("/nbi/setLimitTime")
	public String setTime(int limitTime){
		Action.setLimitTime(limitTime);
		return "设置结束时间为"+limitTime;
	}
}
