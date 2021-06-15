package com.hamit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hamit.dto.RegisterDto;
import com.hamit.entity.RegisterEntity;
import com.hamit.repository.RegisterRepository;
import com.hamit.service.RegisterService;

import lombok.extern.java.Log;

@Log
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public RegisterDto getById(int id) {
		RegisterEntity entity = null;
		try {
			entity = registerRepository.getOne(id);
			log.info(RegisterDto.class + " id: " + id + " çağrıldı");
		} catch (Exception e) {
			e.printStackTrace();
			log.warning(RegisterDto.class + " id: " + id + " çağrılmadı");
		}
		
		return modelMapper.map(entity, RegisterDto.class);
	}
	
	@Override
	public List<RegisterDto> getAllList() {
		List<RegisterEntity> entityList = new ArrayList<RegisterEntity>();
		List<RegisterDto> dtoList = new ArrayList<RegisterDto>();
		try {
			entityList.forEach(entity -> dtoList.add(modelMapper.map(entity, RegisterDto.class)));
			log.info(RegisterDto.class + " listelendi");
		} catch (Exception e) {
			e.printStackTrace();
			log.warning(RegisterDto.class + " Listelenmedi");
		}
		
		return dtoList;
	}
	
	// güncelleme ve ekleme için save kullanıyoruz.
	// 2 tane modelMapper işlemi yaptım
	@Override
	public void getPost(RegisterDto dto) {
		try {
			RegisterEntity entity = modelMapper.map(dto, RegisterEntity.class);
			registerRepository.save(entity);
			log.info(RegisterDto.class + " eklendi");
			// return modelMapper.map(entity, RegisterDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			log.warning(RegisterDto.class + " eklenmedi");
		}
	}
	
	// void kullanamabiliriz.
	// güncelleme ve ekleme için save kullanıyoruz.
	@Override
	public void getUpdate(int id, RegisterDto dto) {
		try {
			RegisterEntity find = registerRepository.getOne(id);
			find.setRegisterName(dto.getRegisterName());
			find.setRegisterSurname(dto.getRegisterSurname());
			find.setRegisterPassword(dto.getRegisterPassword());
			find.setRegisterEmail(dto.getRegisterEmail());
			registerRepository.save(find);
			log.info(RegisterDto.class + " kayıt edildi");
			// return modelMapper.map(find, RegisterDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			log.warning(RegisterDto.class + " kayıt edilmedi");
		}
	}
	
	@Override
	public void getDelete(int id) {
		try {
			registerRepository.deleteById(id);
			log.info(RegisterDto.class + "id: " + id + " kayıt silindi");
		} catch (Exception e) {
			e.printStackTrace();
			log.warning(RegisterDto.class + "id: " + id + "  kayıt silinmedi");
		}
	}
	
	@Override
	public void getDeleteAll() {
		try {
			registerRepository.deleteAll();
			log.info(RegisterDto.class + " kayıtlar silindi");
		} catch (Exception e) {
			e.printStackTrace();
			log.warning(RegisterDto.class + "kayıtlar silinmedi");
		}
	}
	
}
