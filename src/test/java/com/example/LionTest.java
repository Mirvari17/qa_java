package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Mock
    Feline felineMock;

    // у льва 1 котёнок
    @Test
    public void lionGetKittensTest() throws Exception {
        lion = new Lion("Самка", felineMock);
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals(lion.getKittens(), 1);
    }

    // еда льва - "Животные", "Птицы", "Рыба"
    @Test
    public void lionGetFoodTest() throws Exception {
        lion = new Lion("Самка", felineMock);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }

    // лев выбрасывает ошибку, если ему подсунуть не "Самец" или "Самка"
    @Test
    public void lionThrowsExceptionTest() {
        try {
            new Lion("Абырвалг", felineMock);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }


    // льва внутри тестов можно создавать с любыми параметрами
    // feline мокируем


//    @Test
//    public void lionGetKittensMockedTest() throws Exception {
//        Lion l = new Lion("Самка", felineMock);
//        l.getKittens();
//        verify(felineMock).getKittens();
//    }
//
//    @Test
//    public void lionGetFoodMockedTest() throws Exception {
//        Lion l = new Lion("Самец", felineMock);
//        l.getFood();
//        verify(felineMock).getFood("Хищник");
//    }
}