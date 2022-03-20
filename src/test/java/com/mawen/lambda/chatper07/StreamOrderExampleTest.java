package com.mawen.lambda.chatper07;

import com.mawen.lambda.model.Album;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StreamOrderExampleTest {

    @Test
    public void canCountFeatures() {
        StreamOrderExample.OrderDomain order = new StreamOrderExample.OrderDomain(Arrays.asList(
                new Album("Exile on Main St.", null, null),
                new Album("Beggars Banquet.", null, null),
                new Album("Aftermatch.", null, null),
                new Album("Let it Bleed.", null, null)
        ));

        assertEquals(8, order.countFeature(album -> 2));

    }

    @Test
    public void canCountFeaturesWithMock() {
        List<Integer> otherList = List.of(1,2,3);

        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenAnswer(inv -> otherList.size());

        assertEquals(3, list.size());
    }
}