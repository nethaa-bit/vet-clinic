/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.*;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(!Pattern.matches("\\d{12}", "123456789012"));
        System.out.println(Pattern.matches("\\d{2,4}-\\d{7,8}", "0700-12345678"));
    }
    
}
