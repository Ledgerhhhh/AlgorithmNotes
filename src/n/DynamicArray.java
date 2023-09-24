package n;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {

    private int capacity = 8; // 容量

    private int[] array = {};
    private int size = 0; // 逻辑大小

    public void add(int element) {
        insert(size, element);
    }

    public void insert(int index, int element) {
        // 扩容
        checkAndExpansion();
        if (index < 0 || index > size)
            throw new RuntimeException("索引越界");
        if (index < size)
            System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public int remove(int index) {
        int i = array[index];
        if (index < size - 1)
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return i;
    }

    private void checkAndExpansion() {
        if (size == 0)
            //懒加载
            array = new int[capacity];
        else if (size == capacity) {
            capacity += capacity >> 1;
            int[] ints = new int[capacity];
            System.arraycopy(array, 0, ints, 0, size);
            array = ints;
        }
    }


    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++)
            consumer.accept(array[i]);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, size));
    }

}
