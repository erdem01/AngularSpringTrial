package erdemc.deneme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name=User.TABLE_NAME)
@Table(name=User.TABLE_NAME)
public class User {
	
	static final String TABLE_NAME = "USERS";
	
	private static final String ID_COL_NAME = "USER_ID";
	
	private static final String USER_CODE_COL_NAME = "USER_CODE";
	
	private static final String HIDDEN_COL_NAME = "PASSWORD";

	@Id
    @Column(name=ID_COL_NAME)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name=USER_CODE_COL_NAME)
	private String userCode;
	
	@Column(name=HIDDEN_COL_NAME)
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}
	
}