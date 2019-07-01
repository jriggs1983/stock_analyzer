package com.jriggs.stock_analyzer.search;

import com.jriggs.stock_analyzer.datareaders.Http;
import com.jriggs.stock_analyzer.params.Configuration;
import com.jriggs.stock_analyzer.params.SearchParams;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author jbr5551
 */
public class Search {

    private SearchParams searchParams;
    private Http http;

    public Search() {
    }

    public SearchResults search(String keyword) throws IOException, URISyntaxException {
        if (searchParams == null) {
            searchParams = new SearchParams();
        }

        searchParams.setKeyword(keyword);
        return performSearch();
    }

    private SearchResults performSearch() throws IOException, URISyntaxException {
        if (http == null) {
            http = new Http();
        }

        String jsonResults = http.get(null, searchParams, Configuration.getUri());
        SearchResults searchResults = SearchResults.parseJson(jsonResults);
        return searchResults;
    }

}
