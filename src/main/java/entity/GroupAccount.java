package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name ="Ga")
@IdClass(value = GroupAccount.PrimaryKey.class)
public class GroupAccount {
    @Id
    private int accountId;
    private int groupId;
    @Column(name = "joined_Date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate joinDate;


    @Setter
    @Getter
    @Embeddable
    public static class PrimaryKey  implements Serializable {
        @Column(name = "group_id",nullable = false)
        private int groupId;
        @Column(name = "account_id",nullable = false)
        private int accountId;
    }
}
