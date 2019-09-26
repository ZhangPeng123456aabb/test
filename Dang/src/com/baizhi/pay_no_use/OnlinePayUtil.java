package com.baizhi.pay_no_use;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baizhi.entity.Order;

public class OnlinePayUtil {
	/**  
     * 鏍规嵁璁㈠崟鐢熸垚鏀粯瀹濇帴鍙RL.  
     * @param httpRequest  
     * @param order 璁㈠崟瀹炰緥  
     * @return  
     * @throws Exception  
     */  
	 public static String makeOrderAlipayUrl(HttpServletRequest httpRequest,Order order) throws Exception {   
	        HashMap<String,String> hm = new HashMap<String,String>();   
	        hm.put("_input_charset",httpRequest.getCharacterEncoding());//采用相同的编码方式   
	        hm.put("body","您在www.xxx.com上的订单,价格"+order.getTotalPrice());//填写在跳到支付宝页面上显示的付款内容信息   
	        hm.put("discount","-5");//填写折扣信息 -5表示抵扣5元   
	        hm.put("logistics_fee","10");//物流费用   
	        hm.put("logistics_payment","BUYER_PAY");//物流费用支付人 BUYER_PAY=买家支付物流费用   
	        hm.put("logistics_type","EXPRESS");//物流方式   
	        hm.put("notify_url","http://www.xxx.com/payref.jsp");//客户付款后,支付宝调用的页面   
	        hm.put("out_trade_no",order.getOrderId1()+"");//外部交易号,最好具有唯一性,在获取支付宝发来的付款信息时使用.   
	        hm.put("partner","2088102123456789");//合作商户号(需要申请)
	        hm.put("agent","2088102123456789");//支付宝合作厂商id(需要申请)
	        hm.put("payment_type","1");//支付类型 1=商品购买,2=服务购买,...   
	        hm.put("price",order.getTotalPrice()+"");//订单金额信息   
	        hm.put("quantity","1");//订单商品数量,一般都是写1,它是按照整个订单包来计算   
	        hm.put("return_url","http://www.xxx.com/payref.jsp");//客户付款成功后,显示给客户的页面   
	        hm.put("seller_email","alipay@xxx.com");//你的支付宝账户email (需要申请)  
	        hm.put("service","create_direct_pay_by_user");//create_direct_pay_by_user=直接付款,trade_create_by_buyer 担保付款    
	        hm.put("subject","www.xxx.com的订单");//填写在跳到支付宝页面上显示的付款标题信息   
	        String payGateway = "https://www.alipay.com/cooperate/gateway.do?";//跳转到支付宝的url头   
	        String url = makeUrl(hm,"100000000",httpRequest.getCharacterEncoding(),payGateway);//securityCode(安全码) (需要申请)   
	        return url;

    }   
       
       
    /**  
     * 鏍规嵁浼犲叆鐨勫弬鏁扮敓鎴恆lipay鐨勬敮浠楿RL  
     * @param hm 鍙傛暟鍊� 
     * @param securityCode 瀹夊叏鐮� 
     * @param charset 缂栫爜  
     * @param payGateway 鏀粯瀹漡ateway  
     * @return  
     */  
    public static String makeUrl(HashMap<String,String> hm,String securityCode,String charset,String payGateway) throws Exception{   
        List<String> keys = new ArrayList<String>(hm.keySet());   
        Collections.sort(keys);//鏀粯瀹濊姹傚弬鏁板繀椤绘寜瀛楁瘝鎺掑簭   
        StringBuffer content = new StringBuffer();   
        for (int i = 0; i < keys.size(); i++) {   
            content.append((String) keys.get(i));   
            content.append("=");   
            content.append((String) hm.get((String) keys.get(i)));   
            if (i != keys.size() - 1) {   
                content.append("&");   
            }   
        }   
        content.append(securityCode);   
        String sign = md5(content.toString(),charset);   
        content.delete(0,content.length());   
        content.append(payGateway);   
        for (int i = 0; i < keys.size(); i++) {   
            content.append(keys.get(i));
            content.append("=");
            content.append(URLEncoder.encode((String) hm.get(keys.get(i)), charset));
            content.append("&");   
        }   
        content.append("sign=");   
        content.append(sign);   
        content.append("&sign_type=MD5");   
        keys.clear();   
        keys = null;   
        return content.toString();   
    }   
       
    /**  
     * 鐢熸垚md5缂栫爜瀛楃涓�  
     * @param str 婧愬瓧绗︿覆  
     * @param charset 缂栫爜鏂瑰紡  
     * @return  
     *  
     */  
    public static String md5(String str,String charset) {   
        if (str == null)   
            return null;   
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',   
                'a', 'b', 'c', 'd', 'e', 'f' };   
           
        MessageDigest md5MessageDigest = null;   
        byte[] md5Bytes = null;   
        char md5Chars[] = null;   
        byte[] strBytes = null;   
        try {   
            strBytes = str.getBytes(charset);   
            md5MessageDigest = MessageDigest.getInstance("MD5");   
            md5MessageDigest.update(strBytes);   
            md5Bytes = md5MessageDigest.digest();   
            int j = md5Bytes.length;   
            md5Chars = new char[j * 2];   
            int k = 0;   
            for (int i = 0; i < j; i++) {   
                byte md5Byte = md5Bytes[i];   
                md5Chars[k++] = hexDigits[md5Byte >>> 4 & 0xf];   
                md5Chars[k++] = hexDigits[md5Byte & 0xf];   
            }   
            return new String(md5Chars);   
        } catch (NoSuchAlgorithmException e) {   
            return null;   
        } catch (UnsupportedEncodingException e) {   
            return null;   
        } finally {   
            md5MessageDigest = null;   
            strBytes = null;   
            md5Bytes = null;   
        }   
    }  
}
