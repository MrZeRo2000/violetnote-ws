package com.romanpulov.violetnotews.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rpulov on 09.01.2017.
 */

@XmlRootElement(name = "DataItem")
public class DataItem {
    @XmlElement
    private int id;

    @XmlElement
    private String name;

    public void setId(int value) {
        id = value;
    }

    public void setName(String value) {
        name = value;
    }
}
