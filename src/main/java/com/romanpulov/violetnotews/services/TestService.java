package com.romanpulov.violetnotews.services;

import com.romanpulov.violetnotews.model.DataItem;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rpulov on 09.01.2017.
 */

@WebService
public class TestService {

    @WebMethod
    public String getMessage() {
        return "Test Message";
    }

    @WebMethod
    public DataItem getDataItem() {
        DataItem newItem = new DataItem();
        newItem.setId(12);
        newItem.setName("New data 12");
        return newItem;
    }

    @WebMethod
    @WebResult(name = "Item")
    public List<DataItem> getDataItems() {
        List<DataItem> result = new ArrayList<DataItem>();
        DataItem newItem = new DataItem();
        newItem.setId(10);
        newItem.setName("New data 10");
        result.add(newItem);
        newItem = new DataItem();
        newItem.setId(11);
        newItem.setName("New data 11");
        result.add(newItem);

        return result;

    }

}
