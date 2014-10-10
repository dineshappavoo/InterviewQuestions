package com.amazon.challenge;




import java.util.Scanner;
public class StringReflection
{
    public static int isSameReflection(String word1, String word2){
        if(word1==null||word2==null)
        {
            return -1;
        }
        int word1Length=word1.length();
        int word2Length=word2.length();
        if(word1Length!=word2Length)
        {
            return -1;
        }
        if(word1Length>100||word2Length>100)
        {
            return -1;
        }
        if((word1.equals(""))||(word2.equals("")))
        {
            return -1;
        }
        String tempStr=word1+word1;
        if(tempStr.contains(word2))
        {
            return 1;
        }else
        {
            return -1;
        }
    }
    public static void main(String[] args)
    {
        String word1,word2;
        Scanner s= new Scanner(System.in);
        word1=s.next();
        word2=s.next();
        System.out.println(isSameReflection(word1,word2));
    }
}