package Basics;

import java.util.Arrays;

public class StringPractice {

      public static void Concat()
      {
          String str = "Deepika";
          String str1 = "Reddy";
          System.out.println("String:"+str);
          //Using new keyword
          String str2 = str.concat(str1);
          System.out.println(str2);

      }

    public static void Equals()
    {
        String str = "Deepika";
        String str1 = "Deepika";
        System.out.println("String:"+str);
        //Using new keyword
        boolean isTrue = str.equals(str1);
        System.out.println(isTrue);

    }



    public static boolean Substring(String s, String sub)
    {
      return  s.contains(sub);

    }

    public static int stringwwwOccurance(String s, String sub)
    {
       int count = 0;
       int index = 0;

       while ((index = s.indexOf(sub,index))!= -1){
           count++;
           index+= sub.length();

       }

        return count;
    }

    public static String getSubdomain(String url)
    {   int start = url.indexOf("://")+3;
        int end =url.indexOf(".");
        return url.substring(start,end);
    }



    public static void main(String[]args)
    {

        Concat();
        Equals();
        String s = "deepika";
        String sub = "dee";
        String[] parts = s.split("p");
        // split based on array an then convert arry to string
        System.out.println(Arrays.toString(parts));
        Substring(s, sub);
        //fetch character
        System.out.println(s.charAt(3));
        //ignore case
        System.out.println("ABC".equalsIgnoreCase("abc"));
        //equals
        System.out.println("hello".length());

        //change ABC to ABD
        System.out.println("ABC".replace("C", "D"));
        System.out.println("abcdddddjujjscxs".toUpperCase());
        System.out.println("ASDGJKNBBJKLL:L".toLowerCase());
        //trim space
        System.out.println(" abc ".trim().equals("abc"));
        //only make dee to Deepika
        System.out.println("deepika".substring(0, 4).toUpperCase());
        System.out.println("deepika".substring(4, 7));
        //Index of p
        System.out.println("deepika".indexOf("p"));
        //System.out.println(stringOccurance("hello deepika hello", "rahul"));

            //domain
        String url ="https://subdomain.example.com";


        System.out.println(getSubdomain(url));



    }




}

