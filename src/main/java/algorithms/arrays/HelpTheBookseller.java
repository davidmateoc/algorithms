package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:46 PM
 * Algorithm URL: https://www.codewars.com/kata/54dc6f5a224c26032800005c
 */

public class HelpTheBookseller {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<String, Integer> books = new HashMap();
        for(String category : lstOf1stLetter) {
            books.put(category, 0);
        }

        for(String book : lstOfArt) {
            if(books.containsKey(Character.toString(book.charAt(0)))) {
                int numberOfCopies = Integer.parseInt(book.split(" ")[1]);
                books.put(Character.toString(book.charAt(0)), books.get(Character.toString(book.charAt(0))) + numberOfCopies);
            }
        }

        String result = "";
        if(lstOf1stLetter.length != 0 && lstOfArt.length != 0) {
            result = formatBookList(books);
        }
        return result;
    }

    public static String formatBookList(Map<String, Integer> bookList) {
        String result = "";
        for(String book : bookList.keySet()) {
            result += "(" + book + " : " + bookList.get(book) + ") - ";
        }
        return result.substring(0, result.length() - 3);
    }

    public static void main(String[] args) {
        String art[] = new String[] {"ROXANNE 102", "RHODODE 123", "BKWRKAA 125", "BTSQZFG 239", "DRTYMKH 060"};
        String cd[]  = new String[] {};


        System.out.println(stockSummary(art, cd));
    }
}
