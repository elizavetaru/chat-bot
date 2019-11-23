package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.telegram.model.Bot;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


@RestController
@RequestMapping("/api/bot")
@Slf4j
public class BotController {
    private Logger logger = LoggerFactory.getLogger(BotController.class);
    private TelegramBotsApi telegramBotsApi;
    private Bot bot;

    @RequestMapping("/start")
    public void startBot() {
        ApiContextInitializer.init();
        telegramBotsApi = new TelegramBotsApi();
        bot = new Bot();

        try{
            telegramBotsApi.registerBot(bot);

        }
        catch (TelegramApiRequestException e){
            logger.trace(e.getMessage());
        }
    }
    @RequestMapping("/restart")
    public void restartBot(){

    }

    @RequestMapping("/stop")
    public void stopBot(){

    }
}
