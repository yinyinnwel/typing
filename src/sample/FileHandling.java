package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {

    public static File lastModified(String dirFilePath) {
        File directory = new File(dirFilePath);
        File[] files =  directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;

        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }

        return chosenFile;
    }

    public static int[] sumText(String dirFilePath) {
        File directory = new File(dirFilePath);
        File [] files = directory.listFiles(File::isFile);
        int [] arr = new int[4];
        String[] stArr;
        int counter = 0;
        if (files != null) {
            for (File file : files) {
                counter++;
                try {
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    String st;
                    while ((st = bf.readLine()) != null) {
                        stArr = st.split(";");
                        arr[0] += Integer.parseInt(stArr[0]);
                        arr[1] += Integer.parseInt(stArr[1]);
                        arr[2] += Integer.parseInt(stArr[2]);

                    }

                } catch (IOException ignored) {
                }
            }
        }
        arr[3] = counter;
        return arr;

    }

}