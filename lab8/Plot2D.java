import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
public class Plot2D extends JPanel
{ 
    private double minX, minY, maxX, maxY;
    private double stepSize;
    private int scale;
    GeneralPath path, xCoord, yCoord;
    JFrame frame;  

    public Plot2D()
    {
       this.minX=-10;
       this.minY=-10;
       this.maxX=10;
       this.maxY=10;
       this.stepSize = 0.01;
       this.scale = 40;
       setPanelSize();

       frame =new JFrame();//creating instance of JFrame 
       frame.add(this);

       frame.pack(); 
       frame.setVisible(true);//making the frame visible 

    }

    private void setPanelSize()
    {
        int x_dim = (int)(maxX-minX)*this.scale;
        int y_dim = (int)(maxY-minY)*this.scale;
        this.setPreferredSize(new Dimension(x_dim, y_dim));
    }

    private void plotCoordinates()
    {
        xCoord = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 2);
        xCoord.moveTo(0, scale*maxY);
        xCoord.lineTo(scale *(maxX-minX), scale*maxY);

        yCoord = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 2);
        yCoord.moveTo(scale*(1-minX), 0);
        yCoord.lineTo(scale*(1-minX), scale*(maxY-minY));
    }

    public void plot(Function2D f)
    {
       plotCoordinates();

       int numPoints = (int)((maxX-minX)/stepSize);
       path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, numPoints);
       path.moveTo(scale*0, scale*(maxY-f.eval(minX)));

       double current = minX;
       while (current <= maxX)
       {
          current = current + stepSize;
          double yValue = f.eval(current);
          path.lineTo(scale*(current-minX), scale*(maxY-yValue));
       }

    }

    @Override
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D)g;
       g.setColor(Color.BLACK);
       g2.draw(this.xCoord);
       g2.draw(this.yCoord);

       g.setColor(Color.RED);
       g2.draw(this.path);
    }
}
  
