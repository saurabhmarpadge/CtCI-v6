public class Library {
    private HashMap<Integer, Book> books;

    public Book addUser(int id, String name){
        if(!books.containsKey(id)){
            books.add(new Book(id,name));
        }
        return books.get(id);
    }

    public boolean remove(Book book){

    }

    public boolean remove(int bookId){

    }

    public Book find(int bookId){

    }
}