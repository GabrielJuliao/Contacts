public class testUtils {
    public static void main(String[] args){
        String firstName = "GABRIEL";

        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();

        System.out.println(firstName);
    }
}
