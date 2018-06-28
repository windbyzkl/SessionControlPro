package SessionControlPro.control;

import java.util.*;


public class HttpBody {
	private int deliverySessionId;
	private Action action;
	private long startTime;
	private long endTime;
	private static Map map=new HashMap();
	public HttpBody(int deliverySessionId){
		setDeliverySessionId(deliverySessionId);
		setStartTime(System.currentTimeMillis());
		this.action=new Action(startTime,deliverySessionId);
		map.put(new Integer(deliverySessionId), this.action);
		action.setMap(map);
	}
	@Override
	public String toString() {
		return "HttpBody [deliverySessionId=" + deliverySessionId
				+ ", endTime=" + (startTime+1000) + ", startTime=" + startTime + "] is started";
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getDeliverySessionId() {
		return deliverySessionId;
	}
	public void setDeliverySessionId(int deliverySessionId) {
		this.deliverySessionId = deliverySessionId;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}
