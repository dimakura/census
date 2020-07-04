package com.toptal.census.domain.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SurveySlug")
final class SurveySlugTest {
  @Test
  void testValid() {
    var validSlugs = new String[] { "a", "abc", "test_123", " this_is_ok ", "UPCASTED",
        "a1234567890123456789012345678901234567890123456789" };

    for (var slugStr : validSlugs) {
      var slug = new SurveySlug(slugStr);
      assertTrue(slug.isValid());
      assertEquals(0, slug.getErrors().length);
      assertEquals(slugStr.trim().toLowerCase(), slug.getSlug());
    }
  }

  @Test
  void testBlank() {
    var blankStrings = new String[] { null, "", " " };

    for (var slugStr : blankStrings) {
      var slug = new SurveySlug(slugStr);
      assertFalse(slug.isValid());
      assertEquals(1, slug.getErrors().length);
      assertEquals("cannot be blank", slug.getErrors()[0].getMessage());
    }
  }

  @Test
  void testInvalidFormat() {
    var invalidSlugs = new String[] { "_a", "1abc", "few words",
        "a12345678901234567890123456789012345678901234567890" };

    for (var slugStr : invalidSlugs) {
      var slug = new SurveySlug(slugStr);
      assertFalse(slug.isValid());
      assertEquals(1, slug.getErrors().length);
      assertEquals("wrong format", slug.getErrors()[0].getMessage());
    }
  }
}