package game;

/**
 *
 */
public class _7_2_HowManyTimes {
    private static String solution(String line) {
        String[] arr = line.split(",");
        int countGoods = Integer.parseInt(arr[0]);
        int countPerson = Integer.parseInt(arr[1]);
        int times;
        if (countGoods <= countPerson) {
            return "4";
        }

        int repeat = countGoods / countPerson;
        int tempTimes = (repeat * 2 -1 ) * 4;

        if (countPerson!=1 && !(countGoods % countPerson == 0)) {
            tempTimes += 8;
        }

        int stopCount = tempTimes % 18 == 0 ? tempTimes / 18 -1 : tempTimes / 18;
        int stopTimes = stopCount * 5;
        times = tempTimes + stopTimes;
        return String.valueOf(times);
    }

    public static void main(String[] args) {
        System.out.println(solution("11,2"));
        System.out.println(solution("2,1"));
        System.out.println(solution("6,7"));
        System.out.println(solution("9,1"));  // 83
        System.out.println(solution("100,18"));  // 54
        System.out.println(solution("54,12"));  // 41
    }
}
