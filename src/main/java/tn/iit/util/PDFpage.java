package tn.iit.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFpage {
	private int id;
	private String description;

	public PDFpage(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public void writePDFfile() {
		try {
			String currentDirectory = System.getProperty("user.dir");
			System.out.println("Current working directory: " + currentDirectory);
			// Create a new empty PDF document
			PDDocument document = new PDDocument();

			// Create a blank page and add it to the document
			PDPage page = new PDPage();
			document.addPage(page);

			// Create a new content stream for the page
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Begin the content stream
			contentStream.beginText();

			// Set the font and font size
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

			// Set the starting position for the text
			contentStream.newLineAtOffset(25, 700);

			// Write the text to the content stream
			contentStream.showText(this.description);
			// Set the starting position for the text
			contentStream.newLineAtOffset(0, -15);
			// Write the text to the content stream
			contentStream.showText("id=" + this.id +".Le nombre d'heures restantes est "+this.FourHoursPerWeekCount()+".");
			

			// End the content stream
			contentStream.endText();

			// Close the content stream
			contentStream.close();
			Date date = new Date();
			// Save the document to a file
			document.save("d:\\" + this.id + date.toString().replace(":", "_") + "autorisation.pdf");

			// Close the document
			document.close();

			System.out.println("PDF created successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int FourHoursPerWeekCount() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Get the last day of the current year
		LocalDate lastDayOfYear = currentDate.withDayOfYear(365);

		// Get the week fields for the default locale
		WeekFields weekFields = WeekFields.of(Locale.getDefault());

		// Get the week number of the last day of the year
		int lastWeekOfYear = lastDayOfYear.get(weekFields.weekOfWeekBasedYear());

		// Get the current week number
		int currentWeekOfYear = currentDate.get(weekFields.weekOfWeekBasedYear());

		// Calculate the number of weeks left in the year
		int weeksLeft = lastWeekOfYear - currentWeekOfYear;

		return 4 * weeksLeft;
	}

	public String stringDivider(String string) {
		String inputString = string;

		int lineLength = 10; // Desired length for each line

		// Divide the string into multiple lines
		StringBuilder dividedString = new StringBuilder();
		for (int i = 0; i < inputString.length(); i += lineLength) {
			int endIndex = Math.min(i + lineLength, inputString.length());
			String line = inputString.substring(i, endIndex);
			dividedString.append(line).append("\n");
		}
		return dividedString.toString();
	}
}
