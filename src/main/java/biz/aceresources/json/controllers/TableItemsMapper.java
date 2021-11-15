package biz.aceresources.json.controllers;

import biz.aceresources.json.models.OutputClass;
import biz.aceresources.json.models.input.json.InputFileContents;
import biz.aceresources.json.models.output.OutputTable;
import biz.aceresources.json.models.output.OutputTableItem;

import java.util.ArrayList;
import java.util.List;

/**
 * To convert input from json table to a Class used for Table format
 * This can be considered a bit of over engineering but will be useful if we want to extend
 */
public class TableItemsMapper extends OutputConvertor {

    /**
     * Converts input format to output format
     *
     * @return output formatted POJO
     */
    @Override
    protected OutputClass ConvertClasses() {
        InputFileContents inputItem = (InputFileContents) inputClass;
        OutputTable outputTable = new OutputTable();
        List<OutputTableItem> outputTableItems = new ArrayList<>();
        inputItem.getPojoItems().getItem().forEach(item ->
                item.getBatters().getBatter().forEach(batter -> {
                    item.getTopping().forEach(topping ->
                            outputTableItems.add(
                                    OutputTableItem.builder().id(item.getId()).name(item.getName()).type(item.getType()).topping(topping.getType()).batter(batter.getType())
                                            .build()));
                }));
        outputTable.setItems(outputTableItems);
        return outputTable;
    }
}

