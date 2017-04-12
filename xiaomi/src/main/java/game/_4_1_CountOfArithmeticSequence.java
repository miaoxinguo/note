package game;

/**
 *
 */
public class _4_1_CountOfArithmeticSequence {

    private static String solution(String line) {
        int n = Integer.parseInt(line);
        if(n<=3) return "1";
        Integer[] a = get(1, n);  // 1,3,5,7..
        Integer[] b = get(2, n);  // 2,4,6,8..
        int count = getCount(a, n) + getCount(b, n) + 1;
        return String.valueOf(count);
    }

    private static Integer[] get(int start, int n) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        for (int i=start; i<=n/2+1; i=i+2) {
            list.add(i);
        }
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        return arr;
    }

    // s 队列， count 和
    private static int getCount(Integer[] s, int count) {
        if(s.length == 0) return 0;

        int c = 0;
        int tempCount = 0;
        int i = 0;
        while(tempCount < count && i<s.length) {
            tempCount += s[i];
            i++;
        }
        if(tempCount == count) {
            c++;
        }

        if(s.length>1) {
            return c + getCount(java.util.Arrays.copyOfRange(s, 1, s.length), count);
        }
        else {
            return c;
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("15"));
        System.out.println(solution("30"));
        System.out.println(solution("50"));
    }
}
