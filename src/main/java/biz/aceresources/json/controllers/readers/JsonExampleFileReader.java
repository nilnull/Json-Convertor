package biz.aceresources.json.controllers.readers;

import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.models.InputClass;
import biz.aceresources.json.models.input.json.InputFileContents;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

/**
 * To read json files from a provided file.
 */
@Getter
@NoArgsConstructor
public  class JsonExampleFileReader extends JsonReader<InputFileContents> {

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
        try {
            com.google.gson.stream.JsonReader reader = new com.google.gson.stream.JsonReader(new FileReader(param));
            return gson.fromJson(reader, EXAMPLE_TYPE);
        } catch (IllegalStateException | FileNotFoundException exception) {
            throw new AceApplicationException(exception);
        }
    }
}
