import com.registry.*;


public class JavaExample {

	
	public static void main(String[] args) {
		
		RegistryKey k = RegistryKey.parseKey("HKEY_LOCAL_MACHINE");
		RegistryKey key = new RegistryKey(k, "\\SOFTWARE\\7-Zip");
		String path = key.getValue("Path").toString();
		System.out.println(path);
		
	}

}
