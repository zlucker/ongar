package kz.enu.ongar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Enemy {
	
	
	// Fields 
	private int x;
	private int y;
	private int speed;
	private Color color;
	private int r ;
	private int j;
	private int hp;
	
	
	//Constructor
	
	Enemy(){
		r=5;
		x = (int) (Math.random()*GamePanel.WIDTH);
		y = (int) (Math.random()*GamePanel.HEIGHT);
		speed = 5;
		color = Color.YELLOW;
		j=0;
		hp=10;
	}
	
	
	//Functions
	
	public void update(){
		if(j==10){j=0;
		x=(int) (x-((Math.random()-0.5))*20);
		}
		j++;
		
		if(y<0 || x<0){
			x=r*2;
			y=r*2;
		}
		if(y>GamePanel.HEIGHT || x>GamePanel.WIDTH){
			x=GamePanel.HEIGHT-(r*2);
			y=r*2;
		}
	}
	
	public void draw(Graphics2D g){
		g.setColor(color);
		g.fillOval((int)(x-r),(int)(y-r),2*r,2*r);
		g.setStroke(new BasicStroke(2));	
		g.setColor(color.darker());
		g.drawOval((int)(x-r),(int)(y-r),2*r,2*r);
		g.setStroke(new BasicStroke(5));
	}
	


}
