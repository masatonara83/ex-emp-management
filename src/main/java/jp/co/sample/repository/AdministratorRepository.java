package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * adoministeratrasテーブルを操作するリポジトリ（Dao）
 * 
 * @author naramasato
 *
 */
@Repository
public class AdministratorRepository {

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = new BeanPropertyRowMapper<>(Administrator.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 管理者情報を挿入する
	 * 
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		
		String insertSql = "INSERT INTO administrators(name, mail_address, password) VALUES(:name, :mailAddress, :password);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String[] keyColumnNames = {"id"};
		template.update(insertSql,param,keyHolder,keyColumnNames);
		administrator.setId(keyHolder.getKey().intValue());
	}
	
	/**
	 * 
	 * @param mailAddress　管理者メールアドレス
	 * @param password　管理者パスワード
	 * @return　メールアドレスとパスワードから管理者情報を取得する
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		
		String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address = :mailAddress AND password = :password;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		
		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		
		if(administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}
}
