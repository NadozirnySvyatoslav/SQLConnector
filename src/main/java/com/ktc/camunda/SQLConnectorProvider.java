package com.ktc.camunda;

import org.camunda.connect.spi.ConnectorProvider;

public class SQLConnectorProvider implements ConnectorProvider{
  public String getConnectorId() {
    return SQLConnector.ID;
  }

  public SQLConnector createConnectorInstance() {
    return new SQLConnector();
  }

}
