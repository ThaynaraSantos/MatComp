package br.com.matcomp.view;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.LineFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Chart extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	private XYDataset inputData;
	private JFreeChart chart;

	public Chart(){
		super("Método dos Mínimos Quadrados");
	}

	public void showChart(double[] array_x, double[] array_y, double[] result){

		this.inputData = createDatasetXY(array_x, array_y);
		this.chart = createChart(inputData);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);	
		
		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);		
		drawRegressionLine(result);
	}
	
	private XYDataset createDatasetXY(double[] array_x, double[] array_y){

		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("(X,Y)");

		for(int line = 0; line< array_x.length; line++){
			series.add(array_x[line],array_y[line]);
		}	
		
		dataset.addSeries(series);
		return dataset;
	}

	private XYDataset createDatasetResult(double[] result){

		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("(X,Y)");

	
		for(int line = 0; line< result.length; line++){
			series.add(line+1,result[line]);
		}	
		
		dataset.addSeries(series);
		return dataset;
	}
	
	private JFreeChart createChart(XYDataset inputData){
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Regressão Linear", "", "", inputData,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();
		plot.getRenderer().setSeriesPaint(0, Color.RED);
		return chart;
	}
	
	 private void drawRegressionLine(double[] result) {
		 this.inputData = createDatasetResult(result);
		 double regressionParameters[] = Regression.getOLSRegression(this.inputData,
		 0);
		 
		 LineFunction2D linefunction2d = new LineFunction2D(
		 regressionParameters[0], regressionParameters[1]);
		 
		 XYDataset dataset = DatasetUtilities.sampleFunction2D(linefunction2d,
		 0D, 7, 7, "Resultado");
		 
		 XYPlot xyplot = chart.getXYPlot();
		 xyplot.setDataset(1, dataset);
		 XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(
		 true, false);
		 xylineandshaperenderer.setSeriesPaint(0, Color.BLUE);
		 xyplot.setRenderer(1, xylineandshaperenderer);
	 }
	
}