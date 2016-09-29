package br.com.matcomp.methods;

import br.com.matcomp.model.LeastSquares;

public class LeastSquaresMethod {

	public void calculate(LeastSquares leastSquares) {				
		for(int line = 0; line < leastSquares.getQtd(); line++){
			double x = leastSquares.getMatrixValue(line,0);
			double y = leastSquares.getMatrixValue(line,1);
			leastSquares.setArray_x(line, x);
			leastSquares.setArray_y(line, y);
		}
		
		double soma_x = 0;
		double soma_y = 0;
		double soma_produto = 0;
		double soma_quad_x = 0;

		for(int line = 0; line < leastSquares.getQtd(); line++){
			double x = leastSquares.getArray_xValue(line);
			double y = leastSquares.getArray_yValue(line);
			soma_x += x;
			soma_y += y;

			double produto = x*y;
			soma_produto += produto;

			double quad_x = x*x;
			soma_quad_x += quad_x;
		}

		double div_soma_x_qtd = soma_x / leastSquares.getQtd();
		double div_soma_y_qtd = soma_y / leastSquares.getQtd();

		double a1 = ((leastSquares.getQtd()*soma_produto)-(soma_x*soma_y))/((leastSquares.getQtd()*soma_quad_x)-(soma_x*soma_x));
		leastSquares.setA1(a1);
		
		double a0 = (div_soma_y_qtd-leastSquares.getA1()*div_soma_x_qtd);
		leastSquares.setA0(a0);
		
		for(int line = 0; line < leastSquares.getQtd(); line++){
			leastSquares.setArray_result(line, leastSquares.getLineEquationResult(line));
		}
		
	}

}
