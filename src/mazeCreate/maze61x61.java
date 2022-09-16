package mazeCreate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class maze61x61 {
	private int[][] matriz = new int[61][61];
	private BufferedImage buffer;
	
	public maze61x61(int[][] matriz) {
		this.matriz = matriz;
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
}
