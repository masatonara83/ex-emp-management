package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * employeesテーブルを操作するリポジトリ（Dao）
 * 
 * @author naramasato
 *
 */
@Repository
public class EmployeeRepository {

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 従業員一覧情報を表示する
	 * 
	 * @return　従業員情報一覧
	 */
	public List<Employee> findAll(){
		String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count "
				+ "FROM employees ORDER BY DESC;";
		
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		
		return employeeList;
	}
	
	/**
	 * 主キーから従業員情報を検索する
	 * 
	 * @param id　主キー
	 * @return　1つの従業員情報
	 */
	public Employee load(Integer id) {
		
		String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count "
				+ "FROM employees WHERE id = :id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		
		return employee;
	}
	
	/**
	 * 従業員情報を変更する
	 * 
	 * @param employee　渡された変更する従業員情報
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		
		String updateSql = "UPDATE employees SET "
				+ "name = :name , "
				+ "image = :iamge, "
				+ "gender = :gender, "
				+ "hire_date = :hireDate, "
				+ "mail_address = :mailAddress, "
				+ "zip_code = :zipCode, "
				+ "address = address, "
				+ "telephone = :telephone, "
				+ "salary = :salary, "
				+ "characteristics = :characteristics, "
				+ "dependents_count = :dependentsCount "
				+ "WHERE id = :id;";
		
		template.update(updateSql, param);
	}
}
