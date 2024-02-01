package fr.emse.ai.csp.nqueens;

import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.Domain;
import fr.emse.ai.csp.core.Variable;

public class NaturalNQueenCSP extends CSP {

    public NaturalNQueenCSP(int number) {
        collectVariables(number);

        ChessBoardCell[] chessboard = new ChessBoardCell[number*number];

        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                chessboard[number*row+col] = new ChessBoardCell(row, col);
            }
        }

        Domain numbers = new Domain(chessboard);

        for (Variable queen1 : getVariables()){
            setDomain(queen1, numbers);
            for (Variable queen2 : getVariables()) {
                if (queen1 != queen2) {
                    addConstraint(new QueenConstrain(queen1, queen2));
                }
            }
        }
    }

    private void collectVariables(int number) {
        for (int i = 0; i < number; i++) {
            addVariable(new Variable("queen"+Integer.toString(i)));
        }
    }
}
