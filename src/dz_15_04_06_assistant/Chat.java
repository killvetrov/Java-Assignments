package dz_15_04_06_assistant;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Vector;

public class Chat extends Thread {
	
	private Vector<Chatter> chatters;
	private static Calendar cal = Calendar.getInstance();
	
	private LinkedList<Message> messages = new LinkedList<Message>();
	private LinkedList<Message> log = new LinkedList<Message>();
	
	public enum State {
		NEW,
		EMPTY_CHAT,
		WAITING_FOR_CHATTER_ACTIVITY,
		NEW_MESSAGES,
		QUIT
	}
	
	private State _state;
	private int idleSeconds = 0;
	
	private static long _msToSleep = 1000;
	private static Runnable asyncSleeper = new Runnable() {
		public void run() {
			try {
				Thread.sleep(_msToSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	};
	
	public Chat() {
		super("Chat Thread");		
		chatters = new Vector<Chatter>();		
		
		_state = State.NEW;
	}
	
	public synchronized void join(Chatter joiningChatter) {
		
		if (chatters.contains(joiningChatter)) {
			System.out.println("------- " + joiningChatter.getName() + " пытается подключиться повторно.");
			return;
		}
		
		if (chatters.add(joiningChatter)) {
			System.out.printf("[ + 1 ] %s вошел в чат в %s. Участников беседы: %s.%n", 
					joiningChatter.getName(), _timestamp(), chattersCount());
			
			notify();			
			
			new Thread(joiningChatter).start();
			joiningChatter.onEnterChat(this);
			
			
			
//			for (Chatter chttr : chatters)
//				if (!chttr.equals(joiningChatter))					
//					chttr.onNewChatter(this, joiningChatter);
			
		}
	}
	
	public synchronized void leave(Chatter leavingChatter) {
		
		if (chatters.remove(leavingChatter)) {
			leavingChatter.onLeaveChat(this);
			System.out.printf("[ - 1 ] %s вышел из чата в %s. Участников беседы: %s.%n", 
					leavingChatter.getName(), _timestamp(), chattersCount());			
			
			for (Chatter chttr : chatters)
				if (!chttr.equals(leavingChatter))
					chttr.onChatterLeft(this, leavingChatter);
			
			notify();
		}
	}
	
	public int chattersCount() {
		return chatters.size();
	}
	
	public synchronized void sendMessage(Chatter sender, String message) {
		
//		_msToSleep = 1333;
//		Thread sleeper = new Thread(asyncSleeper);
//		sleeper.start();
//		try {
//			sleeper.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Message incoming = new Message(message, sender);
		messages.add(incoming);
		log.add(incoming);
		
//		System.out.printf("[%s] %s говорит: %s%n", 
//				_timestamp(), sender.getName(), message);
		
		notify();
		
//		for (Chatter chttr : chatters) 
//			if (!chttr.equals(sender)) {
//				chttr.onNewMessage(this, message);
//				//System.out.println("-- итератор для " + chttr.getName());
//			}
//		
	}
	
	private static String _timestamp() {		
		cal.setTimeInMillis(System.currentTimeMillis());;
		return String.format("%d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
	}
	
	private synchronized void _updateState() {
		if (_state == State.QUIT) {			
			return;
		}
		
		if (chatters.size() == 0) {
			_state = State.EMPTY_CHAT;
		} else if (chatters.size() > 0) {
			_state = messages.isEmpty() ? State.WAITING_FOR_CHATTER_ACTIVITY : State.NEW_MESSAGES;
		}
		
		//System.out.println("Статус чата обновлен: " + _state);
		notify();
	}
	
	public synchronized void quit() {
		_state = State.QUIT;
		notify();
	}
	
	public synchronized void printLog() {
		for (Message m : log)
			System.out.println(m);
	}
	
	@Override
	public void run() {
		
		synchronized (this) {		

			while (_state != State.QUIT) {

				switch (_state) {

				case EMPTY_CHAT:
					//System.out.println("В чате пока пусто. Ожидание подключения пользователей...");
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;

				case WAITING_FOR_CHATTER_ACTIVITY:
					//System.out.println("Ожидание активности пользователей...");
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
					
				case NEW_MESSAGES:					
					while (!messages.isEmpty()) {
						Message m = messages.removeFirst();
						System.out.println(m);
											
						Vector<Chatter> chattersToNotify = new Vector<Chatter>();
						for (Chatter chttr : chatters)							
							if (!chttr.equals(m.getSender())) {
								chattersToNotify.add(chttr);
								//System.out.println("-- итератор для " + chttr.getName());
							}
						
						for (Chatter chttr : chattersToNotify)
							chttr.onNewMessage(this, m);
					}					
					break;
				
				case NEW:
					System.out.printf("[старт] Чат начался %s в %s.%n",
							DateFormat.getDateInstance(DateFormat.LONG).format(System.currentTimeMillis()),
							DateFormat.getTimeInstance().format(System.currentTimeMillis())
							);
					break;
				
				case QUIT:
					break;
				
				default:
					break;					
				}			
				
				_updateState();

			}

		}
		
		for (Chatter chttr : chatters)
			chttr.onLeaveChat(this);
		
		System.out.printf("[выход] Чат завершился %s в %s.%n",
				DateFormat.getDateInstance(DateFormat.LONG).format(System.currentTimeMillis()),
				DateFormat.getTimeInstance().format(System.currentTimeMillis())
				);
		
	}
	
	public static void main(String[] args) throws Exception {

		Chat myChat = new Chat();

		LocalUser lu1 = new LocalUser();
		//lu1.setName("1");
		LocalUser lu2 = new LocalUser();
		//lu2.setName("2");
		AssistantAI as1 = new AssistantAI();

		//myChat.join(lu1);
		//myChat.join(lu2);
		//myChat.join(as1);
		myChat.setPriority(MAX_PRIORITY);
		myChat.start();
		
		Thread sleeper = new Thread(asyncSleeper, "Sleeper1");
		_msToSleep = 2000;
		sleeper.start();
		sleeper.join();
		myChat.join(lu1);
		myChat.join(lu2);
		myChat.join(lu2);
		
		sleeper = new Thread(asyncSleeper, "Sleeper1");
		_msToSleep = 2000;
		sleeper.start();
		sleeper.join();
		myChat.join(as1);
		myChat.leave(lu1);
		
		sleeper = new Thread(asyncSleeper, "Sleeper2");
		_msToSleep = 27000;
		sleeper.start();
		sleeper.join();
		
		myChat.quit();

	}

}
