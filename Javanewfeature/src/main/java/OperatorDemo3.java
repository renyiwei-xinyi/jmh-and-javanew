/*
-----------------------------------------------------
    Author : 高文豪
    Github : https://github.com/gaowenhao
    Blog   : https://gaowenhao.cn
-----------------------------------------------------
*/

public class OperatorDemo3 {
    public static void main(String[] args) {
        var a = 6;                  // 6的二进制为00000000 0000000 00000000 00000110
        var b = 3;                  // 3的二进制为00000000 0000000 00000000 00000011

        System.out.println(a & b);  // 如果对应位都是1,则结果为1,上面的值只有第二位a,b都为1,故结果是10（高位补0,这里忽略）十进制为2.
        System.out.println(a | b);  // 如果对应位都是0,则结果为0,否则为1,上面的结果为111,十进制为7.
        System.out.println(a ^ b);  // 如果对应位相同则为0,否则为1,上面的结算结果为101,十进制为5
        System.out.println(~a);     // 如果对应位是0,则返回1,如果对应位是1,结果是个补码,他的原码是-1后取反符号位不变，这个值的十进制就是-7.
        System.out.println(a << 1); // 表示a的二进制左移1位,原本的110变为1100（低位补0），这个值的10进制是12，你会发现任何数字<<1都是原数字的二倍，希望你能想清楚这个问题。
        System.out.println(a >> 1); //a的二进制向右移动1位，原本110变为11，高位补0(但不会影响符号位)，而11是十进制的3
        System.out.println(a >>> 1);//a的二进制向右移动1位，原本110变为11，高位补0(会影响符号位)，而11是十进制的3
    }
}