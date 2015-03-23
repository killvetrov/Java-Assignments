package cw_15_03_23_timer;

public class Timer {

	private int interval;
	private int count = 1;
	private OnTimerTickListener myListener;

	public Timer() {
	};

	public Timer(int timerInterval, OnTimerTickListener timerListener) {
		interval = timerInterval;
		myListener = timerListener;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int newInterval) {
		interval = newInterval;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int newCount) {
		count = newCount;
	}

	public void start() {
		Thread waitingThread = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.currentThread().sleep(interval);
				} catch (InterruptedException e) {
				}
				
			}
		});

		for (int i = 0; i < count; i++) {
			waitingThread.run();
			try {
				waitingThread.join();
			} catch (Exception e) {
			}
			myListener.onTimerTick();

		}

	}

}
