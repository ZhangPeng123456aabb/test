package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101000651824";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCrgmyhPWzzAhXCUC9iIjHDFACTQonbKas9AXA5P1/Vtxe6GBynrgs8qWuhhNmpSKSHWV4rHFGo6qbE99LnL4wdmlCeWA3ZP03wbjnKdH2aoIc+/ophNZ98Afu9PfKlAJT719ne/b7fwQEEwaRuTfFTfnuJGQf/tffRXcD/1UyXfoCt7y1rBpoHljz+wyfHDXgVP1TOM3nwxf6JbbxPk9XIy2HcufOGD6soTDS0flkhAmsAjQ9hS9NX2bkYZ2R6zp2VqnYDgtnVCuV06nB8lShooA9KMW5vNd6rddrRjVxPKxdZ5zyv4GFwCeivCFfUu3GQQuazzn/35D2Jkhym8xzFAgMBAAECggEAV2j0ZkUBFuTUJCFr1M7qn6q9FFBQJCObg08NXA/hjvFupUiOqiL41STflwU3TaCZQeYZKU2YjMdy0WYg1fSUq62vMtRb0oIB/eyfhYBTV5BC/acK7bo/mxsDqxI8bT3bsHL1NkIKms0p8LukSxdsTApleZ0JR5j9QXZP29Ng4sAfbrqcDxQL0LL0dqzPsKblMQuFT6R7T8MxfZHk6KxPXIhe7uudSrznMsQIFlSwvSjCQiFojDOLMETQWV4xyG4w9wHikX25yVPs7moEI3k8+ftn3Rg3dg6zfAPKSaQrPUDVzPsgXuH3DQoXb78reZtmqzn9pAOBYFr1s/NSu8CQjQKBgQDeNAygl+6Fnm9q47vC9jqgUcEVbL80inFS08BYOalozhXsJPuEkQcrae+2jULsqAxqDuqko8kkSheYKt5PKSH4wZ62UCXCGy+nV0ONB9NTPgfSNoTObj5QsM6PEp7DM+JI3UThqhDU/tU4qc4HCI5e7b7BRBNLRGAh2JQ6FGj2xwKBgQDFmIELcYxEDBWHS7oEuxFDY2AnfUcW7ahtAjoPeTbsmeTGyjvmEUpeIUD6g4GLj4VwxNiTjHr4a1Fw91tsz786I0RG/4Xff87itQRxsGQrdWl6oEsPYZ89ooxz44yZ+CxLYV1biUDaQGe8nUU0gI1OLscwKLI0bx2yCalVVtTUEwKBgADzB/rHq2U2wBMc1fiHRMjakJCe3lJDJSjNbszxsh+Ygc94ePqgA//TfAqzn82TCjqJxcbeTEWza1ZjGIAOFO8TJLJytTaXFyUH4mn/1o9MfIwRX4/iOLHvj3JdCgCbgCP/jgPIzjmavR5420B8cN9G9MGuoMZ5jE+YtUlqPOiRAoGAa5y+yuiwJ28dWm3XhTQMFtNMTrVfvhD4pUWNMVgmnXzCp7EEJixMgC9EICr2pncniV7rRJBBeIGZ/Rf55qzNzG/gg3ouAqasmbNUFEaohzKOm4Yo2tujygF41LScok4ScYs5ONzrQPHKjWJpikpoqqe3O3cudnf9iDTSz/NWPZkCgYAw6lHyq3k5T8hjFfNAEQ7MQ9Yp5yKk4/uxrN9/5ERYQgLeLSRIXIZEzxkIvSHi3WzaLy0keqy3ySX8j1MEijjvdw0rfRggeaFBDzjhh7+8rW4KD95Bco7TLaKk2uOZUsObynk1HIUZ7V4APLDHUAlOciuVEASb35g9/pLhRddD2w==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAizDTzscYG6Z48G+NkzpCjJ2CZ40P7+iZifwmN8ENL0cw52O1mj5hzy496oRdGRai8BDJcKHF9b+ixHYYJ76DzxLdIER2Jq6nBx9fXgRP3poNhdWmCT9pGjEL2AtMqa10AZpY2IH24C8U10Ykf+E6VKW/3Gy7x+S5pTT8iQVTWLVdf2cALUjGuYJ7JOz/6cgsHxe7vT5nCo1V8pXudTxUiaBp25iSYXEKSlh884bAE2SoYrE9Lmv303F0MW+tKYsFPS9xS4N/nid0FKwkSQKJlCmSXmGJKETAH7SR0tTpFch1QCYpbybyXLgDNX6dwyRBbFhxpDn4D8H5DqHUQ+DyYwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8989/Dang/order/o_updateOrderStatus";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
