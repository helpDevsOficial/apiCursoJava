package net.helpdevs.clientApi.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.helpdevs.clientApi.Dto.ClientDto;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    private static final long serialVersionUID = -1559864615786877060L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Transient
    public ClientDto clientDto(){
        return new ClientDto(name,email);
    }

}

