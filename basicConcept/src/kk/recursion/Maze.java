package kk.recursion;

import kk.oops.interfaces.nestedinterface.A;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        System.out.println(mazeRightDown(0, 0, 3, 3));
        ArrayList<String> answers = new ArrayList<>();
        mazeRightDownPath(0, 0, 3, 3, "", answers);
        System.out.println(answers);

        System.out.println(mazeRightDownDiagRD(0, 0, 3, 3));
        answers = new ArrayList<>();
        mazeRightDownDiagRDPath(0, 0, 3, 3, "", answers);
        System.out.println(answers);

        int[][] rivers = {{1, 1}};
        System.out.println(mazeHVDriver(0, 0, 3, 3, rivers));
        answers = new ArrayList<>();
        mazeHVDriverPath(0, 0, 3, 3, rivers, "", answers);
        System.out.println(answers);

        boolean[][] isVisited = new boolean[3][];
        isVisited[0] = new boolean[3];
        isVisited[1] = new boolean[3];
        isVisited[2] = new boolean[3];
        System.out.println(mazeUDLR(0, 0, 3, 3, isVisited));

        answers = new ArrayList<>();
        isVisited[0] = new boolean[3];
        isVisited[1] = new boolean[3];
        isVisited[2] = new boolean[3];
        mazeUDLRpath(0, 0, 3, 3, "", isVisited, answers);
        System.out.println(answers);
    }


    private static int mazeRightDown (int curRow, int curCol, int totRow, int totCol) {
        if (curRow == totRow - 1 || curCol == totCol - 1) {
            return 1;
        }
        // First right, then down, then add both
        return mazeRightDown(curRow + 1, curCol, totRow, totCol) + mazeRightDown(curRow, curCol + 1, totRow, totCol);

        /**
         * So, the idea here is, we have an ideal scenario for right-down walk, where walk to destination is possible for at least once, ie, dest-row is not to the up of init-row, or dest-col is not left of init-col.
         * Also, here we are considering count of 1 for ONE COMPLETE PATH. So, in ideal case, if at any point our currow==destrow OR currcol==destcol, then we have just straight way to complete path to dest, a unit.
         * Hence, more robust solution will be to first check if walk is feasible overall or not. If it is feasible, then in anchor condition, compare with curRow|Col with the destRow|Col
         */
    }

    /**
     * We know that if its possible to go to destination from init position, then there are exactly destCol-initCol of right movement, and destRow-initRow of down movement. So, path is only the permutations of these.
     */
    private static void mazeRightDownPath(int curRow, int curCol, int totRow, int totCol, String path, ArrayList<String> paths) {
        if (curRow == totRow - 1 && curCol == totCol - 1) {
            paths.add(new String(path));
            return;
        }
        if (curRow < totRow - 1) {
//            path += "R";
//            mazeRightDownPath(curRow + 1, curCol, totRow, totCol, path, paths);
            mazeRightDownPath(curRow + 1, curCol, totRow, totCol, path + "R", paths);
        }
        if (curCol < totCol - 1) {
            mazeRightDownPath(curRow, curCol + 1, totRow, totCol, path + "D", paths);
        }
    }

    private static int mazeRightDownDiagRD(int curRow, int curCol, int totRow, int totCol) {
        if (curRow == totRow - 1 || curCol == totCol - 1) {
            return 1;
        }
        return mazeRightDownDiagRD(curRow + 1, curCol, totRow, totCol)
                + mazeRightDownDiagRD(curRow, curCol + 1, totRow, totCol)
                + mazeRightDownDiagRD(curRow + 1, curCol + 1, totRow, totCol);
    }

    private static void mazeRightDownDiagRDPath(int curRow, int curCol, int totRow, int totCol, String path, ArrayList<String> answers) {
        if (curRow == totRow - 1 && curCol == totCol - 1) {
            answers.add(new String(path));
            return;
        }
        if (curCol < totCol - 1 && curRow < totRow - 1) {
            mazeRightDownDiagRDPath(curRow + 1, curCol + 1, totRow, totCol, path + "D", answers);
        }
        if (curRow < totRow - 1) {
            mazeRightDownDiagRDPath(curRow + 1, curCol, totRow, totCol, path + "V", answers);
        }
        if (curCol < totCol - 1) {
            mazeRightDownDiagRDPath(curRow, curCol + 1, totRow, totCol, path + "H", answers);
        }
    }

    private static int mazeHVDriver (int curRow, int curCol, int totRow, int totCol, int[][] rivers) {
        for (int i = 0; i < rivers.length; i++) {
            if (rivers[i][0] == curRow && rivers[i][1] == curCol) {
                return 0;
            }
        }

        if (curRow == totRow - 1 || curCol == totCol - 1) {
            return 1;
        }

        return mazeHVDriver(curRow + 1, curCol, totRow, totCol, rivers)
                + mazeHVDriver(curRow, curCol + 1, totRow, totCol, rivers)
                + mazeHVDriver(curRow + 1, curCol + 1, totRow, totCol, rivers);
    }

    private static void mazeHVDriverPath(int curRow, int curCol, int totRow, int totCol, int[][] rivers, String path, ArrayList<String> answers) {
        for (int i = 0; i < rivers.length; i++) {
            if (rivers[i][0] == curRow && rivers[i][1] == curCol) {
                return;
            }
        }
        if (curRow == totRow - 1 && curCol == totCol - 1) {
            answers.add(new String(path));
            return;
        }
        if (curRow < totRow - 1) {
            mazeHVDriverPath(curRow + 1, curCol, totRow, totCol, rivers, path + "V", answers);
        }
        if (curCol < totCol - 1) {
            mazeHVDriverPath(curRow, curCol + 1, totRow, totCol, rivers, path + "H", answers);
        }
        if (curRow < totRow - 1 && curCol < totCol - 1) {
            mazeHVDriverPath(curRow + 1, curCol + 1, totRow, totCol, rivers, path + "D", answers);
        }
    }

    private static int mazeUDLR(int curRow, int curCol, int totRow, int totCol, boolean[][] isVisited) {
        if (isVisited[curRow][curCol]) {
            return 0;
        }
        if (curRow == totRow - 1 && curCol == totCol - 1) {     // OBSERVE HERE, IN CASE FOR NAVIGATING TILL THE END DESTINATION, AND NOT JUST ITS COL|ROW, WE WILL USE && OPERATOR. AFTER TOUCHING WALL, ONE CAN GO TO DESTINATION BY CHANGING DIRECTION AS WELL.
            return 1;
        }
        isVisited[curRow][curCol] = true;
        int up = 0, down = 0, left = 0, right = 0;
        // For UP
        if (curRow > 0) {
            up = mazeUDLR(curRow - 1, curCol, totRow, totCol, isVisited);
        }
        // For DOWN
        if (curRow < totRow - 1) {
            down = mazeUDLR(curRow + 1, curCol, totRow, totCol, isVisited);
        }
        // For LEFT
        if (curCol > 0) {
            left = mazeUDLR(curRow, curCol - 1, totRow, totCol, isVisited);
        }
        // For RIGHT
        if (curCol < totCol - 1) {
            right = mazeUDLR(curRow, curCol + 1, totRow, totCol, isVisited);
        }
        isVisited[curRow][curCol] = false;  // For any other parent path, if this cords hits, then it should be considered as non-v-sited, because parent paths are different.
        return up + down + left + right;
    }

    private static void mazeUDLRpath(int curRow, int curCol, int totRow, int totCol, String path, boolean[][] isVisited, ArrayList<String> answers) {
        if (isVisited[curRow][curCol]) {
            return;
        }
//        isVisited[curRow][curCol] = true;
// Because in the below code of end case, we should ideally mark true and then in the same block as false before the return statement. Better if we just keep as default false.
        if (curRow == totRow - 1 && curCol == totCol - 1) {
            answers.add(new String(path));
            return;
        }
        isVisited[curRow][curCol] = true;
        if (curRow > 0) {
            mazeUDLRpath(curRow - 1, curCol, totRow, totCol, path + "U", isVisited, answers);
        }
        if (curCol > 0) {
            mazeUDLRpath(curRow, curCol - 1, totRow, totCol, path + "L", isVisited, answers);
        }
        if (curRow < totRow - 1) {
            mazeUDLRpath(curRow + 1, curCol, totRow, totCol, path + "D", isVisited, answers);
        }
        if (curCol < totCol - 1) {
            mazeUDLRpath(curRow, curCol + 1, totRow, totCol, path + "R", isVisited, answers);
        }
        isVisited[curRow][curCol] = false;

    }
}
