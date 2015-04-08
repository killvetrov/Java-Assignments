package dz_15_04_06_assistant;

import java.util.Random;

public class AssistantMain implements AssistantListener {
	
	static final String CSI = "\u001B[";
	static Random rnd = new Random();
	static Assistant myAssistant = new Assistant(new AssistantMain());
	
	public static void main(String[] args) {		
		
		//System.out.print(CSI + "2J");
		
		
		
		myAssistant.start();	
		
	}

	@Override
	public void onAssistantReply(String reply) {
		
	}

	@Override
	public synchronized void onAssistantQuestion(String question) {
		System.out.println(question);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		myAssistant.answer = "exit";
		myAssistant.answer.notify();	
		
	}
	
	

}
