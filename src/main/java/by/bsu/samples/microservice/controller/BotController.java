package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.telegram.service.BotService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private BotService bot;

    @GetMapping("/start")
    public ResponseEntity<String> startBot() {
        ApiContextInitializer.init();
        telegramBotsApi = new TelegramBotsApi();
        bot = new BotService();

        try{
            telegramBotsApi.registerBot(bot);
            return new ResponseEntity<>("Bot started", HttpStatus.OK);
        }
        catch (TelegramApiRequestException e){
            logger.trace(e.getMessage());
            return new ResponseEntity<>("Bot crashed, check log file", HttpStatus.BAD_REQUEST);
        }
    }
}
