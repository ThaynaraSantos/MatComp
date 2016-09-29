package br.com.matcomp.model;

public class Jacobi {

	private double[] coefficients;
	private double[][] matrix;
	private boolean precision;
	
	public Jacobi(double[][] matrix) {
		this.matrix = matrix;				
		this.coefficients = new double[matrix.length];
		this.precision = false;
	}
	
	public double getCoefficientsValue(int line) {
		return this.coefficients[line];
	}

	public int getMatrixLength() {
		return this.matrix.length;
	}

	public boolean getPrecision() {
		return this.precision;
	}

	public double[] getCoefficients() {
		return this.coefficients;
	}
	
	public double getMatrixValue(int line, int column) {
		return this.matrix[line][column];
	}
	
	public void setCoefficientsValue(int line, double value){
		this.coefficients[line] = value;
	}
	
	public void setPrecision(boolean value) {
		this.precision = true;
	}
}
