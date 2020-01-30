package file_system;

class File extends Entry {
    int size;
    String content;
    File(String fileName, Directory parent){
        super(fileName,parent);
    }

    @Override
    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}