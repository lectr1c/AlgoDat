package me.lectr1c.LABA.LAB1;

public class Upp1 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("[");
        for(int n = 50; n <= 50; n++){
            int r=0;
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=i;j++){
                    for(int k=j;k<=i+j;k++){
                        for(int m=1;m<=i+j-k;m++) r++;
                    }
                }
            }
            sb.append(r).append(" ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}