package dz_15_04_06_assistant;

public class Sleeper extends Thread {
	
	public static interface OnWakeUpListener {
		public void onWakeUp(Object o);
	}
	
	private Object objToNotify;
	private long interval;
	private OnWakeUpListener myListener;
	
	public Sleeper(Object notifyWho, long interval, OnWakeUpListener listener) {
		this.objToNotify = notifyWho;
		this.interval = interval;
		myListener = listener; 
	}
	
	@Override
	public void run() {
		try {
			sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		myListener.onWakeUp(objToNotify);		
	}

}
