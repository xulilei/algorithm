package 字符串String;

public class SixtySeven_把字符串转换成整数 {
    public int strToInt(String str) {
        char[] strs = str.trim().toCharArray();
        if(strs.length==0)return 0;
        //定义边界
        int res=0,boundary=Integer.MAX_VALUE/10;
        //定义首位是正是负
        int sign=1;
        //定义数字从第几位开始
        int i=1;
        if(strs[0]=='-')sign=-1;
        //无正无负
        else if(strs[0]!='+')i=0;
        for(int j=i;j<strs.length;i++){
            //不满足数字情况
            if(strs[j]>'9'||strs[j]<'0')break;
            //数字情况,说明越界了
            if(res>boundary||res==boundary&&strs[j]>'7'){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=res*10+strs[j]-'0';
        }
        return sign*res;
    }
}
