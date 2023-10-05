package seminars.third.tdd;

public class MoodAnalyser {
    /*
    3.5 Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение
выраженное во фразах.

     */
    public String analyseMood(String message) {
        if (message.equals("Все хорошо!")) {
            return "Mood positive";
        } else if (message.equals("Все плохо!")) {
            return "Mood negative";
        }
        else if (message.equals("Все нормально!")) {
            return "Mood neutral";
        }
        else {
            return "Mood unknown";
        }
    }

}