package com.hamit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamit.dto.LoginDto;
import com.hamit.entity.LoginEntity;
import com.hamit.repository.LoginRepository;
import com.hamit.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public LoginDto getById(int id) {
		LoginEntity loginEntity = loginRepository.getOne(id);
		return modelMapper.map(loginEntity, LoginDto.class);
	}
	
	<S, T> List<T> modelMapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(item -> modelMapper.map(item, targetClass)).collect(Collectors.toList());
	}
	
	@Override
	public List<LoginDto> getAllList() {
		List<LoginEntity> entityList = new ArrayList<LoginEntity>();
		loginRepository.findAll().forEach(entityList::add);
		List<LoginDto> dtoList = modelMapList(entityList, LoginDto.class);
		return dtoList;
	}
	
	@Override
	public LoginDto getUpdate(int id, LoginDto loginDto) {
		LoginEntity loginEntity = loginRepository.getOne(id);
		loginEntity.setLoginPassword(loginDto.getLoginPassword());
		loginEntity.setLoginEmailAddres(loginDto.getLoginEmailAddres());
		loginEntity.setLoginUserName(loginDto.getLoginUserName());
		loginRepository.save(loginEntity);
		return modelMapper.map(loginEntity, LoginDto.class);
	}
	
	@Override
	public void getDelete(int id) {
		loginRepository.deleteById(id);
	}
	
	@Override
	public void getAllDelete() {
		loginRepository.deleteAll();
	}
	
	@Override
	public LoginDto getPost(LoginDto loginDto) {
		LoginEntity loginEntity = modelMapper.map(loginDto, LoginEntity.class);
		loginRepository.save(loginEntity);
		return modelMapper.map(loginEntity, LoginDto.class);
	}
	
}
