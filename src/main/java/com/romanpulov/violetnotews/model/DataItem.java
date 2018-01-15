package com.romanpulov.violetnotews.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rpulov on 09.01.2017.
 */

@XmlRootElement(name = "DataItem")
public class DataItem {

    private int id;

    private String name;

    public void setId(int value) {
        id = value;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setName(String value) {
        name = value;
    }

    @XmlElement
    public String getName() {
        return name;
    }

}
