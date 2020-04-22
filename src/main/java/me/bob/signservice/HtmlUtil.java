package me.bob.signservice;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**Html相关工具类
 * @author Bob
 * @create 2020-04-22
 * @since 1.0.0
 */
public class HtmlUtil {

    /**
     * html 转 PDF
     * @param content html 内容
     * @return
     * @throws IOException
     */
    public static byte[] html2Word(String content) throws IOException {
        POIFSFileSystem poifs = new POIFSFileSystem();
        DirectoryEntry directoryEntry = poifs.getRoot();
        directoryEntry.createDocument("WordDocument", new ByteArrayInputStream(content.getBytes()));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        poifs.writeFilesystem(bos);
        return bos.toByteArray();
    }

    /*
    * 参考：
    * http://vence.coding.me/2016/04/21/html2word/ 基本转换
    * 带图片
    * https://blog.csdn.net/j1231230/article/details/80712531?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2
    *
    * word 转 html
    * https://blog.csdn.net/zhouzhiwengang/article/details/89002094
    * word html 相互转换
    * https://www.cnblogs.com/wadmwz/p/8926737.html
    * 解析html内容，重新生成word
    * https://www.xuwangcheng.com/articles/2019/08/21/1566371746217.html
    *
    * */



}
