package jp.co.sample.form;

/**
 * ログイン時に使うフォーム
 * 
 * @author naramasato
 *
 */
public class LoginForm {

	//ログインの名前
	private String name;
	//ログインのパスワード
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginForm [name=" + name + ", password=" + password + "]";
	}
	
	
}
