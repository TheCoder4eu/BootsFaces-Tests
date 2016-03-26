import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class SortTaglib {
	public static String mergedContent = "";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String content = readFile("src/main/meta/META-INF/bootsfaces-b.taglib-merged.xml", StandardCharsets.UTF_8);
		String[] chunks = content.split("</tag>");

		Comparator<String> compareByTagName = new Comparator<String>() {

			@Override
			public int compare(String tag1, String tag2) {
				int start = tag1.indexOf("<tag-name>");
				int end = tag1.indexOf("</tag-name>");
				if (start < 0)
					return 1;
				String tagname1 = tag1.substring(start + "<tag-name>".length(), end).trim();
				start = tag2.indexOf("<tag-name>");
				end = tag2.indexOf("</tag-name>");
				if (start < 0)
					return -1;
				String tagname2 = tag2.substring(start + "<tag-name>".length(), end).trim();
				return tagname1.compareTo(tagname2);
			}
		};
		Arrays.sort(chunks, compareByTagName);
		for (String chunk : chunks) {
			chunk = sortTag(chunk);
			mergedContent += chunk;
			mergedContent += "</tag>";
		}

		PrintWriter out = new PrintWriter("src/main/meta/META-INF/bootsfaces-b.taglib-merged-and-sorted.xml");
		out.println(mergedContent);
		out.close();
	}

	private static String sortTag(String chunk) {
		Comparator<String> compareByAttributeName = new Comparator<String>() {
			@Override
			public int compare(String tag1, String tag2) {
				int start = tag1.indexOf("<name>");
				int end = tag1.indexOf("</name>");
				if (start < 0)
					return -1;
				String tagname1 = tag1.substring(start + "<name>".length(), end).trim();
				start = tag2.indexOf("<name>");
				end = tag2.indexOf("</name>");
				if (start < 0)
					return 1;
				String tagname2 = tag2.substring(start + "<name>".length(), end).trim();
				return tagname1.compareTo(tagname2);
			}
		};
		String sortedContent = "";
		int start = chunk.indexOf("<attribute>");

		if (start < 0)
			return chunk;
		sortedContent = chunk.substring(0, start);
		chunk = chunk.substring(start);
		String[] attributes = chunk.split("</attribute>");
		Arrays.sort(attributes, compareByAttributeName);
		for (String attribute : attributes) {
			sortedContent += attribute;
			if (attribute.contains("<attribute>"))
				sortedContent += "</attribute>";
		}
		return sortedContent;
	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
