package bubblebubble;

public class MonsterMove extends Thread{

	private MonsterMove monMove=this;
	private int MonsterMove;
	private double randomValue;
	private Monster monster;

	public MonsterMove() {
		
	}
	
	private void num() {
		while(true) {
			randomValue=Math.random();
			MonsterMove=(int)(randomValue*3);
			System.out.println(MonsterMove);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		num();
		if(MonsterMove==0) {
			return;
	}
		else if(MonsterMove==1) {
		monster.isRight=false;
		}
		else if(MonsterMove==2) {
		monster.isLeft=false;
		}
	}
}
