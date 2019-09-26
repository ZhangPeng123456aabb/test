package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�޸����ڣ�2017-04-05
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {
	
//�����������������������������������Ļ�����Ϣ������������������������������

	// Ӧ��ID,����APPID���տ��˺ż�������APPID��Ӧ֧�����˺�
	public static String app_id = "2016101000651824";
	
	// �̻�˽Կ������PKCS8��ʽRSA2˽Կ
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCrgmyhPWzzAhXCUC9iIjHDFACTQonbKas9AXA5P1/Vtxe6GBynrgs8qWuhhNmpSKSHWV4rHFGo6qbE99LnL4wdmlCeWA3ZP03wbjnKdH2aoIc+/ophNZ98Afu9PfKlAJT719ne/b7fwQEEwaRuTfFTfnuJGQf/tffRXcD/1UyXfoCt7y1rBpoHljz+wyfHDXgVP1TOM3nwxf6JbbxPk9XIy2HcufOGD6soTDS0flkhAmsAjQ9hS9NX2bkYZ2R6zp2VqnYDgtnVCuV06nB8lShooA9KMW5vNd6rddrRjVxPKxdZ5zyv4GFwCeivCFfUu3GQQuazzn/35D2Jkhym8xzFAgMBAAECggEAV2j0ZkUBFuTUJCFr1M7qn6q9FFBQJCObg08NXA/hjvFupUiOqiL41STflwU3TaCZQeYZKU2YjMdy0WYg1fSUq62vMtRb0oIB/eyfhYBTV5BC/acK7bo/mxsDqxI8bT3bsHL1NkIKms0p8LukSxdsTApleZ0JR5j9QXZP29Ng4sAfbrqcDxQL0LL0dqzPsKblMQuFT6R7T8MxfZHk6KxPXIhe7uudSrznMsQIFlSwvSjCQiFojDOLMETQWV4xyG4w9wHikX25yVPs7moEI3k8+ftn3Rg3dg6zfAPKSaQrPUDVzPsgXuH3DQoXb78reZtmqzn9pAOBYFr1s/NSu8CQjQKBgQDeNAygl+6Fnm9q47vC9jqgUcEVbL80inFS08BYOalozhXsJPuEkQcrae+2jULsqAxqDuqko8kkSheYKt5PKSH4wZ62UCXCGy+nV0ONB9NTPgfSNoTObj5QsM6PEp7DM+JI3UThqhDU/tU4qc4HCI5e7b7BRBNLRGAh2JQ6FGj2xwKBgQDFmIELcYxEDBWHS7oEuxFDY2AnfUcW7ahtAjoPeTbsmeTGyjvmEUpeIUD6g4GLj4VwxNiTjHr4a1Fw91tsz786I0RG/4Xff87itQRxsGQrdWl6oEsPYZ89ooxz44yZ+CxLYV1biUDaQGe8nUU0gI1OLscwKLI0bx2yCalVVtTUEwKBgADzB/rHq2U2wBMc1fiHRMjakJCe3lJDJSjNbszxsh+Ygc94ePqgA//TfAqzn82TCjqJxcbeTEWza1ZjGIAOFO8TJLJytTaXFyUH4mn/1o9MfIwRX4/iOLHvj3JdCgCbgCP/jgPIzjmavR5420B8cN9G9MGuoMZ5jE+YtUlqPOiRAoGAa5y+yuiwJ28dWm3XhTQMFtNMTrVfvhD4pUWNMVgmnXzCp7EEJixMgC9EICr2pncniV7rRJBBeIGZ/Rf55qzNzG/gg3ouAqasmbNUFEaohzKOm4Yo2tujygF41LScok4ScYs5ONzrQPHKjWJpikpoqqe3O3cudnf9iDTSz/NWPZkCgYAw6lHyq3k5T8hjFfNAEQ7MQ9Yp5yKk4/uxrN9/5ERYQgLeLSRIXIZEzxkIvSHi3WzaLy0keqy3ySX8j1MEijjvdw0rfRggeaFBDzjhh7+8rW4KD95Bco7TLaKk2uOZUsObynk1HIUZ7V4APLDHUAlOciuVEASb35g9/pLhRddD2w==";
	
	// ֧������Կ,�鿴��ַ��https://openhome.alipay.com/platform/keyManage.htm ��ӦAPPID�µ�֧������Կ��
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAizDTzscYG6Z48G+NkzpCjJ2CZ40P7+iZifwmN8ENL0cw52O1mj5hzy496oRdGRai8BDJcKHF9b+ixHYYJ76DzxLdIER2Jq6nBx9fXgRP3poNhdWmCT9pGjEL2AtMqa10AZpY2IH24C8U10Ykf+E6VKW/3Gy7x+S5pTT8iQVTWLVdf2cALUjGuYJ7JOz/6cgsHxe7vT5nCo1V8pXudTxUiaBp25iSYXEKSlh884bAE2SoYrE9Lmv303F0MW+tKYsFPS9xS4N/nid0FKwkSQKJlCmSXmGJKETAH7SR0tTpFch1QCYpbybyXLgDNX6dwyRBbFhxpDn4D8H5DqHUQ+DyYwIDAQAB";

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String notify_url = "http://���̹������ʵ�ַ/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String return_url = "http://localhost:8989/Dang/order/o_updateOrderStatus";

	// ǩ����ʽ
	public static String sign_type = "RSA2";
	
	// �ַ������ʽ
	public static String charset = "utf-8";
	
	// ֧��������
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// ֧��������
	public static String log_path = "C:\\";


//�����������������������������������Ļ�����Ϣ������������������������������

    /** 
     * д��־��������ԣ�����վ����Ҳ���ԸĳɰѼ�¼�������ݿ⣩
     * @param sWord Ҫд����־����ı�����
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
