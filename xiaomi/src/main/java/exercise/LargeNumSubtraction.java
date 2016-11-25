package exercise;

/**
 * 两个长度超出常规整形变量上限的大数相减
 */
public class LargeNumSubtraction {

    private static String solution(String line) {
        String[] arr = line.split("-");
        String s1 = arr[0].trim();
        String s2 = arr[1].trim();
        if(s1.equals(s2)) {
            return "0";
        }

        int[] num = new int[s1.length()];  // 结果的长度最多与大数一致
        int index = s1.length() - 1;

        char[] num1 = s1.toCharArray();
        char[] num2 = s2.toCharArray();

        int temp = 0;  // 是否从上一位借数
        int index1, index2;
        for(index1=num1.length-1, index2=num2.length-1; index1>=0 && index2>=0; index1--, index2--) {
            int tempResult;
            if(Integer.parseInt(String.valueOf(num1[index1])) - temp >= Integer.parseInt(String.valueOf(num2[index2]))) {
                tempResult = num1[index1] - temp - num2[index2];
                temp = 0;
            } else {
                tempResult = Integer.parseInt(String.valueOf(num1[index1])) - temp - Integer.parseInt(String.valueOf(num2[index2])) + 10;
                temp = 1;
            }
            num[index--] = tempResult;
        }

        // 大数剩余的元素拼接到结果数组前面
        while(index1 >= 0) {
            num[index--] = Integer.parseInt(String.valueOf(num1[index1])) - temp;
            temp = 0;   // 最多只需要减1次
            index1--;
        }

        StringBuilder builder = new StringBuilder(num.length);
        boolean startAppend = false;  // 从第一个非0 开始拼
        for (int aNum : num) {
            if (aNum != 0 && !startAppend) {
                startAppend = true;
            }
            if (startAppend) {
                builder.append(String.valueOf(aNum));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("1231231237812739878951331231231237812739878951331231231237812650365639018918853110413950365639018918853110413950365639018918853110413950357"
                .equals(solution("1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870 - 89513312312312378127398789513312312312378127398789513312312312378127398789513")));

        System.out.println("1231231237812739878951331231231237812739878951331231231237812739878620099998762187260121048668768770"
                .equals(solution("1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001 - 331231231237812739878951331231231")));
    }
}
