package biz.aceresources.json.errors;

import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Centralised class to handle exception with our own messages
 */
public class AceApplicationException extends RuntimeException {

    @Getter
    private String shortMessage;
    private String description;

    /**
     * Instantiates a new Ace application exception.
     *
     * @param exception the exception
     */
    public AceApplicationException(Exception exception) {
        super(exception);
        if (exception instanceof FileNotFoundException) {
            this.shortMessage = "File Not Found!";
            this.description = "The requested file is not found please make sure file is there and you use a correct address";
        } else if (exception instanceof IOException) {
            this.shortMessage = "Problem in processing file!";
            this.description = "Make sure you have provided a correct file address";
        } else if (exception instanceof IllegalStateException) {
            this.shortMessage = "Invalid Json Format!";
            this.description = "Json file is incorrect " + exception.getMessage();
        }

    }

    /**
     * Instantiates a new Ace application exception.
     *
     * @param shortMessage the short message
     */
    public AceApplicationException(String shortMessage) {
        this.shortMessage = shortMessage;
        this.description = shortMessage;


    }
}
