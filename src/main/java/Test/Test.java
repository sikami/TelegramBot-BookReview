package Test;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Test extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "testbot";
    }

    public String getBotToken() {
        return "1336596386:AAHtuEOIe5X_8zi_V5BfN8MaN7uE7Jh9BwE";
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().getText().equals("/hello")) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Hello, how are you today?");
            

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
