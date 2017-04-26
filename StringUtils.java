/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standarstring;

import java.text.Normalizer;
import java.util.regex.Pattern;



/**
 *
 * @author admin
 */
public class StringUtils {
    public static String removeAccent(String s) {
            String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
    }
    
    public static String StandarName(String input){
        String result = "";
        input = input.toLowerCase();
        String arr[] = input.split(" ");
        for (String s : arr) {
            if(!s.equals("") && !s.equals(null)){
                result += String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1) + " ";
            }
        }
        if(result.equals("")&&result.equals(null)){
            result = result.substring(0 , result.length()-1);
        }
        return result;
    }
}
