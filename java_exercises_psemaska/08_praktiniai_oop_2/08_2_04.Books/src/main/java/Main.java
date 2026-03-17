import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them

        List<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter book title: ");
            String title = scanner.nextLine();

            if(title.isEmpty()) {
                break;
            }

            System.out.println("Pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            System.out.println("Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            books.add(new Book(title, pages, year));
        }

        System.out.println("What info will be printed (everything/name)? ");
        String answer = scanner.nextLine();

        for(Book book : books){
            if(answer.equalsIgnoreCase("everything")){
                System.out.println(book.getTitle() + ", " + book.getPages() + " pages, " + book.getYear());
            } else {
                System.out.println(book.getTitle());
            }
        }
    }
}
