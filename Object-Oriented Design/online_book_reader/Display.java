public class Display {
    private  Book activeBook;
    private User activeUser;
    private int pageNumber;

    public void displayUser(User user){
        this.activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book){
        this.pageNumber = 0;
        this.activeBook = book;
        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void refreshUsername(){

    }

    public void refreshTitle(){

    }

    public void refreshDetails(){

    }

    public void refreshPage(){

    }

    public void turnPageForward(){
        this.pageNumber++;
        refreshPage();
    }

    public void turnPageBackward(){
        this.pageNumber--;
        refreshPage();
    }

}