package Assignment_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class parse {
	public static void parse(File file) throws IOException {

		RandomAccessFile input = null;
		String line = null;

		try {
			input = new RandomAccessFile(file, "r");
			input.write(05);
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No file found");
		} catch (IOException io) {
			System.err.println(io.toString());
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

}
