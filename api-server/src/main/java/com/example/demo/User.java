package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * User class.
 * </p>
 * 
 * @author Michal Svacha
 * @author Martin Myslik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor //추가 모든 필드가 있는 생성자를 만든다.
@NoArgsConstructor(access = AccessLevel.PRIVATE)  //추가 디폴트 생성자를 만든다. 이놈이 필요한이유는 JPA 덕분 
public class User implements UserDetails {

  static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  @Column(name = "user_id", nullable = false, updatable = false)
  private long id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  public User(String username, String password, String name)
  {
	  this.username = username;
	  this.password = password;
	  this.name = name;
  }
 
  public String getName() {
    return this.name;
  }
 

  // User Details

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

    return authorities;
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
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
