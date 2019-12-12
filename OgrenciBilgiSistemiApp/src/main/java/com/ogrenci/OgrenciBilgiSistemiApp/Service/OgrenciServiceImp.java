package com.ogrenci.OgrenciBilgiSistemiApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogrenci.OgrenciBilgiSistemiApp.dao.OgrenciRepository;
import com.ogrenci.OgrenciBilgiSistemiApp.entity.Ogrenci;
@Service
public class OgrenciServiceImp implements OgrenciService{
	@Autowired
	private OgrenciRepository ogrenciRepository ;
	
	@Override
	public List<Ogrenci> getOgrenciList() {
		List<Ogrenci> myList = ogrenciRepository.findAll();
		return myList;
	}

	@Override
	public void saveOgrenci(Ogrenci ogrenci) {
		ogrenciRepository.save(ogrenci);
		
	}

	@Override
	public Ogrenci getOgrenci(int ogrenciId) {
		Ogrenci ogrenci = ogrenciRepository.getOne(ogrenciId);
		return ogrenci;
	}

	@Override
	public void deleteOgrenci(int ogrenciId) {
		ogrenciRepository.deleteById(ogrenciId);
		
	}

	

}
