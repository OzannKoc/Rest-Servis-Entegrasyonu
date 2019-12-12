package com.ogrenci.OgrenciBilgiSistemiApp.Service;

import java.util.List;

import com.ogrenci.OgrenciBilgiSistemiApp.entity.Ogrenci;

public interface OgrenciService {
	public List<Ogrenci> getOgrenciList();
	public void saveOgrenci(Ogrenci ogrenci);
	public Ogrenci getOgrenci(int ogrenciId);
	public void deleteOgrenci(int ogrenciId);
	
}
