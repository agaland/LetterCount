import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
//import java.util.HashSet;


public class Main {

	public static void main(String[] args) {
		String content=getContent("test.txt");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		count(content, map);
		System.out.println(map.entrySet());
	}

	private static void count(String content, HashMap<String, Integer> map) {
		char[] tmp = content.toCharArray();	
		for (int i=0; i< tmp.length-1;i++){
			char letter=tmp[i];
			map.put(String.valueOf(letter), map.get(String.valueOf(letter)+1));
		}
	}

	private static String getContent(String filename) {
		try {
			return readFile(filename, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
