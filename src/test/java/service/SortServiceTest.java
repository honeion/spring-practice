package service;

import org.example.logic.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SortServiceTest {

    private final SortService sort = new SortService(new BubbleSort<>());
    //강결합 상태에서는 Main, SortService등에서 변경해야했으나, 사용하는 곳에서 변경하면 되도록 의존성 주입 방식으로 구현체를 주입해서 사용 한 것.
    //지금은 현재
    @Test
    void doSort() {
        //Given
        //When
        List<String> actual = sort.doSort(List.of("3","2","1"));
        //Then
        assertEquals(List.of("1","2","3"),actual);
    }
}