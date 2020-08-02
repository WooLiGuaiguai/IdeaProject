package 数学;

public class 改变数组元素使所有元素相等 {
    public static void main(String[] args) {
        int []sum={13,34,62,91,12,10};//10 12 13 34 62 91
        System.out.println(minMoves2(sum));
    }
    public static int minMoves2(int[] nums) {
        int move = 0;
        int median = findKthSmallest(nums, nums.length / 2);
        System.out.println(median);
        for (int num : nums) {
            move += Math.abs(num - median);
        }
        return move;
    }

    private static int findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h) ;
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
