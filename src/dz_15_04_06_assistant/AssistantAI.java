package dz_15_04_06_assistant;

import dz_15_04_06_assistant.AssistantMain.InputContainer;

public class AssistantAI extends Chatter implements Runnable {
	
	Chat myChat;
	
	public AssistantAI() {
		super();
	};
	
	private synchronized void updateState() {
		if (_state == State.LEAVE_CHAT) {
			return;
		}
		
		_state = State.IDLE;
		
		notify();
	}	
	
	@Override
	public void run() {		
		
		synchronized (this) {
			
			while (_state != State.LEAVE_CHAT) {
				switch (_state) {
				case CHATTER_LEFT:
					break;
				case ENTER_CHAT:
					myChat.sendMessage(this, "Всем привет!");
					_state = State.IDLE;
					break;
				case IDLE:					
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				case LEAVE_CHAT:
					break;
				case NEW:
					_state = State.IDLE;
					break;
				case NEW_CHATTER:
					break;
				case NEW_MESSAGE:
					myChat.sendMessage(this, "Есть живые!");
					_state = State.IDLE;
					break;
				default:
					break;
				
				}
				
				//updateState();
			}
			
		}
		
	}

	@Override
	public void onEnterChat(Chat chatToEnter) {
		synchronized (this) {		
			myChat = chatToEnter;
			_state = State.ENTER_CHAT;
			notify();
		}
	}

	@Override
	public void onLeaveChat(Chat chatToLeave) {
		synchronized (this) {
			_state = State.LEAVE_CHAT;
			notify();
		}	
	}

	@Override
	public void onNewChatter(Chat chatWithNewChatter, Chatter newChatter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatterLeft(Chat chatMinusOneChatter, Chatter chatterWhoLeft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewMessage(Chat chatToReply, Message message) {
		// TODO Auto-generated method stub
		synchronized (this) {			
			_state = State.NEW_MESSAGE;
			notify();
		}		
	}

	@Override
	public String nextReplica(Chat chatToTalk) {
		// TODO Auto-generated method stub
		return null;
	}

}
