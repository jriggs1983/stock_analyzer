package com.jriggs.stock_analyzer.params;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class SearchParams implements TransactionParams {

    private String keyword;
    private final Function FUNCTION = Function.SYMBOL_SEARCH;

    private List<NameValuePair> pairs;

    @Override
    public List<NameValuePair> getNameValuePair() {
        if (pairs == null) {
            pairs = new ArrayList();
        }
        return pairs;
    }

    public Function getFunction() {
        return FUNCTION;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void addParam(String key, String value) {
        pairs.add(new BasicNameValuePair(key, value));
    }

}
