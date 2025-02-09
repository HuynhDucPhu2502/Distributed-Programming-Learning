package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/8/2025
 **/
@Entity
@Table(name = "friends")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ElementCollection
    @CollectionTable(
            name = "friend_nicknames",
            joinColumns = @JoinColumn(name = "friend_id")
    )
    @Column(name = "nickname", nullable = false)
    private Set<String> nicknames = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "friend_addresses",
            joinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<Address> addresses = new HashSet<>();


}
