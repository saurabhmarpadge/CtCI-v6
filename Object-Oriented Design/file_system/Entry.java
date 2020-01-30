package file_system;

import java.time.LocalDate;

abstract class Entry{
    Directory parent;
    String createdDate;
    String name;
    Entry(String entryName, Directory p){
        name = entryName;
        parent=p;
        createdDate = LocalDate.now().toString();
    }

    public int size() {
        return 0;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath(){
        if(parent==null){
            return "/"+name;
        }
        return parent.getPath()+"/"+name;
    }
}