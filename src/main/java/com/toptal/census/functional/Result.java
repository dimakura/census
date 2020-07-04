package com.toptal.census.functional;

public final class Result<S, E> {
  private final S success;
  private final E error;

  public static <S, E> Result<S, E> of(S success) {
    return new Result<>(success);
  }

  public static <S, E> Result<S, E> error(E error) {
    return new Result<>(error, false);
  }

  protected Result(S success) {
    this.success = success;
    this.error = null;
  }

  protected Result(E error, boolean isSuccess) {
    this.success = null;
    this.error = error;
  }

  public boolean isSuccess() {
    return this.success != null;
  }

  public S getSuccess() {
    return success;
  }

  public E getError() {
    return error;
  }
}