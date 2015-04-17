package dz_15_04_06_assistant;

import java.util.HashMap;

public abstract class Chatter implements ChatEventsListener, Runnable {
	
	private static HashMap<String, Integer> instanceCounter = new HashMap<String, Integer>();
	protected String name;
	
	public enum State {
		NEW,
		IDLE,
		ENTER_CHAT,
		LEAVE_CHAT,
		NEW_CHATTER,
		CHATTER_LEFT,
		NEW_MESSAGE,
		WAITING_FOR_REPLY
	}
	
	protected State _state;
	
	public Chatter() {
		instanceCounter.put(this.getClass().getSimpleName(), 
							instanceCounter.getOrDefault(this.getClass().getSimpleName(), 0) + 1);		
		this.name = this.getClass().getSimpleName() + instanceCounter.get(this.getClass().getSimpleName());
		
		_state = State.NEW;
	}
	
	public String getName() {
		return name;
	};
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String nextReplica(Chat chatToTalk);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
