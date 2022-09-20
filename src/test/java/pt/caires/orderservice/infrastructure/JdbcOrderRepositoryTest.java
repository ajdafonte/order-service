package pt.caires.orderservice.infrastructure;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ExtendWith(MockitoExtension.class)
class JdbcOrderRepositoryTest {

  @Mock
  private IdentifierGenerator idGenerator;
  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private JdbcOrderRepository jdbcOrderRepository;

  @BeforeEach
  void setUp() {
    this.jdbcOrderRepository = new JdbcOrderRepository(namedParameterJdbcTemplate, idGenerator);
  }

  @Test
  void shouldGenerateAnId() {
    given(idGenerator.generate()).willReturn("uuid");

    var result = jdbcOrderRepository.generateId();

    then(result)
        .isNotBlank()
        .isEqualTo("uuid");
  }

}