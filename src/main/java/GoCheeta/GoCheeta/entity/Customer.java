package GoCheeta.GoCheeta.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column (nullable = false,  name = "First_Name")
    private String firstname;

    @Column (nullable = false,  name = "Last_Name")
    private String lastname;

    @Column (nullable = false, unique = true, name = "Email")
    private String email;

    @Column (nullable = false, name = "Address")
    private String address;

    @Column (nullable = false,  name = "Password")
    private String password;

}
