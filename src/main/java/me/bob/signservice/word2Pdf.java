package me.bob.signservice;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author Bob
 * @create 2020-04-20
 * @since 1.0.0
 */
public class word2Pdf{

    /**
     * The constant LOG.
     *
     */
    private static final Logger LOG = LoggerFactory.getLogger(word2Pdf.class);

    /**
     * 获取license
     *
     * @return
     */
    private static boolean getLicense() {
        boolean result = false;
        try {
            // 凭证
            String licenseStr =
                    "<License>\n" +
                            "  <Data>\n" +
                            "    <Products>\n" +
                            "      <Product>Aspose.Total for Java</Product>\n" +
                            "      <Product>Aspose.Words for Java</Product>\n" +
                            "    </Products>\n" +
                            "    <EditionType>Enterprise</EditionType>\n" +
                            "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
                            "    <LicenseExpiry>20991231</LicenseExpiry>\n" +
                            "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" +
                            "  </Data>\n" +
                            "  <Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n" +
                            "</License>";
            InputStream license = new ByteArrayInputStream(licenseStr.getBytes("UTF-8"));
            License asposeLic = new License();
            asposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            LOG.error("error:", e);
        }
        return result;
    }

    /**
     * Word 2 pdf.
     *
     * @param path the multipart file
     * @param pdfFilePath   the pdf file path
     */
    public static void word2Pdf(String path, String pdfFilePath) {
        FileOutputStream fileOS = null;
        // 验证License
        if (!getLicense()) {
            LOG.error("验证License失败！");
            return;
        }
        try {
//            Document doc = new Document(multipartFile.getInputStream());
            Document doc = new Document(path);
            fileOS = new FileOutputStream(new File(pdfFilePath));
            // 保存转换的pdf文件
            doc.save(fileOS, SaveFormat.PDF);
        } catch (Exception e) {
            LOG.error("error:", e);
        } finally {
            try {
                if(fileOS != null){
                    fileOS.close();
                }
            } catch (IOException e) {
                LOG.error("error:", e);
            }
        }


    }



    public static void main(String[] args) {
        word2Pdf("/Users/***/Desktop/testData/testD.docx","/Users/***/Desktop/testData/testDocx.pdf");
    }
}