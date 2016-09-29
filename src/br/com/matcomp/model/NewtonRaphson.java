package br.com.matcomp.model;

public class NewtonRaphson {

	private double initial_value;
	private double[] array;
	private boolean precision;
	private double erro;	
	private double[] derived;
	
	public NewtonRaphson(int initial_value, double[][] matrix) {
		this.initial_value = initial_value;
		this.precision = false;
		this.erro = 0.00001;
		this.array = matrix[0];
		this.calculateDerived();
	}

	private void calculateDerived() {
		this.derived = new double[this.array.length-1];
		
		int degree = array.length - 1;
		for(int column = 0; column < this.array.length - 1; column++) {
			derived[column] = this.array[column] * degree;
			degree--;
		}		
	}

	public double[] getDerived() {
		return this.derived;
	}

	public boolean getPrecision() {
		return this.precision;
	}

	public double getInitialValue() {
		return this.initial_value;
	}

	public double[] getArray() {
		return this.array;
	}

	public double getErro() {
		return this.erro;
	}

	public void setPrecision(boolean value) {
		this.precision = true;		
	}

	public void setInitialValue(double value) {
		this.initial_value = value;		
	}
}
