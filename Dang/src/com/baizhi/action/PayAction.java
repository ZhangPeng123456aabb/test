package com.baizhi.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.baizhi.action.base.BaseActionTwo;
import com.baizhi.constant.DangDangConstant;
import com.baizhi.pay_no_use.PayValidateUtil;
/**
 * 做一个假的支付
 */
public class PayAction extends BaseActionTwo{
	private static final long serialVersionUID = 7022637409197984964L;
	private Logger log = Logger.getLogger(CategoryAction.class);
	/**
	 * 错误信息
	 */
	private String msg;
	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg 要设置的 msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 1.验证支付密码
	 * @return
	 */
	public String pay(){
		try {
			log.info("into mydangdang action:进入支付环节");
			//TODO 接下来你要调用支付接口：微信接口、支付宝接口、银联卡网银支付
			//获取前端传来的密码  ：  将来是获取cardid而已
			String password = ServletActionContext.getRequest().getParameter("password");
			//对密码进行解密
			String password2= new String(PayValidateUtil.decode(password));
			//TODO：未来不是在这里校验 ：是需要证书、非对称秘钥算法  验证身份  签名等等
			//校验密码
			if(DangDangConstant.PASSWORD_DANGDANG.equals(password2)){
				log.info("into mydangdang aciton:支付密码校验成功");
				log.info("into mydangdang aciton:支付流程成功");
				
				return "success";
			}else{
				log.info("into mydangdang aciton:支付密码校验失败");
				log.info("into mydangdang aciton:支付流程失败");
				this.msg="密码校验失败！";
				return "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
