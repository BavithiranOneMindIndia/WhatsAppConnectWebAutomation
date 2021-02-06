package actiondefs;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

//import AppiumPackage002GroupId.LoggingFolder.LogGeneratorClass;


public class ApiAccessing {

    //LogGeneratorClass LogGeneratorClass_obj = new LogGeneratorClass();

    public String apiGetProcessing(String apiUrl) {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {

            HttpGet getRequest = new HttpGet(apiUrl);

            // Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");
            getRequest.addHeader("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ilg1ZVhrNHh5b2pORnVtMWtsMll0djhkbE5QNC1jNTdkTzZRR1RWQndhTmsifQ.eyJpc3MiOiJodHRwczovL3N0YWdlbWtzdGVhbS5iMmNsb2dpbi5jb20vNTNiNzg2OTgtYzA3YS00YTJlLTgzZGItY2ExNDNjYjFhMmE3L3YyLjAvIiwiZXhwIjoxNjEyNjc0MjI4LCJuYmYiOjE2MTI1ODc4MjgsImF1ZCI6ImViYTRmMDVlLTczMzItNGIzOS1hZWYwLWY3NzM4MDkwYjdjZCIsInN1YiI6IjI5NzljN2E1LThmNDYtNGMzZi1hODVhLTZjY2YyYTJiZjRjOSIsImV4dGVuc2lvbl9BcHBsaWNhdGlvbklkIjoiZWJhNGYwNWUtNzMzMi00YjM5LWFlZjAtZjc3MzgwOTBiN2NkIiwibmFtZSI6IkJhdmlDb250ZW50Q3JlYXRvciIsImV4dGVuc2lvbl9Sb2xlcyI6IkNvbnRlbnRDcmVhdG9yIiwiZXh0ZW5zaW9uX1RlbmFudElkIjoiOGY3MGRhMmUtN2UwMS00ZTcwLWFhNDEtOTY5NmEzM2E4YzRhLDhmNzBkYTJlLTdlMDEtNGU3MC1hYTQxLTk2OTZhMzNhOGM0ZiIsInRmcCI6IkIyQ18xX3N0YWdlX21rc3RlbV9zaWdudXBzaWduaW4iLCJub25jZSI6IjFhNWQ0MTM0MzUwODRkNTU5YzgyOTFkYzBhYjFlNTU5Iiwic2NwIjoicmVhZCIsImF6cCI6IjkzMGQ3MjNmLTZjZTAtNDZlMC1iZjEwLWE2ZDEyMDQ5ZjVhMCIsInZlciI6IjEuMCIsImlhdCI6MTYxMjU4NzgyOH0.Fq1_2xd6H4fGI7IBiVZ_UoxGJmdNRXm4xeshZT6c1I22e4X5_ksPluFSY6uDVNU18Uq8JeYJYnqli6aPWO7lraErrDNzu3BaWcBPNUyjIFCjewpbKyzWGT-vlKtUB7nGMx_1lDAOHKWbbYZxBQKjlbh0T0rUa85uSysmTirbldoyXv0U1Ent8kFmurRd3uEqNZZ0uInUMjap151QAff1qzHja0_CUdfFwmxfm7aRv4iBcMB3pExQhC3RRTfSifaeBX-DYfm17PnFE7HwUp6pQUkqeUopYVtBqtAGOMRdgIxmDUBc80ztEHwGdh-YFk9Ux4ryWUaDAib0gXuC690XBA");

            HttpResponse response = httpClient.execute(getRequest);

            // verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            

            // Now pull back the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);
            return apiOutput;
            // Lets see what we got from API
            // System.out.println(apiOutput);
        } catch (Exception exception) {
            System.out.println("Api got failed");
            //LogGeneratorClass_obj.GenerateLog("Api got failed");
            return null;
        }
    }

    public String apiPostProcessing(String apiUrl , String jsonBody) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost postRequest = new HttpPost(apiUrl);

            StringEntity input = new StringEntity(jsonBody);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP post error code : " + statusCode);
            }

            // Now pull back the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);
            return apiOutput;
            // Lets see what we got from API
            // System.out.println(apiOutput);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
            System.out.println("Post Api got failed");
            //LogGeneratorClass_obj.GenerateLog(exception.getMessage());
            return null;
        }

    }

   
}
