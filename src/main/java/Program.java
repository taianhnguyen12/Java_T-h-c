import entity.Account;
import entity.Group;
import entity.GroupAccount;
import util.hibernateUtil;


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


                var groupAccount1 = new GroupAccount();
                groupAccount1.setAccount(account1);
                groupAccount1.setGroup(group1);
                session.persist(groupAccount1);

                var groupAccount2 = new GroupAccount();
                groupAccount2.setAccount(account1);
                groupAccount2.setGroup(group2);
                session.persist(groupAccount2);


                var groupAccount3 = new GroupAccount();
                groupAccount3.setAccount(account2);
                groupAccount3.setGroup(group2);
                session.persist(groupAccount3);


                var groupAccount4 = new GroupAccount();
                groupAccount4.setAccount(account2);
                groupAccount4.setGroup(group1);
                session.persist(groupAccount4);
            });

            //THử thứ 2 Find all
 factory.inTransaction(session -> {
     //hibernate
     var hql = "FROM Group ";
    var groups = session.createSelectionQuery(hql, Group.class)
             .getResultList();//bắt buộc Department là tên của entity
     for (var group : groups) {
         System.out.println("group = " + group.getName()); // lệnh gõ nhanh : department.soutv
         var groupAccounts = group.getGroupAccounts();
         for (var groupAccount : groupAccounts) {
             System.out.println("account = " + groupAccount.getAccount().getName());
             System.out.println("joined_at = " + groupAccount.getJoinedAt());
         }
     }

 });
        }
    }
}
