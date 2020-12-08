package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player3 extends JLabel implements Initable, floorHeight {

   public Player3 player = this;
   public final static String TAG = "Player : ";

   public ImageIcon icPlayerR, icPlayerL;
   public int x = 55;
   public int y = 470;
   
   public boolean jumpState=false;
   public boolean isRight = false; // ����
   public boolean isLeft = false;
   public boolean isJump = false;
   
   public int floor = floorHeight.floor1; // 470 / 2f = 328 / 3f = 183 / 4f = 38

   public Player3() {
      icPlayerR = new ImageIcon("images/imgStayR.png");
      icPlayerL = new ImageIcon("images/imgStayL.png");
      setIcon(icPlayerR);
      setSize(100, 100); // �����̹Ƿ� ����� ��
      setLocation(x, y);
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
	   if (floor == floorHeight.floor1) { // 1���� ��
	         x++;
	      } else if (floor == floorHeight.floor2) { // 2���� ��
	         if ((x >= 108 && x <= 600) || (x >= 891 && x <= 1178)) {
	            x++;
	         } else if (x < 108 || (x > 600) || (x < 891 || x >= 1178)) {
	        	 if(!jumpState) {
	        		 floor = floorHeight.floor1; // 1������ ������
	        		 moveDown(floor);
	        	 }
	         }
	      } else if (floor == floorHeight.floor3) { // 3���� ��
	         if (x >= 108 && x <= 955) {
	            x++;
	         } else if (x < 108 || x > 955) {
	            floor = floorHeight.floor2; // 3������ 2������ ������
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      } else if (floor == floorHeight.floor4) {
	         if (x >= 108 && x <= 600) {
	            x++;
	         } else if (x < 108) {
	            floor = floorHeight.floor1; // 4������ 1������ ������
	            moveDown(floor);
	         } else if (x > 600) {
	            floor = floorHeight.floor3; // 4������ 3������ ������
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      }
   }

   public void moveRangeL() {
	      if (floor == floorHeight.floor1) { // 1���� ��
	    	  if(x>=0&&x<=1280) {
	    		  x--;
	    	  }
	      } else if (floor == floorHeight.floor2) { // 2���� ��
	         if ((x >= 108 && x <= 600) || (x >= 891 && x <= 1178)) {
	            x--;
	         } else if (x < 108 || (x > 600) || (x < 891 || x >= 1178)) {
	        	 if(!jumpState) {
	        		 floor = floorHeight.floor1; // 1������ ������
	        		 moveDown(floor);
	        	 }
	         }
	      } else if (floor == floorHeight.floor3) { // 3���� ��
	         if (x >= 108 && x <= 955) {
	            x--;
	         } else if (x < 108 || x > 955) {
	            floor = floorHeight.floor2; // 3������ 2������ ������
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      } else if (floor == floorHeight.floor4) {
	         if (x >= 108 && x <= 600) {
	            x--;
	         } else if (x < 108) {
	            floor = floorHeight.floor3; // 4������ 1������ ������
	            moveDown(floor);
	         } else if (x > 600) {
	            floor = floorHeight.floor3; // 4������ 3������ ������
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      }
   }

   public void moveRight() {
      System.out.println(TAG + "moveRight()");
      System.out.println("x : " + x);
      System.out.println("y : " + y);
      System.out.println(floor);
      System.out.println(""+jumpState+"");
      if (isRight == false) {
         new Thread(new Runnable() {
            @Override
            public void run() {
               setIcon(icPlayerR);
               isRight = true;
               while (isRight) {
                  moveRangeR();
                  setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                  try {
                     Thread.sleep(10);
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
                  setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
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
      System.out.println(TAG + "moveUp()");

      new Thread(new Runnable() {
         @Override
         public void run() {
            for (int i = 0; i < 145; i++) {
               y--;
               setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
               try {
                  Thread.sleep(3);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      }).start();

   }

   public void moveDown() {
      System.out.println(TAG + "moveDown()");

      new Thread(new Runnable() {
         @Override
         public void run() {
            while (y < floorHeight.floor1) {
               y++;
               setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
               try {
                  Thread.sleep(10);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      }).start();
   }

   public void moveDown(int height) { // �Ʒ��� �������°� �����ε�
      System.out.println(TAG + "moveDown()");

      new Thread(new Runnable() {
         @Override
         public void run() {
            while (y <= height) {
               y++;
               setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
               try {
                  Thread.sleep(10);
                  if (x >= 108&& x<200 && (y > floorHeight.floor4 && y < floorHeight.floor3)) {	//4������ 3��
                	  floor = floorHeight.floor3;
                	  while (y < floorHeight.floor3) {
                          y++;
                          setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                          try {
                             Thread.sleep(10);
                          } catch (InterruptedException e) {
                             e.printStackTrace();
                          }
                       }
                     return;
                  }
                  else if (x >= 108&& x<200 && (y > floorHeight.floor3 && y < floorHeight.floor2)) {	//3������ 2��
                	  floor = floorHeight.floor2;
                	  System.out.println("��������");
                	  while (y < floorHeight.floor2) {
                          y++;
                          setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                          try {
                             Thread.sleep(10);
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
                  for (int i = 0; i < 160; i++) {
                     y--;
                     setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                     try {
                        Thread.sleep(5);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
                     for (int i = 0; i < 160; i++) {
                        y++;
                        System.out.println("������");
                        setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                        try {
                           Thread.sleep(10);
                           if(floor==floorHeight.floor1&&((x>=108&&x<=600)||(x>=891&&x<=1178))) {
                        	   floor=floorHeight.floor2;
                        	   System.out.println("1->2");
                        	   while (y < floorHeight.floor2) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(5);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                           }else if(floor==floorHeight.floor2&&(x>=108&&x<=955)) {
                        	   floor=floorHeight.floor3;
                        	   System.out.println("2->3");
                        	   while (y < floorHeight.floor3) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(5);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                           }else if(floor==floorHeight.floor3&&(x>=108&&x<=600)) {
                        	   floor=floorHeight.floor4;
                        	  System.out.println("3->4");
                        	   while (y < floorHeight.floor4) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(5);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                           }else if(floor==floorHeight.floor4&&(x<=108&&x>=600)) {
                        	   floor=floorHeight.floor4;
                        	  
                        	   while (y < floorHeight.floor4) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(5);
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