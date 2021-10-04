package faceLogin;

import java.net.URLEncoder;

import utils.Base64Util;
import utils.FileUtil;
import utils.HttpUtil;

public class PicAdd {
    public static String pAdd() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate";
        try {
            // 本地文件路径
            String filePath = "D:\\xx.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            System.out.println("imgParam:"+imgParam);
            //user_id是用户名    
            String param = "&image_type=BASE64" + "&image=" + imgParam ;
            AuthService auth = new AuthService();
            
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = auth.getAuth();
            String result = HttpUtil.post(url, accessToken, param);
          
            System.out.println("picAdd:"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
