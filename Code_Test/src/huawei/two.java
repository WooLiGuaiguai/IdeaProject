package huawei;

public class two {
    public static void main(String[] args) {
        String []strs={"XXX","addr","mask","val"};
        String str="XXX[addr=0xYYY,mask=0xZZZ,val=0xWWW]";
        String string=replaceSpace(strs,str);
        StringBuffer []strings=new StringBuffer[3];
        int count=0;
        for(int q=0;q<string.length();q++){
            if(string.charAt(q)==','){
                count++;
                continue;
            }
            strings[count].append(string.charAt(q));
        }
        for (StringBuffer stringBuffer : strings) {
            System.out.print(stringBuffer.toString()+" ");
        }
    }
    public static String replaceSpace(String[] strs,String s){
        if(s==null){
            return "Fail";
        }
        StringBuffer sb=new StringBuffer();
        int l=0;
            for(int j=0;j<strs[0].length();j++,l++){
                if(strs[0].charAt(j)!=s.charAt(j)){
                    return "Fail";
                }
            }
            l=l+1;
            for(int k=0;k<strs[1].length();k++,l++){
                if(strs[1].charAt(k)!=s.charAt(l)){
                    return "Fail";
                }
            }
            for(l=l+1;l<s.length();l++){
                if(s.charAt(l)==','){
                    break;
                }
                sb.append(s.charAt(l));
            }
            sb.append(',');
            int m=0;
            for(l=l+1;m<strs[2].length();m++,l++){
                if(strs[2].charAt(m)!=s.charAt(l)){
                    return "Fail";
                }
            }
            for(l=l+2;l<s.length();l++){
                if(s.charAt(l)==','){
                    break;
                }
                sb.append(s.charAt(l));
            }
            sb.append(',');
            int n=0;
            for(l=l+1;n<strs[3].length();n++,l++){
                if(strs[2].charAt(n)!=s.charAt(l)){
                    return "Fail";
                }
            }
            for(l=l+2;l<s.length();l++){
                if(s.charAt(l)==']'){
                    break;
                }
                sb.append(s.charAt(l));
            }
        String string=sb.toString();
        return string;
    }
}
