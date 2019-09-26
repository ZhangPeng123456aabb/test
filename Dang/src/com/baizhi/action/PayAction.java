package com.baizhi.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.baizhi.action.base.BaseActionTwo;
import com.baizhi.constant.DangDangConstant;
import com.baizhi.pay_no_use.PayValidateUtil;
/**
 * ��һ���ٵ�֧��
 */
public class PayAction extends BaseActionTwo{
	private static final long serialVersionUID = 7022637409197984964L;
	private Logger log = Logger.getLogger(CategoryAction.class);
	/**
	 * ������Ϣ
	 */
	private String msg;
	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg Ҫ���õ� msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 1.��֤֧������
	 * @return
	 */
	public String pay(){
		try {
			log.info("into mydangdang action:����֧������");
			//TODO ��������Ҫ����֧���ӿڣ�΢�Žӿڡ�֧�����ӿڡ�����������֧��
			//��ȡǰ�˴���������  ��  �����ǻ�ȡcardid����
			String password = ServletActionContext.getRequest().getParameter("password");
			//��������н���
			String password2= new String(PayValidateUtil.decode(password));
			//TODO��δ������������У�� ������Ҫ֤�顢�ǶԳ���Կ�㷨  ��֤���  ǩ���ȵ�
			//У������
			if(DangDangConstant.PASSWORD_DANGDANG.equals(password2)){
				log.info("into mydangdang aciton:֧������У��ɹ�");
				log.info("into mydangdang aciton:֧�����̳ɹ�");
				
				return "success";
			}else{
				log.info("into mydangdang aciton:֧������У��ʧ��");
				log.info("into mydangdang aciton:֧������ʧ��");
				this.msg="����У��ʧ�ܣ�";
				return "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
