package dz_15_04_06_assistant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class AssistantAI extends Chatter {
	
	private static Random rnd = new Random();
	
	final private static String DATA_DIR = "data";
	
	private HashMap<String, ArrayList<String>> conversationMap = 
			new HashMap<String, ArrayList<String>>();
	
	Chat myChat;
	
	Message curMsg;
	
	public AssistantAI() {
		super();
		this.setName("ИИ");
		
		try {
			loadConversationMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	private void loadConversationMap() throws IOException {
		//File dataFile = new File(DATA_DIR + "/assistant.txt");
		BufferedReader br = new BufferedReader(new FileReader(DATA_DIR + "/assistant.txt"));
		String line, currentCategory;
		int iline = 0;
		currentCategory = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();			
			if ( !line.isEmpty() ) {
				if (iline % 2 == 0) {
					currentCategory = line;
					conversationMap.put(currentCategory, new ArrayList<String>(10));
				} else {
					int pos = 0;
					int nextSemicolonPos = line.indexOf(";");
					if (nextSemicolonPos == -1)
						conversationMap.get(currentCategory).add(line);
					while ( pos < line.length() ) {
						if (nextSemicolonPos != -1) {
							conversationMap.get(currentCategory).add(line.substring(pos, nextSemicolonPos));
							pos = nextSemicolonPos + 1;
						} else {
							conversationMap.get(currentCategory).add(line.substring(pos));
							pos = line.length();
						}						
						nextSemicolonPos = line.indexOf(";", nextSemicolonPos + 1);
					}					
				}
					
				iline++; 
			}  
		}
		br.close();			
	}
	
	private String getConversationLine(String msg) {
		ArrayList<StringBuffer> words = new ArrayList<StringBuffer>();
		
		int spos = 0;
		boolean nextWord = false;
		StringBuffer strbuf = new StringBuffer();
		while (spos < msg.length()) {
			
			if (msg.charAt(spos) == ' ' || msg.charAt(spos) == ','
					|| msg.charAt(spos) == '.' || msg.charAt(spos) == '!'
					|| msg.charAt(spos) == '?') {
				if (!nextWord)
					nextWord = true;
				else {
					spos++;
					continue;
				}
			} else {
				strbuf.append(msg.charAt(spos));
			}
			
			if (nextWord || spos == msg.length() - 1) {
				words.add(strbuf);
				strbuf = new StringBuffer();
				nextWord = false;
			}
			
			spos++;			
		}		
		
		String detectedKey = "default";
		boolean keyFound = false;
		for ( String key : conversationMap.keySet() ) {
			for ( StringBuffer word : words) {
				if (word.length() == 0) continue;
				if (conversationMap.get(key).contains(word.toString())) {
					detectedKey = key;
					keyFound = true;
					break;
				}
			}	
			if (keyFound) break;		
		}
		
		return conversationMap.get(detectedKey).get(rnd.nextInt(conversationMap.get(detectedKey).size()));
		
	}

	
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
					//myChat.sendMessage(this, "Всем привет!");
					myChat.sendMessage(this, Arrays.toString(conversationMap.entrySet().toArray()));
					_state = State.IDLE;
					break;
				case IDLE:					
					try {
						wait(15000);
						if (_state == State.IDLE)
						myChat.sendMessage(this, "хрен вас дождешься!");
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
					myChat.sendMessage(this, getConversationLine(curMsg.getText()));					
					
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
			curMsg = message;
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
