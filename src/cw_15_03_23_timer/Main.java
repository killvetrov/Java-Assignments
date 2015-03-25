package cw_15_03_23_timer;

public class Main implements OnTimerTickListener{
	
	static int i = 0;
	static int i2 = 0;
	
	static Timer myTimer = new Timer(1000, new Main());
	
	static Timer myTimer2 = new Timer(2000, new Main());
	
//	static Timer myTimer2 = new Timer(2000, new OnTimerTickListener() {
//		@Override
//		public void onTimerTick(Timer timer) {
//			System.out.println("I'm the second timer " + i2 + " timer1 running: " + myTimer.isRunning());
//			if (++i2 == 10) {
//				myTimer.start();
//			}
//			if (i2 == 20) {
//				myTimer2.stop();
//			}
//		}
//	});

	public static void main(String[] args) {
		
		myTimer.setCount(6);
		myTimer2.setCount(Timer.TIMER_INFINITE);
		
		myTimer.start();		
		myTimer2.start();
		System.out.println("Timers started. End of main thread.\n");
		
	}
	
	@Override
	public void onTimerTick(Timer timer) {		
		System.out.println("[TICK] " + timer.toString());		
		
//		if (++i == 2) {
//			timer.stop();			
//		}
	}

}
