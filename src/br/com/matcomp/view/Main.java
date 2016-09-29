package br.com.matcomp.view;

public class Main {

	public static void main(String[] args) {
		Screen screen = new Screen();
		int option = 0;
		
		do{
			option = screen.printMenu();
			Solution solution = new Solution();
			solution.callMethod(option);			
		}while(option != 0);		
	}
}
