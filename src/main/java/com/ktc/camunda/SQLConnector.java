package com.ktc.camunda;


import org.camunda.connect.Connectors;
import org.camunda.connect.spi.Connector;
import org.camunda.connect.impl.AbstractConnector;
import org.camunda.connect.spi.ConnectorResponse;

import java.io.Closeable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SQLConnector extends AbstractConnector<SQLRequest,SQLResponse> {
    public static final String ID = "sql-connector";
    private final static Logger LOGGER = LoggerFactory.getLogger(SQLConnector.class);

  public SQLConnector() {
    super(ID);
  }

  public SQLRequest createRequest() {
    return new SQLRequest(this);
  }

 @Override
  public ConnectorResponse execute(SQLRequest request) {
    SQLResponse response;
    try{
		SQLInvocation invocation=new SQLInvocation(request,request, requestInterceptors);
		response=(SQLResponse)invocation.proceed();
    }catch (Exception e) {
		LOGGER.error("SQL exception: "+ e.getMessage());
		throw new SQLException("SQL connector execution error ",e);
    }
    return response;
  }
}
