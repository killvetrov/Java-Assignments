package dz_15_04_06_assistant;

public interface ChatEventsListener {
	
	public abstract void onEnterChat(Chat chatToEnter);
	public abstract void onLeaveChat(Chat chatToLeave);
	public abstract void onNewChatter(Chat chatWithNewChatter, Chatter newChatter);
	public abstract void onChatterLeft(Chat chatMinusOneChatter, Chatter chatterWhoLeft);
	public abstract void onNewMessage(Chat chatToReply, Message message);

}
