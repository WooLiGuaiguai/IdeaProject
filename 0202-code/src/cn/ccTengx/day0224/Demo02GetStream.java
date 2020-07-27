package cn.ccTengx.day0224;

import java.util.*;
import java.util.stream.Stream;

public class Demo02GetStream {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Stream<Integer> stream = list.stream();

        Map<Integer,Integer> map=new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Stream<Map.Entry<Integer, Integer>> stream1 = entries.stream();

        Integer []integers={1,2,3,4,5,6};
        Stream<Integer> integers1 = Stream.of(integers);


    }
}
