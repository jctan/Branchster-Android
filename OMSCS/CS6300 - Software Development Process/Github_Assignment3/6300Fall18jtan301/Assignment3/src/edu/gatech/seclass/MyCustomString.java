package edu.gatech.seclass;

public class MyCustomString implements MyCustomStringInterface {

    private String string;

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        if(string == null || string.equals("")){
            return null;
        }
        return string;
    }

    public int countDuplicates() {
        int count = 0;
        char c;
        int index1;
        int index2;

        if(string == null || string.length() == 0){
            return 0;
        }

        for(int i=0; i < string.length(); i++) {
            c = string.charAt(i);
            index1 = string.indexOf(c, i);
            index2 = string.indexOf(c, i + 1);
            if (index2 - index1 == 1) {
                count++;
            }
        }
        return count;
    }

    public String addDigits(int n, boolean positive) {
        int a;
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] chars = string.toCharArray();

        if(string == null) {
            throw new NullPointerException();
        }
        if((n > 9 || n <= 0) && string != null){
            throw new IllegalArgumentException();
        }

        for(int i=0; i < string.length(); i++) {
            if(positive){
                if(Character.isDigit(string.charAt(i))){
                    a = Character.getNumericValue(string.charAt(i)) + arr[n];
                    if(a >= 0){
                        chars[i] = (char)(a % 10 + '0');
                    } else if(a < 0) {
                        chars[i] = (char)((a % 10) + 10 + '0');
                    }
                }
            } else {
                if(Character.isDigit(string.charAt(i))){
                    a = Character.getNumericValue(string.charAt(i)) - arr[n];
                    if(a >= 0 && a < 10){
                        chars[i] = (char)(a % 10 + '0');
                    } else if(a < 0) {
                        chars[i] = (char)((a % 10) + 10 + '0');
                    }
                }
            }
        }
        string = new String(chars);
        return string;
    }

    public void flipLetttersInSubstring(int startPosition, int endPosition) {
        if(string == null){
            throw new NullPointerException();
        }
        if((endPosition > string.length() || startPosition <= 0) && string != null ) {
            throw new MyIndexOutOfBoundsException();
        }
        if((!(endPosition > string.length()) || !(startPosition <= 0)) && (string != null) && (startPosition > endPosition)) {
            throw new IllegalArgumentException();
        }
        char[] chars = string.toCharArray();
        endPosition = endPosition - 1;
        for(int i = startPosition-1; i < endPosition; i++)  {
            char startChars = chars[i];
            char endChars = chars[endPosition];

            if(!Character.isLetter(startChars) && !Character.isLetter(endChars)){
                endPosition = endPosition - 1;
                endChars = chars[endPosition];
                i = i + 1;
                startChars = chars[i];
            }

            if(!Character.isLetter(endChars)){
                endPosition = endPosition - 1;
                endChars = chars[endPosition];
            }
            else if(!Character.isLetter(endChars)){
                i = i + 1;
                startChars = chars[i];
            }

            if (Character.isLetter(startChars) && Character.isLetter(endChars)) {
                char temp = chars[i];
                chars[i] = chars[endPosition];
                chars[endPosition] = temp;
                endPosition = endPosition - 1;
            } else if(Character.isLetter(startChars)){
                endPosition = endPosition - 1;
            } else if(Character.isLetter(endChars)){
                i +=1;
            } else {
                endPosition = endPosition - 1;
                i= i + 1;
            }
        }
        string = new String(chars);
        System.out.println(string);
    }

}
