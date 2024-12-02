package entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name",length = 50,nullable = false)
    private String name;
    @Column(name = "email",length = 50,unique = true,nullable = false)
    private String email;


    @ManyToMany(mappedBy = "accounts")

    private List<Group> groups;
}
