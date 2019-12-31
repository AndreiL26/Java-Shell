package uk.ac.ucl.jsh.Utilities;

public class JshException extends Exception {
    private static final long serialVersionUID = -1517441780643449892L;

    public JshException(String errorMessage) {
        super(errorMessage);
    }
}