package game;

/**
 *
 描述：
 假如有一组字符串符合如下规律：
 S1 = 1
 S2 = 12
 S3 = 123
 .........
 S9 = 123456789
 S10 = 1234567898
 S11 = 12345678987
 ............
 S17 = 12345678987654321
 S18 = 123456789876543212
 ..................
 (对于Sn来说，长度为n，每个串从1开始，增长到9再降到1，再从1开始增长，不包含0)

 现在我们把所有的字符串拼接起来，组成一个无限长的字符串
 S = 1121231234.......123456789876543212345678987………
 你能找出该字符串的第n位数字是多少吗?

 输入
 一个整数，表示所求的位数是多少位

 输出
 一个整数，表示该位上的数字是多少

 输入样例
 1
 6
 7
 输出样例
 1
 3
 1
 */
public class _3_1_NumOfTheIndex {

    private static String solution(String line) {
        int n = Integer.parseInt(line);

        // 字符串长度 1 2 3 4 5 …… n 是一个数列，根据输入的位数判断 所在字符串的长度
        int size = 1;
        int sumSize = 1;
        while(sumSize < n) {
            size++;
            sumSize += size;
        }

        int lastIndex = sumSize - n;   // 所在字符串的位置, 从后面数的索引

        // 1234567898765432 1234567898765432 123……  每16位一个循环
        String template = "1234567898765432";

        char c;
        if(size <= 16) {
            c = template.substring(0, size).toCharArray()[size - lastIndex - 1];
        }
        else {
            int tailCount = size % 16;   // 有几个多余的数
            if(lastIndex < tailCount - 1) {
                c = template.toCharArray()[size - lastIndex - 1];
            }
            else {
                // 去掉尾巴 1234567898765432 1234567898765432……  纯循环
                int newLastIndex = (lastIndex - (tailCount - 1)) % 16;
                c = template.toCharArray()[16 - 1 - newLastIndex];
            }
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(solution("1"));
        System.out.println(solution("2"));
        System.out.println(solution("4"));
        System.out.println(solution("6"));
        System.out.println(solution("7"));
    }
}
