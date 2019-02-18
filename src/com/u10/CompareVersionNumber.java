package com.u10;
/*
比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

示例 1:

输入: version1 = "0.1", version2 = "1.1"
输出: -1
 */
public class CompareVersionNumber {

    public static void main(String[] args) {
        System.out.println(("1.1".split("\\.")).length);
        System.out.println(new CompareVersionNumber().compareVersion2("1.1.1.1", "1.1.1"));
    }
    // 01 这种情况
    public int compareVersion2(String v1, String v2) {
        char[] arr1 = v1.toCharArray();
        char[] arr2 = v2.toCharArray();
        int i = 0;
        int j = 0;
        int cur = 0;// 当前部分谁大
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == '.' && arr2[j] != '.') { //后面较长
                return -1;
            }else if (arr1[i] != '.' && arr2[i] == '.') {//前面较长
                
                return 1;
            }else if (arr1[i] == '.' && arr2[i] == '.'){//一样长
                if (cur != 0)
                    return cur;
                else {
                    // 一样大一样长时,
                    i++;j++;
                }
            }
            if (cur == 0) {
                if (arr1[i] > arr2[j]) {
                    cur = 1;
                }else if (arr1[i] < arr2[j]) {
                    cur = -1;
                }
            }
            i++;
            j++;
        }
        if (i < arr1.length && j == arr2.length) {
            for (int k = i; k < arr1.length;k++) {
                if (arr1[k] != '.' && arr1[k] > '0') {
                    return 1;
                }
            }
        }
        else if (i == arr1.length && j < arr2.length) {
            for (int k = j; k < arr2.length;k++) {
                if (arr2[k] != '.' && arr2[k] > '0') {
                    return -1;
                }
            }
        }
        return cur;
    }
    // arr[i] != '.', 返回一个j,arr[j] = '.',j必须离i近
    private int num2dot(char[]arr, int i) {
        for (int a = i;a < arr.length;a++) {
            if (arr[a] == '.') {
                return a;
            }
        }
        return -1;
    }
    // 23.23.1 23.23.2
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0;i < len;i++) {
            int a = 0;
            int b = 0;
            if (i < v1.length) {
                a = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                b = Integer.parseInt(v2[i]);
            }
            if (a > b) {
                return 1;
            }else if (a < b) {
                return -1;
            }
        }
        return 0;
    }
}
