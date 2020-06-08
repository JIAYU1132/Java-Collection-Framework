public class Solution {
    // 有效的数独

    // 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int row, int col) {
        char c = board[row][col];

        // 判断同一行是否合法
        for (int i = 0; i < board.length && i != col; i++) {
            if (board[row][col] == c) {
                return false;
            }
        }

        // 判断同一列是否合法
        for (int i = 0; i < board[row].length && i != row; i++) {
            if (board[row][col] == c) {
                return false;
            }
        }

        // 判断九宫格内是否合法
        int newRow = 3 * (row / 3);
        int newCol = 3 * (col / 3);
        for (int i = newRow; i < newRow + 3; i++) {
            for (int j = newCol; j < newCol + 3; j++) {
                if (i != row && j != col && board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
