package exercise;

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
