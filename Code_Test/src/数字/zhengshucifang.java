package 数字;

public class zhengshucifang {
    public static void main(String[] args) {
        System.out.println(Power(5,-2));
    }
    public static  double Power(double base, int exponent){
        if(base==0){
            if(exponent==0){
                return -1;
            }else if(exponent>0){
                return 0;
            }else{
                return -1;
            }
        }else{
            if(exponent==0){
                //正负数的0次幂都为1
                return 1;
            }else if(exponent>0){
                double plus=1;
                for(int i=0;i<exponent;i++){
                    plus=plus*base;
                    if(plus>1.7976931348623157E308||plus<-1.7976931348623157E308){
                        return -1;
                    }
                }
                return plus;
            }else{
                double plus=1;
                for(int i=0;i<Math.abs(exponent);i++){
                    plus=plus*base;
                    if(plus>1.7976931348623157E308||plus<-1.7976931348623157E308){
                        return -1;
                    }
                }
                return 1/plus;
            }
        }
    }
}
