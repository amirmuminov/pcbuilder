package kz.muminov.pcbuilder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "configuration")
@Data
@NoArgsConstructor
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ssd_or_hdd_id", nullable = true)
    private Component ssd;

    @ManyToOne
    @JoinColumn(name = "mother_board_id", nullable = true)
    private Component motherBoard;

    @ManyToOne
    @JoinColumn(name = "graphics_card_id", nullable = true)
    private Component graphicsCard;

    @ManyToOne
    @JoinColumn(name = "power_supply_id", nullable = true)
    private Component powerSupply;

    @ManyToOne
    @JoinColumn(name = "cpu_id", nullable = true)
    private Component cpu;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "configuration_ram",
            joinColumns = {@JoinColumn(name = "configuration_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ram_id", referencedColumnName = "id")}
    )
    private List<Component> ram;

}
