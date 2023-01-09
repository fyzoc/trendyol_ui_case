package api_requests;

import api_baseurls.BooksBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest extends BooksBaseUrl {

    @Test
    public void getBooks() {
        spec.pathParam("books", "books");
        //String url = "http://localhost:3333/books";
        Response response = given().spec(spec).when().get("{books}");
        response.prettyPrint();
    }

}
