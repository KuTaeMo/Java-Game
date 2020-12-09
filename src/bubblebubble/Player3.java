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
   public boolean isRight = false; // ����
   public boolean isLeft = false;
   public boolean isJump = false;
   
   //�� ��� �ʱⰪ= 1��
   public int floor = floorHeight.floor1; // 470 / 2f = 328 / 3f = 183 / 4f = 38

   public Player3() {
      icPlayerR = new ImageIcon("images/imgStayR.png");
      icPlayerL = new ImageIcon("images/imgStayL.png");
      setIcon(icPlayerR);
      setSize(100, 100); // �����̹Ƿ� ����� ��
      setLocation(x, y);
   }
   public void moveRangeR() {	//���������� ������ �� ����
	   if (floor == floorHeight.floor1) { // 1���� ��
	         x++;
	      } else if (floor == floorHeight.floor2) { // 2���� ��
	         if ((x >= 108 && x <= 600) || (x >= 891 && x <= 1178)) {
	            x++;
	         } else if (x < 108 || (x > 600) || (x < 891 || x >= 1178)) {
	        	 x++;
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

   public void moveRangeL() {	//�������� ������ �� ����
	      if (floor == floorHeight.floor1) { // 1���� ��
	    	  if(x>=0&&x<=1280) {
	    		  x--;  
	    	  }
	      } else if (floor == floorHeight.floor2) { // 2���� ��
	    	  if ((x >= 108 && x <= 600) || (x >= 891 && x <= 1178)) {
		            x--;
		         } else if (x < 108 || (x > 600) || (x < 891 || x >= 1178)) {
		        	 x--;
		        	 if(!jumpState) {
		        		 floor = floorHeight.floor1; // 1������ ������
		        		 moveDown(floor);
		        	 }
		         }
	      } else if (floor == floorHeight.floor3) { // 3���� ��
	    	  x--;
	    	  if (x < 108 || x > 955) {
	            floor = floorHeight.floor2; // 3������ 2������ ������
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      } else if (floor == floorHeight.floor4) {
	    	  x--;
	    	  if (x < 108) {
	            floor = floorHeight.floor3; // 4������ 1������ ������
	            moveDown(floor);
	         } else if (x > 600) {
	            floor = floorHeight.floor3; // 4������ 3������ ������
	            if(!jumpState) 
	            	moveDown(floor);
	         }
	      }
   }

   public void moveRight() {	//���������� ������ �� ���� �Լ�
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
                  moveRangeR();	//������ �����̴� ���ǹ�
                  setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
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
   }
   public void moveDown(int height) { // �Ʒ��� �������°�
      System.out.println(TAG + "moveDown()");

      new Thread(new Runnable() {
         @Override
         public void run() {
            while (y <= height) {
               y++;
               setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
               try {
                  Thread.sleep(5);
                  //4������ ������ �� 3������ �������� ����
                  if (x >= 108&& x<200 && (y > floorHeight.floor4 && y < floorHeight.floor3)) {	//4������ 3��
                	  floor = floorHeight.floor3;
                	  while (y < floorHeight.floor3) {
                          y++;
                          setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                          try {
                             Thread.sleep(15);
                          } catch (InterruptedException e) {
                             e.printStackTrace();
                          }
                       }
                     return;
                  }
                  //3������ ������ �� 2������ �������� ����
                  else if (x >= 108&& x<200 && (y > floorHeight.floor3 && y < floorHeight.floor2)) {	//3������ 2��
                	  floor = floorHeight.floor2;
                	  System.out.println("��������");
                	  while (y < floorHeight.floor2) {
                          y++;
                          setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
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
            	//������ �� �ö󰡴� �κ�
                  for (int i = 0; i < 160; i++) {	
                     y--;
                     setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                     try {
                        Thread.sleep(3);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
                  //������ �� �������� �κ�
                     for (int i = 0; i < 160; i++) {
                        y++;
                        System.out.println("������");
                        setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                        try {
                           Thread.sleep(3);
                           //1������ 2�� ����
                           if(floor==floorHeight.floor1&&((x>=108&&x<=600)||(x>=891&&x<=1178))) {
                        	   floor=floorHeight.floor2;
                        	   System.out.println("1->2");
                        	   while (y < floorHeight.floor2) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //2������ 3������ ����
                           }else if(floor==floorHeight.floor2&&(x>=108&&x<=955)) {
                        	   floor=floorHeight.floor3;
                        	   System.out.println("2->3");
                        	   while (y < floorHeight.floor3) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //2������ 2������ ����
                           }else if(floor==floorHeight.floor2&&(x>=956&&x<=1178)) {
                        	   floor=floorHeight.floor2;
                        	   System.out.println("2->2");
                        	   while (y < floorHeight.floor2) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //3������ 4������ ����
                           }else if(floor==floorHeight.floor3&&(x>=108&&x<=600)) {
                        	   floor=floorHeight.floor4;
                        	  System.out.println("3->4");
                        	   while (y < floorHeight.floor4) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(3);
                                   } catch (InterruptedException e) {
                                      e.printStackTrace();
                                   }
                                }
                        	   jumpState=false;
                        	   return;
                        	   //3������ 3������ ����
                           }else if(floor==floorHeight.floor3&&(x>600&&x<=955)) {
                        	   floor=floorHeight.floor3;
                        	  System.out.println("3->3");
                        	   while (y < floorHeight.floor3) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(3);
                                      if(x>=956&&x<=1178) {
                                    	  while (y < floorHeight.floor2) {
                                    		  floor=floorHeight.floor2;
                                              y++;
                                              setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
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
                        	   //4������ �����ϸ� �ٽ� 4������ ������ �� �����̴ϱ�!
                           }else if(floor==floorHeight.floor4&&(x<=108&&x>=600)) {
                        	   floor=floorHeight.floor4;
                        	  
                        	   while (y < floorHeight.floor4) {
                                   y++;
                                   setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
                                   try {
                                      Thread.sleep(3);
                                      if(x>600) {
                                    	  floor=floorHeight.floor3;
                                    	  while (y < floorHeight.floor3) {
                                              y++;
                                              setLocation(x, y); // ���ο� repaint()�� ���� ���� ���ص� ��
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