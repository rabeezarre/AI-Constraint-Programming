package fr.emse.ai.csp.nqueens;

import fr.emse.ai.csp.core.*;

public class SolveNaturalNQueenCSP {

    public static void main(String[] args) {
        for (int number = 4; number <= 25; number++) {
            solveNQueensWithBTS(number);

            // As number increases the complexity of the problem increases exponentially.
            // That can be seen from the time spend on calculations.
            // From number 12, time is too big to calculate.
            // The conclusion is that even though backtracking is effective with smaller number,
            // computation time can be too big due to exponential growth.

            solveNQueensWithMC(number);
            // Argument of strategy is a maximum number of iterations perform before giving up.
            // It is faster and more suitable for large problems but doesn't guarantee a solution.
            // For example, at maxSteps 40 it doesn't give results after 10.
            // At maxSteps = 80, it was able to give result for 25 queens.
            // Each time, time and solution is random because it starts with random variable.
            // During iterations, it focuses on variables that have conflict trying to minimize them.
            // And process is repeated until a solution is found.
            // In comparison to Backtracking algorithm, MinConflicts is more efficient for larger numbers,
            // but doesn't always provide answers.
        }
    }

    private static void solveNQueensWithMC(int number) {
        NaturalNQueenCSP map = new NaturalNQueenCSP(number);
        MinConflictsStrategy bts = new MinConflictsStrategy(80);
        double start = System.currentTimeMillis();
        Assignment sol = bts.solve(map);
        double end = System.currentTimeMillis();

        System.out.println("Solution with n = " + number + ":");
        printSolution(sol, number);
        System.out.println("Time to solve = " + (end - start) + " ms");
        System.out.println();
    }
    private static void solveNQueensWithBTS(int number) {
        NaturalNQueenCSP map = new NaturalNQueenCSP(number);
        BacktrackingStrategy bts = new BacktrackingStrategy();
        double start = System.currentTimeMillis();
        Assignment sol = bts.solve(map);
        double end = System.currentTimeMillis();

        System.out.println("Solution with n = " + number + ":");
        printSolution(sol, number);
        System.out.println("Time to solve = " + (end - start) + " ms");
        System.out.println();
    }

    private static void printSolution(Assignment assignment, int size) {
        if (assignment == null) {
            System.out.println("No solution found.");
            return;
        }

        for (int i = 0; i < size; i++) {
            ChessBoardCell cell = (ChessBoardCell) assignment.getAssignment(new Variable("queen" + i));
            if (cell != null) {
                System.out.println("Queen " + i + " [" + cell.getRow() + ", " + cell.getCol() + "]");
            }
        }

        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '_';
            }
        }

        for (int i = 0; i < size; i++) {
            ChessBoardCell cell = (ChessBoardCell) assignment.getAssignment(new Variable("queen" + i));
            if (cell != null) {
                board[cell.getRow()][cell.getCol()] = 'Q';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
