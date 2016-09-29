package br.com.matcomp.model;

public class Gauss {

	private double[][] matrix;
	private double[] solutions;
	
	public Gauss(double[][] matrix) {
		this.matrix = new double[matrix.length][matrix.length];
		this.solutions = new double[matrix.length];
		
		for(int line = 0; line < matrix.length; line++){
			for(int column = 0; column <= matrix.length; column++){
				if(column == matrix.length){
					this.solutions[line] = matrix[line][column];
				}else{
					this.matrix[line][column] = matrix[line][column];
				}				
			}
		}
	}

	public double[] getSolutions() {
		return this.solutions;
	}

	public int getMatrixLength() {
		return this.matrix.length;
	}

	public double getMatrixValue(int line, int column) {
		return this.matrix[line][column];
	}
	
	public double getSolutionsValue(int line) {
		return this.solutions[line];
	}

	public void setSolution(int line, double value) {
		this.solutions[line] = value;		
	}

	public void setMatrixValue(int line, int column, double matrixValue) {
		this.matrix[line][column] = matrixValue;
	}

	public double[] getMatrixLine(int line) {
		return this.matrix[line];
	}

	public void setMatrixLine(int line, double[] matrixLine) {
		this.matrix[line] = matrixLine;		
	}

	public void setSolutions(double[] solution) {
		this.solutions = solution;		
	}
}
