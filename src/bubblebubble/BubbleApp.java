package bubblebubble;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Initable{
	
	//���ؽ�Ʈ ����(�Ⱦ����� �Ұ�!)
	private BubbleApp bubbleApp=this;
	// �±� - ����Ǵ� ���� �����ϱ�
	private static final String TAG="BubbleApp : ";
	
	private JLabel laBackground;
	private Player player;
	private Monster monster;
	private MonsterMove monsterMove;
	
	public BubbleApp() {
		init();
		setting();
		batch();
		listener();
		
		//monsterMove.start();
		
		setVisible(true);
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		laBackground=new JLabel(new ImageIcon("images/imgTestBG.png"));
		player=new Player();
		monster=new Monster();
	}
	@Override
	public void setting() {
		// TODO Auto-generated method stub
		setTitle("�������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setLayout(null);
		setContentPane(laBackground);

	}

	@Override
	public void batch() {
		// TODO Auto-generated method stub
		add(player);
		add(monster);
	}

	@Override
	public void listener() {
		// TODO Auto-generated method stub
		addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.moveRight();
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				player.moveLeft();
			}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				//player.moveUp();
				player.moveJump();
			}
		}
		@Override
			public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.isRight=false;
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				player.isLeft=false;
			}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				player.isJump=false;
			}
			}
		});
		
	}
	public static void main(String[] args) {
		new BubbleApp();
	}
}
