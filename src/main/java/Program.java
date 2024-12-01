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


             var account2 = new Account();
             account2.setName("Tài");
             account2.setEmail("Taianhnguyen12@gmail.com");
             account2.setGroup(group);
             session.persist(account2);



                var account1 = new Account();
                account1.setName("Hòa");
                account1.setEmail("HoaAnh96@gmail.com");
                account1.setGroup(group);
                session.persist(account1);
            });

            //THử thứ 2 Find all
 factory.inTransaction(session -> {
     //hibernate
     var hql = "FROM Group ";
    var groups = session.createSelectionQuery(hql, Group.class)
             .getResultList();//bắt buộc Department là tên của entity
     for (var group : groups) {
         System.out.println("group = " + group.getName()); // lệnh gõ nhanh : department.soutv
         var accounts = group.getAccounts();
         for (var account : accounts) {
             System.out.println("account = " + account.getName());
         }
     }

 });



        }
    }
}
