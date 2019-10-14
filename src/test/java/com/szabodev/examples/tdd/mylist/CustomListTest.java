package com.szabodev.examples.tdd.mylist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {

    @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "ConstantConditions"})
    @Test
    void givenEmptyList_whenIsEmpty_thenTrueIsReturned() {
        List<Object> list = new CustomList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void givenNonEmptyList_whenIsEmpty_thenFalseIsReturned() {
        List<Object> list = new CustomList<>();
        list.add(null);

        assertFalse(list.isEmpty());
    }

    @Test
    void givenListWithAnElement_whenSize_thenOneIsReturned() {
        List<Object> list = new CustomList<>();
        list.add(null);

        assertEquals(1, list.size());
    }

    @Test
    void givenListWithAnElement_whenGet_thenThatElementIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("baeldung");
        Object element = list.get(0);

        assertEquals("baeldung", element);
    }

    @Test
    void givenEmptyList_whenElementIsAdded_thenGetReturnsThatElement() {
        List<Object> list = new CustomList<>();
        boolean succeeded = list.add(null);

        assertTrue(succeeded);
    }

    @Test
    void givenListWithAnElement_whenAnotherIsAdded_thenGetReturnsBoth() {
        List<Object> list = new CustomList<>();
        list.add("baeldung");
        list.add(".com");
        Object element1 = list.get(0);
        Object element2 = list.get(1);

        assertEquals("baeldung", element1);
        assertEquals(".com", element2);
    }
}
