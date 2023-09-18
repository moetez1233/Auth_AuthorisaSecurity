package com.app.testAuthSecurity.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.app.testAuthSecurity.customException.ResourceExistException;
import com.app.testAuthSecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.testAuthSecurity.entity.Role;
import com.app.testAuthSecurity.repository.RoleRepo;
import com.app.testAuthSecurity.repository.UserRepo;



@Service 
public class UserServiceImpl implements UserService {
	@Autowired
	private  UserRepo userRepo;
	@Autowired
	private RoleRepo roleRopo;;
	
	@Autowired
	PasswordEncoder passwordEncoder ;
	
	@Override
	public User saveUser(User user) {
		if (getUser(user.getEmail()).isPresent()){
			throw new ResourceExistException("Utilisateur "+user.getEmail()+" est déja existe ");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRopo.save(role);
	}

	@Override
	public Optional<User> getUser(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepo.findByEmail(email).get();
		if(user==null) throw new UsernameNotFoundException(email);
		Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
		//System.out.println("user_implementation : "+user.getRoles());
		Collection<Role> roles=user.getRoles();
		for(Role role :roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		//System.out.println("authorities "+authorities);

		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
	}
	@Override
	public void addRoleToUser(String email) {
		User user=userRepo.findByEmail(email).get();
		System.out.println("user est : "+user);
		
		List<Role> role=roleRopo.findAll();
		System.out.println("list role est : "+role);
		List<Role> rolesID=new ArrayList<>();
		for(int i=0;i<role.size();i++) {
			if(role.get(i).getId()==user.getId()) {
				rolesID.add(role.get(i));
			}
		}
		System.out.println("list est "+rolesID);
		user.setRoles(rolesID);
		userRepo.save(user);
		
	}

	@Override
	public void iniTialUserTest() {
		List<Role> roles =new ArrayList<>();
		roles.add(new Role("consulter_users"));
		roles.add(new Role("ajouter_users"));
		System.out.println("role main : "+roles);
		saveUser(new User("Admin", "root@gmail.com", "root123", roles));
		//System.out.println(userService.getUsers());
		List<Role> rolesUser2 =new ArrayList<>();
		rolesUser2.add(new Role("consulter_users"));
		saveUser(new User("moetez", "moetezmaddouri@gmail.com", "root123", rolesUser2));
	}
}
