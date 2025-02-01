package kk.numberSystem;

/*
any decimal number can surely be expressed as the sum of unique powers of 2. E.g., 6 as 110; 7 as 111; 8 as 1000; and so on...
To find any decimal number raised to the power, we can either run the loop "power" times to get the answer,
or we can derive powers by getting idea from the seeing the binary representation of the power.
3^6 = 3^4 + 3^2. Here, we disintegrated powers into the unique powers of 2, i.e., 2 and 3. So, 3^6 == 3^(110).
If we see the binary representation of power, and try to convert to individual addends while converting binary to decimal, we see that (110)2=(1*2^2 + 1*2^1 + 1*2^0)10=(4+2+0)10
Here, we observe that 3^6 = 3^4 + 3^2 and (4+2+0)10 has similar pattern where powers can be expressed as the sum of unique powers of 2, where bits are set;
and new base on left is expressed as immediate left term times immediate left term, i.e., 3^22= 1*3^16 + 0*3^8 + 1*3^4 + 1*3^2 + 0*3^1 , where powers on 3 are double of its right.
Time Complexity is Log2(power) as we are iteratively dividing power by 2 until it becomes zero.
 */
public class Power {
    public static void main(String[] args) {
        int base = 3;
        int power = 6;

        int ans = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= base;
            }

            base *= base;
            power = power >> 1;
        }
        System.out.println(ans);
    }
}
