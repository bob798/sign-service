//package me.bob.signservice.pdf;
//
///**
// * @author Bob
// * @create 2020-03-12
// * @since 1.0.0
// */
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ReadPdf {
//    public static void main(String[] args) {
//
//        try (PDDocument document = PDDocument.load(new File("/Users/***/Desktop/zjTest.pdf"))) {
//
//            document.getClass();
//
//            if(!document.isEncrypted()) {
//                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//                stripper.setSortByPosition(true);
//                PDFTextStripper tStripper = new PDFTextStripper();
//
//                String pdfFileInText = tStripper.getText(document);
//
//                String[] lines = pdfFileInText.split("\\r?\\n");
//                for(String line : lines) {
//                    System.out.println("test:"+line);
//                }
//
//            }
//
//        } catch (InvalidPasswordException e) {
//
//            e.printStackTrace();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//
//    }
//
//}
//
