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
        //@ todo 
        return Collections.emptySet();
    }

    @Override
    public void storeAnagrams(String word, Set<String> anagrams) {
        // @todo 
    }
}
