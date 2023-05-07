package org.example.service;

import org.example.logic.Sort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    private final Sort<String> sort;

    //Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.example.logic.Sort<java.lang.String>' available: expected single matching bean but found 2: bubbleSort,javaSort
    //에러가 발생 하므로, Sort를 구현하는 빈이 2개이므로 명명을 해줄 필요가 있음.
    //Component("bubbleSort") 이렇게 이름 넣어주거나 기본적으론 앞에 소문자로 해서 클래스명 따라가는데, SortService에서 Qualifier로 구분

    //생성자 주입 방식 1번
    public SortService(@Qualifier("bubbleSort") Sort<String> sort) {
        this.sort = sort;
        System.out.println("[구현체] :" +sort.getClass().getName());
    }

    public List<String> doSort(List<String> list) {
        return sort.sort(list);
    }
}
