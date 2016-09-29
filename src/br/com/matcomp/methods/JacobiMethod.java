package br.com.matcomp.methods;

import br.com.matcomp.model.Jacobi;
import br.com.matcomp.view.Screen;

public class JacobiMethod {

	public void calculate(Jacobi jacobi, Screen screen) {
		int iterations = 0;
		while(jacobi.getPrecision() != true) {
			double[] primary = jacobi.getCoefficients().clone();
			
            for (int line = 0; line < jacobi.getMatrixLength(); line++) {
            	double sum = jacobi.getMatrixValue(line, jacobi.getMatrixLength());
 
                for (int column = 0; column < jacobi.getMatrixLength(); column++)
                    if (column != line)
                    	sum -= jacobi.getMatrixValue(line, column) * primary[column];

                double diagnonal = jacobi.getMatrixValue(line, line);
                jacobi.setCoefficientsValue(line, 1/diagnonal* sum);
                
                screen.printIteractions(iterations++, jacobi.getMatrixLength(), jacobi.getCoefficients());                
                
				if(Math.abs(jacobi.getCoefficientsValue(line) - primary[line]) < 0.0000001) {
					jacobi.setPrecision(true);
				}
            }           
            
		}		
	}
	
}
