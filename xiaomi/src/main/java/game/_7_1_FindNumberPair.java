package game;

/**
 *
 */
public class _7_1_FindNumberPair {
    private static String solution(String line) {
        String[] arr = line.split(",");
        int count = 0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int a = Integer.parseInt(arr[i]);
                int b = Integer.parseInt(arr[j]);
                if(a+b == 10 || a-b == 10 || b-a == 10) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    public static void main(String[] args) {
        System.out.println(solution("4,13,5,6,35,85,3"));
        System.out.println(solution("13,3,6,8,12,4,45,56,66,16"));
        System.out.println(solution("6,4,16"));
    }
}
