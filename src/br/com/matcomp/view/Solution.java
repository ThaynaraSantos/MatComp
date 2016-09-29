package br.com.matcomp.view;

import br.com.matcomp.enums.MethodEnum;
import br.com.matcomp.methods.*;
import br.com.matcomp.model.Gauss;
import br.com.matcomp.model.GaussSeidel;
import br.com.matcomp.model.Jacobi;
import br.com.matcomp.model.LeastSquares;
import br.com.matcomp.model.NewtonRaphson;

public class Solution {

	public void callMethod(int option) {
		MethodEnum method = MethodEnum.fromInt(option);
		
		switch(method){
			case NENHUM: System.out.println("INFO: Obrigada por utilizar nosso sistema."); break;
			case GAUSS: buildGauss(); break;
			case JACOBI: buildJacobi(); break;
			case GAUSS_SEIDEL: buildGaussSeidel(); break;
			case NEWTON_RAPHSON: buildNewtonRaphson(); break;
			case LEAST_SQUARES: buildLeastSquares(); break;
			default: System.out.println("ERRO: Método não encontrado."); break;			
		}
	}

	private void buildGauss() {
		Screen screen = new Screen();
		double[][] matrix = screen.readFile("gauss.txt");

		Gauss gauss = new Gauss(matrix);
		GaussMethod method = new GaussMethod();
		method.calculate(gauss, screen);
		
		screen.printMessage("Resultado: ");
		for(int line = 0; line < gauss.getMatrixLength(); line++) {
			screen.printMessage("X"+(line+1)+": "+Double.toString(gauss.getSolutionsValue(line)));
		}
	}

	private void buildJacobi() {
		Screen screen = new Screen();
		double[][] matrix = screen.readFile("jacobi.txt");

		Jacobi jacobi = new Jacobi(matrix);
		JacobiMethod method = new JacobiMethod();
		method.calculate(jacobi, screen);
		
		screen.printMessage("Resultado: ");
		for(int line = 0; line < jacobi.getMatrixLength(); line++) {
			screen.printMessage("X"+(line+1)+": "+Double.toString(jacobi.getCoefficientsValue(line)));
		}
	}

	private void buildGaussSeidel() {
		Screen screen = new Screen();
		double[][] matrix = screen.readFile("gauss_seidel.txt");

		GaussSeidel gaussSeidel = new GaussSeidel(matrix);
		GaussSeidelMethod method = new GaussSeidelMethod();
		method.calculate(gaussSeidel, screen);
		
		screen.printMessage("Resultado: ");
		for(int line = 0; line < gaussSeidel.getMatrixLength(); line++) {
			screen.printMessage("X"+(line+1)+": "+Double.toString(gaussSeidel.getCoefficientsValue(line)));
		}
	}

	private void buildNewtonRaphson() {
		Screen screen = new Screen();
		double[][] matrix = screen.readFile("new_raph.txt");
		int initial_value = screen.getInitialValue();
		
		if(matrix != null){
			NewtonRaphson newtonRaphson = new NewtonRaphson(initial_value, matrix);
			screen.printArray("Derivada: ", newtonRaphson.getDerived());
			screen.printMessage("Resultado: ");
			NewtonRaphsonMethod method = new NewtonRaphsonMethod();
			method.calculate(newtonRaphson, screen);
		}else{
			screen.printMessage("ERRO: Dados não identificados.");
		}
	}

	private void buildLeastSquares() {
		Screen screen = new Screen();		
		
		double[][] matrix = screen.readFile("least_squares.txt");

		if(matrix != null){
			LeastSquares leastSquares = new LeastSquares(matrix);
			LeastSquaresMethod method = new LeastSquaresMethod();
			method.calculate(leastSquares);

			screen.printMessage("A0 = " + leastSquares.getA0());
			screen.printMessage("A1 = " + leastSquares.getA1());	
			
			Chart chart = new Chart();
			chart.showChart(leastSquares.getArray_x(), leastSquares.getArray_y()
					, leastSquares.getArray_result());		
			
			screen.printlnArray("Resultado: ", leastSquares.getArray_result());
			
		}else{
			screen.printMessage("ERRO: Dados não identificados.");
		}

	}
	

}
