import java.text.SimpleDateFormat;
import java.util.Date;

public class Testing {

    public static void main(String[] args) {
        Date currentDate = new Date(1626639600000L);

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
        System.out.println(date);
    }
}
