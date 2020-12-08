//package bubblebubble;
//
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//
//public class Player2 extends JLabel implements Initable,floorHeight{
//	
//	public Player2 player=this;
//	public final static String TAG="Player : ";
//	
//	public ImageIcon icPlayerR, icPlayerL;
//	public int x= 80;
//	public int y=480;
//	
//	public boolean isRight=false; //상태
//	public boolean isLeft=false;
//	public boolean isJump=false;
//	
//	public int floor=floorHeight.floor[1]; 
//	
//	public Player2() {
//		icPlayerR=new ImageIcon("images/imgStayR.png");
//		icPlayerL=new ImageIcon("images/imgStayL.png");
//		setIcon(icPlayerR);
//		setSize(100,100); //고정이므로 상수로 줌
//		setLocation(x,y);
//	}
//
//	@Override
//	public void setting() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void init() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void batch() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void listener() {
//		// TODO Auto-generated method stub
//		
//	}
//	public void moveRangeR() {
//		if(floor==floorHeight.floor[1])
//			x++;
//		else if(floor==floorHeight.floor[2]) {
//			if(x>=199&&x<=290) {
//				x++;
//			}else {
//				floor=floorHeight.floor[1];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[3]) {
//			if(x>=21&&x<=157) 
//				x++;
//			else {
//				floor=floorHeight.floor[2];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[4]) {
//			if(x>=21&&x<=157) 
//				x++;
//			else {
//				floor=floorHeight.floor[2];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[5]) {
//			if(x>=203&&x<=1280)
//				x++;
//			}else if(floor==floorHeight.floor[6]) {
//				if(x>=266&&x<=364)
//					x++;
//				else {
//					floor=floorHeight.floor[5];
//					moveDown(floor);
//				}
//		}else if(floor==floorHeight.floor[7]) {
//			if(x>=121&&x<=249)
//				x++;
//			else {
//				floor=floorHeight.floor[6];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[8]) {
//			if(x>=121&&x<=249)
//				x++;
//			else {
//				floor=floorHeight.floor[6];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[9]) {
//			if(x>=307&&x<=1280)
//				x++;
//		}else if(floor==floorHeight.floor[10])
//			if(x>=365&&x<=433)
//				x++;
//			else {
//				floor=floorHeight.floor[9];
//				moveDown(floor);
//			}
//	}
//	public void moveRangeL() {
//		if(floor==floorHeight.floor[1])
//			x--;
//		else if(floor==floorHeight.floor[2]) {
//			if(x>=199&&x<=290) {
//				x--;
//			}else {
//				floor=floorHeight.floor[1];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[3]) {
//			if(x>=21&&x<=157) 
//				x--;
//			else {
//				floor=floorHeight.floor[1];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[4]) {
//			if(x>=21&&x<=157) 
//				x--;
//			else {
//				floor=floorHeight.floor[1];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[5]) {
//			if(x>=203&&x<=1280)
//				x--;
//			else {
//				floor=floorHeight.floor[4];
//				moveDown(floor);
//			}
//			}else if(floor==floorHeight.floor[6]) {
//				if(x>=266&&x<=364)
//					x--;
//				else {
//					floor=floorHeight.floor[5];
//					moveDown(floor);
//				}
//		}else if(floor==floorHeight.floor[7]) {
//			if(x>=121&&x<=249)
//				x--;
//			else {
//				floor=floorHeight.floor[4];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[8]) {
//			if(x>=121&&x<=249)
//				x--;
//			else {
//				floor=floorHeight.floor[4];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[9]) {
//			if(x>=307&&x<=1280)
//				x--;
//			else {
//				floor=floorHeight.floor[8];
//				moveDown(floor);
//			}
//		}else if(floor==floorHeight.floor[10])
//			if(x>=365&&x<=433)
//				x--;
//			else {
//				floor=floorHeight.floor[9];
//				moveDown(floor);
//			}
//	}
//	public void moveRight() {
//		System.out.println(TAG+"moveRight()");
//		System.out.println("x : "+x);
//		System.out.println("y : "+y);
//		System.out.println(floor);
//		
//		if(isRight==false) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					setIcon(icPlayerR);
//					isRight=true;
//					while(isRight) {
//						moveRangeR();
//						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					
//					}//while
//				}
//			}).start();
//		}
//	}
//	public void moveLeft() {
//		System.out.println(TAG+"moveLeft()");
//		System.out.println("x : "+x);
//		System.out.println("y : "+y);
//		System.out.println(floor);
//		
//		if(isLeft==false) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					setIcon(icPlayerL);
//					isLeft=true;
//					while(isLeft) {
//						moveRangeL();
//						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}).start();
//		}
//	}
//	public void moveUp() {
//		System.out.println(TAG+"moveUp()");
//		
//		
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					for(int i=0;i<60;i++) {
//						y--;
//						setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//						try {
//							Thread.sleep(5);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}).start();
//		
//	}
//	public void moveDown() {
//		System.out.println(TAG+"moveDown()");
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(y<floorHeight.floor1) {
//					y++;
//					setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
//	public void moveDown(int height) {	//아래로 내려오는거 오버로딩
//		System.out.println(TAG+"moveDown()");
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(y<=height) {
//					y++;
//					setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
//	
//	public void moveJump() {
//		System.out.println(TAG+"moveJump()");
//		System.out.println("x = "+x);
//		System.out.println("y = "+y);
//		if(isJump==false) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					if(floor==floorHeight.floor[1]&&(x>=199&&x<=290)) {
//						floor=floorHeight.floor[2];
//					}else if(floor==floorHeight.floor[2]&&(x>=199&&x<=230)) {
//						floor=floorHeight.floor[3];
//					}else if(floor==floorHeight.floor[3]&&(x>=21&&x<=157)) {
//						floor=floorHeight.floor[4];
//					}else if(floor==floorHeight.floor[4]&&(x>=125&&x<=157)) {
//						floor=floorHeight.floor[5];
//					}else if(floor==floorHeight.floor[6]&&(x>=266&&x<=364)) {
//						floor=floorHeight.floor[6];
//					}else if(floor==floorHeight.floor[7]&&(x>=266&&x<=300)) {
//						floor=floorHeight.floor[8];
//					}else if(floor==floorHeight.floor[8]&&(x>=215&&x<=249)) {
//						floor=floorHeight.floor[9];
//					}else if(floor==floorHeight.floor[9]&&(x>=365&x<=433)) {
//						floor=floorHeight.floor[10];
//					}else if(floor==floorHeight.floor[10]) {
//						floor=floorHeight.floor[11];
//					}
//					if(floor!=floorHeight.floor[11]) {	//점프 - 올라가기 조건 1
//						for(int i=0;i<75;i++) {
//							y--;
//							setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//							try {
//								Thread.sleep(5);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//						if(floor==floorHeight.floor[2]&&(x<199||x>290)) {
//							for(int i=floor;i<=floorHeight.floor[1];i--) {
//								y++;
//								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//								try {
//									Thread.sleep(5);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//						if((x>=108 && x<=600)||(x>=891&&x<=953)) {	// 점프 - 떨어지기 조건 1
//							for(int i=0;i<15;i++) {
//								y++;
//								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//								try {
//									Thread.sleep(5);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//						}else if(x>953&&x<1178) { // 점프 - 떨어지기 조건 2
//							for(int i=0;i<160;i++) {
//								y++;
//								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//								try {
//									Thread.sleep(5);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//						else{ // 점프 - 떨어지기 조건 3
//							for(int i=0;i<160;i++) {
//								y++;
//								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//								try {
//									Thread.sleep(5);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//					}else if(floor==floorHeight.floor5) { // 점프 - 올라가기 조건2
//						for(int i=0;i<160;i++) {
//							y--;
//							setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//							try {
//								Thread.sleep(5);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//							for(int i=0;i<160;i++) {
//								y++;
//								setLocation(x,y); // 내부에 repaint()가 존재 따로 안해도 됨
//								try {
//									Thread.sleep(5);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//							floor=floorHeight.floor4;
//					}
//				}
//			}).start();
//		}
//	}
//	//구현안함
//	public void attack() {
//		
//	}
//	
//}
