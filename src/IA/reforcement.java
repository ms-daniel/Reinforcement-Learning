package IA;

import java.util.Random;

public class reforcement extends Thread{
	//
	private float[][] qTable;
	private int[][] map;
	
	//numeros para percorrer a matriz
	private int start_C;
	private int start_L;
	private int linhaAtual;
	
	//maximos da matriz
	private int max_width;
	private int max_height;
	
	private Random random;
	
	public reforcement(int[][] matriz) {
		random = new Random();
		this.map = matriz;
		max_width = matriz.length;
		max_height = matriz[0].length;
		
		
	}
	
	public void run(){
		//metodo para começar em um lugar aleatorio
	}
	
	private void startSomewhere() {
		start_C = random.nextInt(max_width);
		start_L = random.nextInt(max_height);
		
		while(map[start_L][start_C] != 0) {
			start_L = random.nextInt(61);
			start_C = random.nextInt(61);
			//main.mostrar("");
		}
		
		linhaAtual = start_C + start_L + (max_width + start_L);
	}
	
	
	
}
