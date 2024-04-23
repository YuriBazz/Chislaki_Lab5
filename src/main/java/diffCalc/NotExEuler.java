package diffCalc;

import org.jfree.data.xy.XYSeries;

import java.util.ArrayList;

public class NotExEuler implements IgetSeries {
    private final double h;

    private double f(double x, double y){
        return y / (1 - 50 * h * (x - 0.6)*(x - 0.85));
    }

    public NotExEuler(double h){
        this.h = h;
    }

    public XYSeries getSeries(){
        var result = new XYSeries("Неявный метод Эйлера");
        var y = new ArrayList<Double>();
        y.add(0.1);
        result.add(0,0.1);
        for(double x = h; x < 1 + h; x+=h){
            y.add(f(x, y.getLast()));
            result.add(x, y.getLast());
        }
        return result;
    }
}
