package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.*;

public class SimpleCSPTest {
    public static void main(String[] args) {
        SimpleCSP map = new SimpleCSP();

        AC3Strategy ac3 = new AC3Strategy();

        System.out.println("Domains before AC-3:");
        for (Variable var : map.getVariables()) {
            System.out.println(var + ": " + map.getDomain(var));
        }

        ac3.reduceDomains(map);

        System.out.println("Domains after AC-3:");
        for (Variable var : map.getVariables()) {
            System.out.println(var + ": " + map.getDomain(var));
        }

        BacktrackingStrategy bts = new BacktrackingStrategy();
        bts.addCSPStateListener(new CSPStateListener() {
            @Override
            public void stateChanged(Assignment assignment, CSP csp) {
                System.out.println("Assignment evolved : " + assignment);
            }

            @Override
            public void stateChanged(CSP csp) {
                System.out.println("CSP evolved : " + csp);
            }
        });
        double start = System.currentTimeMillis();
        Assignment sol = bts.solve(map);
        double end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve = " + (end - start));
    }
}
