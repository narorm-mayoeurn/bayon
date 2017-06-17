package org.bayon.form.validation;

import java.util.List;

/**
 * Created by darith on 6/16/17.
 */
public class FormCriteriaImp implements FormCriteria {

    private Integer intFrom;
    private Integer intTo;
    private List<Character> charList;
    private List<String> stringList;

    private String stringValue;

    @Override
    public Integer getIntFrom() {
        return intFrom;
    }

    @Override
    public void setIntFrom(Integer intFrom) {
        this.intFrom = intFrom;
    }

    @Override
    public Integer getIntTo() {
        return intTo;
    }

    @Override
    public void setIntTo(Integer intTo) {
        this.intTo = intTo;
    }

    @Override
    public List<Character> getCharList() {
        return charList;
    }

    @Override
    public void setCharList(List<Character> charList) {
        this.charList = charList;
    }

    @Override
    public List<String> getStringList() {
        return stringList;
    }

    @Override
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String getStringValue() {
        return stringValue;
    }

    @Override
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
