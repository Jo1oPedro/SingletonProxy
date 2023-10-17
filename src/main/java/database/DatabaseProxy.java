package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseProxy implements IDatabase {

    public void query(String query) {
        this.realizaLog(query);
        Database.getConnection().query(query);
    }

    private void realizaLog(String query)
    {
        String filePath = "log.txt";

        try {
            // Create a File object representing the file
            File file = new File(filePath);

            // Check if the file already exists; if not, create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // Create a FileWriter to write to the file
            FileWriter fileWriter = new FileWriter(file, true);

            // Create a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data to the file
            bufferedWriter.write("Query: "+ query + "\n");

            // Close the BufferedWriter and FileWriter to release resources
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
