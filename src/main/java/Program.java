import entity.Department;
import entity.GroupAccount;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.hibernateUtil;

import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        try(var factory = hibernateUtil.buildSessionFactory()) {
            factory.inTransaction(session -> {
               var  groupAccount = new GroupAccount();
               groupAccount.setGroupId(1);
               groupAccount.setAccountId(2);
               session.persist(groupAccount);
                });
            factory.inTransaction(session -> {
                var  groupAccount = new GroupAccount();
                groupAccount.setGroupId(7);
                groupAccount.setAccountId(9);
                session.persist(groupAccount);
            });

            //THử thứ 2 Find all
 factory.inTransaction(session -> {
     //hibernate
     var hql = "FROM GroupAccount ";
    var groupAccounts = session.createSelectionQuery(hql, GroupAccount.class)
             .getResultList();//bắt buộc Department là tên của entity
     for (var groupAccount : groupAccounts) {
         System.out.println("gr = " + groupAccounts); // lệnh gõ nhanh : department.soutv
     }

 });



        }
    }
}
