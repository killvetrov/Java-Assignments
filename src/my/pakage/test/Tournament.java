package my.pakage.test;

import java.util.Random;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.*;

public class Tournament extends Thread {
	
	static Random rnd = new Random();
	
	volatile Human[][] bracket;
	int numberOfContestants;
	volatile int currentRound;
	int finalRound;
	
	private int[] tableMap = { 20, 18, 40 };
	volatile int secsLeft; 
	
	public Tournament(Human[] contestants) {
		int pickedIndex;
		
		numberOfContestants = contestants.length;
		
		if ( (numberOfContestants < 2) || (numberOfContestants & (numberOfContestants - 1)) != 0 )
			throw new IllegalArgumentException("Wrong number of contestants. Should not be less than 2 and must be power of 2.");
		
		int numberOfPlayers = 0, numberOfEnemies = 0;
		for (int i = 0; i < contestants.length; i++) {
			if (contestants[i] instanceof Player)
				numberOfPlayers++;
			else if (contestants[i] instanceof Enemy)
				numberOfEnemies++;
		}		
		if (numberOfPlayers != numberOfEnemies) 
			throw new IllegalArgumentException("Tournament cannot be created. Number of players and enemies entering the tournament must be equal.");
		
		
		finalRound = Integer.numberOfTrailingZeros(numberOfContestants);
		
		bracket = new Human[finalRound + 1][];
		for (int i = 0; i < finalRound; i++) {
			bracket[i] = new Human[numberOfContestants >> i];
			if (i == 0) {
				for (int j = 0; j < numberOfContestants; j++) {
					if (j % 2 == 0) {
						do {
							pickedIndex = rnd.nextInt(numberOfContestants);							
						} while ( (contestants[pickedIndex] == null) || (contestants[pickedIndex] instanceof Enemy) );
						bracket[i][j] = contestants[pickedIndex];
						contestants[pickedIndex] = null;						
					} else {
						do {
							pickedIndex = rnd.nextInt(numberOfContestants);							
						} while ( (contestants[pickedIndex] == null) || (contestants[pickedIndex] instanceof Player) );
						bracket[i][j] = contestants[pickedIndex];
						contestants[pickedIndex] = null;
					}
				}
			} 
		}
		bracket[finalRound] = new Human[1];
		
		currentRound = 0;
	}
	
	public void reportRoundBracket(int round) {
		
		System.out.printf("%n------- Round %s%s ------------------------%n", round + 1, round + 1 == finalRound ? " (FINAL)" : "");		
		for (int i = 1; i < bracket[round].length; i += 2) {			
			System.out.println("\t" + bracket[round][i - 1].name + " VS " + bracket[round][i].name);
		}
		System.out.println();
	}
	
	public void fillBracketTable() {
		System.out.print(ansi().cursor(5, 3));
		for (int i = 0; i < bracket[currentRound].length; i++) {			
			if ( (i % 2 == 0) )
				System.out.print(ansi().cursorDown(1));
			if (bracket[currentRound][i].isKilled())
				System.out.print(ansi().fg(Color.RED));
			System.out.print(bracket[currentRound][i].name);
			System.out.print(ansi().reset());
			System.out.print(ansi().newline());
			System.out.print(ansi().cursorUp(1));
			System.out.print(ansi().cursorRight(tableMap[0] + 3));
			bracket[currentRound][i].printHealthBar();
			System.out.print(ansi().cursorRight(3).saveCursorPosition());
			System.out.print("                                   ");
			System.out.print(ansi().restorCursorPosition());
			System.out.print(ansi().render(bracket[currentRound][i].status));
//			if (!bracket[round][i].isKilled())
//				bracket[round][i].printHealthBar();
//			else {
//				System.out.print(ansi().fg(Color.RED));
//				System.out.print("killed           ");
//				System.out.print(ansi().reset());
//			}
			System.out.print(ansi().newline().cursorRight(2));			
		}
		System.out.print(ansi().newline().newline());		
	}
	
	public void drawTable() {
		
		final char[] tableChars = { '│' , '┤', '┐', '└', '┴', '┬', '├', '─', '┼', '┘', '┌'};				
			
		char[][] output = new char[ bracket[currentRound].length * 3 / 2 + 3 ][79];
		
		System.out.printf("%n%n");
		
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[i].length; j++) {				
				if (i == 0 && j == 0) 
					output[i][j] = tableChars[10];
				else if (i == 0 && j > 0 && placeColumn(j, tableMap))
					output[i][j] = tableChars[5];
				else if (i < output.length - 1 && j > 0 && placeColumn(j, tableMap))
					output[i][j] = tableChars[0];
				else if (i == output.length - 1 && j > 0 && placeColumn(j, tableMap))
					output[i][j] = tableChars[4];
				else if ( (i == 0) && (j < output[i].length - 1) )
					output[i][j] = tableChars[7];
				else if ( (i == 0) && (j == output[i].length - 1) )
					output[i][j] = tableChars[2];
				else if ( (i < output.length - 1) && (j == 0) )
					output[i][j] = tableChars[0];
				else if ( (i < output.length - 1) && (j == output[i].length - 1) )
					output[i][j] = tableChars[0];
				else if ( (i == output.length - 1) && (j == 0) )
					output[i][j] = tableChars[3];
				else if ( (i == output.length - 1) && (j < output[i].length - 1) )
					output[i][j] = tableChars[7];
				else if ( (i == output.length - 1) && (j == output[i].length - 1) )
					output[i][j] = tableChars[9];
				else	
					output[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < output.length; i++) {
			AnsiConsole.system_out.println(output[i]);
		}
		
		System.out.print(ansi().cursor(2, 2));
		if (currentRound + 1 == finalRound)
			System.out.print(ansi().render("> @|bold FINAL ROUND|@"));
		else
			System.out.print(ansi().render("> @|bold ROUND %s|@ of %s", currentRound + 1, finalRound));
		System.out.print(ansi().cursor(4, 2));
		System.out.print(ansi().fg(Color.DEFAULT).bold());
		System.out.print("       Player       ");
		System.out.print(ansi().cursorRight(1));
		System.out.print("      Health      ");
		System.out.print(ansi().cursorRight(1));
		System.out.print("               Status               ");
		System.out.print(ansi().reset());
		
		fillBracketTable();
		
	}
	
	private static boolean placeColumn(int pos, int[] tableMap) {
		boolean result = false;
		
		int mapPos = 0;
		for (int i = 0; i < tableMap.length; i++) {
			if (pos == mapPos) {
				result = true;
				break;
			}
			mapPos += tableMap[i] + 1;
		}
		
		return result;
	}
	
	@Override
	public void run() {
		
		Duel[] duels;
		
		for (int iRound = 0; iRound < finalRound; iRound++) { 
		
			//reportRoundBracket(iRound);
			
			if (iRound > 0) {
				for (int i = 0; i < bracket[iRound].length; i++)
					bracket[iRound][i].heal();
			}
			
			drawTable();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			duels = new Duel[bracket[iRound].length];
			int j = 0;
			for (int i = 1; i < bracket[iRound].length; i += 2) {
				duels[j] = new Duel(this, bracket[iRound][i - 1], bracket[iRound][i], j);
				duels[j].start();
				j++;
			}

			for (int i = 0; i < j; i++)
				try {
					duels[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			currentRound++;
			
			if (currentRound < finalRound) {
				secsLeft = 9;
				System.out.printf("Round %s will begin in %s s...", currentRound + 1, secsLeft);
				System.out.print(ansi().saveCursorPosition());
				cw_15_03_23_timer.Timer myTimer = new cw_15_03_23_timer.Timer(1000, new cw_15_03_23_timer.OnTimerTickListener() {
					public void onTimerTick(cw_15_03_23_timer.Timer timer) 
					{
						System.out.print(ansi().cursorLeft(6));
						System.out.print(--secsLeft);
						System.out.print(ansi().restorCursorPosition());
					};
				}
						);
				myTimer.setCount(8);
				myTimer.start();

				try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.print(ansi().bg(Color.BLACK).cursor(1, 1));
				for (int i = 0; i < 23; i++)
					System.out.println("                                                                               ");
				System.out.print(ansi().reset().cursor(1, 1));

			}			
		
		}
		
		System.out.println();
		System.out.println("======== THE WINNER IS: " + bracket[finalRound][0].name + " ========");
		
	}
	
	public static void main(String[] args) {
		
		AnsiConsole.systemInstall();
		System.out.print(ansi().eraseScreen().cursor(1, 1));
		
		Human[] mobs = new Human[8];
		
		mobs[0] = new NormalPlayer("Malvina", 5, 1, 10, 100);
		mobs[1] = new NormalPlayer("Piero", 5, 1, 10, 100);
		mobs[2] = new DonatePlayer("Artemon", 15, 1, 10, 100);
		mobs[3] = new DonatePlayer("Buratino", 15, 1, 10, 100);
//		mobs[4] = new LowEnemy("LowEnemy-1", 5, 1, 10, 100);
//		mobs[5] = new LowEnemy("LowEnemy-2", 5, 1, 10, 100);
		mobs[4] = new MediumEnemy("Alisa", 12, 1, 10, 100);
		mobs[5] = new MediumEnemy("Basilio", 12, 1, 10, 100);
		mobs[6] = new HardEnemy("Karabas Barabas", 20, 1, 10, 100);
		mobs[7] = new HardEnemy("Duremar", 20, 1, 10, 100);

		Tournament myTournament = new Tournament(mobs);		
		
		//myTournament.drawTable();
		
		myTournament.start();
//		
		try {
			myTournament.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.print(ansi().cursor(23, 1));
	}

}

class Duel extends Thread {
	private Human p1;
	private Human p2;
	private boolean turn;
	private int winnerPlace;
	private Tournament myTournament;
	
	
	public Duel(Tournament tournament, Human p1, Human p2, final int winnerPlace) {
		this.myTournament = tournament;
		this.p1 = p1;
		this.p2 = p2;
		this.winnerPlace = winnerPlace;
		this.turn = Tournament.rnd.nextBoolean();
	}
	
	public void run() {		
		do {
			if (turn) {
				p1.atack(p2);
				p1.status = "@|bold,green >|@ @|bold " + p1.status + "|@";
			} else {
				p2.atack(p1);
				p2.status = "@|bold,green >|@ @|bold " + p2.status + "|@";
			}
			turn = !turn;
			
			//if (myTournament.currentRound == 0) {
				myTournament.fillBracketTable();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			//}
			
		} while (!(p1.isKilled() || p2.isKilled()));
		Human winner = p2.isKilled() ? p1 : p2;
		//myTournament.fillBracketTable(0);
		myTournament.bracket[myTournament.currentRound + 1][winnerPlace] = winner;		
	};
};