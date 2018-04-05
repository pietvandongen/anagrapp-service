package com.pietvandongen.anagrapp.store;

import com.pietvandongen.anagrapp.service.impl.AnagramServiceImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
@Category(com.pietvandongen.anagrapp.test.categories.IntegrationTest.class)
public class ITAnagramStoreServiceImpl {

    @Mock
    private AnagramStore anagramStore;

    @InjectMocks
    private AnagramServiceImpl anagramService;

    @Test
    public void thatXX() {
        anagramService.getAnagrams("a");

//        Mockito.verify(anagramStore, times(1)).findAnagrams(anyString());
//        Mockito.verify(anagramStore, times(1)).storeAnagrams(anyString(), anySet());

        anagramService.getAnagrams("a");

        when(anagramStore.findAnagrams(anyString())).thenReturn(Collections.emptySet());

        Mockito.verify(anagramStore, times(2)).findAnagrams(anyString());
        Mockito.verify(anagramStore, times(1)).storeAnagrams(anyString(), anySet());
    }
}
