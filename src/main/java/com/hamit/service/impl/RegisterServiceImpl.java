package com.hamit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hamit.dto.RegisterDto;
import com.hamit.entity.RegisterEntity;
import com.hamit.repository.RegisterRepository;
import com.hamit.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public RegisterDto getById(int id) {
		@SuppressWarnings("deprecation")
		RegisterEntity entity = registerRepository.getOne(id);
		return modelMapper.map(entity, RegisterDto.class);
	}
	
	@Override
	public List<RegisterDto> getAllList() {
		List<RegisterEntity> entityList = new ArrayList<RegisterEntity>();
		List<RegisterDto> dtoList = new ArrayList<RegisterDto>();
		entityList.forEach(entity -> dtoList.add(modelMapper.map(entity, RegisterDto.class)));
		return dtoList;
	}
	
	// güncelleme ve ekleme için save kullanıyoruz.
	// 2 tane modelMapper işlemi yaptım
	@Override
	public RegisterDto getPost(RegisterDto dto) {
		RegisterEntity entity = modelMapper.map(dto, RegisterEntity.class);
		registerRepository.save(entity);
		return modelMapper.map(entity, RegisterDto.class);
	}
	
	// void kullanamabiliriz.
	// güncelleme ve ekleme için save kullanıyoruz.
	@Override
	public RegisterDto getUpdate(int id, RegisterDto dto) {
		@SuppressWarnings("deprecation")
		RegisterEntity find = registerRepository.getOne(id);
		find.setRegisterName(dto.getRegisterName());
		find.setRegisterSurname(dto.getRegisterSurname());
		find.setRegisterPassword(dto.getRegisterPassword());
		find.setRegisterEmail(dto.getRegisterEmail());
		registerRepository.save(find);
		return modelMapper.map(find, RegisterDto.class);
	}
	
	@Override
	public RegisterDto getDelete(int id) {
		registerRepository.deleteById(id);
		RegisterDto dto = new RegisterDto();
		dto.setRegisterId(id);
		return dto;
	}
	
	@Override
	public RegisterDto getDeleteAll() {
		registerRepository.deleteAll();
		return null;
	}
	
}
