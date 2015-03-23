package cw_15_03_23_threads;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Поток 1 начал работать");
		
		Thread main = Thread.currentThread();
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Поток 2 начал работать");
				try {
					Thread.currentThread().sleep(10000);
				} catch (Exception e) {};
				System.out.println("Поток 2 завершил работу");
			}
		}
		);
		
		thread2.start();
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Поток 1, итерация " + i);
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {};
		}
		
	}
	
}
