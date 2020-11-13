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
        this.bookname = bookname.trim().replace(" ", "+");
        this.author = "";
        this.apiKey = "key=hgTduibWyDqLAgu1v6wnRQ" ;
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

            String title = next.getChildText("title");
            String rating = next.getChildText("average_rating");
            String desc = next.getChildText("description").replaceAll("<.*?>", "");

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


/**
 Get the reviews for a book given a title string
 Get an xml response that contains embed code for the iframe reviews widget, which shows an excerpt (first 300 characters) of the most popular reviews of a book for a given title/author. The book shown will be the most popular book that matches all the keywords in the input string. The reviews are from all known editions of the book.
 URL: https://www.goodreads.com/book/title.FORMAT    (sample url)
 HTTP method: GET
 Parameters:
 format: xml or json
 key: Developer key (required).
 title: The title of the book to lookup.
 author: The author name of the book to lookup. This is optional, but is recommended for accuracy.
 rating: Show only reviews with a particular rating (optional)

 API key and sample : "https://www.goodreads.com/book/isbn/\" + isbn + \"?key=hgTduibWyDqLAgu1v6wnRQ"

 sample without author: https://www.goodreads.com/book/title.xml?key=hgTduibWyDqLAgu1v6wnRQ&title=Hound+of+the+Baskervilles
 sample with author: https://www.goodreads.com/book/title.xml?author=Arthur+Conan+Doyle&key=hgTduibWyDqLAgu1v6wnRQ&title=Hound+of+the+Baskervilles
 **/


//need to catch this
//book title, average rating, description
/**<book>
<id>8921</id>
<title>
<![CDATA[
The Hound of the Baskervilles (Sherlock Holmes, #5)
]]>
</title>


 <average_rating>4.12</average_rating>


 <description>
 <![CDATA[
 blah blah
 ]]>
 </description>
 **/