public class test3 {
    public static void main(String[] args){
        int size = 9;
        String format = " %-" + (size - 2) + "." + (size - 2) + "s ";
        System.out.println(format);
        System.out.printf(format, "word");
        System.out.println("hello");
        System.out.printf(format, "wordn");
        System.out.println("hello");
        System.out.printf(format, "wordno");
        System.out.println("hello");
        System.out.printf(format, "wordnow");
        System.out.println("hello");
        System.out.printf(format, "wordnowb");
        System.out.println("hello");
        System.out.printf(format, "wordnowbl");
        System.out.println("hello");
        System.out.printf(format, "wordnowblu");
        System.out.println("hello");
        System.out.printf(format, "wordnowblue");
        System.out.println("hello");
    }
}
