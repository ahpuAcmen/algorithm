package leetcode;

/**
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右非递减的顺序排序，
 * 每一列都按照从上到下非递减的顺序排序。
 * 请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 */
public class FindByDoubleDimensionalArray
{

    public boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        int n = matrix.length;
        int m = matrix[1].length;
        for (int i = 0; i < n; i++)
        {
            int first = matrix[i][1];
            if (first > target)
            {
                return false;
            }
            for (int j = 0; j < m; j++)
            {
                int value = matrix[i][j];
                if (value > target)
                {
                    break;
                }
                if (value == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

}
