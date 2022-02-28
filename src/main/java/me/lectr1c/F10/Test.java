package me.lectr1c.F10;

public class Test {
    public static void main(String[] args) {
        Heap<Integer> integerHeap = new Heap<>(10);

        integerHeap.insert(5);
        integerHeap.insert(7);
        integerHeap.insert(3);
        System.out.println(integerHeap);
        integerHeap.insert(8);
        integerHeap.insert(4);
        integerHeap.insert(2);
        System.out.println(integerHeap);
        integerHeap.extract();
        integerHeap.extract();
        integerHeap.extract();
        System.out.println(integerHeap);




    }
}
