package kk.recursion;

import java.util.ArrayList;

public class Nqueens {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> answers = new ArrayList<>();
//        findQueensPosition1(4, 4, 0, new ArrayList<>(), answers);


        // Above method uses O(N) TC 3 times for checking the existence of queen in upper-left diag, lower-left diag, left. We can simply omit this by maintaining the hashCode DS for each of these 3 cases, reducing it to O(1)
        // For left checking, we can simply maintain an array of size 'totCol' and mark true if the element is in that row.
        // For lower-left diag, we observe that if we imagine totRow*totCol matrix and at each (r,c), we place the value of r+c, then the value on the lower-left||upper-right diags will be same. So, marking true if anything has been placed. Maximum value of r+c is (totRow-1+totCol-1). Size:(2*N-1)
        // Similarly for upper-left diag check, another matrix where each element will be ((N-1)+(col-row)), assuming totRow==totCol. Value at upper-left || lower-right diagonal will be same, ranging from [0, (totRow-1+totCol-1)]. Size of this DS is (2*N-1)
        // For both of the above diag conditions, if we maintain separate hashDS for each diag-check of size [0, (totRow-1+totCol-1)], then if we put any element in recursion|iteration , we will calculate the hash and mark it as true.
        // On coming back, we will remove from that hashDS as well.

        int totCol = 4, totRow = 4;
        boolean[] leftRow = new boolean[totCol], upperLeftDiag = new boolean[2*totRow - 1], lowerLeftDiag = new boolean[2*totRow - 1];
        findQueensPosition2(totRow, totCol, 0, leftRow, upperLeftDiag, lowerLeftDiag, new ArrayList<>(), answers);

        System.out.println(answers);
    }

    private static void findQueensPosition1(int totRow, int totCol, int curCol, ArrayList<ArrayList<Integer>> potentialAns, ArrayList<ArrayList<ArrayList<Integer>>> answers) {
        if (curCol == totCol) {
            answers.add(new ArrayList<>(potentialAns));
            return;
        }

        for (int curRow = 0; curRow < totRow; curRow++) {
            ArrayList<Integer> pairs = new ArrayList<>();
            pairs.add(curRow);
            pairs.add(curCol);
            if (canBePlaced1(pairs, potentialAns, totRow, totCol)) {
                potentialAns.add(new ArrayList<>(pairs));
                findQueensPosition1(totRow, totCol, curCol + 1, potentialAns, answers);
                potentialAns.remove(potentialAns.size() - 1);
            }
        }
    }

    private static boolean canBePlaced1(ArrayList<Integer> pairs, ArrayList<ArrayList<Integer>> potentialAns, int totRow, int totCol) {
        int row = pairs.get(0), col = pairs.get(1);

        for (int i = potentialAns.size() - 1; i >= 0; i--) {
            if (potentialAns.get(i).getFirst() == --row && potentialAns.get(i).getLast() == --col) {
                return false;
            }
        }

        row = pairs.get(0);
        col = pairs.get(1);
        for (int i = potentialAns.size() - 1; i >= 0; i--) {
            if (potentialAns.get(i).getFirst() == row) {
                return false;
            }
        }

        row = pairs.get(0);
        col = pairs.get(1);
        for (int i = potentialAns.size() - 1; i >= 0; i--) {
            if (potentialAns.get(i).getFirst() == ++row && potentialAns.get(i).getLast() == --col) {
                return false;
            }
        }

        return true;
    }

    private static void findQueensPosition2(int totRow, int totCol, int currentCol, boolean[] leftRow, boolean[] upperLeftDiag, boolean[] lowerLeftDiag, ArrayList<ArrayList<Integer>> potentialAns, ArrayList<ArrayList<ArrayList<Integer>>> answers) {
        if (currentCol == totCol) {
            answers.add(new ArrayList<>(potentialAns));
            return;
        }

        for (int i = 0; i < totRow; i++) {
            if (leftRow[i] == false && lowerLeftDiag[i+currentCol] == false && upperLeftDiag[(totCol-1)+(currentCol-i)] == false) {
                ArrayList<Integer> pairs = new ArrayList<>();
                pairs.add(i);
                pairs.add(currentCol);
                potentialAns.add(pairs);
                leftRow[i] = true;
                upperLeftDiag[totCol - 1 + currentCol - i] = true;
                lowerLeftDiag[currentCol + i] = true;
                findQueensPosition2(totRow, totCol, currentCol + 1, leftRow, upperLeftDiag, lowerLeftDiag, potentialAns, answers);
                potentialAns.remove(potentialAns.size() - 1);
                leftRow[i] = false;
                upperLeftDiag[totCol - 1 + currentCol - i] = false;
                lowerLeftDiag[currentCol + i] = false;
            }
        }
    }
}
