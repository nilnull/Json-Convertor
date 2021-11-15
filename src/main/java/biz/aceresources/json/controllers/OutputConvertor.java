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
     * Convert output convertor.
     *
     * @return the output convertor
     */
    public OutputConvertor<T> Convert() {
        this.outputClass = ConvertClasses();
        return this;
    }

    /**
     * Implement this to convert input to output format
     *
     * @return the output class
     */
    protected abstract T ConvertClasses();

}
