import Test.Test;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.xml.sax.helpers.XMLReaderAdapter;

public class Main {
    public static void main(String[] args) {
        //instantiate telegram bot
        //register bot
//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(new Test());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }


    }
}

//parse XML like this:
// String url = "http://api.indeed.com/ads/apisearch?publisher=8397709210207872&q=java&l=austin%2C+tx&sort&radius&st&jt&start&limit&fromage&filter&latlong=1&chnl&userip=1.2.3.4&v=2";
//
//try
//{
//  DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
//  DocumentBuilder b = f.newDocumentBuilder();
//  Document doc = b.parse(url);
//}