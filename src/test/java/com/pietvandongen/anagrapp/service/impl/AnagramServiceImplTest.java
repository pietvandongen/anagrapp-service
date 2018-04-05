package com.pietvandongen.anagrapp.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AnagramServiceImplTest {

    private AnagramServiceImpl anagramService;

    @Before
    public void setUp() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void thatCreateAnagramsReturnsNullWhenWordIsNull() {
        Set<String> expected = null;
        Set<String> actual = anagramService.getAnagrams(null);

        assertThat(actual, Matchers.is((expected)));
    }

    @Test
    public void thatCreateAnagramsReturnsEmptyStringWhenWordIsEmpty() {
        Set<String> expected = Collections.singleton("");
        Set<String> actual = anagramService.getAnagrams("");

        assertThat(actual, Matchers.is((expected)));
    }

    @Test
    public void thatCreateAnagramsReturnsQBla() {
        Set<String> expected = Collections.singleton("a");
        Set<String> actual = anagramService.getAnagrams("a");

        assertThat(actual, Matchers.is((expected)));
    }

    @Test
    public void thatCreateAnagramsReturnsQBlab() {
        Set<String> actual = anagramService.getAnagrams("ab");
        Set<String> expected = new HashSet<>();
        expected.add("ab");
        expected.add("ba");

        assertThat(actual, Matchers.is(expected));
    }
}