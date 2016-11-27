package exercise;

public class _1_LargeNumAddition {

    private static String solution(String line) {
        String[] arr = line.split(" ");
        char[] num1 = arr[0].toCharArray();
        char[] num2 = arr[1].toCharArray();

        int count1 = num1.length;  // 数字位数
        int count2 = num2.length;

        // 新数字长度 为 大数长度 或 大数长度+1
        int count = count1 > count2 ? count1 : count2;
        int[] result = new int[count + 1];
        int index = count;  // 结果数组的索引

        int flag = 0;  // 是否进位
        int index1;    // index of num1
        int index2;    // index of num2
        for (index1 = count1 - 1, index2 = count2 - 1; index1 >= 0 && index2 >= 0; index1--, index2--) {
            int temp = Integer.parseInt(String.valueOf(num1[index1]))
                    + Integer.parseInt(String.valueOf(num2[index2]))
                    + flag;
            if(temp >= 10) {
                result[index] = temp % 10;
                flag = 1;
            }
            else {
                result[index] = temp;
                flag = 0;
            }
            index--;
        }

        // 两数字位数相同
        if(index1 == -1 && index2 == -1) {
            result[index] = flag;   // 此时 index = 0;
        }
        else {
            char[] lastArr;  // 数组的剩余部分
            if(index1 == -1) {
                lastArr = copyOfRange(num2, 0, index2);
            }else{
                lastArr = copyOfRange(num1, 0, index1);
            }

            for (int i = lastArr.length-1; i >= 0; i--) {
                int temp = Integer.parseInt(String.valueOf(lastArr[i])) + flag;
                if(temp >= 10) {
                    result[index] = temp % 10;
                    flag = 1;
                }
                else {
                    result[index] = temp;
                    flag = 0;
                }
                index--;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if(i == 0 && result[i] == 0){
                continue;
            }
            builder.append(String.valueOf(result[i]));
        }
        return builder.toString();
    }

    // 获取部分数组,包含from,包含to： [from, to]
    private static char[] copyOfRange(char[] array, int from, int to) {
        char[] range = new char[to - from + 1];
        int index = 0;
        for(int i=from; i<=to; i++) {
            range[index++] = array[from];
        }
        return range;
    }

    public static void main(String[] args) {
        System.out.println(solution("123456789789 201"));
        System.out.println(solution("9 1"));
        System.out.println(solution("777 888888"));
    }
}
