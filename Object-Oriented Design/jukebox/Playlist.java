public class Playlist {
    private Queue<Song> queue;

    public Playlist(Queue<Song> queue) {
        this.queue = queue;
    }

    public Song getNextSongToPlay(){
        return this.queue.peek();
    }

    public void queueUpSong(Song song){
        this.queue.add(song);
    }
}