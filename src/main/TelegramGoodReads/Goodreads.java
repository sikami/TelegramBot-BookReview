import Api.Api;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.util.List;

public class Goodreads {
    private String apiKey;
    private String bookname;
    private String url;
    private String author;
    private XMLReader reader;
    private Result result;

    public Goodreads(String bookname) {
        Api api = new Api();
        this.bookname = bookname.trim().replace(" ", "+");
        this.author = "";
        this.apiKey = api.getApiKey() ;
        this.url = "https://www.goodreads.com/book/title.xml?";
        this.result = new Result();
    }

    public Goodreads() {
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    private String getApiKey() {
        return apiKey;
    }

    private String getUrl() {
        return url;
    }

    private String queryUrlToConnect() {
        String urlToConnect;

        //check if user gives author's name
        if (this.author.equals("")) {
            urlToConnect = this.url + this.apiKey + "&title=" + this.bookname;
        } else {
            this.author.trim();
            this.author.replace(" ", "+");
            urlToConnect = this.url + "author=" + this.author + "&" + this.apiKey + "&title=" + this.bookname;
        }

        return urlToConnect;
    }

    public String parseWebsite() {
        String url = queryUrlToConnect();

        //instantiate SAXBuilder
        SAXBuilder builder = new SAXBuilder();
        try {
            //instantiate Document to build or parse web
            Document document = builder.build(url);
            //get Element node
            Element rootNode = document.getRootElement();
            Element next = rootNode.getChild("book");
            Element author = next.getChild("authors");
            Element authorChild = author.getChild("author");
            String authorReal = authorChild.getChildText("name");

            String title = next.getChildText("title");
            String rating = next.getChildText("average_rating");
            String desc = next.getChildText("description").replaceAll("<.*?>", "");

            result.setAuthor(authorReal);
            result.setBookTitle(title);
            result.setAverageRating(rating);
            result.setDescription(desc);

            return result.toString();

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
