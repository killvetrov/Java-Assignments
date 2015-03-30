package cw_15_03_23_timer;

public class Timer {

	public final static int TIMER_INFINITE = -1;

	private int interval;
	private int count = 1;
	private int tickCount = 0;
	private OnTimerTickListener myListener;

	private Runnable ticker = new Runnable() {
		public void run() {
			boolean interrupted = false;
			try {
				for (int i = count; i != 0;) {
					Thread.sleep(interval);
					tickCount++;
					myListener.onTimerTick(Timer.this);
					if (count > 0)
						i--;
				}
			} catch (InterruptedException e) {
				interrupted = true;
				//System.out.println("[STOP] " + Timer.this.toString());
			}

			//if (!interrupted)
				//System.out.println("[ELAPSED] " + Timer.this.toString());
		}
	};

	private Thread timerThread = new Thread(ticker);

	public Timer() {
	};

	public Timer(int timerInterval, OnTimerTickListener timerListener) {
		interval = timerInterval;
		myListener = timerListener;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int newInterval) throws IllegalArgumentException {
		if (newInterval < 1) {
			throw new IllegalArgumentException(
					"Timer interval can't be negative");
		}
		interval = newInterval;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int newCount) {
		count = newCount;
	}

	public int getTickCount() {
		return tickCount;
	}

	public void start() {
		if (timerThread.isAlive())
			return;

		tickCount = 0;
		//System.out.println("[START] " + this.toString());

		try {
			timerThread.start();
		} catch (IllegalThreadStateException alreadyStarted) {
			timerThread = new Thread(ticker);
			timerThread.start();
		}

	}

	public void setAlarm(int hour, int minute, int second) {
		final long MS_IN_SEC = 1000l;
		final long MS_IN_MIN = 60 * MS_IN_SEC;
		final long MS_IN_HOUR = 60 * MS_IN_MIN;
		final long MS_IN_DAY = 24 * MS_IN_HOUR;
		final long MS_IN_WEEK = 7 * MS_IN_DAY;

		if (timerThread.isAlive())
			return;

		long curTime = System.currentTimeMillis();
		curTime -= curTime % MS_IN_SEC;

		long curSec = (curTime % MS_IN_MIN) / 1000;
		long curMin = (curTime % MS_IN_HOUR) / MS_IN_MIN;
		long curHour = (curTime % MS_IN_DAY) / MS_IN_HOUR;

		long finishTime = curTime 
				+ (hour - curHour) * MS_IN_HOUR
				+ (minute - curMin) * MS_IN_MIN 
				+ (second - curSec) * MS_IN_SEC;

		interval = (int) (finishTime - curTime);
		count = 1;

		start();
	}

	public void stop() {
		if (timerThread.isAlive()) {
			timerThread.interrupt();
		}
	}

	public boolean isRunning() {
		return timerThread.isAlive();
	}

	@Override
	public String toString() {
		if (timerThread.isAlive())
			return String.format("%s ms timer (%s/%s ticks)", interval,
					tickCount, count > TIMER_INFINITE ? count : "infinite");
		else
			return String.format("%s ms timer (%s ticks)", interval,
					count > TIMER_INFINITE ? count : "infinite");
	}

}
