package com.jriggs.stock_analyzer.search;

import org.json.JSONObject;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class SearchResults {

    private String symbol;
    private String name;
    private String type;
    private String region;
    private String marketOpen;
    private String marketClose;
    private String timezone;
    private String currency;
    private String matchScore;

    public static SearchResults parseJson(String json) {
        return null;
    }

    private void parse(String json) {
        JSONObject jsonObject = new JSONObject(json);
        jsonObject.keySet();

    }

//            JSONObject jsonObject = new JSONObject(json);
//        String name = parseName(jsonObject);
//        JSONObject tsElement = jsonObject.getJSONObject(name);
//        Set<String> keys = tsElement.keySet();
//        TimeSeries ts = new TimeSeries();
//        ts.setTimeUnit(name);
//        ts.units = new ArrayList();
//        Gson gson = new Gson();
//
//        for (String key : keys) {
//            Unit u = gson.fromJson(tsElement.getJSONObject(key).toString(), Unit.class);
//            u.setDate(parseDateFromName(key));
//            ts.units.add(u);
//        }
//        ts.sort();
//        return ts;
    public static void main(String[] args) {
        String json = "{\n"
                + "    \"bestMatches\": [\n"
                + "        {\n"
                + "            \"1. symbol\": \"V\",\n"
                + "            \"2. name\": \"Visa Inc.\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"United States\",\n"
                + "            \"5. marketOpen\": \"09:30\",\n"
                + "            \"6. marketClose\": \"16:00\",\n"
                + "            \"7. timezone\": \"UTC-04\",\n"
                + "            \"8. currency\": \"USD\",\n"
                + "            \"9. matchScore\": \"1.0000\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"VISAX\",\n"
                + "            \"2. name\": \"Virtus KAR International Small-Cap Fund Class A\",\n"
                + "            \"3. type\": \"Mutual Fund\",\n"
                + "            \"4. region\": \"United States\",\n"
                + "            \"5. marketOpen\": \"09:30\",\n"
                + "            \"6. marketClose\": \"16:00\",\n"
                + "            \"7. timezone\": \"UTC-04\",\n"
                + "            \"8. currency\": \"USD\",\n"
                + "            \"9. matchScore\": \"0.8889\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"VISA.VIE\",\n"
                + "            \"2. name\": \"Visa Inc.\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"Vienna\",\n"
                + "            \"5. marketOpen\": \"08:55\",\n"
                + "            \"6. marketClose\": \"17:35\",\n"
                + "            \"7. timezone\": \"UTC+02\",\n"
                + "            \"8. currency\": \"EUR\",\n"
                + "            \"9. matchScore\": \"0.7273\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"3V64.FRK\",\n"
                + "            \"2. name\": \"Visa Inc.\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"Frankfurt/XETRA\",\n"
                + "            \"5. marketOpen\": \"08:00\",\n"
                + "            \"6. marketClose\": \"20:00\",\n"
                + "            \"7. timezone\": \"UTC+02\",\n"
                + "            \"8. currency\": \"EUR\",\n"
                + "            \"9. matchScore\": \"0.6154\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"VISA34.SAO\",\n"
                + "            \"2. name\": \"Visa Inc.\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"Brazil/Sao Paolo\",\n"
                + "            \"5. marketOpen\": \"10:00\",\n"
                + "            \"6. marketClose\": \"17:30\",\n"
                + "            \"7. timezone\": \"UTC-03\",\n"
                + "            \"8. currency\": \"BRL\",\n"
                + "            \"9. matchScore\": \"0.6154\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"V.MEX\",\n"
                + "            \"2. name\": \"Visa Inc.\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"Mexico\",\n"
                + "            \"5. marketOpen\": \"08:30\",\n"
                + "            \"6. marketClose\": \"15:00\",\n"
                + "            \"7. timezone\": \"UTC-05\",\n"
                + "            \"8. currency\": \"MXP\",\n"
                + "            \"9. matchScore\": \"0.6154\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"V.SAN\",\n"
                + "            \"2. name\": \"Visa Inc.\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"Chile/Santiago\",\n"
                + "            \"5. marketOpen\": \"09:30\",\n"
                + "            \"6. marketClose\": \"16:00\",\n"
                + "            \"7. timezone\": \"UTC-03\",\n"
                + "            \"8. currency\": \"CLP\",\n"
                + "            \"9. matchScore\": \"0.6154\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"VISAKAIND.NSE\",\n"
                + "            \"2. name\": \"Visaka Industries Limited\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"India/NSE\",\n"
                + "            \"5. marketOpen\": \"09:15\",\n"
                + "            \"6. marketClose\": \"15:30\",\n"
                + "            \"7. timezone\": \"UTC+5.5\",\n"
                + "            \"8. currency\": \"INR\",\n"
                + "            \"9. matchScore\": \"0.6154\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"1. symbol\": \"V-USD.SWI\",\n"
                + "            \"2. name\": \"Visa\",\n"
                + "            \"3. type\": \"Equity\",\n"
                + "            \"4. region\": \"Switzerland\",\n"
                + "            \"5. marketOpen\": \"09:00\",\n"
                + "            \"6. marketClose\": \"17:30\",\n"
                + "            \"7. timezone\": \"UTC+02\",\n"
                + "            \"8. currency\": \"CHF\",\n"
                + "            \"9. matchScore\": \"0.5000\"\n"
                + "        }\n"
                + "    ]\n"
                + "}";
    }
}
