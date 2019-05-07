import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;


public class Main {

    private static String API_URI = "http://localhost:2020/insurance";

    private static String allCustomers = "http://localhost:8080/customers";

    public static void main(String[] args) {
        System.out.println("=== Start ===");
        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("Creating user with invalid name");
        String responseBody = createRequest(new Customer("Firstname", "12345", "01234567890"));
        System.out.println("Responsebody: " + responseBody);
        System.out.println("----------------------------------------");

        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("Creating user with invalid nationalId");
        responseBody = createRequest(new Customer("Firstname", "Lastname", "12345"));
        System.out.println("Responsebody: " + responseBody);
        System.out.println("----------------------------------------");

        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("Creating valid user #1");
        prettyPrintJson(createRequest(new Customer("Firstname", "Lastname", "01234567890")));

        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("Creating invalid user (Same as user #1)");
        prettyPrintJson(createRequest(new Customer("Firstname", "Lastname", "01234567890")));

        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("Creating valid user #2");
        prettyPrintJson(createRequest(new Customer("John", "Smith", "12345678901")));

        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("Creating valid user #3");
        prettyPrintJson(createRequest(new Customer("Jane", "Doe", "98765432109")));



        System.out.println();
        System.out.println();
        System.out.println();
        //System.out.println("Displaying all customers");
        //prettyPrintJson(createRequest());


    }

    private static void prettyPrintJson(String responseBody) {
        try {
            System.out.println("Responsebody:");
            ObjectMapper mapper = new ObjectMapper();
            Object resultJson = mapper.readValue(responseBody, Object.class);
            System.out.println();
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultJson));
            System.out.println("----------------------------------------");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static String createRequest(Customer customer) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(customer);

            System.out.println(json);
            HttpPost httpPost = new HttpPost(API_URI);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                System.out.println("HTTP Status: " + status);
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            };
            return httpclient.execute(httpPost, responseHandler);
            //System.out.println(responseBody);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    private static String createRequest() {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            HttpGet httpGet = new HttpGet(allCustomers);
            httpGet.setHeader("Accept", "application/json");

            System.out.println("Executing request " + httpGet.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                System.out.println("HTTP Status: " + status);
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            };
            return httpclient.execute(httpGet, responseHandler);
            //System.out.println(responseBody);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return "";
    }


}
