public class Result {
    private String bookTitle;
    private String averageRating;
    private String description;
    private String author;

    public Result(String bookTitle, String averageRating, String description, String author) {
        this.bookTitle = bookTitle;
        this.averageRating = averageRating;
        this.description = description;
        this.author = author;
    }

    public Result() {
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return this.bookTitle + "\n" + "By: " + this.author + "\n\n" + "Average rating: " + this.averageRating + "\n\n" + "Description: " + "\n" + this.description;
    }
}
