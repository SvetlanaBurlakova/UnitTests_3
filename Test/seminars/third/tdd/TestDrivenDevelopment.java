package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.second.simple_shopping_cart.Cart;
import seminars.second.simple_shopping_cart.Shop;
import seminars.third.coverage.SomeService;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    //3.5. Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение
    //выраженное во фразах.

    private MoodAnalyser moodAnalyser;
    @BeforeEach
    void setup() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void positiveMood(){
        assertThat(moodAnalyser.analyseMood("Все хорошо!")).isEqualTo("Mood positive");
    }

    @Test
    void negativeMood(){
        assertThat(moodAnalyser.analyseMood("Все плохо!")).isEqualTo("Mood negative");
    }

    @Test
    void neutralMood(){
        assertThat(moodAnalyser.analyseMood("Все нормально!")).isEqualTo("Mood neutral");
    }

    @Test
    void unknownMood(){
        assertThat(moodAnalyser.analyseMood("Ничего!")).isEqualTo("Mood unknown");
    }
}