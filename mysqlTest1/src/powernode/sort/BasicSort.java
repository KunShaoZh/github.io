package powernode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序案例一（不适用于有负数元素的数组，典型的空间换时间的算法）。
 * 稳定排序算法。
 * 时间复杂度。
 * */
public class BasicSort {
    public static int[] sort (int[] array) {
        // 找出数组最大值
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array [i] > max) {
                max = array[i];
            }
        }
        System.out.println("数组最大值:" + max);

        // 计算最大值有几位数，算出位数digit
        int maxDigit =  0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        System.out.println("最大元素的位数:" + maxDigit);
        // 创建桶并初始化
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }
        //按照从右往左的顺序，依次将每一位都当做一次关键字，然后按照该关键字依次将数据放入对应索引的桶中，对数组排序，每一轮排序都基于上轮排序后的结果
        int mold = 10;// 取模运算
        int div = 1;// 获取对应位数的值
        for (int i = 0; i < maxDigit; i++, mold *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                System.out.println("数组元素：" + array[j] + " 索引：" + j);
                // 获取个位数、十位数、百位数。。。。。。
                int a = Math.abs((array[j] % mold) / div);
                System.out.println("第" + maxDigit + "次大循环");
                System.out.println("第" + (j+1) + "次小循环" );
                System.out.println("a的值：" + a);
                // 把数据放到对应索引的桶里
                bucket.get(a).add(array[j]);
            }
            // 把桶中的数据依次重新写到原来的数组中，并把桶中的元素清空，开始第二轮排序
            int index = 0;
            for (int k = 0; k < bucket.size(); k++) {
                // 桶中对应的数据
                List<Integer> list = bucket.get(k);
                for (int l = 0; l < list.size(); l++) {
                    array[index]=list.get(l);
                    index++;
                }
                // 清空桶中的数据
                list.clear();
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {53, 3, 542, -980, 728, 14, 214, -78, -100};
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("======================");
        sort2(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] sort2 (int[] arrays) {
        int max = 0;
        for (int array : arrays) {
            if (array > max) {
                max = array;
            }
        }

        int digit = 0;
        while (max != 0) {
            max /= 10;
            digit++;
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }

        int mold = 10;
        int div = 1;
        for (int i = 0; i < digit; i++, mold *= 10, div *= 10) {
            for (int array : arrays) {
                int num = Math.abs((array % mold) / div);
                bucket.get(num).add(array);
            }

            int index = 0;
            for (List<Integer> list : bucket) {
                for (Integer integer : list) {
                    arrays[index] = integer;
                    index++;
                }
                list.clear();
            }
        }
        return arrays;
    }
}
