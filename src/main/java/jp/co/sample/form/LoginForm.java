package jp.co.sample.form;

/**
 * ログイン時に使うフォーム
 * 
 * @author naramasato
 *
 */
public class LoginForm {

	//ログインのメールアドレス
	private String mailAddress;
	//ログインのパスワード
	private String password;
	
	
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	
	
	
	
}
