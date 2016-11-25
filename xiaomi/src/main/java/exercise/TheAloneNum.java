package exercise;

/**
 * 给出N个数字。其中仅有一个数字出现过一次，其他数字均出现过两次，找出这个出现且只出现过一次的数字
 */
public class TheAloneNum {

    private static String solution(String line) {
        String[] arr = line.split(" ");
        java.util.List<String> cache = new java.util.ArrayList<>();

        for (String s : arr) {
            if (cache.contains(s)) {
                cache.remove(s);
                continue;
            }
            cache.add(s);
        }
        return cache.get(0);
    }


    public static void main(String[] args) {
        System.out.println(solution("10 10 11 12 12 11 16"));
        System.out.println(solution("10 10 11 12 99 11 99"));
    }
}
