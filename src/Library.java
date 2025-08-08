import java.awt.print.Book;
import java.util.*;

public class Library {

    private List<Users> usersList;
    private List<Books> booksList;
    private HashMap<Users, List<Books>> map;

    public Library(){
        usersList = new ArrayList<>();
        booksList = new ArrayList<>();
        map = new HashMap<>();
    }

    public void addUser(Users user){
        usersList.add(user);
        System.out.println("User " + user.getName() + " added Successfully " );
    }
    public void addBook(Books book){
        booksList.add(book);
        System.out.println("Book " + book.getTitle() + " is addedd Successfully " );
    }
    private Users findById(int userid){
        if(usersList.isEmpty()){
            System.out.println("No user Found");
        }
        for(Users user : usersList){
            if(userid == user.getId()){
                return user;
            }
        }
        return null;
    }
    private Books findByTitle(String title){
        if(booksList.isEmpty()){
            System.out.println("No books available ");
        }
        for(Books book : booksList){
            if(title.equalsIgnoreCase(book.getTitle())){
                return book;
            }
        }
        return null;
    }


    public void isuueBookToUser(int userid, String booktitle){
        Users user  = findById(userid);
        Books book =  findByTitle(booktitle);
        for (Map.Entry<Users, List<Books>> entry : map.entrySet()) {
            if (entry.getValue().contains(book)) {
                System.out.println(" Book '" + book.getTitle() + "' is already issued to " + entry.getKey().getName());
                return;
            }
        }
        book.setIsAvailable(false);
        map.computeIfAbsent(user, k -> new ArrayList<>()).add(book);
        System.out.println("Book " + book.getTitle() + " is Issued to " + user.getName());

    }
    public void returnBook(int userid, String title){
        Users user = findById(userid);

        if(user == null || !map.containsKey(user)){
            System.out.println("User or book not found ");
            return;
        }
        List<Books> books =   map.get(user);
        for(Books book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                book.setIsAvailable(true);
                books.remove(book);
                System.out.println("Book " + book + " is returned by user " + user);
                return;
            }else{
                System.out.println("No biook has been issued to this user " + user);
            }
        }
    }

    public void showIssuedBook(){
        if(map.isEmpty()){
            System.out.println("No books found ");
        }
        for(Map.Entry<Users, List<Books>> x : map.entrySet()){
            System.out.println(x.getKey().getName() + " has issued ");
            if(booksList.isEmpty()){
                System.out.println("No book is issued to this user ");
            }
            for(Books books : x.getValue()){
                System.out.print(books.getTitle() + " ");
            }
        }
    }
    public void showAllBooks(){
        if(booksList.isEmpty()){
            System.out.println("No books in library.");
            return;
        }
        for(Books b : booksList){
            System.out.println(b);
        }
    }


}
