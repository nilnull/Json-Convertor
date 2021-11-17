package biz.aceresources.json.controllers.readers;

import biz.aceresources.json.errors.AceApplicationException;

public interface InputFileReader {

    public Object read() throws AceApplicationException;
}
