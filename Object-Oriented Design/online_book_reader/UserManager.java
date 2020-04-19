public class UserManager {
    private HashMap<Integer, User> users;

    public User addUser(int id, String name, int accountType){
        if(!users.containsKey(id)){
            users.add(new User(id,name,accountType));
        }
        return users.get(id);
    }

    public boolean remove(User user){

    }

    public boolean remove(int userId){

    }

    public User find(int userId){

    }
}