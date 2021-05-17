package com.ktc.camunda;

import java.util.Arrays;
import java.util.List;
import org.camunda.connect.impl.AbstractRequestInvocation;
import org.camunda.connect.spi.ConnectorRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.json.JSONArray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLInvocation extends AbstractRequestInvocation<SQLRequest> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SQLInvocation.class);
    private SQLRequest request;
  public SQLInvocation(SQLRequest target, SQLRequest request, List<ConnectorRequestInterceptor> requestInterceptors){
    super(target, request, requestInterceptors);
    this.request=request;
  }

  @Override
  public Object invokeTarget() throws Exception {
    LOGGER.debug("====================================\n [x] SQL execute:\n====================================\n{}", request.getQuery());

    int rows_affected=0;
    ResultSet resultSet = null;

    try (Connection connection = DriverManager.getConnection(request.getURI());
         Statement statement = connection.createStatement();) {

        resultSet = statement.executeQuery(request.getQuery());
        JSONArray rows=new JSONArray ();

        while (resultSet.next()) {
            JSONArray row=new JSONArray();
            for(int i=1; i < resultSet.getMetaData().getColumnCount(); i++){
                row.put(resultSet.getObject(i));
            }
            rows.put( row );
        }
	    LOGGER.debug("====================================\n [x] SQL result:\n====================================\n{}", rows);
        return new SQLResponse(rows.toString(),rows_affected);

      } catch (Exception ex) {
         ex.printStackTrace();
      }

    return new SQLResponse("",-1);

  }

}

