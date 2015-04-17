package dz_15_04_06_assistant;

public class LocalUser extends Chatter {	
	
	@Override
	public void onEnterChat(Chat chatToEnter) {
		// TODO Auto-generated method stub
		chatToEnter.sendMessage(this, "Всем привет!");
	}

	@Override
	public void onLeaveChat(Chat chatToLeave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewMessage(Chat chatToReply, Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String nextReplica(Chat chatToTalk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onNewChatter(Chat chatWithNewChatter, Chatter newChatter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatterLeft(Chat chatMinusOneChatter, Chatter chatterWhoLeft) {
		// TODO Auto-generated method stub
		synchronized (chatMinusOneChatter) {		

			if (chatMinusOneChatter.chattersCount() < 2) {
				chatMinusOneChatter.sendMessage(this, "Я в чате один :/");
				//chatMinusOneChatter.leave(this);
			}	
		}
		
	}	

}
