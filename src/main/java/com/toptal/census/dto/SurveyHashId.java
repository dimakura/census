package com.toptal.census.dto;

import org.hashids.Hashids;

public final class SurveyHashId {
  public static final String HASH_SALT = "Survey";
  public static final int MIN_LENGTH = 5;

  private static final Hashids hashId = new Hashids(HASH_SALT, MIN_LENGTH);

  public static String hashId(long id) {
    return hashId.encode(id);
  }

  public static long unhashId(String id) {
    long[] ids = hashId.decode(id);
    return ids[0]; // XXX: runtime errors?
  }
}