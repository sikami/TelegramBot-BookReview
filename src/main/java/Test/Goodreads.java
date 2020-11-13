package Test;

import org.xml.sax.XMLReader;

public class Goodreads {
    private String apiKey;
    private String bookname;
    private String url;
    private String author;
    private XMLReader reader;

    public Goodreads(String bookname) {
        this.bookname = bookname;
        this.bookname.trim();
        this.author = "";
        this.apiKey = "key=hgTduibWyDqLAgu1v6wnRQ" ;
        this.url = "https://www.goodreads.com/book/title.xml?";
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUrl() {
        return url;
    }

    public String queryUrlToConnect() {
        String urlToConnect;

        //check if this.bookname contains space
        if (this.bookname.contains(" ")) {
            this.bookname.replace(" ", "+");
        }

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

