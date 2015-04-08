package dz_15_04_06_assistant;

public class Assistant extends Thread {	
	
	private AssistantListener myListener;
	
	public String answer;
	
	public Assistant(AssistantListener listener) {
		myListener = listener;
	}	
	
	@Override
	public synchronized void run() {
		do {
			//String answer = "";
			myListener.onAssistantQuestion("You there?");
						
			try {
				answer.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Answer received: " + answer);
			if (answer.equals("exit")) return;
			
		} while (true);	
	}

}
