package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Initable,floorHeight{
	
	public Player player=this;
	public final static String TAG="Player : ";
	
	public ImageIcon icPlayerR, icPlayerL;
	public int x= 55;
	public int y=470;
	
	public boolean isRight=false; //상태
	public boolean isLeft=false;
	public boolean isJump=false;
	
	public int floor=floorHeight.floor1; // 470 / 2f = 328 / 3f = 183 / 4f = 38
	
	public Player() {
		icPlayerR=new ImageIcon("images/imgStayR.png");
		icPlayerL=new ImageIcon("images/imgStayL.png");
		setIcon(icPlayerR);
		setSize(100,100); //고정이므로 상수로 줌
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
	public void moveRangeR() {
		if(floor==floorHeight.floor1) { //1층일 때
			x++;
		}else if(floor==floorHeight.floor2) { // 2층일 때
			if((x>=108 && x<=600)||(x>=891&&x<=1178)) {
				x++;
			}else if(x<108||(x>600)||(x<891||x>=1178)) {
				floor=floorHeight.floor1;	//1층으로 떨어짐
				moveDown(floor);					
			}
		}else if(floor==floorHeight.floor3) { //3층일 때
			if(x>=108&&x<=955) {
				x++;
			}else if(x<108||x>955) {
				floor=floorHeight.floor2;	//3층에서 2층으로 떨어짐
				moveDown(floor);
			}
		}else if(floor==floorHeight.floor4) {
			if(x>=108 && x<=600) {
				x++;
			}else if(x<108) {
				floor=floorHeight.floor4;	//4층에서 1층으로 떨어짐
				moveDown(floor);
			}else if(x>600) {
				floor=floorHeight.floor3;	//4층에서 3층으로 떨어짐
				moveDown(floor);
			}
		}
	}
	public void moveRangeL() {
		if(floor==floorHeight.floor1) { //1층일 때
			x--;
		}else if(floor==floorHeight.floor2) { // 2층일 때
			if((x>=108 && x<=600)||(x>=891&&x<=1178)) {
				x--;
			}else if(x<108||(x>600)||(x<891||x>=1178)) {
				floor=floorHeight.floor1;	//1층으로 떨어짐
				moveDown(floor);					
			}
		}else if(floor==floorHeight.floor3) { //3층일 때
			if(x>=108&&x<=955) {
				x--;
			}else if(x<108||x>955) {
				floor=floorHeight.floor2;	//3층에서 2층으로 떨어짐
				moveDown(floor);
			}
		}else if(floor==floorHeight.floor4) {
			if(x>=108 && x<=600) {
				x--;
			}else if(x<108) {
				floor=floorHeight.floor4;	//4층에서 1층으로 떨어짐
				moveDown(floor);
			}else if(x>600) {
				floor=floorHeight.floor3;	//4층에서 3층으로 떨어짐
				moveDown(floor);
			}
		}
	}
	public void moveRight() {
		System.out.println(TAG+"moveRight()");
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		System.out.println(floor);
		
		if(isRight==false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerR);
					isRight=true;
					while(isRight) {
						moveRangeR();
						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					
					}//while
				}
			}).start();
		}
	}
	public void moveLeft() {
		System.out.println(TAG+"moveLeft()");
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		System.out.println(floor);
		
		if(isLeft==false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isLeft=true;
					while(isLeft) {
						moveRangeL();
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
				while(y<floorHeight.floor1) {
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
	public void moveDown(int height) {	//아래로 내려오는거 오버로딩
		System.out.println(TAG+"moveDown()");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(y<=height) {
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
					if(floor==floorHeight.floor1&&((x>=108 && x<=600)||(x>=891&&x<=1178))) {
						floor=floorHeight.floor2;
					}else if(floor==floorHeight.floor2&&((x>=108 && x<=600)||(x>=891&&x<=953))) {
						floor=floorHeight.floor3;
					}else if(floor==floorHeight.floor2&&(x<953&&x<1178)) {
						floor=floorHeight.floor5;
					}else if(floor==floorHeight.floor3&&x>=108&&x<=600) {
						floor=floorHeight.floor4;
					}else if(floor==floorHeight.floor4) {
						floor=floorHeight.floor5;
					}
					if(floor!=floorHeight.floor5) {	//점프 - 올라가기 조건 1
						for(int i=0;i<160;i++) {
							y--;
							setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if((x>=108 && x<=600)||(x>=891&&x<=953)) {	// 점프 - 떨어지기 조건 1
							for(int i=0;i<10;i++) {
								y++;
								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
								try {
									Thread.sleep(5);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}else if(x>953&&x<1178) { // 점프 - 떨어지기 조건 2
							for(int i=0;i<160;i++) {
								y++;
								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
								try {
									Thread.sleep(5);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
						else{ // 점프 - 떨어지기 조건 3
							for(int i=0;i<160;i++) {
								y++;
								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
								try {
									Thread.sleep(5);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}else if(floor==floorHeight.floor5) { // 점프 - 올라가기 조건2
						for(int i=0;i<160;i++) {
							y--;
							setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
							for(int i=0;i<160;i++) {
								y++;
								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
								try {
									Thread.sleep(5);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							floor=floorHeight.floor4;
					}
				}
			}).start();
		}
	}
	//구현안함
	public void attack() {
		
	}
	
}
