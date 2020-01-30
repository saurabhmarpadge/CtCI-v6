package file_system;

public class Question {
    public static void main(String[] args) {
        Directory root = new Directory("root",null);
        Directory levelOne = new Directory("levelOne",root);
        File appleFile = new File("Apple",root);
        appleFile.setSize(10);
        File orangeFile = new File("Orange",root);
        orangeFile.setSize(20);
        File mangoFile = new File("Mango",root);
        mangoFile.setSize(30);
        File graphFile = new File("Graph",levelOne);
        graphFile.setSize(40);
        root.addEntry(appleFile);
        root.addEntry(orangeFile);
        root.addEntry(mangoFile);
        levelOne.addEntry(graphFile);
        root.addEntry(levelOne);
        System.out.println(root.size());
        System.out.println(root.noOfFiles());
        System.out.println(graphFile.getPath());
        System.out.println("Graph - isPresent() "+root.isPresent("Graph"));
        root.removeEntry(levelOne);
        System.out.println(root.size());
        System.out.println(root.noOfFiles());
    }
}
