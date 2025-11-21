package vn.hcmute.retrofit2;

public class ApiClient {

    private static final String BASE_URL = "http://app.iotstar.vn:8081/appfoods/";
    private static APIService apiService;

    public static APIService getService() {
        if (apiService == null) {
            apiService = BaseClient
                    .getRetrofit(BASE_URL)
                    .create(APIService.class);
        }
        return apiService;
    }
}
