package 数字;


import java.util.HashMap;

public class 整数与罗马数字相互转化 {
    public static String intToRoman(int num) {
        int []values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(values[i]<=num){
                num-=values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
    public static int romanToInt(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> hashMap=new HashMap<>();
        hashMap.put('M',1000);hashMap.put('D',500);hashMap.put('C',100);hashMap.put('L',50);
        hashMap.put('X',10);hashMap.put('V',5);hashMap.put('I',1);
        int result=hashMap.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            if(hashMap.get(s.charAt(i+1))<=hashMap.get(s.charAt(i))){//如果后一位小于前一位
                result=result+hashMap.get(s.charAt(i));
            }else{
                result=result-hashMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX" ));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
