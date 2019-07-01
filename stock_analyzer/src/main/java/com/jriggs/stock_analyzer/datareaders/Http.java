package com.jriggs.stock_analyzer.datareaders;

import com.jriggs.stock_analyzer.params.TransactionParams;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Jacob Riggs
 */
public class Http {

    private int responseCode;
    private String body;

    public String post(List<Header> headers, TransactionParams params, String uri) throws IOException {
        SSLConnectionSocketFactory sslConnectionSocketFactory
                = new SSLConnectionSocketFactory(SSLContexts.createDefault(),
                        new String[]{"TLSv1.2"},
                        null,
                        SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        CloseableHttpResponse response;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build()) {

            org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(uri);
            if (params != null) {
                httpPost.setEntity(new UrlEncodedFormEntity(params.getNameValuePair()));
            }

            if (headers != null) {
                httpPost.setHeaders(headers.toArray(new Header[headers.size()]));
            }

            response = httpClient.execute(httpPost);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            response.getEntity().writeTo(baos);
            responseCode = response.getStatusLine().getStatusCode();
            body = new String(baos.toByteArray());
            return body;
        } catch (IOException ioe) {
            throw ioe;
        }
    }

//    https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=v&apikey=KYSTXRCY4FVM6VKW&outputsize=full
    public String get(List<Header> headers, TransactionParams params, String uri) throws IOException, URISyntaxException {
        SSLConnectionSocketFactory sslConnectionSocketFactory
                = new SSLConnectionSocketFactory(SSLContexts.createDefault(),
                        new String[]{"TLSv1.2"},
                        null,
                        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpResponse response;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build()) {
            URIBuilder builder = new URIBuilder(uri);

            for (NameValuePair nvp : params.getNameValuePair()) {
                builder.setParameter(nvp.getName(), nvp.getValue());
            }

            org.apache.http.client.methods.HttpGet httpGet = new org.apache.http.client.methods.HttpGet(builder.build());
            if (headers != null) {
                httpGet.setHeaders(headers.toArray(new Header[headers.size()]));
            }

            response = httpClient.execute(httpGet);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            response.getEntity().writeTo(baos);
            responseCode = response.getStatusLine().getStatusCode();
            body = new String(baos.toByteArray());
            return body;
        } catch (IOException | URISyntaxException ex) {
            throw ex;
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Http http = new Http();
        String s = http.get(null, null, "https://www.alphavantage.co/query");
        System.out.println(s);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
