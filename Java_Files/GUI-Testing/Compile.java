import java.io.IOException;

public class Compile{
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < args.length; i++) {
			Process process = Runtime.getRuntime().exec("javac " + args[i] + ".java");
			process = Runtime.getRuntime().exec("java " + args[i]);
		}
	}
}