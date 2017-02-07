import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZHENJA on 17.11.2016.
 */
public class RegularExpression {
    private String[] expression;
    private int size;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private boolean[] isRightExpression;

   /* public void writeToFile() {

        try {

            bufferedWriter = new BufferedWriter(new FileWriter("Result.txt"));
            //  String inputString = String.valueOf(valueToReturn);
            //  bufferedWriter.write(inputString);
            bufferedWriter.close();
        }catch (IOException ex) {

        }
    }
*/
    public void readFromFile() {

        try {

            bufferedReader = new BufferedReader(new FileReader("Input.txt"));
            String number = bufferedReader.readLine();
            size = Integer.valueOf(number);
            expression = new String[size];
            isRightExpression = new boolean[size];
            int i = 0;

            while (i < size) {
                expression[i] = bufferedReader.readLine();
                System.out.println(expression[i]);
                i++;
            }

            StringBuffer stringBuffer = new StringBuffer(expression[size - 1]);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            expression[size - 1] = new String(stringBuffer);

            bufferedReader.close();
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean[] isDefineExpression() {

        //"(?i)[a-f\\d]{8}-([a-f\\d]{4}-){3}[a-f\\d]{12}"
        Pattern pattern = Pattern.compile("^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$");

        for (int i = 0; i < size; i++) {
            Matcher matcher = pattern.matcher(expression[i]);
            isRightExpression[i] = matcher.matches();
            System.out.println(isRightExpression[i]);
        }

        return isRightExpression;
    }

    public String[] getExpression() { return expression; }
}
