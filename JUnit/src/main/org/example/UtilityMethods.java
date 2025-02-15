package org.example;

public class UtilityMethods {
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public boolean isPalindrome(String s){
        String str = "";
        for(int i= s.length()-1; i>0;i--){
            str+= s.charAt(i);
        }
        if(str.equals(s)){
            return true;
        }
       return false;
    }
    public String toUpperCase(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        String s = "HelloJava";
        UtilityMethods um = new UtilityMethods();
        System.out.println(um.reverse(s));
        System.out.println(um.isPalindrome(s));
        System.out.println(um.toUpperCase(s));

    }
}
