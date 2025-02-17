package org.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    // Method to convert date from yyyy-MM-dd to dd-MM-yyyy format
    public String formatDate(String inputDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            // Parse the input date and convert it to the desired format
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            // If the input date is invalid, return null or throw an exception
            return null; // You can also throw an exception depending on your preference
        }
    }
}
