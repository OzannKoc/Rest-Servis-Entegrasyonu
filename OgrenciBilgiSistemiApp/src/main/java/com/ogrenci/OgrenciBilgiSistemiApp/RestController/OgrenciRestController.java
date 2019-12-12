package com.ogrenci.OgrenciBilgiSistemiApp.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogrenci.OgrenciBilgiSistemiApp.Service.OgrenciService;
import com.ogrenci.OgrenciBilgiSistemiApp.entity.Ogrenci;

@RestController
@RequestMapping("ogrenciApi")
public class OgrenciRestController {
	private List<Ogrenci> ogrenciList;
	@Autowired
	private OgrenciService ogrenciService;
	
	@GetMapping("/list")
	public List<Ogrenci> getOgrenciList(){
		ogrenciList = ogrenciService.getOgrenciList();
		return ogrenciList;
	}
	@PutMapping("/update/{id}")
	public Ogrenci updateOgrenci(@RequestBody Ogrenci ogrenci,@PathVariable int id) {
		Ogrenci ogr =null ;
		if(id>0) {
			ogr =ogrenciService.getOgrenci(id);
			ogr.setBorcTutari(ogrenci.getBorcTutari());
			ogr.setBorcDurumu(ogrenci.getBorcDurumu());
			ogrenciService.saveOgrenci(ogr);
		}
		System.out.println("abi güncellemeler tamam");
		return ogrenci ;
	}
	
}
