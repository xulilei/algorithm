public class test {
    public static void main(String[] args) {

    }
    public int reverse(int x) {
        String s=Integer.toString(x);
        StringBuilder sb=new StringBuilder();
        if(s.charAt(0)=='-'){
            sb.append(s.substring(1));
        }else{
            sb.append(s);
        }
        sb.reverse();
        if(s.charAt(0)=='-'){
            sb.insert(0,'-');
        }
        long res=Long.parseLong(sb.toString());
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)return 0;
        else return (int)res;
    }
}
