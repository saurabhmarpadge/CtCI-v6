public class OnlineReaderSystem {
    private Library library;
    private UserManager userManager;
    private Display display;

    private Book activeBook;
    private User activeUser;

    public OnlineReaderSystem(Library library, UserManager userManager, Display display) {
        this.library = library;
        this.userManager = userManager;
        this.display = display;
    }

    public void setActiveBook(Book activeBook) {
        this.display.displayBook(activeBook);
        this.activeBook = activeBook;
    }

    public void setActiveUser(User activeUser) {
        this.display.displayUser(activeUser);
        this.activeUser = activeUser;
    }

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Display getDisplay() {
        return display;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public User getActiveUser() {
        return activeUser;
    }

}