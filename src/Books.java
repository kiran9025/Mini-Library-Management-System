public class Books {

    private String title;
    private String author;
    private boolean isAvailable = true;

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setIsAvailable(boolean isAvailable){
       this.isAvailable = isAvailable;
    }
    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', available=" + isAvailable + "}";
    }


}
