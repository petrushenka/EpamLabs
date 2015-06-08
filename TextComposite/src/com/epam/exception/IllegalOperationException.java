package com.epam.exception;

public class IllegalOperationException extends IllegalArgumentException {

  private static final long serialVersionUID = -8568170428374256577L;

  public IllegalOperationException() {
    super();
  }

  public IllegalOperationException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalOperationException(String s) {
    super(s);
  }

  public IllegalOperationException(Throwable cause) {
    super(cause);
  }
}
