
package standarstring;

import java.text.Normalizer;
import java.util.regex.Pattern;



/**
 *
 * @author admin
 */
public class StringUtils {
    
    /**
     * viết hoa kí tự đầu
     * @param input = "trần Trọng HIẾn"
     * @return "Trần Trọng Hiến"
     */
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
    
    
    //============== Bỏ dấu ===============
    /**
     * 
     * @param ch = 'Đ' 
     * @return 'D'
     * bỏ dấu kí tự và ngăn cách bởi dấu  của chrSeparator
     * 
     */
    public static char removeAccent(char ch, char chrSeparator) {
        int index = Arrays.binarySearch(SPECIAL_CHARACTERS, ch);
        if (index > 0) {
            ch = REPLACEMENTS[index];
        }else if(index == 0){
            ch = chrSeparator;
        }
        return ch;
    }
    public static final char SPACE = ' ';
    
    /**
     * 
     * @param s = "Trần Trọng Hiến"   chuổi đầu vào 
     * @param chrSeparator = ' '      dấu phân cách
     * @return = "Tran Trong Hien"    output
     */
    public static String removeAccents(String s, char chrSeparator) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i), chrSeparator));
        }
        return sb.toString();
    }
}
