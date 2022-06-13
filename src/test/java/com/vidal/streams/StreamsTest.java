package com.vidal.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamsTest {


    @Test
    public void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

        assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));

        Stream<Integer> infiniteStream2 = Stream.iterate(2, i -> i * 2);

        infiniteStream2 = Stream.iterate (3, i -> i * 3);

        infiniteStream2
                .skip(3)
                .limit(10)
                .forEach(c -> System.out.println(c));

    }


//    @Test
//    public void whenSortStream_thenGetSortedStream() {
//        Employee[] arrayOfEmps = {
//                new Employee(1, "Jeff Bezos", 100000.0),
//                new Employee(2, "Bill Gates", 200000.0),
//                new Employee(3, "Mark Zuckerberg", 300000.0)
//        };
//
//        List<Employee> empList = Arrays.asList(arrayOfEmps);
//
//        List<Employee> employees = empList.stream()
//                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
//                .collect(Collectors.toList());
//
//        assertEquals(employees.get(0).getName(), "Bill Gates");
//        assertEquals(employees.get(1).getName(), "Jeff Bezos");
//        assertEquals(employees.get(2).getName(), "Mark Zuckerberg");
//    }
}
