package myMath;

import java.awt.Color;
import myMath.Polynom;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class Graph extends JFrame {

	public Graph(Polynom p,double x0,double x1, double eps ) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);

        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = x0; x <= x1; x+=eps) {
            double y = p.f(x);
            data.add(x, y);
        }
        XYPlot plot = new XYPlot(data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
     // Draw a tick mark and a grid line every 10 units along x axis
        plot.getAxisRenderer(XYPlot.AXIS_X).setTickSpacing(10.0);
        // Draw a tick mark and a grid line every 20 units along y axis
        plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(20.0);
    }

    public static void main(String[] args) {
    	Polynom p=new Polynom ("2x^2");
    	double x0=-6;
    	double x1=10;
    	double eps=0.5;
        Graph frame = new Graph(p,x0,x1,eps);
        frame.setVisible(true);
    

}}
