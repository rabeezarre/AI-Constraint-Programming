package cp.csp.australia;

import cp.csp.core.Assignment;
import cp.csp.core.BacktrackingStrategy;
import cp.csp.core.CSP;
import cp.csp.core.CSPStateListener;


public class MapCSPMain {
    public static void main(String[] args) {
        MapCSP map = new MapCSP();
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
