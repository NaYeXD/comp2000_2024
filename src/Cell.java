import java.awt.*;

public class Cell {
    private int x;
    private int y;
    private int size;
    private Color fillColor;
    private Color borderColor;
    private boolean highlighted;

    public Cell(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.fillColor = Color.WHITE;
        this.borderColor = Color.BLACK;
        this.highlighted = false;
    }

    public void setHighlighted(boolean highlighted)
    {
        this.highlighted = highlighted;
        this.fillColor = highlighted ? Color.GRAY : Color.WHITE;
    }

    public void paint(Graphics g){
        g.setColor(fillColor);
        g.fillRect(x, y, size, size);
        g.setColor(borderColor);
        g.drawRect(x, y, size, size);
    }
}
