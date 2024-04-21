package diffCalc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Application {
    public static void creatre(){
        var H = new double[]{0.1, 0.01, 0.001};
        for(var h : H){
            var func = new OriginalFunction(h);
            var euler = new Euler(h);
            var neuler = new NotExEuler(h);
            var adams = new Adams(h);
            var filed = new XYSeriesCollection(func.getSeries());
            filed.addSeries(euler.getSeries());
            filed.addSeries(neuler.getSeries());
            filed.addSeries(adams.getSeries());

            var chart =
                    ChartFactory.
                            createXYLineChart
                                    ("y' = 50y(x-0.6)(x-0.85): y(0) = 0.1", "", "",
                                            filed,
                                            PlotOrientation.VERTICAL,
                                            true,true,true);

            JFrame frame = new JFrame(String.format("Графики при h = %.3f", h));
            frame.getContentPane().add(new ChartPanel(chart));
            frame.setSize(900,800);
            frame.setVisible(true);
        }
    }
}
