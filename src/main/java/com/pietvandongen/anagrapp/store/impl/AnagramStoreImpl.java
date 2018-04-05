package com.pietvandongen.anagrapp.store.impl;

import com.pietvandongen.anagrapp.store.AnagramStore;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class AnagramStoreImpl implements AnagramStore {

    private Map<String, Set<String>> storedAnagrams = new ConcurrentHashMap<>();

    @Override
    public Set<String> findAnagrams(String word) {
        Set<String> anagrams = storedAnagrams.get(word);
        
        if (anagrams == null) {
            return Collections.emptySet();
        }

        return anagrams;
    }

    @Override
    public void storeAnagrams(String word, Set<String> anagrams) {
        storedAnagrams.put(word, anagrams);
    }
}
