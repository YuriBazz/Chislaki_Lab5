package diffCalc;

import org.jfree.data.xy.XYSeries;

public class OriginalFunction implements IgetSeries {

    private final double h;
    private double function(double x){
        return 0.1 * Math.exp(50.0/3 * x *x *x - 72.5/2 * x * x + 25.5 * x);
    }

    public OriginalFunction(double h){
        this.h = h;
    }

    public XYSeries getSeries(){
        var result = new XYSeries("Точная функция");
        for(double x = 0; x < 1 + h; x+=h){
            result.add(x, function(x));
        }
        return result;
    }
}
