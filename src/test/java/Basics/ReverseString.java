package Basics;

public class ReverseString {


    public static void main(String[] args) {
        String str = "Deepika";
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        System.out.println("Reversed string:" + reversed);
    }
}