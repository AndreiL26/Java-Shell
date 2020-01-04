package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class History implements Application {
    private String indexHistoryElement(int index, String historyElement) {
        return Integer.toString(index) + ". " + historyElement;
    }

    private void checkArguments(ArrayList<String> applicationArguments) throws JshException {
        if (applicationArguments.size() > 1) {
            throw new JshException("history: too many arguments");
        }
    } 

    @Override
    public void execute(ArrayList<String> applicationArguments, 
                        InputStream inputStream, 
                        OutputStream outputStream) throws JshException {

        checkArguments(applicationArguments);
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
            throw new JshException("history: invalid option");
        }

        for (int index = history.size() - numberOfElementsToPrint; index < history.size(); ++index) {
            historyToPrint.add(indexHistoryElement(index + 1, history.get(index)));
        }
        
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        try {
            for (String historyElement: historyToPrint) {
                writer.write(historyElement + Jsh.lineSeparator);
                writer.flush();
            }
        } catch (IOException e) {
            throw new JshException("history: cannot write output");
        }
    }
}