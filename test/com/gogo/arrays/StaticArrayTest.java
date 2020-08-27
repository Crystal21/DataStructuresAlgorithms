package com.gogo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StaticArrayTest {

    StaticArray<Integer> staticArray;

    @BeforeEach
    void setUp() {
        Integer[] a = new Integer[5];
        staticArray = new StaticArray<>(a);
    }

    @Test
    void push() {
        staticArray.push(5);
        assertEquals(1, staticArray.size());
        assertEquals(5, staticArray.get(0));
    }

    @Test
    void pop() {
        staticArray.push(1);
        staticArray.push(2);
        staticArray.push(3);
        int popped = staticArray.pop();
        assertEquals(3, popped);
        assertEquals(2, staticArray.size());
    }

    @Test
    void unshift() {
        staticArray.push(2);
        staticArray.push(3);
        staticArray.unshift(1);
        assertEquals(3, staticArray.size());
        assertEquals(1, staticArray.get(0));
    }

    @Test
    void splice() {
        staticArray.push(1);
        staticArray.push(2);
        staticArray.push(3);
        staticArray.splice(2, 1);
        assertEquals(2, staticArray.size());
    }

    @Test
    void spliceStartThrowsException() {
        staticArray.push(1);
        staticArray.push(2);
        staticArray.push(3);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticArray.splice(3, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticArray.splice(3, 1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticArray.splice(1, 3));
    }
}