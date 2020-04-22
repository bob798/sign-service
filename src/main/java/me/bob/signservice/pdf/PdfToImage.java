package me.bob.signservice.pdf;

import com.itextpdf.io.util.FileUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageNode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author Bob
 * @create 2020-04-20
 * @since 1.0.0
 */
public class PdfToImage {

    public static List<String> PDF2Img(String filePath, String destPath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }

        List<String> fileNames = new ArrayList<>();
        try {
            PDDocument document = PDDocument.load(file);
            PDPageNode node = document.getDocumentCatalog().getPages();
            List<PDPage> pages = node.getKids();
            int count = 0;
            for (PDPage page : pages) {
                BufferedImage img = page.convertToImage(BufferedImage.TYPE_INT_RGB, 128);
                File imageFile = new File(destPath + count++ + ".jpg");
                ImageIO.write(img, "jpg", imageFile);
                fileNames.add(imageFile.getName());
            }
            return fileNames;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<BufferedImage> readImage(InputStream is) throws IOException {
        PDDocument doc = PDDocument.load(is);
        PDPageNode node = doc.getDocumentCatalog().getPages();
        List<PDPage> pages = node.getKids();
        List<BufferedImage> imgs = new ArrayList<>();
        for (PDPage page : pages) {
            imgs.add(page.convertToImage(BufferedImage.TYPE_INT_RGB, 128));
        }
        return imgs;
    }


    public static List<String> pdf2Base64Img(InputStream is) throws IOException {
        List<BufferedImage> images = readImage(is);
        List<String> base64Imgs = new ArrayList<>();
        for (BufferedImage img : images) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", os);
            base64Imgs.add(Base64.getEncoder().encodeToString(os.toByteArray()));
        }
        return base64Imgs;

    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        PDF2Img("/Users/***/Desktop/testPdf.pdf", "/Users/***/Desktop/");
        System.out.println("spent time=" + (System.currentTimeMillis() - startTime));

    }
}
