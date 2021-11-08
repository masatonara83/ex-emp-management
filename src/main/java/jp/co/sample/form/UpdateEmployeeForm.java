package jp.co.sample.form;

import javax.validation.constraints.NotNull;

/**
 * 従業員情報更新時に使うフォーム
 * 
 * @author naramasato
 *
 */
public class UpdateEmployeeForm {

	//従業員ID
	private String id;
	
	private String characteristics;
	
	//扶養人数
	@NotNull(message="扶養人数入力されていません")
	private String dependentsCount;
	
	public int getIntId() {
		return Integer.parseInt(id);
	}
	
	public int getIntDependentsCount() {
		return Integer.parseInt(dependentsCount);
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", characteristics=" + characteristics + ", dependentsCount="
				+ dependentsCount + "]";
	}

	
	
	
}
