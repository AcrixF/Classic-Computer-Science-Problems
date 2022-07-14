package org.neoa.ch02.helper;

import java.util.List;

public class SearchHelper {

    public static <T extends Comparable<T>> boolean linearSearch(List<T> list, T key) {
        for (T item: list) {
            if (item.compareTo(key) == 0)
                return true;
        }
        return false;
    }


    public static <T extends Comparable<T>> boolean binarySearch(List<T> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int middle = (low + high) / 2;
            int comparison = list.get(middle).compareTo(key);
            if (comparison < 0)
                low = middle + 1;
            else if (comparison > 0)
                high = middle - 1;
            else
                return true;
        }
        return false;
    }

}




