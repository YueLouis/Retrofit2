package vn.hcmute.retrofit2;

public class ApiClient {

    // DÙNG PORT 8081 NHƯ THẦY YÊU CẦU
    private static final String BASE_URL = "http://app.iotstar.vn:8081/appfoods/";

    public static APIService getService() {
        return BaseClient.getClient(BASE_URL).create(APIService.class);
    }
}
