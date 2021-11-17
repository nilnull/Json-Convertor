package biz.aceresources.json.controllers.readers;

import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.models.InputClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

/**
 * The type Input reader that will be used inorder to read diffrent types of file (json, csv and etc).
 *
 * @param <T> the type parameter
 */
public abstract class JsonReader<T extends InputClass> implements InputFileReader {


    /**
     * The Param.
     */
    File param;


    /**
     * Read input class.
     *
     * @return the input class
     */






    public JsonReader initiate(File parameter) {
        param = (File) parameter;
        return this;
    }

    /**
     * Read the provided json file and convert it to provided type
     *
     * @return
     * @throws AceApplicationException
     */
    @Override
    public T read() throws AceApplicationException {
        final Type EXAMPLE_TYPE = new TypeToken<T>() {
        }.getType();
        Gson gson = new Gson();
        try {
            com.google.gson.stream.JsonReader reader = new com.google.gson.stream.JsonReader(new FileReader(param));
            return gson.fromJson(reader, EXAMPLE_TYPE);
        } catch (java.lang.IllegalStateException exception) {
            throw new AceApplicationException(exception);
        } catch (FileNotFoundException exception) {
            throw new AceApplicationException(exception);
        }
    }
}

