package com.u9;

public class DistributeCandy {

    public static void main(String[] args) {
        int testarr[] = {0,1,2,3,2,1};
        System.out.println(new DistributeCandy().candy(testarr));
    }
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1;i < ratings.length;i++) {
            int compare = ratings[i] - ratings[i-1];
            if (compare > 0) {
                candy[i] = candy[i-1] + 1;
            }else if (compare == 0) {
                candy[i] = 1;
            }else {
                candy[i] = 1;
                if (candy[i-1] <= candy[i]) {
                    // 前面的=1
                    int k = i;
                    while (k-1 >= 0 && ratings[k-1] > ratings[k] && candy[k-1] <= candy[k]) {
                        candy[k-1] = candy[k] + 1;
                        k--;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0;i < candy.length;i++) {
            System.out.print(candy[i] + " ");
            res += candy[i];
        }
        return res;
    }
}
