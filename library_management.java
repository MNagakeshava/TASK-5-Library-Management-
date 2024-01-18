import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Member {
    String name;
    String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

class LibrarySystem {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private Map<String, Boolean> bookAvailability = new HashMap<>();

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.put(title, newBook);
        bookAvailability.put(title, true);
    }

    public void addMember(String name, String email) {
        Member newMember = new Member(name, email);
        members.put(email, newMember);
    }

    public void issueBook(String bookTitle, String memberEmail) {
        if (books.containsKey(bookTitle) && members.containsKey(memberEmail)) {
            if (bookAvailability.get(bookTitle)) {
                bookAvailability.put(bookTitle, false);
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is not available ");
            }
        } else {
            System.out.println("Invalid book or member details.");
        }
    }

    public void returnBook(String bookTitle) {
        if (books.containsKey(bookTitle) && !bookAvailability.get(bookTitle)) {
            bookAvailability.put(bookTitle, true);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid book details or the book is already available.");
        }
    }
}

public class library_management {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        librarySystem.addBook("Java Programming", "Mohan");
        librarySystem.addBook("HTML", "Smith");

        librarySystem.addMember("Kishore", "kishore@example.com");
        librarySystem.addMember("Bunny", "bunny@example.com");

        int choice;
        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String issueBookTitle = scanner.nextLine();
                    System.out.print("Enter member email: ");
                    String issueMemberEmail = scanner.nextLine();
                    librarySystem.issueBook(issueBookTitle, issueMemberEmail);
                    break;
                case 2:
                    System.out.print("Enter book title to return: ");
                    String returnBookTitle = scanner.nextLine();
                    librarySystem.returnBook(returnBookTitle);
                    break;
                case 3:
                    System.out.println("Exiting Library Management System.");
                    System.out.println("            Thank You             ");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
