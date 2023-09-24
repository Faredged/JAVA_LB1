import java.util.ArrayList;

// Клас, що представляє книгу
class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    // Геттери для отримання властивостей книги
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Назва: " + title + ", Автор: " + author + ", ISBN: " + isbn + ", Рік видання: " + year;
    }
}

// Клас, що представляє бібліотеку
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Додавання нової книги в бібліотеку
    public void addBook(Book book) {
        books.add(book);
    }

    // Показ усіх книг в бібліотеці
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Пошук книги за назвою
    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Знайдено книгу:\n" + book);
                return;
            }
        }
        System.out.println("Книга з назвою \"" + title + "\" не знайдена.");
    }

    // Видалення книги за номером ISBN
    public void removeBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Книга з ISBN " + isbn + " була видалена.");
                return;
            }
        }
        System.out.println("Книга з ISBN " + isbn + " не знайдена.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Додавання книг в бібліотеку
        library.addBook(new Book("Книга 1", "Автор 1", "1234567890", 2020));
        library.addBook(new Book("Книга 2", "Автор 2", "9876543210", 2018));
        library.addBook(new Book("Книга 3", "Автор 1", "1112223334", 2019));

        // Виведення всіх книг в бібліотеці
        System.out.println("Всі книги в бібліотеці:");
        library.displayBooks();

        // Пошук книги за назвою
        System.out.println("\nПошук книги за назвою \"Книга 2\":");
        library.searchBookByTitle("Книга 2");

        // Видалення книги за номером ISBN
        System.out.println("\nВидалення книги з ISBN 1234567890:");
        library.removeBookByISBN("1234567890");

        // Виведення оновленого списку книг
        System.out.println("\nОновлений список книг:");
        library.displayBooks();
    }
}
