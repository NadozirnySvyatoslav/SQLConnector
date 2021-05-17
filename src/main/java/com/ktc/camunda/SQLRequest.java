package com.ktc.camunda;

import org.camunda.connect.impl.AbstractConnectorRequest;
import org.camunda.connect.spi.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SQLRequest extends AbstractConnectorRequest<SQLResponse> {
   private final static Logger LOGGER = LoggerFactory.getLogger(SQLRequest.class);

 public SQLRequest(Connector<?> connector) {
    super(connector);
  }

 public String getQuery() {
    return getRequestParameter("query");
  }
 public String getURI() {
    return getRequestParameter("uri");
  }

  @Override
  protected boolean isRequestValid() {
    if(getQuery() == null ) {
      LOGGER.error("parameter 'query' is empty {}", this);
        return false;
    }
    if(getURI() == null ) {
      LOGGER.error("parameter 'uri' is empty {}", this);
        return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "SQL QUERY:\n" + getQuery();
  }
}

