package diffCalc;

import org.jfree.data.xy.XYSeries;

import java.util.ArrayList;
import java.util.List;

public class Euler implements IgetSeries {
    private final double h;

    private double f(double x, double y){
        return 50 * y *(x - 0.6) * (x - 0.85);
    }

    public Euler(double h){
        this.h = h;
    }

    public XYSeries getSeries(){
        var result = new XYSeries("Явный метод Эйлера");
        List<Double> y = new ArrayList<>();
        y.add(0.1);
        result.add(0,0.1);
        for(double x = h; x< 1 + h; x+=h){
            y.add(y.get((int)(x/h) - 1) + h * f(x, y.get((int)(x/h) - 1)));
            result.add(x, y.getLast());
        }
        return result;
    }
}
