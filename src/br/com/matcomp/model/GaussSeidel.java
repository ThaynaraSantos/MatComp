package br.com.matcomp.model;

public class GaussSeidel {

	private double[] coefficients;
	private double[][] matrix;
	private boolean precision;
	
	public GaussSeidel(double[][] matrix) {
		this.matrix = matrix;				
		this.coefficients = new double[matrix.length];
		this.precision = false;
	}

	public double[] getCoefficients() {
		return coefficients;
	}
	
	public double getCoefficientsValue(int line) {
		return this.coefficients[line];
	}

	public int getMatrixLength() {
		return this.matrix.length;
	}
	
	public void setCoefficientsValue(int line, double value){
		this.coefficients[line] = value;
	}

	public boolean getPrecision() {
		return this.precision;
	}

	public double getMatrixValue(int line, int column) {
		return this.matrix[line][column];
	}

	public void setPrecision(boolean value) {
		this.precision = true;
	}
}
