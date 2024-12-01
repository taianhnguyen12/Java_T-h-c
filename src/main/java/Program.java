import entity.Account;
import entity.Department;
import entity.Group;
import entity.GroupAccount;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.hibernateUtil;

import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        try(var factory = hibernateUtil.buildSessionFactory()) {
            factory.inTransaction(session -> {
             var group = new Group();
             group.setName("Hibernate");
             session.persist(group);


             var account = new Account();
             account.setName("Tài");
             account.setEmail("Taianhnguyen12@gmail.com");
             account.setGroup(group);
             session.persist(account);

            });

            //THử thứ 2 Find all
 factory.inTransaction(session -> {
     //hibernate
     var hql = "FROM Account ";
    var accounts = session.createSelectionQuery(hql, Account.class)
             .getResultList();//bắt buộc Department là tên của entity
     for (var account : accounts) {
         System.out.println("account = " + account.getName()); // lệnh gõ nhanh : department.soutv
         System.out.println("group = " + account.getGroup().getName());
     }

 });


            factory.inTransaction(session -> {
                //hibernate
                var hql = "FROM Group ";
                var groups = session.createSelectionQuery(hql, Group.class)
                        .getResultList();//bắt buộc Department là tên của entity
                for (var group : groups) {
                    System.out.println("group = " + group.getName()); // lệnh gõ nhanh : department.soutv
                    System.out.println("account = " + group.getAccount().getName());
                }

            });

        }
    }
}
