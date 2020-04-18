public class JukeBox{
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdList;
    private SongSelector songSelector;

    public JukeBox(CDPlayer cdPlayer, User user,
                   Set<CD> cdList, SongSelector songSelector){
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdList = cdList;
        this.songSelector = songSelector;
    }

    public Song getCurrentSong(){
        return this.songSelector.getCurrentSong();
    }

    public void setUser(User newUser){
        this.user = newUser;
    }
}