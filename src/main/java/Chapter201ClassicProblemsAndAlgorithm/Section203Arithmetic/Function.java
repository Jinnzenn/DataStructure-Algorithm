package Chapter201ClassicProblemsAndAlgorithm.Section203Arithmetic;

import java.util.Scanner;

public class Function {
    //私有化成员变量a,b,c
    private double a;
    private double b;
    private double c;
    //提供无参、有参构造方法
    public Function() {}
    public Function(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //为每个成员变量提供set/get方法
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    //提供成员方法，用以解决二次函数问题
    public void quadratic(){
        double d = b*b-4*a*c;
        if (Math.pow(d, 0.5)>=0) {
            //求根公式
            double q1=(-b)+Math.pow(d, 0.5);
            double q2=(-b)-Math.pow(d, 0.5);
            System.out.println(q1+"  "+q2);
        }else {
            System.out.println("没有实根");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);//创建键盘录入对象
        System.out.println("请输入a的值");//接收键盘录入数据
        double a= sc.nextDouble();
        System.out.println("请输入b的值");//接收键盘录入数据
        double b= sc.nextDouble();
        System.out.println("请输入c的值");//接收键盘录入数据
        double c= sc.nextDouble();
        Function f = new Function(a,b,c);//调用方法Function
        f.quadratic();
    }
}
