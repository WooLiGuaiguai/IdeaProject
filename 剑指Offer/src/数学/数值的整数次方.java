package 数学;
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
//保证base和exponent不同时为0
public class 数值的整数次方 {
    public static double Power(double base, int exponent){
        if(base==0){
            if(exponent==0){
                return -1;
            }else if(exponent>0){
                return 0;
            }else{
                return -1;
            }
        }else {
            if(exponent==0){
                return 1;
            }else if(exponent>0){//幂次为正数
                double plus=1;
                for(int i=0;i<exponent;i++){
                    plus=plus*base;
                    if(plus>1.7976931348623157E308||plus<-1.7976931348623157E308){
                        return -1;//越界处理
                    }
                }
                return plus;
            }
            else{//幂次为负  需要加绝对值判断次数
                double plus=1;
                for(int i=0;i<Math.abs(exponent);i++){
                    plus=plus*base;
                    if(plus>1.7976931348623157E308||plus<-1.7976931348623157E308){
                        return -1;//越界处理
                    }
                }
                return 1/plus;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Power(5,-2));
    }
}
