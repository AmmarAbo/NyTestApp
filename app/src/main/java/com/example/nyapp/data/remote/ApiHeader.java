package com.example.nyapp.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;

    private PublicApiHeader mPublicApiHeader;

    @Inject
    public ApiHeader(PublicApiHeader publicApiHeader, ProtectedApiHeader protectedApiHeader) {
        mPublicApiHeader = publicApiHeader;
        mProtectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return mPublicApiHeader;
    }

    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("Authorization")
        private String mAccessToken;


        @Expose
        @SerializedName("language")
        private String language;

        public ProtectedApiHeader() {

        }
        public ProtectedApiHeader(String language, String mAccessToken) {
            this.language = language;

            this.mAccessToken = mAccessToken;
        }

        public String getAccessToken() {
            return mAccessToken;
        }

        public void setAccessToken(String accessToken) {
            mAccessToken = accessToken;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String apiKey) {
            language = apiKey;
        }


    }

    public static final class PublicApiHeader {


        @Expose
        @SerializedName("language")
        private String language;
        public PublicApiHeader() {



        }
        public PublicApiHeader(String mlanguage) {

            language = mlanguage;

        }


        public String getLanauge() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
