package me.bob.signservice.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.font.FontProvider;

import java.io.*;

/**
 * @author Bob
 * @create 2020-03-25
 * @since 1.0.0
 */
public class HtmlToPdf {
    /**
     * @param pdfFileName
     * @param htmlString     : html文件内容
     * @param resourcePrefix
     */
    public static void  createPdfFromHtml(String pdfFileName, String htmlString, String resourcePrefix) {
        PdfDocument pdfDoc = null;
        try {
            FileOutputStream outputStream = new FileOutputStream(resourcePrefix + pdfFileName);
            WriterProperties writerProperties = new WriterProperties();
            writerProperties.addXmpMetadata();
            PdfWriter pdfWriter = new PdfWriter(outputStream, writerProperties);
            pdfDoc = createPdfDoc(pdfWriter);
            ConverterProperties props = createConverterProperties(resourcePrefix);
            HtmlConverter.convertToPdf(htmlString, pdfDoc, props);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            pdfDoc.close();
        }

    }
    private static PdfDocument createPdfDoc(PdfWriter pdfWriter) {
        PdfDocument pdfDoc;
        pdfDoc = new PdfDocument(pdfWriter);
        pdfDoc.getCatalog().setLang(new PdfString("zh-CN"));
        pdfDoc.setTagged();
        pdfDoc.getCatalog().setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));
        return pdfDoc;
    }

    private static ConverterProperties createConverterProperties(String resourcePrefix) {
        ConverterProperties props = new ConverterProperties();
        props.setFontProvider(createFontProvider(resourcePrefix));
        props.setBaseUri(resourcePrefix);
        props.setCharset("UTF-8");
        DefaultTagWorkerFactory tagWorkerFactory = new DefaultTagWorkerFactory();
        props.setTagWorkerFactory(tagWorkerFactory);
        return props;
    }

    private static  FontProvider createFontProvider(String resourcePrefix) {
        FontProvider fp = new FontProvider();
        fp.addStandardPdfFonts();
        fp.addDirectory(resourcePrefix);
        return fp;
    }

    public static String readFileUTF8(String filePath) throws Exception {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,
                "UTF-8"));
        String fileContent = "";
        String temp = "";
        while ((temp = br.readLine()) != null) {
            fileContent = fileContent + temp;
        }
        br.close();
        fis.close();
        return fileContent;
    }


    public static void main(String[] args) throws Exception {

//        String htmlContent = readFileUTF8("/Users/***/Desktop/testData/downloadContractInfoDetailHtmlTemplate.html");
        String htmlContent = readFileUTF8("/Users/***/Desktop/reportTemplate.html");
        createPdfFromHtml("testConvertPdf.pdf", htmlContent, "/Users/***/Desktop/");


    }
}

