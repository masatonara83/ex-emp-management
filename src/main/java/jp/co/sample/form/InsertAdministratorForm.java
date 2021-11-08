package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 管理者情報登録時に使用するフォーム
 * 
 * @author naramasato
 *
 */
public class InsertAdministratorForm {
	
	//名前
	@NotBlank(message="名前を入力してください")
	private String name;
	//メールアドレス
	@Email(message="メールアドレスを正しく入力してください")
	@NotBlank(message="メールアドレスを入力してください")
	private String mailAddress;
	//パスワード
	@NotBlank(message="パスワードを入力してください")
	private String password;
	
	//ゲッターとセッター
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	//toStirng()を記載
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	
}
