import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Point;

public class Canvas extends JPanel{
    private Stage stage;

    public Canvas(){
        setPreferredSize(new Dimension(720, 720));
        stage = new Stage();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        stage.paint(g, getMousePosition());
    }
}
