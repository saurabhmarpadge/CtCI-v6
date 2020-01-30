package file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    List<Entry> contents;
    Directory(String dirName,Directory parent){
        super(dirName,parent);
        contents = new ArrayList<>();
    }

    public void addEntry(Entry entry){
        contents.add(entry);
    }

    public void removeEntry(Entry entry){
        contents.remove(entry);
    }

    @Override
    public int size(){
        int totalSize=0;
        for(Entry entry:contents){
            totalSize+=entry.size();
        }
        return totalSize;
    }

    public boolean isPresent(String entryName){
        for(Entry entry:contents){
            if(entry instanceof File && entry.getName().equalsIgnoreCase(entryName)){
                return true;
            } else if(entry instanceof Directory ) {
                Directory dir = (Directory) entry;
                return dir.isPresent(entryName);
            }
        }
        return false;
    }

    public int noOfFiles(){
        int count=0;
        for(Entry entry:contents){
            if(entry instanceof File){
               count++;
            } else {
                Directory dir = (Directory) entry;
                count += dir.noOfFiles();
            }
        }
        return count;
    }

}