package myMath;

import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class Graph extends JFrame {
	private double eps=0.1;
    public Graph(Polynom p,double x0,double x1) {
    	double area=p.area(x0, x1,  0.01);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        DataTable Extreme = new DataTable(Double.class, Double.class);
        DataTable data = new DataTable(Double.class, Double.class);
    	String extreme=("Extreme Points: ");
        for (double x = x0; x <= x1; x+=eps) {
			double y = p.f(x);
			if (isEx(p,x,eps)) {
				extreme=extreme+"("+x+","+y+") ";
				Extreme.add(x, y);
			}else {
			data.add(x, y);
			}
		}
        if(extreme.equals("Extreme Points: ")) {
			extreme="there is no Extreme Points";
		}
        XYPlot plot = new XYPlot(data,Extreme);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        Color colorExtreme = new Color(1f, 0f, 0f);
        plot.getPointRenderers(Extreme).get(0).setColor(colorExtreme);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
        System.out.println(extreme +"\nthe area is: "+area);
    }
    public static boolean isEx(Polynom p,double x, double eps) {
    	Polynom_able dx = p.derivative();
			if(dx.f(x)<=-0.001 || dx.f(x)>=-0.001) {
				if(dx.f(x-eps)>=0&&dx.f(x+eps)<=0) {
				return true;
				}
				if(dx.f(x-eps)<=0&&dx.f(x+eps)>=0) {
					return true;
				}
			}
			return false;
    }
    public static void main(String[] args) {
	Polynom p=new Polynom("0.2x^4-1.5x^3+3x^2-x-5");
	double start=-2;
	double finish=6;
	p.GUI(start, finish);
    }
}
