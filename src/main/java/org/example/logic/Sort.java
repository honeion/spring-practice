package org.example.logic;

import java.util.List;

//추상화에 의존해야지 구체화가 아니고
public interface Sort <T extends Comparable<T>>{
    List<T> sort(List<T> list);
}
