package powernode.investigation;

import java.util.Arrays;
/**
 * 插入排序与希尔排序测试，在插入排序中，位移法要比逆序交换法的效率高，速度快（2倍关系）。同时希尔排序要比普通插入排序效率高速度快
 * */
public class Test05 {
    public static void main(String[] args) {
        int[] arr01 = new int[100000];
        for (int i = 0; i < arr01.length; i++) {
            arr01[i] = (int)(Math.random() * 100000);
        }

        int[] arr02 = new int[100000];
        for (int i = 0; i < arr02.length; i++) {
            arr02[i] = arr01[i];
        }

        int[] arr03 = new int[100000];
        for (int i = 0; i < arr03.length; i++) {
            arr03[i] = arr01[i];
        }
        int[] arr04 = Arrays.copyOf(arr01, arr01.length);


        System.out.println("四个数组的的地址：" + arr01 + "、" + arr02 + "、" + arr03 + "、" + arr04);
        /*System.out.println("arr01数组元素:" + Arrays.toString(arr01));
        System.out.println("arr02数组元素:" + Arrays.toString(arr02));
        System.out.println("arr03数组元素:" + Arrays.toString(arr03));
        System.out.println("arr04数组元素:" + Arrays.toString(arr04));*/
        long start01 = System.currentTimeMillis();
        System.out.println("位移法插入排序开始:" + start01);
        insertSort01(arr01);
        long end01 = System.currentTimeMillis();
        System.out.println("位移法插入排序结束:" + end01 + ",用时:" + (end01-start01));
        //System.out.println("位移法插入排序后元素:" + Arrays.toString(arr01));

        long start02 = System.currentTimeMillis();
        System.out.println("位移法希尔排序开始:" + start02);
        shellSort01(arr02);
        long end02 = System.currentTimeMillis();
        System.out.println("位移法希尔排序结束:" + end02 + ",用时:" + (end02-start02));
        //System.out.println("位移法希尔排序后元素:" + Arrays.toString(arr02));

        long start03 = System.currentTimeMillis();
        System.out.println("逆序交换法插入排序开始:" + start03);
        insertSort02(arr03);
        long end03 = System.currentTimeMillis();
        System.out.println("逆序交换法插入排序结束:" + end03 + ",用时:" + (end03-start03));
        //System.out.println("逆序交换法插入排序后元素:" + Arrays.toString(arr03));

        long start04 = System.currentTimeMillis();
        System.out.println("逆序交换法希尔排序开始:" + start04);
        shellSort02(arr04);
        long end04 = System.currentTimeMillis();
        System.out.println("逆序交换法希尔排序结束:" + end04 + ",用时:" + (end04-start04));
        //System.out.println("逆序交换法希尔排序后元素:" + Arrays.toString(arr04));
    }

    /**
     * 位移法
     * @param arr 插入排序
     */
    public static void insertSort01 (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i; j >= 1 ; j--) {
                if (arr[j-1] > tmp) {
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * @param arr 位移法
     */
    public static void shellSort01 (int[] arr) {
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    if (arr[j] > tmp) {
                        arr[j+gap] = arr[j];
                        arr[j] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr 逆序交换法
     */
    public static void insertSort02 (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j] > arr[j+1] ) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * @param arr 逆序交换法
     */
    public static void shellSort02 (int[] arr) {
        for (int gap = arr.length/2; gap >= 1  ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap ; j -= gap) {
                    if (arr[j] < arr[j-gap]) {
                        int tmp = arr[j-gap];
                        arr[j-gap] = arr[j];
                        arr[j] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
