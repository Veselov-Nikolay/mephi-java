import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(?:\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        double d = 0;
        while (matcher.find()) {
            d+=Double.valueOf(text.substring(matcher.start(), matcher.end()));
        }
        System.out.println(d);
    }
}