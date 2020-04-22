package com.example.user.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.user.bean.User;

@Component
public class UserDaoService {
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static int usersCount = 1;
	
	static {
		users.put(usersCount, new User(usersCount,"carlos",LocalDate.of(1989, Month.DECEMBER, 25)));
		usersCount++;
	}
	
	public User save(final User user) {
		final Integer id;
		if (user.getId() == null) {
			usersCount++;
			user.setId(usersCount);
		}
		users.put(usersCount, user);
		id = user.getId();
		return users.get(id);
	}
	
	public User findById(final Integer id) {
		return users.get(id);
	}
	
	public User deleteById(final Integer id) {
		if (users.containsKey(id)) {
			User user = users.get(id);
			users.remove(id);
			return user;
		}
		return null;
	}
	
	public List<User> findAll() {
		return users.values().stream().collect(Collectors.toList());
	}
	
	
}
