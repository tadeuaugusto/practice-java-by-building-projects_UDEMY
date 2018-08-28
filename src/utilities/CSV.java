package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Read data from a CSV file
 * @author Tadeu
 *
 */
public class CSV {

	/**
	 * Read data from a CSV file and return as a list
	 */
	public static List<String[]> read(String file) {
		List<String[]> data = new LinkedList<String[]>();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			String dataRow;
			
			while ((dataRow = br.readLine()) != null) {
				String[] dataRecords = dataRow.split(",");
				data.add(dataRecords);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("COULD NOT FIND FILE");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("COULD NOT READ FILE");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return data;
	}
}
