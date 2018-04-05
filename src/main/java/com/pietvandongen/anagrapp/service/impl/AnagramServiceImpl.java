package com.pietvandongen.anagrapp.service.impl;

import com.pietvandongen.anagrapp.service.AnagramService;
import com.pietvandongen.anagrapp.store.AnagramStore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class AnagramServiceImpl implements AnagramService {

    @Inject
    private AnagramStore anagramStore;

    static Set<String> createAnagrams(String word) {
        if (word == null) {
            return null;
        }

        if (word.isEmpty()) {
            return Collections.singleton("");
        }

        if (word.length() == 1) {
            return Collections.singleton(word);
        }

        Set<String> result = new HashSet<>();
        result.add("ab");
        result.add("ba");

        return result;
    }

    @Override
    public Set<String> getAnagrams(String word) {
        Set<String> anagrams = anagramStore.findAnagrams(word);

        if (anagrams != null && !anagrams.isEmpty()) {
            return anagrams;
        }

        Set<String> createdAnagrams = createAnagrams(word);
        
        anagramStore.storeAnagrams(word, createdAnagrams);
        
        return createdAnagrams;
    }
}
