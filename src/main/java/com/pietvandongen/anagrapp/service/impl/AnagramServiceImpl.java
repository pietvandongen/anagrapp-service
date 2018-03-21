package com.pietvandongen.anagrapp.service.impl;

import com.pietvandongen.anagrapp.service.AnagramService;
import com.pietvandongen.anagrapp.store.AnagramStore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Set;

@ApplicationScoped
public class AnagramServiceImpl implements AnagramService {

    @Inject
    private AnagramStore anagramStore;

    private static Set<String> createAnagrams(String word) {
        return Collections.singleton(word);
    }

    @Override
    public Set<String> getAnagrams(String word) {
        // @todo
        
        return Collections.emptySet();
    }
}
