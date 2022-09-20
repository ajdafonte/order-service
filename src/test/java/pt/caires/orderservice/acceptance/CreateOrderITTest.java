package pt.caires.orderservice.acceptance;

import static org.hamcrest.Matchers.is;
import java.net.HttpURLConnection;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pt.caires.orderservice.TestFileUtils;

class CreateOrderITTest extends BaseIntegrationTest {

  private static final String CREATE_ORDER_REQUEST_BODY_PATH = "jsons/requests/create_order.json";
  private static final String CREATE_ORDER_RESPONSE_BODY_PATH = "jsons/responses/create_order.json";

  @Test
  void shouldCreateAnOrder() throws Exception {
    RestAssured.given()
        .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
        .body(TestFileUtils.getBody(CREATE_ORDER_REQUEST_BODY_PATH))
        .post("api/v1/orders")
        .then()
        .statusCode(HttpURLConnection.HTTP_CREATED)
        .contentType(ContentType.JSON)
        .body(is(TestFileUtils.getBody(CREATE_ORDER_RESPONSE_BODY_PATH)));
  }

}
