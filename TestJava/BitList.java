package TestJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BitList {

    private List<String> reverse(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        List<String> tempList = new ArrayList<>(list);
        int length = tempList.size();
        for (int i = 0; i < length / 2; i++) {
            String temp = tempList.get(i);
            tempList.set(i, tempList.get(length - i - 1));
            tempList.set(length - i - 1, temp);
        }

        return tempList;
    }

    private List<String> createList(List<String> list, int n) {
        int length = list.size();
        List<String> reverseList = reverse(list);
        assert reverseList != null;

        for (int i = 0; i < length; i++) {
            list.set(i, "0" + list.get(i));
            reverseList.set(i, "1" + reverseList.get(i));
        }

        list.addAll(reverseList);
        if (n - 1 == 1) {
            return new ArrayList<>(list);
        }

        return createList(list, --n);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        BitList b = new BitList();
        List<String> a = new ArrayList<>(Arrays.asList("0", "1"));
        List<String> result = b.createList(a, 5);
        System.out.println(result.size());

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}