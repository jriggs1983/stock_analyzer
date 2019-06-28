package com.jriggs.stock_analyzer.params;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class Params implements TransactionParams {

    private List<NameValuePair> paramList;

    @Override
    public List<NameValuePair> getNameValuePair() {
        return paramList;
    }

    public void addParam(String name, String value) {
        if (paramList == null) {
            paramList = new ArrayList();
        }
        paramList.add(new BasicNameValuePair(name, value));
    }
}
