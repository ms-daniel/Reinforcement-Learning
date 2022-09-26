package mazeCreate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class locationPrint extends Thread{
	//private int width, height;
	private static int x, x_ant=0, y, y_ant=0;
	private BufferedImage buffer;
	private JLabel img = new JLabel();
	private boolean stop = false;
	
	public locationPrint(JLabel label) {
		this.img= label;
	}
	/*
	 * posicoes de onde sera pintado o agente
	 */
	public void setPosition(int tx, int ty) {
		x = tx;
		y = ty;
		img.setIcon(printPosition());
	}
	
	public void clearMaze() {
		img = null;
		buffer = null;
	}
	
	public ImageIcon printPosition() {
		int width=305, height=305;
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		g.setColor( Color.BLUE );
		g.fillRect(x*5,y*5,5,5);
		
		return new ImageIcon(buffer);
	}
	
	public void stopMe() {
		stop = true;
	}
	
	/**
	 * chame setPosition antes de dar um start na thread
	 */
	@Override
	public void run(){
		while(!stop) {
			//System.out.println("x: " + x + " y: " + y);
			/*if(x_ant != x || y_ant != y) {
				img.setIcon(printPosition());
				x_ant = x;
				y_ant = y;
			}*/
		}
	}
	
}
