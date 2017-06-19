package org.bayon.form.validation;

import java.util.List;

/**
 * Created by darith on 6/16/17.
 */
public interface FormCriteria {
    public void setIntFrom(Integer from);
    public Integer getIntFrom();
    public void setIntTo(Integer to);
    public Integer getIntTo();
    public void setCharList(List<Character> charList);
    public List<Character> getCharList();
    public void setStringList(List<String> stringList);
    public List<String> getStringList();
    public void setStringValue(String stringValue);
    public String getStringValue();
    public void setFlag(Boolean flag);
    public Boolean getFlag();
}
