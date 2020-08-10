package 字符串String;

class twenty_表示数值的字符串 {
    public static void main(String[] args) {
        System.out.println(isNumber("sdasdas.e.sadasd"));

    }

        public static boolean isNumber(String s) {
            if(s==null||s.length()==0)return false;
            char[] str=s.trim().toCharArray();
            //三大规则
            boolean numExist=false;
            boolean eExist=false;
            boolean dotExist=false;

            //第一个是 .之前不能出现.或者e
            //第二个是e之前不能出现e，必须出现数，且E后也要有数防止123E
            //第三个是+ - 只能出现在开头或者E e后面的第一个位置
            for(int i=0;i<str.length;i++){
                if(str[i]>='0'&&str[i]<='9'){
                    numExist=true;
                }else if(str[i]=='.'){
                    if(eExist||dotExist){
                        return false;
                    }
                    dotExist=true;
                }else if(str[i]=='e'||str[i]=='E'){
                    if(eExist||!numExist){
                        return false;
                    }
                    eExist=true;
                    //当E出现后，要截断即E后也一定要有数，因此将numExist重新置为false
                    numExist=false;
                }else if(str[i]=='+'||str[i]=='-'){
                    if(i!=0&&str[i-1]!='e'&&str[i-1]!='E'){
                        return false;
                    }
                }else {
                    return false;
                }
            }
            return numExist;

        }

}
