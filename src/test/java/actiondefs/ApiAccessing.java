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

    String authorization =  "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ilg1ZVhrNHh5b2pORnVtMWtsMll0djhkbE5QNC1jNTdkTzZRR1RWQndhTmsifQ.eyJpc3MiOiJodHRwczovL3N0YWdlbWtzdGVhbS5iMmNsb2dpbi5jb20vNTNiNzg2OTgtYzA3YS00YTJlLTgzZGItY2ExNDNjYjFhMmE3L3YyLjAvIiwiZXhwIjoxNjEyNzY0MTU4LCJuYmYiOjE2MTI2Nzc3NTgsImF1ZCI6ImViYTRmMDVlLTczMzItNGIzOS1hZWYwLWY3NzM4MDkwYjdjZCIsInN1YiI6IjE4MzQ1NmRjLTZiY2EtNDVlNi05MjMzLTUwNmYzMmQ3ZThmNSIsImV4dGVuc2lvbl9BcHBsaWNhdGlvbklkIjoiZWJhNGYwNWUtNzMzMi00YjM5LWFlZjAtZjc3MzgwOTBiN2NkIiwibmFtZSI6IkJhdmlFZGl0b3IiLCJleHRlbnNpb25fUm9sZXMiOiJFZGl0b3IiLCJleHRlbnNpb25fVGVuYW50SWQiOiI4ZjcwZGEyZS03ZTAxLTRlNzAtYWE0MS05Njk2YTMzYThjNGYiLCJ0ZnAiOiJCMkNfMV9zdGFnZV9ta3N0ZW1fc2lnbnVwc2lnbmluIiwibm9uY2UiOiJkNGY0NjJiYWFlYmU0MzQ0YWNhZDE5ODlmMjYzN2EzZSIsInNjcCI6InJlYWQiLCJhenAiOiI5MzBkNzIzZi02Y2UwLTQ2ZTAtYmYxMC1hNmQxMjA0OWY1YTAiLCJ2ZXIiOiIxLjAiLCJpYXQiOjE2MTI2Nzc3NTh9.pnrdy3G_zA4J1OMxemkXRRlalPlh7B1yVK_lVnxhueDvt3h5_AoQ_YkgYBpupf4tZuOgI92hMyfDTVXnRLOYPOM1MbbihQkQETCE-7x8hFtfPcXjfGBL1gsKS-mpBDneCwVTi4L8nSlD624Apz52gguu7akjtumEbWRTqjqMX-mGJiWKLvC8i0wDmS310Rk8vEfH5nPBOTyrYF7YZHSuXXeP55VSGCYkQX34f5lmr6PMuWOcouMZ2eA237CbcGg5jU7WH_9hzWTgRmkeO-9Zoh3GNWufSaualDApgMSANam0loE4fV2HCYzyMO9wR9rakckdRkp4JgZNgLxZLsGd4w";

    //LogGeneratorClass LogGeneratorClass_obj = new LogGeneratorClass();

    public String apiGetProcessing(String apiUrl) {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {

            HttpGet getRequest = new HttpGet(apiUrl);

            // Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");
            getRequest.addHeader("Authorization", authorization);

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
            postRequest.addHeader("accept", "application/json");
            postRequest.addHeader("Authorization",authorization);
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
