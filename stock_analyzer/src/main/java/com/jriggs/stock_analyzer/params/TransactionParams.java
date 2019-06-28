package com.jriggs.stock_analyzer.params;

import java.util.List;
import org.apache.http.NameValuePair;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public interface TransactionParams {
    public List<NameValuePair> getNameValuePair();

}