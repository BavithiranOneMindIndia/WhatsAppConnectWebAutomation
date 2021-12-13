package actiondefs;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

//import AppiumPackage002GroupId.LoggingFolder.LogGeneratorClass;

public class ApiAccessing {

    String authorization = "Bearer "
            + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ilg1ZVhrNHh5b2pORnVtMWtsMll0djhkbE5QNC1jNTdkTzZRR1RWQndhTmsifQ.eyJpc3MiOiJodHRwczovL3Byb2Rta3N0ZWFtd2hhdHNhcHBjb25uZWN0LmIyY2xvZ2luLmNvbS8xYWYyYTllZC1kYTE4LTRhYmMtODI1OS0zZjRlMmJkNjRmZGMvdjIuMC8iLCJleHAiOjE2MzkxMjU1MDAsIm5iZiI6MTYzOTAzOTEwMCwiYXVkIjoiYjVjNzc2NzMtNmYzNi00NTVhLWI4YTItOTBiNTVmN2M4MTE2Iiwic3ViIjoiODQyYzAxOWEtNGQ5Ni00MzBjLTkyNjAtZWYyNTRjNGVhOTZhIiwiZXh0ZW5zaW9uX1JvbGVzIjoiU3VwZXJBZG1pbiIsIm5hbWUiOiJiYXZpU3VwZXJBZG1pbiIsImV4dGVuc2lvbl9UZW5hbnRJZCI6ImI0NGYwNDQ2LWMyNmEtNDkxOC1hNzlmLTA4ZmNkYTFiZGE5Ziw3OGQ5MjMxYS04ZDU4LTQ1NTQtYTMwNi0xNjRjODc5MjVmNGUsM2NkNDVlZjEtOGE2MC00ZjJkLWFmNGMtN2E5NGNmNGY0NDlmLDhmNzBkYTJlLTdlMDEtNGU3MC1hYTQxLTk2OTZhMzNhOGM0ZixjNzM4ZWRmZS1jZjJmLTRlMTQtODlmMi1jMTYxNTU3ZDYxMTIiLCJ0ZnAiOiJCMkNfMV9zaWdudXBzaWdpbl93aGF0c2FwcGNvbm5lY3RfcHJvZCIsIm5vbmNlIjoiMjY0OWNjNjQwZWRkNDFiZjk5NzczNmU2YjNiZmFiODAiLCJzY3AiOiJyZWFkIiwiYXpwIjoiNzc4MjZkZmItYzFmMS00N2FiLTg4MWItNWU4YTkzNTg1ZDU3IiwidmVyIjoiMS4wIiwiaWF0IjoxNjM5MDM5MTAwfQ.XzzSYQh3s6NBI-SQRHXrBrVp-xZuRx5EWZp44Ej8tuybfz_5CNUXN0fIPYkiPiBsWKQOtxDG-xLW9BNYe8XyUq7iA-ci8zgPtIX8PfShAbfkvTvfbH4YZJNKAqR-dawKJY0I1bw84XVOypdXmZ5lMNqyYrKAW33b6HrgPmpEUDmE-MJmCBcF7Bqdyun3EFFhVq_-pNSbcePVW9GngmckhDpcJtVEUTasuxXYD38wohPOsr-H91YDILEr_Da2EgcwfWaK0BiaMBFiQJ6sb4F-NKZgTMSQZa5Fk5GLb4jslLzpQpSk_SgXdTNi8vWBtglt34h4QP_hsI6lj7el9TnWcQ";

    // LogGeneratorClass LogGeneratorClass_obj = new LogGeneratorClass();

    public String apiGetProcessing(String apiUrl) {
        // HttpClient httpClient = new HttpClient();
        CloseableHttpClient httpClient = HttpClients.createDefault();

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
            // LogGeneratorClass_obj.GenerateLog("Api got failed");
            return null;
        }
    }

    public String apiPostProcessing(String apiUrl, String jsonBody) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost postRequest = new HttpPost(apiUrl);

            StringEntity input = new StringEntity(jsonBody);
            input.setContentType("application/json");
            postRequest.addHeader("accept", "application/json");
            postRequest.addHeader("Authorization", authorization);
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
            // LogGeneratorClass_obj.GenerateLog(exception.getMessage());
            return null;
        }

    }

}
