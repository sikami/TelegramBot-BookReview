public class Result {
    private String bookTitle;
    private String averageRating;
    private String description;

    public Result(String bookTitle, String averageRating, String description) {
        this.bookTitle = bookTitle;
        this.averageRating = averageRating;
        this.description = description;
    }

    public Result() {
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
        return this.bookTitle + "\n" + "Average rating: " + this.averageRating + "\n" + "Description: " + "\n" + this.description;
    }
}
