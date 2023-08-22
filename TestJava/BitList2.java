package TestJava;

import java.util.ArrayList;
import java.util.List;

class BitList2 {

    private List<String> createList(int n) {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");

        for (int iter = 1; iter < n; iter++) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.add("0" + list.get(i));
                list.set(i, "1" + list.get(i));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        BitList2 b = new BitList2();
        List<String> result = b.createList(5);
        System.out.println(result.size());

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
