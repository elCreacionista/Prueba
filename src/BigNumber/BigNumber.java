package BigNumber;



public class BigNumber {
    public static void main(String[] args) {
        BigNumber y = new BigNumber("84729394857209374898273498232");
        BigNumber h = new BigNumber("29398347982734981193284712371");
    }

    String number;
    char[] arraynumber;

    BigNumber(String number) {
        this.number = number;
        this.arraynumber = number.toCharArray();
        for (int i = 0; i < arraynumber.length; i++) {
            //arraynumber[i] -= 48;
            System.out.println(arraynumber[i]);
        }
    }

    public int compareTo(BigNumber b2) {


        int diferences[] = new int[this.arraynumber.length];



        return 1;
    }

    public BigNumber add(BigNumber b2) {
        return b2;
    }

    public BigNumber sub(BigNumber b2) {
        return b2;
    }

    public BigNumber mult(BigNumber b2) {
        return b2;

    }

    public BigNumber div(BigNumber b2) {
        return b2;

    }

    public BigNumber sqrt() {
        return new BigNumber("1");

    }

    public BigNumber power(int i) {
        return new BigNumber("1");

    }

    public BigNumber factorial() {
        return new BigNumber("1");

    }

    public BigNumber mcd(BigNumber b2) {
        return new BigNumber("1");

    }
}
