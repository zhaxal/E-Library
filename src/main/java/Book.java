public class Book {
    int isbn;
    String name;
    String author;
    int amount;

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

}
