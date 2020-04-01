package Test7;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (; k > 0; k--) {
            // 先创建一个新的二维数组
            int[][] arr = new int[grid.length][grid[0].length];
            // 移动除了最后一列的其他元素
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    // 把当前值给下一个值
                    arr[row][col + 1] = grid[row][col];
                }
            }
            // 移动最后一列元素(但不是最后一行最后一列元素)
            for (int row = 0; row < grid.length - 1; row++) {
                // 把每行最后一列的值给下一行的第一列元素
                arr[row + 1][0] = grid[row][grid[0].length - 1];
            }
            // 移动最后一行最后一个元素, 给(0, 0)
            arr[0][0] = grid[grid.length - 1][grid[0].length - 1];
            // 把 arr 给 grid
            grid = arr;
        }

        // 创建一个新的 List, 存 grid 的值, 以供返回
        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            list.add(listRow);
            for (int v : row) listRow.add(v);
        }
        return list;
        }
    }

