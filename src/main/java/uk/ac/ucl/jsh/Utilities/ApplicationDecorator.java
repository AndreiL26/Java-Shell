package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Applications.Application;

public abstract class ApplicationDecorator implements Application {
    protected Application application;

    public ApplicationDecorator(Application application) {
        this.application = application;
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws JshException {
        this.application.execute(applicationArguments, inputStream, outpustream);
    }

}