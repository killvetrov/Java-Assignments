package cw_15_03_23_timer;

public class Main implements OnTimerTickListener{

	public static void main(String[] args) {
		
		Timer myTimer = new Timer(1000, new Main());
		
		myTimer.setCount(4);
		
		myTimer.start();
		
	}
	
	@Override
	public void onTimerTick() {		
		System.out.println("Tick");		
	}

}
