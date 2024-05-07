import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HugeIntegerTest {
    @Test
    public void testHugeInteger() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("56748");
        String expected = "56748";
        assertEquals(expected, hugeInteger.toString());
    }

    @Test
    public void parsesGreaterThan40Digits_throwsIllegalArgumentException() {
        HugeInteger hugeInteger = new HugeInteger();
        String numbers = "56748567387656423456666666672345672345612345678234567";
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse(numbers));

    }

    @Test
    public void parsesNullOrBlankString_throwsIllegalArgumentException() {
        HugeInteger hugeInteger = new HugeInteger();
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse(""));
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse("  "));
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse(null));

    }

    @Test
    public void parsesInvalidData_throwsIllegalArgumentException() {
        HugeInteger hugeInteger = new HugeInteger();
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse("-45"));
    }

    @Test
    public void addTwoHugeIntegerObjects() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("1234");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("4321");

        String expected = "5555";
        String actual = hugeInteger.add(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("9674");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");

        String expected = "6341";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects_throwIllegalStateException() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("9674");
        assertThrows(IllegalStateException.class, () -> hugeInteger.subtract(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isEqual() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");

        assertTrue(hugeInteger.isEqualTo(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isNotEqual() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("9674");
        assertTrue(hugeInteger.isNotEqualTo(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isGreaterThan() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3330");
        assertTrue(hugeInteger.isGreaterThan(hugeInteger2));
    }
    @Test
    public void compareTwoHugeIntegerObjects_isLessThan() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("4567");
        assertTrue(hugeInteger.isLessThan(hugeInteger2));
    }
    @Test
    public void compareTwoHugeIntegerObjects_isGreaterThanOrEqualsTo()  {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");
        assertTrue(hugeInteger.isGreaterThanOrEqualTo(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isGreaterThanOrEqualsTo2()  {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3334");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");
        assertTrue(hugeInteger.isGreaterThanOrEqualTo(hugeInteger2));
    }
}