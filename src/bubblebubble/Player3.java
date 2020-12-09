package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player3 extends JLabel implements floorHeight {

   public Player3 player = this;
   public final static String TAG = "Player : ";

   public ImageIcon icPlayerR, icPlayerL;
   public int x = 55;
   public int y = 470;
   
   public boolean jumpState=false;
   public boolean isRight = false; // 상태
   public boolean isLeft = false;
   public boolean isJump = false;
   
   //층 계산 초기값= 1층
   public int floor = floorHeight.floor1; // 470 / 2f = 328 / 3f = 183 / 4f = 38

   public Player3() {
      icPlayerR = new ImageIcon("images/imgStayR.png");
      icPlayerL = new ImageIcon("images/imgStayL.png");
      setIcon(icPlayerR);
      setSize(100, 100); // 고정이므로 상수로 줌
      setLocation(x, y);
   }
   public void moveRangeR() {	//오른쪽으로 움직일 때 조건
	   if (floor == floorHeight.floor1) { // 1층일 때
	         x++;
	      } else if (floor == floorHeight.floor2) { // 2층일 때
	         if ((x >= 108 && x <= 600) || (x >= 891 && x <= 1178)) {
	            x++;
	         } else if (x < 108 || (x > 600) || (x < 891 || x >= 1178)) {
	        	 x++;
	        	 if(!jumpState) {
	        		 floor = floorHeight.floor1; // 1층으로 떨어짐
	        		 moveDown(floor);
	        	 }
	         }
	      } else if (floor == floorHeight.floor3) { // 3층일 때
	         if (x >= 108 && x <= 955) {
	            x++;
	         } else if (x < 108 || x > 955) {
	            floor = floorHeight.floor2; // 3층에서 2층으로 떨어짐
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      } else if (floor == floorHeight.floor4) {
	         if (x >= 108 && x <= 600) {
	            x++;
	         } else if (x < 108) {
	            floor = floorHeight.floor1; // 4층에서 1층으로 떨어짐
	            moveDown(floor);
	         } else if (x > 600) {
	            floor = floorHeight.floor3; // 4층에서 3층으로 떨어짐
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      }
   }

   public void moveRangeL() {	//왼쪽으로 움직일 때 조건
	      if (floor == floorHeight.floor1) { // 1층일 때
	    	  if(x>=0&&x<=1280) {
	    		  x--;  
	    	  }
	      } else if (floor == floorHeight.floor2) { // 2층일 때
	    	  if ((x >= 108 && x <= 600) || (x >= 891 && x <= 1178)) {
		            x--;
		         } else if (x < 108 || (x > 600) || (x < 891 || x >= 1178)) {
		        	 x--;
		        	 if(!jumpState) {
		        		 floor = floorHeight.floor1; // 1층으로 떨어짐
		        		 moveDown(floor);
		        	 }
		         }
	      } else if (floor == floorHeight.floor3) { // 3층일 때
	    	  x--;
	    	  if (x < 108 || x > 955) {
	            floor = floorHeight.floor2; // 3층에서 2층으로 떨어짐
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      } else if (floor == floorHeight.floor4) {
	    	  x--;
	    	  if (x < 108) {
	            floor = floorHeight.floor3; // 4층에서 1층으로 떨어짐
	            moveDown(floor);
	         } else if (x > 600) {
	            floor = floorHeight.floor3; // 4층에서 3층으로 떨어짐
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      }
   }

   public void moveRight() {	//오른쪽으로 움직일 때 쓰는 함수
      System.out.println(TAG + "moveRight()");
      System.out.println("x : " + x);
      System.out.println("y : " + y);
      System.out.println(floor);
      
      if (isRight == false) {
         new Thread(new Runnable() {
            @Override
            public void run() {
               setIcon(icPlayerR);
               isRight = true;
               while (isRight) {
                  moveRangeR();	//오른쪽 움직이는 조건문
                  setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                  try {
                     Thread.sleep(3);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
               } // while
            }
         }).start();
      }
   }

   public void moveLeft() {
      System.out.println(TAG + "moveLeft()");
      System.out.println("x : " + x);
      System.out.println("y : " + y);
      System.out.println(floor);

      if (isLeft == false) {
         new Thread(new Runnable() {
            @Override
            public void run() {
               setIcon(icPlayerL);
               isLeft = true;
               while (isLeft) {
                  moveRangeL();
                  setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                  try {
                     Thread.sleep(3);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
               }
            }
         }).start();
      }
   }
   public void moveDown(int height) { // 아래로 내려오는거
      System.out.println(TAG + "moveDown()");

      new Thread(new Runnable() {
         @Override
         public void run() {
            while (y <= height) {
               y++;
               setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
               try {
                  Thread.sleep(5);
                  //4층에서 떨어질 때 3층으로 떨어지는 조건
                  if (x >= 108&& x<200 && (y > floorHeight.floor4 && y < floorHeight.floor3)) {	//4층에서 3층
                	  floor = floorHeight.floor3;
                	  while (y < floorHeight.floor3) {
                          y++;
                          setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                          try {
                             Thread.sleep(15);
                          } catch (InterruptedException e) {
                             e.printStackTrace();
                          }
                       }
                     return;
                  }
                  //3층에서 떨어질 때 2층으로 떨어지는 조건
                  else if (x >= 108&& x<200 && (y > floorHeight.floor3 && y < floorHeight.floor2)) {	//3층에서 2층
                	  floor = floorHeight.floor2;
                	  System.out.println("떨어진닷");
                	  while (y < floorHeight.floor2) {
                          y++;
                          setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                          try {
                             Thread.sleep(15);
                          } catch (InterruptedException e) {
                             e.printStackTrace();
                          }
                       }
                     return;
                  }
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      }).start();
   }

   public void moveJump() {
      System.out.println(TAG + "moveJump()");
      System.out.println("x = " + x);
      System.out.println("y = " + y);
      if (isJump == false) {
         new Thread(new Runnable() {
            @Override
            public void run() {
            	jumpState=true;
            	//점프할 때 올라가는 부분
                  for (int i = 0; i < 160; i++) {	
                     y--;
                     setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                     try {
                        Thread.sleep(3);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
                  //점프할 때 내려가는 부분
                     for (int i = 0; i < 160; i++) {
                        y++;
                        System.out.println("떨어짐");
                        setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                        try {
                           Thread.sleep(3);
                           //1층에서 2층 착지
                           if(floor==floorHeight.floor1&&((x>=108&&x<=600)||(x>=891&&x<=1178))) {
                        	   floor=floorHeight.floor2;
                        	   System.out.println("1->2");
                        	   while (y < floorHeight.floor2) {
                                   y++;
                                   setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //2층에서 3층으로 착지
                           }else if(floor==floorHeight.floor2&&(x>=108&&x<=955)) {
                        	   floor=floorHeight.floor3;
                        	   System.out.println("2->3");
                        	   while (y < floorHeight.floor3) {
                                   y++;
                                   setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //2층에서 2층으로 착지
                           }else if(floor==floorHeight.floor2&&(x>=956&&x<=1178)) {
                        	   floor=floorHeight.floor2;
                        	   System.out.println("2->2");
                        	   while (y < floorHeight.floor2) {
                                   y++;
                                   setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //3층에서 4층으로 착지
                           }else if(floor==floorHeight.floor3&&(x>=108&&x<=600)) {
                        	   floor=floorHeight.floor4;
                        	  System.out.println("3->4");
                        	   while (y < floorHeight.floor4) {
                                   y++;
                                   setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //3층에서 3층으로 착지
                           }else if(floor==floorHeight.floor3&&(x>600&&x<=955)) {
                        	   floor=floorHeight.floor3;
                        	  System.out.println("3->3");
                        	   while (y < floorHeight.floor3) {
                                   y++;
                                   setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                   try {
                                      Thread.sleep(3);
                                      if(x>=956&&x<=1178) {
                                    	  while (y < floorHeight.floor2) {
                                    		  floor=floorHeight.floor2;
                                              y++;
                                              setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                              try {
                                                 Thread.sleep(3);
                                              } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                              }
                                           }
                                      }
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //4층에서 점프하면 다시 4층으로 떨어짐 맨 위층이니깐!
                           }else if(floor==floorHeight.floor4&&(x<=108&&x>=600)) {
                        	   floor=floorHeight.floor4;
                        	  
                        	   while (y < floorHeight.floor4) {
                                   y++;
                                   setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                   try {
                                      Thread.sleep(3);
                                      if(x>600) {
                                    	  floor=floorHeight.floor3;
                                    	  while (y < floorHeight.floor3) {
                                              y++;
                                              setLocation(x, y); // 내부에 repaint()가 존재 따로 안해도 됨
                                              try {
                                                 Thread.sleep(3);
                                              } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                              }
                                           }
                                    	  return;
                                      }
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                           }
                        } catch (InterruptedException e) {
                           e.printStackTrace();
                        }
                     }
                     jumpState=false;
            }
         }).start();
      }
   }
}