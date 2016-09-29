package br.com.matcomp.methods;

import br.com.matcomp.model.NewtonRaphson;
import br.com.matcomp.view.Screen;

public class NewtonRaphsonMethod {

	public void calculate(NewtonRaphson newtonRaphson, Screen screen) {	
		
		while(newtonRaphson.getPrecision() != true) {		
			double opposite = calculateCateto(newtonRaphson.getArray(), newtonRaphson.getInitialValue());	
			double adjacent = calculateCateto(newtonRaphson.getDerived(), newtonRaphson.getInitialValue());			
			double tangent = opposite / adjacent;
			
			double x = newtonRaphson.getInitialValue() - tangent;
							
			screen.printMessage(Double.toString(x));
			
			if(Math.abs(newtonRaphson.getInitialValue() - x) < newtonRaphson.getErro()) {
				newtonRaphson.setPrecision(true);
			}
			newtonRaphson.setInitialValue(x);			
		}
		
	}

	private double calculateCateto(double[] array, double initialValue) {
		int degree = array.length - 1;		
		double y = 0;
		
		for (double value : array) {
			y += value * Math.pow(initialValue, degree); 
			degree--;
		}

		return y;
	}
}
