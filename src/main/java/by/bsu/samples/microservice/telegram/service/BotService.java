package by.bsu.samples.microservice.telegram.service;



import by.bsu.samples.microservice.controller.BotController;
import by.bsu.samples.microservice.telegram.model.Message;
import by.bsu.samples.microservice.telegram.model.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BotService extends TelegramLongPollingBot {
    private Logger logger = LoggerFactory.getLogger(BotService.class);
    private Map<Long, UserSession> userSessionList;
    private UserSession userSession;
    private SendMessage sendMessage;
    private String answer;
    public BotService(){
        userSessionList = new HashMap<>();
        sendMessage = new SendMessage();

    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = 0;
        //ответ от кнопки
        if (update.hasCallbackQuery()){
            chatId = update.getCallbackQuery().getMessage().getChatId();
            answer = update.getCallbackQuery().getData();
        }
        //ответ текстовым сообщением
        else if (update.hasMessage()) {
            chatId = update.getMessage().getChatId();
            answer = update.getMessage().getText();
        }

        if (chatId != 0){
            sendMessage.setChatId(chatId);
            userSession = userSessionList.get(chatId);

            if (userSession == null) {
                userSession = new UserSession();
                userSessionList.put(chatId, userSession);
            }
            //формирование сообщения
            Message message = userSession.getInfoForMessages(answer);
            sendMessage.setText(message.getQuestion()).setReplyMarkup(message.getKeyboard());
            //отправка сообщения клиенту
            try {
                sendApiMethod(sendMessage);
            } catch (TelegramApiException e) {
                logger.trace(e.getMessage());
            }
        }

    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "";
    }
}

