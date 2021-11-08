package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * ログイン時に使うフォーム
 * 
 * @author naramasato
 *
 */
public class LoginForm {

	//ログインのメールアドレス
	@Email(message="メールアドレスを正しく入力してください。")
	@NotBlank(message="メールアドレスが入力されていません。")
	private String mailAddress;
	//ログインのパスワード
	@NotBlank(message="パスワードが入力されていません。")
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
