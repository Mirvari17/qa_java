package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    // public CatTest() {}
    @Mock
    Feline felineMock;

    @InjectMocks
    Cat cat;

    //Feline feline = new Feline();
    //Cat cat = new Cat(felineMock);

    // кошка издаёт звук "мяу"
    @Test
    public void getSoundTest() {
        assertEquals(cat.getSound(), "Мяу");
    }

    // кошка ест еду хищника - "Животные", "Птицы", "Рыба"
    @Test
    public void getFoodTest() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }


}