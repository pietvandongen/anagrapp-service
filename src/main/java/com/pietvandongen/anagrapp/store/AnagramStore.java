package com.pietvandongen.anagrapp.store;

import java.util.Set;

public interface AnagramStore {

    Set<String> findAnagrams(String word);

    void storeAnagrams(String word, Set<String> anagrams);
}
