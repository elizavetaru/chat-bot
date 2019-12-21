package by.bsu.samples.microservice.telegram.model;

import by.bsu.samples.microservice.telegram.repository.BotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
    private List<String> questions;
    private List<String> answers;
    private int numberOfAskedQuestions;
    private List<InlineKeyboardMarkup> keyboards;



    public UserSession()
    {
        questions = new ArrayList<>();
        questions.add("Здравствуйте!");
        questions.add("Какого цвета вы хотите машину?");
        questions.add("Какой тип кузова?");
        answers = new ArrayList<>();

        keyboards = new ArrayList<>();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> keyboardButtonsRow =  new ArrayList<>();

        keyboardButtonsRow.add(new InlineKeyboardButton().setText("Привет!").setCallbackData("1.1"));
        keyboard.add(new ArrayList<>(keyboardButtonsRow));
        keyboards.add(new InlineKeyboardMarkup().setKeyboard( new ArrayList<>(keyboard)));

        keyboard.clear();
        keyboardButtonsRow.clear();
        keyboardButtonsRow.add(new InlineKeyboardButton().setText("Красный").setCallbackData("Красный"));
        keyboard.add(new ArrayList<>(keyboardButtonsRow));
        keyboardButtonsRow.clear();
        keyboardButtonsRow.add(new InlineKeyboardButton().setText("Желтый").setCallbackData("Желтый"));
        keyboard.add(new ArrayList<>(keyboardButtonsRow));
        keyboards.add(new InlineKeyboardMarkup().setKeyboard( new ArrayList<>(keyboard)));


        keyboard.clear();
        keyboardButtonsRow.clear();
        keyboardButtonsRow.add(new InlineKeyboardButton().setText("Хэтчбек").setCallbackData("Хэтчбек"));
        keyboard.add(new ArrayList<>(keyboardButtonsRow));
        keyboardButtonsRow.clear();
        keyboardButtonsRow.add(new InlineKeyboardButton().setText("Пикап").setCallbackData("Пикап"));
        keyboard.add(new ArrayList<>(keyboardButtonsRow));
        keyboardButtonsRow.clear();
        keyboardButtonsRow.add(new InlineKeyboardButton().setText("Кабриолет").setCallbackData("Кабриолет"));
        keyboard.add(new ArrayList<>(keyboardButtonsRow));
        keyboards.add(new InlineKeyboardMarkup().setKeyboard(new ArrayList<>(keyboard)));



        numberOfAskedQuestions = 0;
    }
    public Message getInfoForMessages(String answer)
    {
        if (numberOfAskedQuestions == 0){
            return new Message(getQuestion(), getKeyboard());
        }
        else if (numberOfAskedQuestions < questions.size())
        {
            if (numberOfAskedQuestions != 1)
                setAnswer(answer);
            return new Message(getQuestion(), getKeyboard());
        }
        else{
            setAnswer(answer);
            return new Message("Вам подойдет " + answers.get(0) + ' ' +
                    answers.get(1),null);
        }

    }

    private void setAnswer(String answer) {
        answers.add(answer);
    }

    private String getQuestion(){
        return questions.get(numberOfAskedQuestions);
    }

    private InlineKeyboardMarkup getKeyboard(){
        return keyboards.get(numberOfAskedQuestions ++);
    }
}
