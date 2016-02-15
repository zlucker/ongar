package kz.enu.ongar;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]){
		GamePanel panel = new GamePanel();
		
		JFrame startFrame = new JFrame();
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setContentPane(panel);
		startFrame.pack();
		startFrame.setLocationRelativeTo(null);
		startFrame.setVisible(true);
		panel.start();
	
	}

}
