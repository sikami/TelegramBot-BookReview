import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramExecute extends TelegramLongPollingBot {
    private Result text = new Result();


    public String getBotUsername() {
        return "testbot";
    }

    public String getBotToken() {
        return "1336596386:AAHtuEOIe5X_8zi_V5BfN8MaN7uE7Jh9BwE";
    }

    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            message.setText("Hi, I am your book review Bot. Please type in the book title. If you wonder where the review is coming from, it is from Goodreads!");
        } else if (update.hasMessage()) {
            String book = update.getMessage().getText();
            Goodreads goodreadsBookTitle = new Goodreads(book);
            message.setText(goodreadsBookTitle.parseWebsite());
        }

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
