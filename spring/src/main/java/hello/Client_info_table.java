package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Client_info_table {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String user_name;

    private String user_pw;

    private boolean is_user_admin;

    private Date registration_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public boolean isIs_user_admin() {
        return is_user_admin;
    }

    public void setIs_user_admin(boolean is_user_admin) {
        this.is_user_admin = is_user_admin;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }


}

