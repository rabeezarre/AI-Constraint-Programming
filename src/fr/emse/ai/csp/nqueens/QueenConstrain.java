package fr.emse.ai.csp.nqueens;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class QueenConstrain implements Constraint {

    private final Variable queen1;
    private final Variable queen2;
    private List<Variable> scope;

    public QueenConstrain(Variable queen1, Variable queen2) {
        this.queen1 = queen1;
        this.queen2 = queen2;
        scope = new ArrayList<Variable>(2);
        scope.add(queen1);
        scope.add(queen2);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        ChessBoardCell cell1 = (ChessBoardCell) assignment.getAssignment(this.queen1);
        ChessBoardCell cell2 = (ChessBoardCell) assignment.getAssignment(this.queen2);

        if(cell1 == null) return true;
        if(cell2 == null) return true;

        if (cell1.getRow() == cell2.getRow() || cell1.getCol() == cell2.getCol()) {
            return false; //same col or row
        }

        int rowDiff = Math.abs(cell1.getRow() - cell2.getRow());
        int colDiff = Math.abs(cell1.getCol() - cell2.getCol());
        return rowDiff != colDiff; //same diagonal
    }
}
