import java.awt.*;

public class Grid {
    private int rows;
    private int cols;
    private int cellSize;
    private Cell[][] cells;
    private Cell highlightedCell;

    public Grid(int rows, int cols, int cellSize){
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.cells = new Cell[rows][cols];
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                cells[i][j] = new Cell(i*cellSize+10, j*cellSize+10, cellSize);
            }
        }
    }

    public void updateHighlight(Point mousePos){
        int x = (mousePos.x - 10) / cellSize;
        int y = (mousePos.y - 10) / cellSize;

        if(x>=0 && x<rows && y>=0 && y<cols)
        {
            if(highlightedCell != null)
            {
                highlightedCell.setHighlighted(false);
            }
            highlightedCell = cells[x][y];
            highlightedCell.setHighlighted(true);
        }
    }

    public void paint(Graphics g){
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                cells[i][j].paint(g);
            }
        }
    }
}
