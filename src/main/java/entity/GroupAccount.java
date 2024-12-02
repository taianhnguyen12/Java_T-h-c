package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="group_account")

public class GroupAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id",nullable = false)
    private Group group;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id",nullable = false)
    private Account account;

    @Column(name = "joined_at",nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;
}
