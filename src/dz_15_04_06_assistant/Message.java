package dz_15_04_06_assistant;

public class Message {
	
	private String text;
	private long timestamp;
	private Chatter sender;
	
	public Message() {};
	
	public Message(Message m) {
		this.text = m.text;
		this.timestamp = m.timestamp;
		this.sender = m.sender;
	}
	
	public Message(String text, Chatter sender) {
		this.text = text;
		this.timestamp = System.currentTimeMillis();
		this.sender = sender;
	}
	
	public String getText() {
		return text;
	}
		
	public Chatter getSender() {
		return sender;
	}
	
	@Override
	public String toString() {
		return String.format("[%tR] %s: %s", timestamp, sender.getName(), text);
	}
	
	@Override
	public boolean equals(Object obj) {
		return text.equals(obj);
	}

}
