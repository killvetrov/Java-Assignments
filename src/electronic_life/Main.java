package electronic_life;

import java.io.IOException;

import jline.console.ConsoleReader;

public class Main {
	
	private static int state = 0;
	private final static Object lock = new Object();
	private static ConsoleReader cr;
	
	public static void main(String[] args) throws Exception {
		
		Grid myGrid = new Grid(5, 5);		
		System.out.println(myGrid.get(new Vector(1, 1)));
		myGrid.set(new Vector(1, 1), "X");
		System.out.println(myGrid.get(new Vector(1, 1)));
		
		cr = new ConsoleReader();
		
		Thread spaceKeyThread = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("мы запустили тред");
				synchronized (lock) {
					//state.notify();
					System.out.println("мы зашли в синхро");
					while (state != -1) {						
						int ich = -1;
						try {
							System.out.println("мы пытаемся прочесть char");
							ich = cr.readCharacter();
							System.out.println("мы прочитали char");
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("мы перешли к case");
						switch (ich) {
						case 32:
							state = 1;
							lock.notify();
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 27:
							state = -1;
							lock.notify();
							break;
						default:
							System.out.println("Что-то нажато");
							break;
						}
					}
				}
			}
		}, "Space key thread");
		
		spaceKeyThread.start();
		
		synchronized (lock) {
			while (state != -1) {
				System.out.println("wait начался");
				lock.wait();
				System.out.println("wait кончился");
				if (state == 1) {
					System.out.println("Дождались пробела");
					state = 0;
					lock.notify();
				}
			}
			System.out.println("Вышли");
		}
		
	}

}
