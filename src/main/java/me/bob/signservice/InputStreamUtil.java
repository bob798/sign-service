package me.bob.signservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**输入流相关工具类
 * @author Bob
 * @create 2020-04-22
 * @since 1.0.0
 */
public class InputStreamUtil {

    /**
     * 输入流转字符串
     * @param is 输入流
     * @return
     * @throws IOException
     */
    public static String getString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        return sb.toString();
    }
}
