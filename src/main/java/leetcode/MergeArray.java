package leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class MergeArray
{

    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        for (int i = m; i < m + n; i++)
        {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n)
    {
        int last1 = m;
        int last2 = n;

        for (int i = m + n - 1; i >= 0; i--)
        {
            if (last2 == 0)
            {
                return;
            }
            if (last1 == 0)
            {
                last2 -= 1;
                nums1[i] = nums1[last2];
            }
            if (nums1[last1] > nums2[last2])
            {
                last1 -= 1;
                nums1[i] = nums1[last1];
            } else
            {
                last2 -= 1;
                nums1[i] = nums1[last2];
            }
        }

    }
}
