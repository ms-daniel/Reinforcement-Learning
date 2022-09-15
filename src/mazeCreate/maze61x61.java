package mazeCreate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class maze61x61 {
	private int[][] matriz = new int[61][61];
	private BufferedImage buffer;
	
	public maze61x61(int[][] matriz) {
		this.matriz = matriz;
	}
	
	public ImageIcon drawnMaze() {
		int width=310, height=310;
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		g.setColor( Color.BLACK );
		for(int i = 0; i < 61; i++){
			for(int j = 0; j < 61; j++){
				
			}
		}
		/*for(int i=0;i <= 305; i+=5)
			for(int j = 0; j <= 305; j+=5) {
				System.out.println(i + " ");
				
				if((i == 0 || i == 305)) {
					g.fillRect(j,i,5,5);
					
				}
				if((i <= 305) && (j == 0 || j == 305)) {
					g.fillRect(j,i,5,5);
				}
			}*/
		
		//g.drawLine(0,0,width,height);
		return new ImageIcon(buffer);
	}
}
