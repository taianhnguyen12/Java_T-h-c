import entity.Account;
import entity.Group;
import util.hibernateUtil;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        try(var factory = hibernateUtil.buildSessionFactory()) {
            factory.inTransaction(session -> {
             var group1 = new Group();
             group1.setName("Hibernate core");
             session.persist(group1);

                var group2 = new Group();
                group2.setName("Spring framework");
                session.persist(group2);

                var account2 = new Account();
             account2.setName("Tài");
             account2.setEmail("Taianhnguyen12@gmail.com");
             session.persist(account2);

                var account1 = new Account();
                account1.setName("Hòa");
                account1.setEmail("HoaAnh96@gmail.com");
                session.persist(account1);

                account1.setGroups(Arrays.asList(group1, group2));
                account2.setGroups(Arrays.asList(group1, group2));
                group1.setAccounts(Arrays.asList(account1, account2));
                group2.setAccounts(Arrays.asList(account1, account2));

                session.persist(group1);
                session.persist(group2);
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
