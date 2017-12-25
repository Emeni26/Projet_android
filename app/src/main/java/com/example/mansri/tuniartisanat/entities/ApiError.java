package com.example.mansri.tuniartisanat.entities;

import java.util.List;
import java.util.Map;

/**
 * Created by mansr on 13/12/2017.
 */

public class ApiError {

    String message;

    Map<String,List<String>> errors;

    public String getMessage() {
        return message;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }
}
