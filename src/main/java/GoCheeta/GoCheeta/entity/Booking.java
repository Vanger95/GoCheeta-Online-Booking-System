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
@Table(name ="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column (nullable = true,  name = "Customer_Name")
    private String customerName;

    @Column (nullable = true,  name = "Pickup_Location")
    private String pickupLocation;

    @Column (nullable = true,  name = "Drop_Location")
    private String dropLocation;

    @Column (nullable = true, name = "Distance")
    private String distance;

    @Column (nullable = true,  name = "Fair")
    private String fair;





}
