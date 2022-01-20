package com.example.nyapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("statusCode")
    private int statusCode;
    @Expose
    @SerializedName("results")
    private List<ArticlesResponse> results;
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        ApiResponse that = (ApiResponse) object;

        if (statusCode != 0 ? statusCode != (that.statusCode) : that.statusCode != 0) {
            return false;
        }
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = statusCode != 0 ? statusCode : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<ArticlesResponse> getResults() {
        return results;
    }

    public String getMessage() {
        return status;
    }
}
