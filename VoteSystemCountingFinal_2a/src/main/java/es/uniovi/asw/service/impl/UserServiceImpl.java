package es.uniovi.asw.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.repository.UserRepository;
import es.uniovi.asw.service.UserService;
import es.uniovi.asw.model.UserInfo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl() {
	}

	public UserInfo validar(UserInfo user) {
		if (user == null)
			return null;
		UserInfo u = this.userRepository.findByLogin(user.getLogin());

		if (u == null)
			return null;

		if (u.getPassword().equals(user.getPassword()))
			return u;

		return null;
	}

	@Override
	public UserInfo update(UserInfo user) {

		if (user != null)
			return this.userRepository.save(user);
		return null;

	}

	@Override
	public UserInfo get(Long id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public List<UserInfo> getAll() {

		return this.userRepository.findAll();
	}

}
