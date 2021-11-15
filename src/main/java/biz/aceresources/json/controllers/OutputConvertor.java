package biz.aceresources.json.controllers;

import biz.aceresources.json.models.InputClass;
import biz.aceresources.json.models.OutputClass;
import lombok.Getter;
import lombok.NonNull;

/**
 * To convert input format to output format
 * Convertors will be depending on input and output format
 * Note: Convert function is called in constructor
 *
 * @param <T> the type parameter
 */
public abstract class OutputConvertor<T extends OutputClass> {

    /**
     * The Input class.
     */
    @NonNull
    InputClass inputClass;
    /**
     * The Output class.
     */
    @Getter
    T outputClass;

    /**
     * Initiate output convertor.
     *
     * @param inputClass the input class
     * @return instance of the class it's self
     */
    public OutputConvertor<T> initiate(@NonNull InputClass inputClass) {
        this.inputClass = inputClass;
        return this;
    }

    /**
     * Convert output convertor.
     *
     * @return the output convertor
     */
    public OutputConvertor<T> convert() {
        this.outputClass = convertClasses();
        return this;
    }

    /**
     * Implement this to convert input to output format
     *
     * @return the output class
     */
    protected abstract T convertClasses();

}
