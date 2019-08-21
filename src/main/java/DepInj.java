public class DepInj {
    public void print(){
        System.out.println(" I do work");
    }

    public static void main(String[] args) {
        new DepInj().print();
    }
}
