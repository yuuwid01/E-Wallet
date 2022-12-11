package utils;
public class NumericString {

    public static String generate(int length) {
        String NumericString = "0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (NumericString.length() * Math.random());
            sb.append(NumericString.charAt(index));
        }

        return sb.toString();
    }
}
