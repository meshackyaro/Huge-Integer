import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HugeInteger {
    private final List<Integer> store = new ArrayList<>();;

    public HugeInteger parse(String numbers) {
        validate(numbers);
        store.clear();

        for (int index = 0; index < numbers.length(); index++) {
            int number = numbers.charAt(index) - '0';
            store.add(number);
        }
        return this;
    }

    private static void validate(String numbers) {
        if (numbers == null) throw new IllegalArgumentException("number should not null");
        String regex = "[0-9]+";
        if (!numbers.matches(regex)) throw new IllegalArgumentException("invalid data");
        if (numbers.length() > 40) throw new IllegalArgumentException("number should not be more than 40");
    }

    @Override
    public String toString() {
        return getString(this);
    }
    public HugeInteger add(HugeInteger hugeInteger) {
        BigInteger bigInteger1 = new BigInteger(this.toString());
        BigInteger bigInteger2 = new BigInteger(hugeInteger.toString());
        bigInteger1 = bigInteger1.add(bigInteger2);

        return parse(bigInteger1.toString());
    }

    private String getString(HugeInteger hugeInteger) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < hugeInteger.store.size(); index++) {
            stringBuilder.append(hugeInteger.store.get(index));
        }
        return stringBuilder.toString();
    }

    public HugeInteger subtract(HugeInteger hugeInteger) {
        BigInteger bigInteger1 = new BigInteger(this.toString());
        BigInteger bigInteger2 = new BigInteger(hugeInteger.toString());
        bigInteger1 = bigInteger1.subtract(bigInteger2);

        if (bigInteger1.toString().startsWith("-")) throw new IllegalStateException("no negative value accepted over here");

        return parse(bigInteger1.toString());

    }

    public boolean isEqualTo(HugeInteger hugeInteger) {
        return this.toString().equals(hugeInteger.toString());

    }


    public boolean isNotEqualTo(HugeInteger hugeInteger) {
        return !this.toString().equals(hugeInteger.toString());
    }

    public boolean isGreaterThan(HugeInteger hugeInteger) {
        return this.toString().compareTo(hugeInteger.toString()) > 0;
    }

    public boolean isLessThan(HugeInteger hugeInteger) {
        return this.toString().compareTo(hugeInteger.toString()) < 0;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger hugeInteger) {
        return this.toString().compareTo(hugeInteger.toString()) >= 0;
    }
}
