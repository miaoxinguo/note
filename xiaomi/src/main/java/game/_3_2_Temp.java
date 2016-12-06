package game;

/**
 *
 */
public class _3_2_Temp {

    private static String solution(String line) {
        String[] tempArr = line.split(" ");
        String[] a = tempArr[0].split(",");
        String[] b = tempArr[1].split(",");
        int k = Integer.parseInt(tempArr[2]);
        
        // 合并数组
        int[] arr = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        while(indexA < a.length && indexB < b.length){
            if(a[indexA].compareTo(b[indexB]) >= 0) {
                arr[index++] = Integer.parseInt(a[indexA]);
                indexA++;
            }
            else {
                arr[index++] = Integer.parseInt(b[indexB]);
                indexB++;
            }
        }
        
        if(indexA == a.length) {
            while(indexB < b.length){
                arr[index++] = Integer.parseInt(b[indexB]);
                indexB++;
            }
        }

        if(indexB == b.length) {
            while(indexA < a.length){
                arr[index++] = Integer.parseInt(a[indexA]);
                indexA++;
            }
        }
        
        // 从 arr 中选出最大的 k 位数
        StringBuilder builder = new StringBuilder(k);
        int startIndex = 0;
        int endIndex = arr.length - k;
        while(k > 0) {
            int maxNumIndex = getMax(arr, startIndex, endIndex);
            builder.append(arr[maxNumIndex]);

            startIndex = maxNumIndex + 1;
            endIndex = arr.length - k;
            k--;
        }

        return builder.toString();
    }

    private static int getMax(int[] arr, int startIndex, int endIndex) {
        int max = -1;
        int index = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
//        System.out.println(solution("1,3,4,5,1,2 8,9,1 5"));
//        System.out.println(solution("6,3,8,9,4,6,0 3,5,7 6"));
//        System.out.println(solution("2,6,8,4,3 6,9,2,5 3"));
//        System.out.println(solution("3,7,2 7,9,5,1 7"));
        System.out.println(solution("3,8,0,2,4,8,3 9,0,5,2,2,7,3,7,9 8"));
//        System.out.println(solution("3,8,0,2,4,8,3 9,0,5,2,2,7,3,7,9 8").equals("99802483")); // 98857379
    }
}
