package bubblebubble;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Initable{
	
	//컨텍스트 저장(안쓰더라도 할것!)
	private BubbleApp bubbleApp=this;
	// 태그 - 실행되는 파일 구분하기
	private static final String TAG="BubbleApp : ";
	
	private JLabel laBackground;
	//private Player player;
	//private Player2 player2;
	private Player3 player;
	private Monster monster;
	private MonsterMove monsterMove;
	
	public BubbleApp() {
		init();
		setting();
		batch();
		listener();

		setVisible(true);
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		laBackground=new JLabel(new ImageIcon("images/MPBG.png"));
		player=new Player3();
		//player2=new Player2();
		//monster=new Monster();
	}
	@Override
	public void setting() {
		// TODO Auto-generated method stub
		setTitle("버블버블");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setLayout(null);
		setContentPane(laBackground);

	}

	@Override
	public void batch() {
		// TODO Auto-generated method stub
		add(player);
		//add(player2);
		//add(monster);
	}

	@Override
	public void listener() {
		// TODO Auto-generated method stub
		addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.moveRight();
				//player2.moveRight();
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				player.moveLeft();
				//player2.moveLeft();
			}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				player.moveJump();
				//player2.moveUp();
			}
		}
		@Override
			public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.isRight=false;
				//player2.isRight=false;
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				player.isLeft=false;
				//player2.isLeft=false;
			}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				player.isJump=false;
				//player2.isJump=false;
			}
			}
		});
		
	}
	public static void main(String[] args) {
		new BubbleApp();
	}
}
