import java.util.Arrays;

public class MaxSubsequence {

public static void main(String[] srg) {

    int[] a = {3, -4, 2, 2, -3, 1, 3, -2};

    System.out.println(MaxSub(a, 0, a.length - 1));

}

public static int MaxSub(int[] a, int left, int right) {

    if(left == right) {
        return (a[left] > -1) ? a[left] : 0;
    }
    int center = (left + right) / 2;

    int maxLeftSum = MaxSub(a, left, center);
    int maxRightSum = MaxSub(a, center + 1, right);

    int maxCrossingSum = maxCrossingSum(a, left, center, right);

    return Math.max(maxLeftSum, Math.max(maxRightSum, maxCrossingSum));
}

static int maxCrossingSum(int[] a, int left, int center, int right) {
    int sum = 0;
    int leftMaxSum = 0;

    for (int i = center; i >= left; i--) {
        sum += a[i];
        leftMaxSum = Math.max(leftMaxSum, sum);
    }

    sum = 0;
    int rightMaxSum = 0;

    for (int i = center + 1; i <= right; i++) {
        sum += a[i];
        rightMaxSum = Math.max(rightMaxSum, sum);
    }

    return leftMaxSum + rightMaxSum;
}

}







