package game;

/**
 * 计算有几个等差数列
 */
public class Game_2_2_ArithmeticSequence {

    private static String solution(String line) {
        String[] arr = line.split(" ");
        if (arr.length <= 1) return "0";
        if (arr.length == 2) return "1";

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Integer v = Integer.valueOf(arr[j]) - Integer.valueOf(arr[i]);  // 差值
                int numCount = 2;  // 等差数列中的数字个数，最少是两个数 即: arr[i]、arr[j]
                for (int k = j+1; k < arr.length; k++) {
                    int tempIndex = j;  // 临时游标，当前数列最后一个数的位置
                    for (int loopIndex = k; loopIndex < arr.length; loopIndex++) {
                        if (Integer.valueOf(arr[loopIndex]) - Integer.valueOf(arr[tempIndex]) == v) {
                            if(tempIndex == j) {
                                k = loopIndex;  // 如果匹配上第3个数字，下次循环从这个数字之后开始
                            }
                            tempIndex = loopIndex;
                            numCount++;
                        }
                    }
                }
                // 计数。以 arr[i] 开头，差值为v的等差数列个数是数字个数-1
                count += numCount - 1;
            }
        }
        return String.valueOf(count);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution("2 7 4 5 6"));         // 12
        System.out.println(solution("3 3 3 3"));           // 11
        System.out.println(solution("-57 38 -24 -54 8"));  // 10
        System.out.println(solution("33 71 -92 -61 71 -75 -64 -90 -53 37 -10 -20 80 -30 -50 91 -30 -53 -98 82 13 -23"));  // 240
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
