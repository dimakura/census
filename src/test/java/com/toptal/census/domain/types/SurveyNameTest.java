package com.toptal.census.domain.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SurveyName")
final class SurveyNameTest {
  @Test
  void testValid() {
    var validNames = new String[] { "name", "1234567890", "Another name", " Name with extra spaces  " };

    for (var nameStr : validNames) {
      var name = new SurveyName(nameStr);
      assertTrue(name.isValid());
      assertEquals(0, name.getErrors().length);
      assertEquals(nameStr.trim(), name.getName());
    }
  }

  @Test
  void testBlank() {
    var blankNames = new String[] { null, "", " " };

    for (var nameStr : blankNames) {
      var name = new SurveyName(nameStr);
      assertFalse(name.isValid());
      assertEquals(1, name.getErrors().length);
      assertEquals("cannot be blank", name.getErrors()[0].getMessage());
    }
  }

  @Test
  void testLongName() {
    var name = new SurveyName("012345678901234567890123456789012345678901234567891");
    assertFalse(name.isValid());
    assertEquals(1, name.getErrors().length);
    assertEquals("too long", name.getErrors()[0].getMessage());
  }
}