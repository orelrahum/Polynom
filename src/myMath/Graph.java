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
    public Graph(Polynom p,double x0,double x1, double eps) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        DataTable Extreme = new DataTable(Double.class, Double.class);
        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = x0; x <= x1; x+=eps) {
			double y = p.f(x);
			if (isEx(p,x)) {
				Extreme.add(x, y);
			}else {
			data.add(x, y);
			}
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
    }
    public static boolean isEx(Polynom p,double x) {
    	Polynom_able dx = p.derivative();
			if(dx.f(x)==0) {
				return true;
			}
			return false;
    }
    public static void main(String[] args) {
    	Polynom p=new Polynom ("x^5-5x^4+5x^3");
		double x0=-6;
		double x1=10;
		double eps=0.5;
		Graph frame = new Graph(p,x0,x1,eps);
		frame.setVisible(true);
    }
}
