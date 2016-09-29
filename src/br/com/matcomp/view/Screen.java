package br.com.matcomp.view;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Screen {
	
	private String filePath = "C:\\matrix\\";
	
	public int printMenu(){
		System.out.println("---------------------------------------");
		System.out.println("|Escolha um dos métodos abaixo:       |");
		System.out.println("|-------------------------------------|");
		System.out.println("|[1] Gauss                            |");
		System.out.println("|[2] Jacobi                           |");
		System.out.println("|[3] Gauss-Seidel                     |");
		System.out.println("|[4] Newton-Raphson                   |");
		System.out.println("|[5] Mínimos Quadrados                |");
		System.out.println("|-------------------------------------|");
		System.out.println("|[0] Sair                             |");
		System.out.println("---------------------------------------");
		
		return readOption();
	}

	private int readOption() {
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		return option;
	}

	public double[][] readFile(String fileName) {		
	    Scanner ler = new Scanner(System.in);   
	    String path = this.filePath + fileName;
	    
	    try {
	      int countLine = 0;
	      int countColumn = 0;
		      
	      FileReader arq = new FileReader(path);
	      BufferedReader readFile = new BufferedReader(arq);	 

	      String stream = readFile.readLine(); 
	      if(stream != null){
	    	  do{
	    		  countLine++;
	    		  int columnLengh = stream.split("\\s+").length;
	    		  if(columnLengh > countColumn) countColumn = columnLengh;
	    		  stream = readFile.readLine();
	    	  }while(stream != null);
	    	  
	    	  arq = new FileReader(path);
	    	  readFile = new BufferedReader(arq);	 
			      
	    	  int line = 0;
	    	  double[][] matrix = new double[countLine][countColumn];

	    	  stream = readFile.readLine();
	    	  do{
	    		  String[] columns = stream.split("\\s+");
	    		  for(int column = 0; column < countColumn; column++){
	    			  matrix[line][column] = Double.parseDouble(columns[column].replace(',', '.'));
	    		  }					
	    		  stream = readFile.readLine();
	    		  line++;
	    	  }while(stream != null);    
	    	  
	    	  arq.close();	    	  
	    	  return matrix;
	      }
      
	      arq.close();	      
	      return null;
	    } catch (IOException e) {
	    	System.out.println("Erro: Abertura do arquivo: "+ e.getMessage());
	    	return null;
	    }
	}

	public void printMessage(String message) {
		System.out.println(message);		
	}

	public void printlnArray(String description, double[] array) {
		System.out.println();
		
		System.out.println(description);
		for(int line = 0; line < array.length; line++){
			System.out.println(array[line]);
		}
		System.out.println();
	}

	public int getInitialValue() {
		System.out.println("Digite o valor inicial, por favor:");
		return readOption();
	}

	public void printArray(String description, double[] array) {
		System.out.println();
		
		System.out.println(description);
		for(int line = 0; line < array.length; line++){
			System.out.print(array[line] + " ");
		}
		System.out.println();		
	}

	public void printIteractions(int iterations, int length, double[] coefficients) {
        System.out.print("X_" + iterations + " = {");
        for (int line = 0; line < length; line++)
            System.out.print(coefficients[line] + " ");
        System.out.println("}");
	}
}
