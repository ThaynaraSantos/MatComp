package br.com.matcomp.methods;

import br.com.matcomp.model.GaussSeidel;
import br.com.matcomp.view.Screen;

public class GaussSeidelMethod {
	public void calculate(GaussSeidel gaussSeidel, Screen screen) {
		int iterations = 0;
		while(gaussSeidel.getPrecision() != true) {
			double[] primary = gaussSeidel.getCoefficients().clone();
			
            for (int line = 0; line < gaussSeidel.getMatrixLength(); line++) {
            	double sum = gaussSeidel.getMatrixValue(line, gaussSeidel.getMatrixLength());
 
                for (int column = 0; column < gaussSeidel.getMatrixLength(); column++)
                    if (column != line)
                    	sum -= gaussSeidel.getMatrixValue(line, column) * gaussSeidel.getCoefficientsValue(column);

                double diagnonal = gaussSeidel.getMatrixValue(line, line);
                gaussSeidel.setCoefficientsValue(line, 1/diagnonal* sum);
                
                screen.printIteractions(iterations++, gaussSeidel.getMatrixLength(), gaussSeidel.getCoefficients());                
                
				if(Math.abs(gaussSeidel.getCoefficientsValue(line) - primary[line]) < 0.0000001) {
					gaussSeidel.setPrecision(true);
				}
            }               
		}
	}
}
