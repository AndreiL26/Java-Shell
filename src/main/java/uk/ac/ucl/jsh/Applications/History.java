package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class History extends Application {
    public History(FileSystem fileSystem) {
        super(fileSystem);
    }

    private String indexHistoryElement(int index, String historyElement) {
        return Integer.toString(index) + ". " + historyElement;
    }

    public void execute(ArrayList<String> applicationArguments, 
                        InputStream inputStream, 
                        OutputStream outputStream) throws IOException {

        checkArguments(applicationArguments, inputStream, outputStream);
        ArrayList<String> historyToPrint = new ArrayList<>();
        ArrayList<String> history = Jsh.getHistory();
        int numberOfElementsToPrint;

        if (applicationArguments.isEmpty()) {
            numberOfElementsToPrint = history.size();
        }
        else {
            numberOfElementsToPrint = Integer.parseInt(applicationArguments.get(0));
            if (numberOfElementsToPrint > history.size()) {
                numberOfElementsToPrint = history.size();
            }
        }

        if (numberOfElementsToPrint > 500) {
            numberOfElementsToPrint = 500;
        }

        if (numberOfElementsToPrint < 0) {
            throw new RuntimeException("History: invalid option");
        }

        for (int index = history.size() - numberOfElementsToPrint; index < history.size(); ++index) {
            historyToPrint.add(indexHistoryElement(index + 1, history.get(index)));
        }
        
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        for (String historyElement: historyToPrint) {
            writer.write(historyElement + System.getProperty("line.separator"));
            writer.flush();
        }
    }
    
    public void checkArguments(ArrayList<String> applicationArguments, 
                               InputStream inputStream, 
                               OutputStream outpustream) {
        if (applicationArguments.size() > 1) {
            throw new RuntimeException("history: too many arguments");
        }
    } 


}