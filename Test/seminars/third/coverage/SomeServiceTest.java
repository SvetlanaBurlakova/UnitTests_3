package seminars.third.coverage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SomeServiceTest {
   // 3.1.
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        // assertEquals...
        SomeService someservice = new SomeService();
        assertEquals(someservice.fizzBuzz(12), "Fizz");
    }
    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        // assertEquals...
        SomeService someservice = new SomeService();
        assertEquals(someservice.fizzBuzz(10), "Buzz");
    }
    @Test
    void multipleFiveAndThreeReturnsBuzz() {
        // assertEquals...
        SomeService someservice = new SomeService();
        assertEquals(someservice.fizzBuzz(15), "FizzBuzz");
    }

    @Test
    void multipleNotFiveNotThreeReturnsI() {
        // assertEquals...
        SomeService someservice = new SomeService();
        assertEquals(someservice.fizzBuzz(8), "8");
    }
    @Test
    void fisrt6(){
        SomeService someservice = new SomeService();
        int[] arr = new int[] {6,0,1};
        assertEquals(someservice.firstLast6(arr),true);
    }
    @Test
    void last6(){
        SomeService someservice = new SomeService();
        int[] arr = new int[] {1,0,6};
        assertEquals(someservice.firstLast6(arr),true);
    }

    @Test
    void firstlast6(){
        SomeService someservice = new SomeService();
        int[] arr = new int[] {6,0,6};
        assertEquals(someservice.firstLast6(arr),true);
    }

    @Test
    void notFirstNotLast6(){
        SomeService someservice = new SomeService();
        int[] arr = new int[] {1,0,1};
        assertEquals(someservice.firstLast6(arr),false);
    }

    @ParameterizedTest
    @CsvSource({"10, 90", "100, 0", "0, 100"})
    void calculatingDiscount(int num, int res) {
        SomeService someservice = new SomeService();
        assertThat(someservice.calculatingDiscount(100,num)).isEqualTo(res);
    }

    @Test
    void calculatingDiscountAmountIncorrect() {
        SomeService someservice = new SomeService();
        assertThatThrownBy(() ->
                someservice.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); //

    }
    @Test
    void calculatingPurchaseAmountMinus() {
        SomeService someservice = new SomeService();
        assertThatThrownBy(() ->
                someservice.calculatingDiscount(-2000.0, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void sumFirst13(){
        SomeService someservice = new SomeService();
        assertThat(someservice.luckySum(13,1,2)).isEqualTo(3);
    }

    @Test
    void sumSecond13(){
        SomeService someservice = new SomeService();
        assertThat(someservice.luckySum(2,13,2)).isEqualTo(4);
    }

    @Test
    void sumThird13(){
        SomeService someservice = new SomeService();
        assertThat(someservice.luckySum(2,3,13)).isEqualTo(5);
    }

    @Test
    void sumNo13(){
        SomeService someservice = new SomeService();
        assertThat(someservice.luckySum(2,3,4)).isEqualTo(9);
    }
}