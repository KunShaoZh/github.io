package powernode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序升级版，一个桶，直接比较所有元素取出最大值放到桶子里，空间换时间
 * 自创招式：一个桶，定义一个桶存放当每轮比较结果，桶子中数据的存放顺序就是元素的索引位置（试用于有负数元素的数组，存在空间换时间）。
 * 思想上有点类似于选择排序，区别在于选择排序是通过元素位置交换直接实现，而该算法是通过写入到新的桶中在重新写入到原数组中，稳定排序
 * */
public class ZiChuang01 {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 50, 108, 2, 1, -36, -23};
        int[] sort01 = sort01(array);
        for (int num : sort01) {
            System.out.println(num);
        }
    }

    /**
     * 每次从数组中找到剩余待排序元素的最小值，依次放入到桶子中，再将桶中元素写入到原来的数组中
     * @param arrays 待排序数组
     * @return
     */
    public static int [] sort01 (int [] arrays) {
        // 找到数组元素最大值
        int max = arrays[0];
        for (int array : arrays) {
            if (array > max) {
                max = array;
            }
        }
        System.out.println("元素最大值为：" + max);
        // 定义桶，用来存放每一轮比较的结果
        List<Integer> bucket = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            int min = max;
            for (int j = 0; j < arrays.length; j++) {
                // 已经写入到桶中的元素，不在此次查找比对范围内。
                if (bucket.contains(arrays[j])) {
                    continue;
                }
                // 如果当前元素>定义的最小值，那么不会走if，也就拿不到当前元素的值，所以元素最小值默认定义成最大值，就可获取每个元素的值。
                if (arrays[j] <= min) {
                    min = arrays[j];
                }

            }
            // 将此次获取的最小值写入到桶中
            bucket.add(min);
        }
        // 把桶中的数据依次重新写到原来的数组中
        int index = 0;
        for (Integer integer : bucket) {
            arrays[index] = integer;
            index++;
        }
        return arrays;
    }

}
