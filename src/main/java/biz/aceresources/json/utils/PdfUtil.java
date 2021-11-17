package biz.aceresources.json.utils;

import com.itextpdf.io.font.constants.StandardFontFamilies;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

/**
 * To generate PDF files
 */
public class PdfUtil {
    private static final Logger LOGGER = Logger.getLogger(PdfUtil.class.getName());



    public void toPdf(List<?> objectList, File file ,boolean displayHeader ) {
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(file.getAbsolutePath()));
            Document doc = new Document(pdfDoc);

            doc.setMargins(20, 20, 20, 20);
            PdfFont font = PdfFontFactory.createFont(StandardFontFamilies.HELVETICA);


            Field[] fields = objectList.get(0).getClass().getDeclaredFields();

            Table table = new Table(fields.length).useAllAvailableWidth();
            if (displayHeader) {
                for (Field field : fields) {
                    addHeader(font, table, field);
                }
            }
            for (Object obj : objectList) {
                for (Field field : fields) {
                    addBody(font, table, obj, field);
                }
            }


            doc.add(table);
            doc.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addBody(PdfFont font, Table table, Object obj, Field field) {
        field.setAccessible(true);
        Object value;
        try {
            value = field.get(obj);
            if (value == null)
                value = "";
            process(table, value + "", font, false);


            field.setAccessible(false);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            LOGGER.severe(e.toString());
        }
    }

    private void addHeader(PdfFont font, Table table, Field field) {
        field.setAccessible(true);
        String value;
        try {
            value = field.getName();
            process(table, value, font, true);
            field.setAccessible(false);
        } catch (IllegalArgumentException e) {
            LOGGER.severe(e.toString());
        }
    }

    public static void process(Table table, String text, PdfFont font, boolean isHeader) {

        if (isHeader) {
            table.addHeaderCell( new Paragraph(text).setBold());
        } else {
            table.addCell(
                    new Cell().add(
                            new Paragraph(text).setFont(font)));
        }

    }
}