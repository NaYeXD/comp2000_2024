import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel implements MouseMotionListener{
      Grid grid = new Grid();
      LinkedList<Point> mousePositions = new LinkedList<>();
      int trailLength = 100;

      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
        addMouseMotionListener(this);
      }

      @Override
      public void paint(Graphics g) {
        super.paint(g);
        grid.paint(g, getMousePosition());

        for(Point p:mousePositions)
        {
          g.setColor(new java.awt.Color(0, 0, 0, 50));
          g.fillOval(p.x - 5, p.y - 5, 15, 15);
        }
      }

      @Override
      public void mouseMoved(MouseEvent e)
      {
        if(mousePositions.size() >= trailLength)
        {
          mousePositions.removeFirst();
        }
        mousePositions.addLast(e.getPoint());
        repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e)
      {
        mouseMoved(e);
      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();

        //60 FPS +-
        try 
        {
          Thread.sleep(16); // roughly 60 FPS
        } 
        catch (InterruptedException e) 
        {
          e.printStackTrace();
        }
      }
    }
}
