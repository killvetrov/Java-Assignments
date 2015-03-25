package cw_15_03_23_timer;

public class Main implements OnTimerTickListener {

	static int i = 0;
	static int i2 = 0;

	static Timer myTimer = new Timer(1000, new Main());

	// static Timer myTimer2 = new Timer(2000, new Main());

	static Timer myTimer2 = new Timer(2000, new OnTimerTickListener() {
		@Override
		public void onTimerTick(Timer timer) {
			System.out.println("[tick] " + timer.toString());
			if (++i2 == 2) {
				myTimer.stop();
			}
			if (i2 == 10) {
				myTimer2.stop();
			}
		}
	});

	public static void main(String[] args) {

		myTimer.setInterval(5);
		myTimer.setAlarm(18, 53, 20);

		// myTimer.setCount(6);
		myTimer2.setCount(Timer.TIMER_INFINITE);
		myTimer2.start();
		//
		// myTimer.start();
		// myTimer2.start();
		// System.out.println("Timers started. End of main thread.\n");

	}

	@Override
	public void onTimerTick(Timer timer) {
		System.out.println("[tick] " + timer.toString());

		// if (++i == 2) {
		// timer.stop();
		// }
	}

}
