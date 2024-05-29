package com.ecom.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue
    private String roleId;
    private String roleName;

//	@ManyToMany(mappedBy = "roles")
//	private Set<User> users =new HashSet<>();


}
