package aaagt.creational.logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Filter tests")
class FilterTest {

    @Test
    public void filterOut() {
        Filter filter = new Filter(4);
        List<Integer> nums = List.of(3, 5, 5, 1, 0, 3, 6);
        // Отсортированный результат
        List<Integer> expected = List.of(5, 5, 6);

        List<Integer> actual = filter.filterOut(nums)
                .stream()
                .sorted(Integer::compareTo)
                .toList();

        assertEquals(expected, actual);
    }

}
