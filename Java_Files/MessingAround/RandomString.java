public class RandomString {
    public static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.!? ";
    
    //Randomly generates strings of characters. args[0] gives the length of each string,
    //args[1] gives the amount of strings
    public static void main(String[] args) {
        for (int amount = 0; amount < Integer.parseInt(args[1]); amount++) { 
            String word = "";
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                word += CHARS.charAt((int)(Math.random()*CHARS.length()));
            }
            System.out.println(word);
        }
    }
}