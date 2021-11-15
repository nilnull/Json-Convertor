package biz.aceresources.json.controllers.readers;

import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.models.input.json.InputFileContents;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

/**
 * To read json files from a provided file.
 */
@Getter
@NoArgsConstructor
public class JsonFileReader extends InputReader<InputFileContents> {


    /**
     * The Param.
     */
    File param;


    @Override
    public InputReader initiate(Object parameter) {
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
    public InputFileContents read() throws AceApplicationException {
        final Type EXAMPLE_TYPE = new TypeToken<InputFileContents>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(param));
            InputFileContents inputFileContents = gson.fromJson(reader, EXAMPLE_TYPE); // contains the whole items list
            return inputFileContents;
        } catch (java.lang.IllegalStateException exception) {
            throw new AceApplicationException(exception);
        } catch (FileNotFoundException exception) {
            throw new AceApplicationException(exception);
        }
    }
}
