import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zipper {
    public String file = "";
    
	public Zipper(String file) {
		this.file = file;
	}
	
	public void zip() {
		try {
			FileInputStream inputStream = new FileInputStream(file);
			ZipOutputStream zipStream = new ZipOutputStream(new FileOutputStream("new.zip"));
			ZipEntry entry = new ZipEntry(file);
			zipStream.putNextEntry(entry);
			int i = 0;
			while((i = inputStream.read()) != -1) {
				zipStream.write((byte) i);
				zipStream.flush();
			}
			inputStream.close();
			zipStream.closeEntry();
			zipStream.close();
			System.out.format("The file %s was zipped.\n", file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
	}
	
	public void unzip() {
		try {
			ZipInputStream zipStream = new ZipInputStream(new FileInputStream(file));
			ZipEntry entry = zipStream.getNextEntry();
			file = entry.getName();
			File newFile = new File(file);
			FileOutputStream output = new FileOutputStream(newFile);
			output.flush();
			output.close();
			zipStream.close();
			System.out.println(file + " unzipped.");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

	public static void main(String[] args) {
		System.out.println("Type in the name of the file: ");
        Scanner scan = new Scanner(System.in);
        Zipper zippy = new Zipper(scan.nextLine());
        System.out.println("Enter -z to zip, -u to unzip.");
        String command = scan.nextLine();
        if (command.contains("-z")) {
        	zippy.zip();
        } else if (command.contains("-u")) {
        	zippy.unzip();
        } else {
        	System.out.println("Invalid command.");
        }
        scan.close();
	}

}
