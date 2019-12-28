package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Applications.Application;

public class UnsafeApplicationDecorator extends ApplicationDecorator {

    public UnsafeApplicationDecorator(Application application) {
        super(application);
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws JshException {
        try {
            this.application.execute(applicationArguments, inputStream, outpustream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}   