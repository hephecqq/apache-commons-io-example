import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.IOCase;

public final class UtilityExample {

	// We are using the file exampleTxt.txt in the folder ExampleFolder,
	// and we need to provide the full path to the Utility classes.
	private static final String EXAMPLE_TXT_PATH = "D:\\git05\\ApacheCommonsExample\\ExampleFolder\\exampleTxt.txt";

	private static final String PARENT_DIR = "D:\\git05\\ApacheCommonsExample";

	public static void runExample() throws IOException {
		System.out.println("Utility Classes example...");

		// FilenameUtils的使用
		// 得到文件的全路径名FileameUtils.getFullPath("filepath");
		System.out.println("Full path of exampleTxt: " + FilenameUtils.getFullPath(EXAMPLE_TXT_PATH));
		// 得到文件的文件 FilenameUtils.getName("filepath");
		System.out.println("Full name of exampleTxt: " + FilenameUtils.getName(EXAMPLE_TXT_PATH));
		// 得到文件的的扩展名FilenameUtils.getExtension("filepath");
		System.out.println("Extension of exampleTxt: " + FilenameUtils.getExtension(EXAMPLE_TXT_PATH));
		// 得到文件的BaseName,FilenameUtils.getBaseName("filepath");
		System.out.println("Base name of exampleTxt: " + FilenameUtils.getBaseName(EXAMPLE_TXT_PATH));

		// FileUtils的使用
		// 根据路径得到文件,FileUtils.getFile("path");
		// We can create a new File object using FileUtils.getFile(String)
		// and then use this object to get information from the file.
		File exampleFile = FileUtils.getFile(EXAMPLE_TXT_PATH);
		// 一行一行遍历文件
		LineIterator iter = FileUtils.lineIterator(exampleFile);

		System.out.println("Contents of exampleTxt...");
		while (iter.hasNext()) {
			System.out.println("\t" + iter.next());
		}
		iter.close();

		// We can check if a file exists somewhere inside a certain directory.
		File parent = FileUtils.getFile(PARENT_DIR);
		System.out.println(
				"Parent directory contains exampleTxt file: " + FileUtils.directoryContains(parent, exampleFile));

		// IOCase
		/**
		 * Enumeration of IO case sensitivity.
		 * 
		 * Different filing systems have different rules for case-sensitivity.
		 * Windows is case-insensitive, Unix is case-sensitive.
		 * 
		 */
		String str1 = "This is a new String.";
		String str2 = "This is another new String, yes!";
		// Checks if one string ends with another using the case-sensitivity
		// rule.
		System.out.println("Ends with string (case sensitive): " + IOCase.SENSITIVE.checkEndsWith(str1, "string."));
		System.out.println("Ends with string (case insensitive): " + IOCase.INSENSITIVE.checkEndsWith(str1, "string."));
		// Compares two strings using the case-sensitivity rule.
		System.out.println("String equality: " + IOCase.SENSITIVE.checkEquals(str1, str2));

		// FileSystemUtils
		// Returns the free space on a drive or volume in kilobytes by invoking
		// the command line.
		System.out.println("Free disk space (in KB): " + FileSystemUtils.freeSpaceKb("C:"));
		System.out.println("Free disk space (in MB): " + FileSystemUtils.freeSpaceKb("C:") / 1024);
	}
}