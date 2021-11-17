package biz.aceresources.json.controllers;

import biz.aceresources.json.models.input.json.InputFileContents;
import biz.aceresources.json.models.output.DesiredObjectsHolder;
import biz.aceresources.json.models.output.DesiredObjectItem;

import java.util.ArrayList;
import java.util.List;

/**
 * To convert input from json table to a Class used for Table format
 * This can be considered a bit of over engineering but will be useful if we want to extend
 */
public class TableItemsMapper extends BaseConvertor<DesiredObjectsHolder> {

    /**
     * Converts input format to output format
     *
     * @return output formatted POJO
     */
    @Override
    protected DesiredObjectsHolder convertClasses() {
        InputFileContents inputItem = (InputFileContents) inputClass;
        DesiredObjectsHolder desiredObjectsHolder = new DesiredObjectsHolder();
        List<DesiredObjectItem> desiredObjectItems = new ArrayList<>();
        inputItem.getPojoItems().getItem().forEach(item ->
                item.getBatters().getBatter().forEach(batter -> item.getTopping().forEach(topping ->
                        desiredObjectItems.add(
                                DesiredObjectItem.builder().id(item.getId()).name(item.getName()).type(item.getType()).topping(topping.getType()).batter(batter.getType())
                                        .build()))));
        desiredObjectsHolder.setItems(desiredObjectItems);
        return desiredObjectsHolder;
    }
}

