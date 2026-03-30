import java.util.List;

public class Iasdasd {
    static void main() {
        try {
//            int[] a= {1,2,3};
//            System.out.println(a[3]);

            List<String> list = null;
            System.out.println(list.size());
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch(Exception e){
            System.out.println("This is an exception");
        }
    }
}
