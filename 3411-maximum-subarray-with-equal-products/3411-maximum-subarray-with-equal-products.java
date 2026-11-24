class Solution {
    public long prod(int[] nums, int i, int j) {
        long pro = 1;
        for(int k = i; k <= j; k++) {
            pro *= nums[k];
        }
        return pro;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public int gcd(int[] nums, int i, int j) {
        int g = nums[i];
        for(int k = i + 1; k <= j; k++) {
            g = gcd(g, nums[k]);
        }
        return g;
    }

    public long lcm(int[] nums, int i, int j) {
        long l = nums[i];

        for(int k = i + 1; k <= j; k++) {
            l = (l * nums[k]) / gcd((int)l, nums[k]);
        }
        return l;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                long pro = prod(nums, i, j);
                int g = gcd(nums, i, j);
                long l = lcm(nums, i, j);

                if(pro == g * l) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}