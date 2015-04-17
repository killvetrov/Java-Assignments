package dz_15_04_06_assistant;

import java.util.Random;

public class AssistantMain implements AssistantListener {
	
	static final String CSI = "\u001B[";
	static Random rnd = new Random();
	public static InputContainer myInput = new InputContainer();
	static AssistantAI myAssistant = new AssistantAI();
	
	//StringBui
	
	public static void main(String[] args) throws Exception {		
		
		//System.out.print(CSI + "2J");

		myInput.input = "Provokator";
		//myAssistant.start();
				
		synchronized (myInput) {
			myInput.wait();
		}
		
		myInput.input = "Hello there!";
		synchronized (myInput) {
			//myInput.wait();
			
			myInput.notify();
		}
		
		//myInput.wait();
		
		Thread.sleep(4000);
		
		synchronized (myInput) {
			myInput.input = "exit";
			myInput.notify();
		}
		
	}

	@Override
	public void onAssistantReply(String reply) {
		
	}

	@Override
	public void onAssistantQuestion(String question) {
//		System.out.println(question);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		
//		myAssistant.answer = "exit";
//		synchronized (myAssistant.answer) {
//			
//		myAssistant.answer.notify();
//		}
		
	}
	
	static class InputContainer {
		public String input;
	}

}
