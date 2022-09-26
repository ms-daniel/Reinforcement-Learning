package IA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

public class archieve {
	private File arqF;
	private static FileWriter arq;
	private PrintWriter gravarArq;
	
	public archieve() {
		
	}
	
	/**
	 * @param matriz - a matriz que ira receber os valores da tabela Q
	 * @param file - o nome do arquivo dentro da pasta do projeto (ex: "qTable.txt"), e preferencial que o arquvio esteja separado por virgulas
	 */
	public void loadFileInMe(double[][] matriz, String file) {
		BufferedReader buffRead = null;
		try{
			arqF = new File(file);
			
			//caso o arquivo nao exista
			if(!arqF.exists())
				arqF.createNewFile();
			
			buffRead = new BufferedReader(new FileReader(arqF));
			
			String linha = "";
			String[] matSTR = new String[4];
			
			linha = buffRead.readLine();
			
			for(int i = 0; linha != null; i++) {
				matSTR = linha.split(";");
				
				matriz[i][0] = Double.parseDouble(matSTR[0]);
				matriz[i][1] = Double.parseDouble(matSTR[1]);
				matriz[i][2] = Double.parseDouble(matSTR[2]);
				matriz[i][3] = Double.parseDouble(matSTR[3]);
				
				linha = buffRead.readLine();
			}
			
		}catch(IOException e) {
			
		}catch(ArrayIndexOutOfBoundsException e) {
			fillMatriz(matriz);
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
	public void saveFile(double[][] matriz , String file, int leng) {
		try {
			arq = new FileWriter(file);
			gravarArq = new PrintWriter(arq);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < leng; i++) {
			for(int j =0; j < 4; j++) {
				if(matriz[i][j] > 0)
					matriz[i][j] *= 0.01;
				gravarArq.print(truncar(matriz[i][j]));
				
				gravarArq.print(";");
			}
			gravarArq.println();
		}
		//truncar(matriz[0][0]);
		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gravarArq.close();
	}
	
	private void fillMatriz(double[][] matriz) {
		//quando não há arquivo para ler
		for(int i = 0; i < matriz.length; i++)
			Arrays.fill(matriz[i], 0);
	}
	
	 private String truncar(Double valor) {
		 Number number = valor;
		 if(valor > 0) {
			 Locale[] locales = NumberFormat.getAvailableLocales();
			 NumberFormat form;
	
	         form = NumberFormat.getPercentInstance(locales[990]);
	         form.setMaximumFractionDigits(10);
	
	         try {
	            number = form.parse(form.format(valor));
	         } catch (ParseException e) {}
		 }
         
         return number.toString();
	 }
	
}
