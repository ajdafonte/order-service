package pt.caires.orderservice.infrastructure;

import javax.inject.Named;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pt.caires.orderservice.domain.Order;
import pt.caires.orderservice.domain.OrderRepository;

@Named
public class JdbcOrderRepository implements OrderRepository {

  private static final String QUERY_INSERT_ORDER =
      "INSERT INTO `order` (`id`, `store_name`, `item_name`, `quantity`) "
      + "VALUES (:id, :storeName, :itemName, :quantity)";
  private static final String KEY_PARAM_ID = "id";
  private static final String KEY_PARAM_STORE_NAME = "storeName";
  private static final String KEY_PARAM_ITEM_NAME = "itemName";
  private static final String KEY_PARAM_QUANTITY = "quantity";
  private final IdentifierGenerator idGenerator;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public JdbcOrderRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
      IdentifierGenerator idGenerator) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    this.idGenerator = idGenerator;
  }

  @Override
  public String generateId() {
    return idGenerator.generate();
  }

  @Override
  public Order save(Order order) {
    var sqlParameterSource = new MapSqlParameterSource()
        .addValue(KEY_PARAM_ID, order.getId())
        .addValue(KEY_PARAM_STORE_NAME, order.getStoreName())
        .addValue(KEY_PARAM_ITEM_NAME, order.getItemName())
        .addValue(KEY_PARAM_QUANTITY, order.getQuantity());

    namedParameterJdbcTemplate.update(QUERY_INSERT_ORDER, sqlParameterSource);

    return order;
  }

}
