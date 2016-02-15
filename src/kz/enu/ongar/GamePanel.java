package kz.enu.ongar;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	//Field
	public static int WIDTH = 400;
	public static int HEIGHT = 400;
	
	private Thread thread;
	private BufferedImage image;
	private Graphics2D g;
	
	public static GameBack background;
	public static Player player;
	public static Enemy enemy;
	public static ArrayList<Bullet> bullets;
	public static ArrayList<Enemy> enemies;
	
	private boolean remove;
	
	
	//Constructor
	public GamePanel(){
		super();
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		
		
		addKeyListener(new Listeners());
		
	}
	
	//Functions
	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	

	public void run(){
		
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);    
		background = new GameBack();
		player = new Player();
		enemy = new Enemy();
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		int FPS = 17;
		long timeMills=0;
		
		while(true){
			timeMills = System.currentTimeMillis();
			gameUpdate();
			gameRander();
			gameDraw();
			timeMills =	System.currentTimeMillis()-timeMills;
			timeMills = FPS - (timeMills);
			if(timeMills < 0)timeMills=0;
			try {
				thread.sleep(timeMills);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}
	
	public void gameUpdate(){
		//Background update
		background.update();
		
		//Player update
		player.update();	
		
		//Bullet update
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).update();
			remove = bullets.get(i).remove();
			if(remove){
				bullets.remove(i);
				i--;
			}
		}
		
		for(int i=0;i<enemies.size();i++){
			enemies.get(i).update();
			
		}
	}
	
	public void gameRander(){
		//Background draw
		background.draw(g);
		
		//Player draw
		player.draw(g);
		
		//Player draw
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).draw(g);
		}
		
		
		for(int i=0;i<enemies.size();i++){
			enemies.get(i).draw(g);
		}
		
		
		
				
	}
	private void gameDraw(){
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();
	}
	
}
