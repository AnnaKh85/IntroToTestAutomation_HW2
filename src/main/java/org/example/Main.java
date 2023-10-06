package org.example;

public class Main {
    public static void main(String[] args) {
        // Creating a simple file system structure
        Directory root = new Directory();
        Directory folder1 = new Directory();
        Directory folder2 = new Directory();
        File file1 = new File(100);
        File file2 = new File(200);
        File file3 = new File(300);

        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        root.add(folder1);
        root.add(folder2);

        int totalSize = root.getSize();
        System.out.println("Total size of the file system: " + totalSize);
    }
}