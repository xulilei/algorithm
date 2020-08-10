package 字符串String;

public class Five_替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpaceIndex("we are happy!"));
    }
    //用索引记录
    public static String replaceSpaceIndex(String s) {
        char[]res=new char[s.length()*3];
        int index=0;
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            if(t==' '){
                res[index++]= '%';
                res[index++]= '2';
                res[index++]= '0';
            }else res[index++]=t;
        }
       String str=new String(res,0,index);
        return  str;


    }


    //用stringBuilder
    public String replaceSpaceSB(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            if(t==' '){
                sb.append("%20");
            }else sb.append(t);
        }
        return sb.toString();
    }
}
