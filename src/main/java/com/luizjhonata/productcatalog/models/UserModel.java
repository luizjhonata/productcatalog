package com.luizjhonata.productcatalog.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class UserModel implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "user_id")
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 4, message = "Name must have 4 or more characters")
    private String name;

    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 4, max = 15, message = "Username needs to be 4 to 15 characters")
    private String username;

    @NotNull(message = "Password must be between 6 to 15 characters")
    @NotEmpty(message = "Password must be between 6 to 15 characters")
    @NotBlank(message = "Password must be between 6 to 15 characters")
    @Size(min = 6, max = 80, message = "Password must be between 6 to 15 characters")
    @Pattern(regexp = "^.*\\d.*", message = "Password must be between 6 to 15 characters and contain 1 number")
    private String password;

    //took the (fetch = FetchType.EAGER) and added @Transactional
    @ManyToMany
    @JoinTable(name = "tb_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleModel> roleModels;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleModels;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }
}