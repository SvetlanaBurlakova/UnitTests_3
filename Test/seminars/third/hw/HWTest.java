package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HWTest {
    MainHW mainHW;
     @BeforeEach
     void setUp(){
         mainHW = new MainHW();
     }
    @Test
    void isNumberOdd(){
        assertTrue(mainHW.evenOddNumber(2));
    }

    @Test
    void isNumberNotOdd(){
        assertFalse(mainHW.evenOddNumber(1));
    }

    @Test
    void isNumberInInterval(){
        assertTrue(mainHW.numberInInterval(50));
    }
    @Test
    void isNumberNotInInterval(){
        assertFalse(mainHW.numberInInterval(25));
    }
}
