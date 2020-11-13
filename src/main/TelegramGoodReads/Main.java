import Test.Test;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.xml.sax.helpers.XMLReaderAdapter;

public class Main {
    public static void main(String[] args) {
//        instantiate telegram bot
//        register bot
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Test());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }



    }
}
