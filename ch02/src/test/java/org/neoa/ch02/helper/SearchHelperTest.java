package org.neoa.ch02.helper;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchHelperTest {

    @Test
    void linearSearchReturnsTrueWhenKeyFoundInCollection() {
        List<Integer> list = List.of(1, 5, 15, 15, 15, 15, 20);
        boolean result = SearchHelper.linearSearch(list, 5);
        assertThat(result).isTrue();
    }

    @Test
    void binarySearchReturnsTrueWhenKeyFoundInCollection() {
        List<String> list = List.of("a", "d", "e", "f", "z");
        boolean result = SearchHelper.linearSearch(list, "f");
        assertThat(result).isTrue();
    }

    @Test
    void binarySearchReturnsFalseWhenNoKeyFoundInCollection() {
        List<String> list = List.of("john", "mark", "ronald", "sarah");
        boolean result = SearchHelper.linearSearch(list, "sheila");
        assertThat(result).isFalse();
    }

}
