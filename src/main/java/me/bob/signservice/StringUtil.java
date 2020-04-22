package me.bob.signservice;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**字符串相关工具
 * @author Bob
 * @create 2020-04-22
 * @since 1.0.0
 */
public class StringUtil {


    /**
     * 字符串转输入流
     * @param input 字符串
     * @return
     */
    public static InputStream getStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }


}
