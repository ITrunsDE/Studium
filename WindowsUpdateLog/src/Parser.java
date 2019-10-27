import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
	static String sep = File.separator;
	
	private List<LogEntry> entry = new LinkedList<LogEntry>();
	
	Parser(String path){
		// open file at specific path
		File file = this.open(path);
		
		// parse the file
		this.parse(file);
		
		// get an output information when the file is loaded
		System.out.println("File loaded. Found " + this.entry.size() + " entrys");
		
		List<LogEntry> list = this.getEntryOfType("Agent");
		System.out.println(list.size());
		
	}
	
	/** Open File 
	 * 
	 * @param path
	 * @return
	 */
	public File open(String path) {
		File file = new File(path);
		
		// check if File exists
		if(file.isFile()) {
			return file;			
		}
		
		return null;
		
	}
	
	/**
	 * Iterate over the file and 
	 * passes each line to the function parseLine
	 * 
	 * @param file
	 */
	public void parse(File file) {
		try {
			
			// create FileReader stream
			FileReader filereader = new FileReader(file);
			
			// buffer the FileReader 
			BufferedReader buffer = new BufferedReader(filereader);
			
			// read each line
			for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
				try {
					this.parseLine(line);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * parse each line to get the result back
	 * 
	 * @param line
	 * @return
	 * @throws Exception 
	 */
	private void parseLine(String line) throws Exception {
		
		// extract information from the line
		String lineTimestamp = line.substring(0, 27).trim();
		String lineId1  = line.substring(28, 33).trim();
		String lineId2  = line.substring(34, 38).trim();
		String lineType = line.substring(40, 55).trim();
		String lineText = line.substring(56).trim();
		
		// prepare for string to date parsing
		SimpleDateFormat sdf,stf;
		sdf = new SimpleDateFormat("yyy.MM.dd HH:mm:ss.SSSSSSS");
		
		// parse to date
		Date parsedDate = sdf.parse(lineTimestamp);
		
		// parse string to integer
		Integer id1 = Integer.parseInt(lineId1);
		Integer id2 = Integer.parseInt(lineId2);
		
		// create new LogEntry
		LogEntry entry = new LogEntry();
		entry.setDate(parsedDate);
		entry.setId1(id1);
		entry.setId2(id2);
		entry.setType(lineType);
		entry.setText(lineText);
		
		// add entry to the list
		this.entry.add(entry);
		
	}
	
	public List<LogEntry> getEntryOfType(String type) {
		
		List<LogEntry> result = new LinkedList<LogEntry>();
		
		for (LogEntry entry: this.entry) {
			if(entry.getType().equals(type)) {
				result.add(entry);
			}
		}
		return result;
	}
}
