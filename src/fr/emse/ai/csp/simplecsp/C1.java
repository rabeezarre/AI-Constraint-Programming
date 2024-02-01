package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class C1 implements Constraint {
    private final Variable var1;
    private final Variable var2;
    private final List<Variable> scope;

    public C1(Variable var1, Variable var2) {
        this.var1 = var1;
        this.var2 = var2;
        scope = new ArrayList<Variable>(2);
        scope.add(var1);
        scope.add(var2);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        Integer val1 = (Integer) assignment.getAssignment(this.var1);
        Integer val2 = (Integer) assignment.getAssignment(this.var2);
        return val2 == null || val1 + val2 == 9;
    }
}
