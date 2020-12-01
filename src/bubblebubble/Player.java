package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Initable{
	
	public Player player=this;
	public final static String TAG="Player : ";
	
	public ImageIcon icPlayerR, icPlayerL;
	public int x= 55;
	public int y=535;
	
	public boolean isRight=false; //상태
	public boolean isLeft=false;
	public boolean isJump=false;
	
	public int floor=1; // 535, 2f = 415, 3f=295, 4f=177
	
	public Player() {
		icPlayerR=new ImageIcon("images/playerR.png");
		icPlayerL=new ImageIcon("images/playerL.png");
		setIcon(icPlayerR);
		setSize(50,50); //고정이므로 상수로 줌
		setLocation(x,y);
	}

	@Override
	public void setting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listener() {
		// TODO Auto-generated method stub
		
	}
	public void moveRight() {
		System.out.println(TAG+"moveRight()");
		if(isRight==false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerR);
					isRight=true;
					while(isRight) {
						x++;
						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	public void moveLeft() {
		System.out.println(TAG+"moveLeft()");
		if(isLeft==false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isLeft=true;
					while(isLeft) {
						x--;
						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	public void moveUp() {
		System.out.println(TAG+"moveUp()");
		
		
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<145;i++) {
						y--;
						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		
	}
	public void moveDown() {
		System.out.println(TAG+"moveDown()");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(y<535) {
					y++;
					setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void moveJump() {
		System.out.println(TAG+"moveJump()");
		System.out.println("x = "+x);
		System.out.println("y = "+y);
		if(isJump==false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<145;i++) {
						y--;
						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(x>=190 && x<=760) {
						for(int i=0;i<50;i++) {
							if(floor<=3) {
								y++;
								floor++;
								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
								try {
									Thread.sleep(5);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}else if(x<190||x>760) {
						for(int i=0;i<145;i++) {
							y++;
							setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
				}
			}).start();
		}
	}
	//구현안함
	public void attack() {
		
	}
	
}
