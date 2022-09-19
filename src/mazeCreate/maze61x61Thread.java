package mazeCreate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class maze61x61Thread extends Thread{
	private int[][] matriz = new int[61][61];
	private BufferedImage buffer;
	private JLabel img = new JLabel();
	private JButton play;
	
	
	
	
	public maze61x61Thread(int[][] matriz, JLabel label, JButton play) {
		this.matriz = matriz;
		this.img= label;
		this.play = play;
	}
	
	public ImageIcon drawnMaze() {
		int width=305, height=305;
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		g.setColor( Color.BLACK );
		for(int i = 0; i < 61; i++){
			for(int j = 0; j < 61; j++){
				if(matriz[i][j] == 1) {
					g.fillRect(j*5,i*5,5,5);
				}
			}
		}
		return new ImageIcon(buffer);
	}


	@Override
	public void run(){
		img.setSize(0,0);
		img.setIcon(drawnMaze()); 
		for(int i = 0; i <= 305; i+=5) {
				img.setSize(i,305);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		play.setEnabled(true);
			
	}
}
