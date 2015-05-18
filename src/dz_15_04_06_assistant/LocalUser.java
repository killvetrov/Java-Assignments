package dz_15_04_06_assistant;

public class LocalUser extends Chatter {	
	
	@Override
	public void onEnterChat(Chat chatToEnter) {
		// TODO Auto-generated method stub
		//chatToEnter.sendMessage(this, "Всем привет!");
	}

	@Override
	public void onLeaveChat(Chat chatToLeave) {

		
	}

	@Override
	public void onNewMessage(Chat chatToReply, Message message) {

		
	}

	@Override
	public String nextReplica(Chat chatToTalk) {
		return null;
	}

	@Override
	public void onNewChatter(Chat chatWithNewChatter, Chatter newChatter) {
		
	}

	@Override
	public void onChatterLeft(Chat chatMinusOneChatter, Chatter chatterWhoLeft) {		

//			if (chatMinusOneChatter.chattersCount() < 2) {
//				chatMinusOneChatter.sendMessage(this, "Я в чате один :/");
//			}	
		
	}	

}
