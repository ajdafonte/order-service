package pt.caires.orderservice.infrastructure;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import pt.caires.orderservice.domain.Order;

@Import({JdbcOrderRepository.class, IdentifierGenerator.class})
@DataSet(cleanBefore = true)
class JdbcOrderRepositoryITTest extends BaseDatabaseIntegrationTest {

  @Inject
  private JdbcOrderRepository repository;

  @Test
  @ExpectedDataSet(value = "datasets/dummy_order.json")
  void shouldSaveAnOrder() {
    var throwable = catchThrowable(
        () -> repository.save(new Order("id", "storeName", "itemName", 1)));

    then(throwable).isNull();
  }

}