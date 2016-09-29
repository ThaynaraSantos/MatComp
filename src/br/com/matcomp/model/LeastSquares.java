package br.com.matcomp.model;

public class LeastSquares {

	private double[][] matrix;
	private int qtd;
	private double[] array_x;
	private double[] array_y;
	private double[] array_result;
	private double a0;
	private double a1;	
	
	public LeastSquares(double[][] matrix){
		this.matrix = matrix;
		this.qtd = matrix.length;
		this.array_x = new double[this.qtd];
		this.array_y = new double[this.qtd];
		this.array_result = new double[this.qtd];
	}

	public int getQtd() {
		return qtd;
	}

	public double getMatrixValue(int line, int column) {
		return this.matrix[line][column];
	}

	public void setArray_x(int line, double x) {
		this.array_x[line] = x;		
	}

	public void setArray_y(int line, double y) {
		this.array_y[line] = y;			
	}

	public double getArray_xValue(int line) {
		return this.array_x[line];
	}	
	
	public double getArray_yValue(int line) {
		return this.array_y[line];
	}

	public void setA1(double a1) {
		this.a1 = a1;		
	}

	public void setA0(double a0) {
		this.a0 = a0;		
	}

	public double getA1() {
		return this.a1;
	}

	public double getA0() {
		return this.a0;
	}
	
	public double getLineEquationResult(int line) {
		return this.a1 * this.array_x[line] + this.a0;
	}

	public void setArray_result(int line, double lineEquationResult) {
		this.array_result[line] = lineEquationResult;	
	}
	
	public double getArray_resultValue(int line) {
		return this.array_result[line];
	}

	public double[] getArray_result() {
		return this.array_result;						
	}

	public double[] getArray_x() {
		return this.array_x;
	}

	public double[] getArray_y() {
		return this.array_y;
	}
}
