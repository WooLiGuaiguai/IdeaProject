package 查找;

public class binary_search {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        System.out.println(binarySearch(a,3));
        int[] b={1,2,2,3,3,3,5};
        System.out.println(binarySearch2(b,3));
        System.out.println(mySqrt(25));
        char[] le={'c','f','j'};
        System.out.println(nextGreatestLetter(le,'f'));
        int [] a0407={3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(a0407));
        System.out.println("寻找旋转排序数组中的最小值"+findMin(new int[]{3,4,5,1,2}));
        int []b0407 = searchRange(new int[]{5,7,7,8,8,10},8);
        int []c0407 = searchRange(new int[]{5,7,7,8,8,10},6);
        for (int i : b0407) {
            System.out.print(i+" ");
        }
        for (int i : c0407) {
            System.out.print(i+" ");
        }
    }
    //在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        int firstLoc=findFirst(nums,target);
        int LastLoc=findFirst(nums,target+1)-1;//比目标大的最小数字的位置  进行减1
        if(firstLoc==nums.length||nums[firstLoc]!=target){//如果没找到
            return new int[]{-1,-1};
        }else{
            return new int[]{firstLoc,Math.max(firstLoc,LastLoc)};
        }
    }
    public static int findFirst(int [] nums,int target){//找到重复数字最左侧的位置
        int left=0,right=nums.length;
        //需要注意这里right的取值  因为如果查找的比target大一点的数不存在，那么返回的是[0,nums.length-1]内的值
        //我们需要的是这个数字"插入"到数组之后的位置即nums.length 所以right的取值要注意
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    //寻找旋转排序数组中的最小值
    public static int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=nums[right]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return nums[left];
    }
    //一个有序数组只有一个数不出现两次，找出这个数。要求以 O(logN) 时间复杂度进行求解
    //因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
    //分析：首先考虑二分法划分之后key的位置可以在mid两侧，也可以是mid
    //如果是key<mid 即mid上一定是一个重复的，如果是两个重复之中左边的那个 那么right=mid-1 如果是右边那个right=mid-2
    //如果是key>mid 即mid上一定是一个重复的，如果是两个重复之中左边的那个 那么left=mid+2 如果是右边那个left=mid+1
    //那么：怎么判断key和mid的位置关系  判断分开之后的数组长度是否奇偶
    //如果mid是左边那个，以mid分隔开的数组是两个奇数 意味着左边有一个单数即key 右边肯定有一个单 因为它的重复元素在右边
    //同理分析mid是左边那个 数组是两个偶数；  mid是右边那个等一共四种情况
    public static int singleNonDuplicate(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            boolean flag=false;//默认为奇数
            if((right-mid)%2==0){
                flag=true;//个数是偶数
            }
            if(nums[mid]==nums[mid+1]) {//它是左边那个重复的
                if(flag){//分开之后是偶数
                    left=mid+2;
                }else{
                    right=mid-1;
                }
            }else if(nums[mid-1]==nums[mid]){
                if(flag){//分开之后是偶数
                    right=mid-2;
                }else{
                    left=mid+1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
    //给定一个循环有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符  重点看看
    // 给定abc 和 d  这时候没有比d大的  abc abc 这么循环 d放在c和a之间 所以这时候a是大于它的最小 所以说如果找不到就返回第 1 个字符
    public static char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int left=0,right=letters.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if (letters[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left<n?letters[left]:letters[0];
    }
    //求x的平方根
    public static int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int left=1,right=x;
        while(left<=right){
            int mid=(left+right)/2;
            int sqrt = x / mid;//防止超时
            if(sqrt==mid){
                return mid;
            }else if(sqrt<mid){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    //在一个有重复元素的数组中查找 key 的最左位置的实现
    public static int binarySearch2(int[] nums, int key) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {              //第二种情况：left<right
            int mid=(left+right)/2;
            if(nums[mid]>=key){
                right=mid-1;                 //             right=mid
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    //一般实现
    public static int binarySearch(int[] nums, int key){
        int left=0,right=nums.length-1;
        while(left<right){
            //left+right可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围
            // 但是 left和right 都为正数，因此 right-left不会出现加法溢出问题。所以，最好使用m = left + (right - left) / 2
            int mid=(left+right)/2;
            if(nums[mid]==key){
                return mid;
            }else if(nums[mid]>key){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;//-1：以一个错误码表示没有查找到 key
    }
}
