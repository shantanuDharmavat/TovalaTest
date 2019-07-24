package com.example.testapplication.Utils;
import org.json.*;

public class JsonValidator {
    public boolean validate(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
