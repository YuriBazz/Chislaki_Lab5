package diffCalc;

import org.jfree.data.xy.XYSeries;

import java.util.ArrayList;
import java.util.List;

public class Adams implements IgetSeries{
    private final double h;
    private final List<Double> y = new ArrayList<>();
    private final List<Double> f = new ArrayList<>();

    private double f(double x, double y){
        return 50 * y *(x - 0.6) * (x - 0.85);
    }

    private double y1(){
        var k1 = h * f(0,0.1);
        var k2 = h * f(h, 0.1 + k1);
        var k3 = h * f(h/2, 0.1 + 1/4.0 *k1 + 1/4.0 * k2);
        return 0.1 + 1.0/6 * k1 + 1.0/4 *k2 + 4.0/6 * k3;
    }

    private double nextY(){
        return y.getLast() + h/2 * (3 * f.getLast() -  f.get(f.size() - 2));
    }

    public Adams(double h){
        this.h = h;
        y.add(0.1);
        y.add(y1());
        f.add(f(0,0.1)); f.add(f(h, y.getLast()));
    }

    public XYSeries getSeries(){
        var result = new XYSeries("Явный двушаговый метод Адамса");
        result.add(0, 0.1); result.add(h, y.getLast());
        for(double x = 2 * h; x < 1 + h; x+=h){
            y.add(nextY());
            f.add(f(x, y.getLast()));
            result.add(x, y.getLast());
        }
        return result;
    }

}
