package pt.caires.orderservice.infrastructure;

import java.util.UUID;
import javax.inject.Named;

@Named
public class IdentifierGenerator {

  public String generate() {
    return UUID.randomUUID().toString();
  }

}
