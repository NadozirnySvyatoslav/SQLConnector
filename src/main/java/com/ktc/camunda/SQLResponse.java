package com.ktc.camunda;

import java.util.Map;
import org.camunda.connect.spi.CloseableConnectorResponse;

import org.camunda.connect.impl.AbstractConnectorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SQLResponse extends AbstractConnectorResponse {
  private static final Logger LOGGER = LoggerFactory.getLogger(SQLResponse.class);
  Object rows;
  int rows_affected;

  public SQLResponse(Object rows, int rows_affected){
    this.rows=rows;
    this.rows_affected=rows_affected;
  }

  @Override
  protected void collectResponseParameters(Map<String, Object> responseParameters) {
    responseParameters.put("rows", this.rows);
    responseParameters.put("rows_affected", this.rows_affected);
  }
  @Override
  public String toString() {
    return "SQL Response ";
  }

}
