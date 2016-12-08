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
        long n = Long.parseLong(line);

        // 字符串长度 1 2 3 4 5 …… n 是一个数列，根据输入的位数判断n所在字符串之前串 拼接的长度
        long sumSize = 0;    // 总长度
        long nextSize = 1;   // 下一个串的长度
        while(sumSize + nextSize < n) {
            sumSize += nextSize;
            nextSize++;
        }

        // 1234567898765432 1234567898765432 123……  每16位一个循环
        String template = "1234567898765432";
        long index = n - sumSize - 1;
        char c = template.charAt((int)(index % 16));
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(solution("1"));
        System.out.println(solution("6"));
        System.out.println(solution("7"));
    }
}
