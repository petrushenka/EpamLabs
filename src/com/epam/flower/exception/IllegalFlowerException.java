package com.epam.flower.exception;

public class IllegalFlowerException extends IllegalArgumentException {

  private static final long serialVersionUID = -8568170428374256577L;

  public IllegalFlowerException() {
    super();
  }

  public IllegalFlowerException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalFlowerException(String s) {
    super(s);
  }

  public IllegalFlowerException(Throwable cause) {
    super(cause);
  }
}
