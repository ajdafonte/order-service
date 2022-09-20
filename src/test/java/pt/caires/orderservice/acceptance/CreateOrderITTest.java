package pt.caires.orderservice.acceptance;

import static org.hamcrest.Matchers.is;
import java.net.HttpURLConnection;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pt.caires.orderservice.TestFileUtils;
import pt.caires.orderservice.infrastructure.IdentifierGenerator;

@DBRider
@DataSet(cleanBefore = true)
class CreateOrderITTest extends BaseIntegrationTest {

  private static final String CREATE_ORDER_REQUEST_BODY_PATH = "jsons/requests/create_order.json";
  private static final String CREATE_ORDER_RESPONSE_BODY_PATH = "jsons/responses/create_order.json";
  @MockBean
  private IdentifierGenerator identifierGenerator;

  @Test
  @ExpectedDataSet(value = "datasets/create_order.json")
  void shouldCreateAnOrder() throws Exception {
    BDDMockito.given(identifierGenerator.generate())
        .willReturn("e3211be6-d0cc-4718-905d-ab933cc91ecb");

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
