package util;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.GroupAccount;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
    public static SessionFactory buildSessionFactory() {
        var url = "jdbc:mysql://localhost:3306/lession_03?createDatabaseIfNotExist=true"; // tạo ra database nếu chưa có
        var configuration = new Configuration()
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(GroupAccount.class)
                .addAnnotatedClass(Department.class) // chúng toi có 1 bảng Department class
                .setProperty(AvailableSettings.URL, url)
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "root")
                .setProperty(AvailableSettings.GLOBALLY_QUOTED_IDENTIFIERS, "true") // tự động thêm thập nháy huyền
                .setProperty(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS, "true")
                .setProperty(AvailableSettings.HBM2DDL_AUTO, "create")
                .setProperty(AvailableSettings.SHOW_SQL, "true")
                .setProperty(AvailableSettings.HIGHLIGHT_SQL , "true");
        return configuration.buildSessionFactory();
    }
}
