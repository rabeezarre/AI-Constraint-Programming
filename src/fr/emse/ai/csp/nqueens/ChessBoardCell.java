package fr.emse.ai.csp.nqueens;

public class ChessBoardCell {
    private final int row;
    private final int col;

    public ChessBoardCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
