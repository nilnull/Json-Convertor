package biz.aceresources.json.controllers.readers;

import biz.aceresources.json.models.InputClass;

/**
 * The type Input reader that will be used inorder to read diffrent types of file (json, csv and etc).
 *
 * @param <T> the type parameter
 */
public abstract class InputReader<T extends InputClass> {


    /**
     * Initiate input reader.
     *
     * @param parameter the parameter
     * @return the input reader
     */
    public abstract InputReader<T> initiate(Object parameter);

    /**
     * Read input class.
     *
     * @return the input class
     */
    public abstract T read();
}

