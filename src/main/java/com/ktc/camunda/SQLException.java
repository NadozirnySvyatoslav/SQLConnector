package com.ktc.camunda;

public class SQLException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public SQLException(String message) {
    super(message);
  }

  public SQLException(Throwable cause) {
    super(cause);
  }

  public SQLException(String message, Throwable cause) {
    super(message, cause);
  }

}

