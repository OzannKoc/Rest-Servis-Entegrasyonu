package com.ogrenci.OgrenciBilgiSistemiApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ogrenci.OgrenciBilgiSistemiApp.entity.Ogrenci;
@RepositoryRestResource(path = "ogrenci")
public interface OgrenciRepository extends JpaRepository<Ogrenci, Integer>{

}
