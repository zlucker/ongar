package kz.enu.ongar;

import java.awt.*;


public class Bullet {

	//Fields
	private double x; 
	private double y; 
	private int r;
	private Color color;
	private int speed;
	
	//Constructor
	public Bullet(){
		x=GamePanel.player.getX();
		y=GamePanel.player.getY();
		r=2;
		speed = 10;
		color = Color.WHITE;
	}
	
	int getX(){
		return (int) x;
	}
	int getY(){
		return (int) y;
	}
	
	//Functions
	public void update(){
		y -=speed;
	}
	public boolean remove(){
		if() {
			return true;}
		else if(y<0) {
			return true;
		}
		else return false;
	}
	
	public void draw(Graphics2D g){
		g.setColor(color);
		g.fillOval((int)x, (int)y, r, r*2);
	}
	
}
