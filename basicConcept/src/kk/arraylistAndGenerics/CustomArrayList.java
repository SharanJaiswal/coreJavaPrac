package kk.arraylistAndGenerics;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    final private static int DEFAULT_SIZE = 10;
    private int size = 0;   // will work as an index iterator

    public CustomArrayList() {
        this.data = new int[CustomArrayList.DEFAULT_SIZE];
    }

    public void add (int element) {
        if (this.isFull()) {
            this.resize();
        }
        this.data[this.size++] = element;
    }

    public int remove() {
        return this.data[this.size--];
    }

    public int get(int idx) {
        return this.data[idx];
    }

    public int size() {
        return this.size;
    }

    public void set(int idx, int ele) {
        this.data[idx] = ele;
    }

    private void resize() {
        int idx = 0;
        int[] temp = new int[this.data.length * 2];
        for (int ele : this.data) {
            temp[idx++] = ele;
        }
        this.data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList arrayList = new CustomArrayList();
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(9);
        System.out.println(arrayList);
    }
}
