package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.Domain;
import fr.emse.ai.csp.core.Variable;

public class SimpleCSP extends CSP {
    public static final Variable X = new Variable("X");
    public static final Variable Y = new Variable("Y");
    public static final Variable Z = new Variable("Z");

    public SimpleCSP() {
        collectVariables();

        Domain numbers = new Domain(new Object[]{1,2,3,4,5,6,7,8,9,10});

        for (Variable var : getVariables())
            setDomain(var, numbers);

        addConstraint(new C1(X, Y));
        addConstraint(new C2(X, Z));
        addConstraint(new C3(Y, Z));

    }

    private void collectVariables() {
        addVariable(X);
        addVariable(Y);
        addVariable(Z);
    }


}
