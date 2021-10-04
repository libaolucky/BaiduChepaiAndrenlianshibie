 
package faceLogin;

 
import java.net.URLEncoder;

import utils.Base64Util;
import utils.FileUtil;
import utils.HttpUtil;

/**
* ����ע��
*/
public class FaceAdd {

    /**
    * ��Ҫ��ʾ���������蹤����
    * FileUtil,Base64Util,HttpUtil,GsonUtils���
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * ����
    */
    public static String add() {
        // ����url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            // �����ļ�·��
            String filePath = "D:\\yy.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            //user_id���û���    
            String param = "user_id=" + "liangliang" + "&user_info=" + "lianghead" + "&group_id=" + "meandliang" + "&image_type=BASE64" + "&image=" + imgParam ;
            AuthService auth = new AuthService();
            
            // ע�������Ϊ�˼򻯱���ÿһ������ȥ��ȡaccess_token�����ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
            String accessToken = auth.getAuth();
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println("addface:"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
   
}
