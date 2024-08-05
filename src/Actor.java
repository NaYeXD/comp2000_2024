import java.awt.Graphics;
import java.awt.Color;

public abstract class Actor {
    protected Cell cell;
    private Color color;

    //Constructor
    public Actor(Cell cell, Color color){
        this.cell = cell;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(cell.x, cell.y, Cell.size, Cell.size);
    }
}
