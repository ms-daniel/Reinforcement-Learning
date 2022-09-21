package IA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class archieve {
	private static FileWriter arq;
	private PrintWriter gravarArq;
	
	public archieve() {
		
	}
	
	/**
	 * @param matriz - a matriz que ira receber os valores da tabela Q
	 * @param file - o nome do arquivo dentro da pasta do projeto (ex: "qTable.txt"), e preferencial que o arquvio esteja separado por virgulas
	 */
	public void loadFileInMe(float[][] matriz, String file) {
		BufferedReader buffRead = null;
		try{
			buffRead = new BufferedReader(new FileReader(file));
			
			String linha = "";
			String[] matSTR = new String[4];
			
			linha = buffRead.readLine();
			
			for(int i = 0; linha != null; i++) {
				matSTR = linha.split(";");
				
				matriz[i][0] = Float.parseFloat(matSTR[0]);
				matriz[i][1] = Float.parseFloat(matSTR[1]);
				matriz[i][2] = Float.parseFloat(matSTR[2]);
				matriz[i][3] = Float.parseFloat(matSTR[3]);
				
				linha = buffRead.readLine();
			}
		}catch(IOException e) {
			
		}catch(ArrayIndexOutOfBoundsException e) {
			//quando não há arquivo para ler
			for(int i = 0; i < matriz.length; i++)
				Arrays.fill(matriz[i], 0);
		}finally {
			try {
				buffRead.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param matriz - a matriz que contem os valores que serao salvos no arquivo
	 * @param file - o nome do arquivo dentro da pasta do projeto onde sera salvas as informacoes (ex: "qTable.txt")
	 */
	public void saveFile(float[][] matriz , String file) {
		try {
			arq = new FileWriter(file);
			gravarArq = new PrintWriter(arq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < 36; i++) {
			for(int j =0; j < 4; j++) {
				gravarArq.print(matriz[i][j]);
				gravarArq.print(";");
			}
			gravarArq.println();
		}
		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gravarArq.close();
	}
	
}
