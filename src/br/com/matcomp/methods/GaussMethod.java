package br.com.matcomp.methods;

import br.com.matcomp.model.Gauss;
import br.com.matcomp.view.Screen;

public class GaussMethod {

	public void calculate(Gauss gauss, Screen screen) {
		int iterations = 0;
        for (int k = 0; k < gauss.getMatrixLength(); k++) 
        {
            int max = k;
            for (int line = k + 1; line < gauss.getMatrixLength(); line++)             	
                if (Math.abs(gauss.getMatrixValue(line, k)) > Math.abs(gauss.getMatrixValue(max, k))) 
                    max = line;
    
            double[] temp = gauss.getMatrixLine(k);
            gauss.setMatrixLine(k, gauss.getMatrixLine(max));
            gauss.setMatrixLine(max, temp); 
            
            double t = gauss.getSolutionsValue(k);
            gauss.setSolution(k, gauss.getSolutionsValue(max));
            gauss.setSolution(max, t);
            
            for (int line = k + 1; line < gauss.getMatrixLength(); line++) 
            {            	
                double factor = gauss.getMatrixValue(line, k) / gauss.getMatrixValue(k, k);
                double solutionValue = gauss.getSolutionsValue(line) - factor * gauss.getSolutionsValue(k);
                gauss.setSolution(line, solutionValue);      
                
                for (int column = k; column < gauss.getMatrixLength(); column++){
                	double matrixValue = gauss.getMatrixValue(line, column) - factor * gauss.getMatrixValue(k, column);
                    gauss.setMatrixValue(line, column, matrixValue);                      
                }                
            }            
        }
 
        double[] solution = new double[gauss.getMatrixLength()];
        for (int line = gauss.getMatrixLength() - 1; line >= 0; line--) 
        {
            double sum = 0.0;
            for (int column = line + 1; column < gauss.getMatrixLength(); column++)             	
                sum += gauss.getMatrixValue(line, column) * solution[column];  
            double diagonal = gauss.getMatrixValue(line, line);
            solution[line] = (gauss.getSolutionsValue(line) - sum) / diagonal;
        }        
        
        gauss.setSolutions(solution);
	}

}
