package src;

public class Main {

    public static void main(String[] args) {
        CustomArrayList<String> array = new CustomArrayList<>();
        System.out.println(array.size());

        CustomArrayList<Integer> arrayInt = new CustomArrayList<>(5);
        System.out.println(arrayInt.size());

        array.add("first");
        array.add("second");
        array.add("third");
        array.add("forth");
        array.add("fifth");

        System.out.println(array.get(2));

        array.add(1, "newEl");

        System.out.println(array.get(1));

        array.remove(1);
        System.out.println(array.get(1));

        array.remove("second");
        for (String el: array) {
            System.out.println(el);
        }
        System.out.println(array.size());

        arrayInt.add(8);
        arrayInt.add(2);
        arrayInt.add(9);
        arrayInt.add(4);
        arrayInt.add(15);
        arrayInt.add(13);

        arrayInt.quickSort(Integer::compareTo);
        System.out.println(arrayInt.toString());

        array.quickSort(String::compareTo);
        System.out.println(array.toString());
    }
}
