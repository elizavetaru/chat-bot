package by.bsu.samples.microservice.telegram.model;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

public class Message {
    private String question;
    private InlineKeyboardMarkup  keyboard;

    public Message(String question, InlineKeyboardMarkup  keyboard) {
        this.question = question;
        this.keyboard = keyboard;
    }

    public String getQuestion() {
        return question;
    }

    public InlineKeyboardMarkup getKeyboard() {
        return keyboard;
    }
}
