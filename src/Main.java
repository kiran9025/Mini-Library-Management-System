import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome to mini Library System : ");
        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        String choice;
        while(true){
            System.out.println("""
                \nChoose an option:
                1. adduser
                2. addbook
                3. issuebook
                4. returnbook
                5. showallbooks
                6. showissuedbooks
                7. exit
                """);

            choice = sc.nextLine().trim().toLowerCase();
            switch(choice){
                case "adduser" ->  {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Users user = new Users(id, name, email);
                    library.addUser(user);
                }
                case "addbook" -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    Books book = new Books(title, author);
                    library.addBook(book);
                }
                case "issuebook" -> {

                        System.out.print("Enter user ID: ");
                        int userId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        library.isuueBookToUser(userId, title);
                }
                case "returnbook" ->{
                    System.out.print("Enter user ID: ");
                    int userId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    library.returnBook(userId, title);

                }
                case "showallbooks" ->  library.showAllBooks();

                case "showissuedbooks" -> library.showIssuedBook();

                case "exit" ->  {
                    System.out.println("Thank you for using mini Library ");
                    return;
                }
                default -> System.out.println("Invalid choice please try again ");

            }

        }

    }
}