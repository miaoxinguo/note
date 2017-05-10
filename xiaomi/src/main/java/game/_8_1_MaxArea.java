package game;

import java.util.ArrayList;

/**
 *
 */
public class _8_1_MaxArea {
    private static String solution(String line) {
        String[] sss = line.split(",");
        int[] arr = new int[sss.length];
        for (int i = 0; i < sss.length; i++) {
            arr[i] = Integer.parseInt(sss[i]);
        }
        return String.valueOf(getArea(arr));
    }

    private static int getArea(int[] arr) {
        int count = arr.length;
        int min = Integer.MAX_VALUE;
        java.util.ArrayList<Integer> minIndexList = new ArrayList<>();
        for (int anArr : arr) {
            if (anArr < min) {
                min = anArr;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                minIndexList.add(i);
            }
        }

        int area = count * min;
        java.util.ArrayList<Integer> areaList = new ArrayList<>();
        areaList.add(area);

        for (Integer index : minIndexList) {
            areaList.add(getArea(java.util.Arrays.copyOfRange(arr, 0, index)));
            if (index < arr.length -1) {
                areaList.add(getArea(java.util.Arrays.copyOfRange(arr, index + 1, arr.length - 1)));
            }
        }

        int max = 0;
        for (Integer a : areaList) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution("2,3,2"));  // 6
        System.out.println(solution("5,6,7,8,3"));  // 20
        System.out.println(solution("78,1,37,18,35,50,20,96,17,75,91,86,82,41,49,86,41,77,79,28,59,99,51,95,48,4,62,74,27,0,8,5,1,45,23,36,95,44"));  // 448
    }
}
