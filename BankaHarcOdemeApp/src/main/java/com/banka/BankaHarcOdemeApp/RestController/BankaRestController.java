package com.banka.BankaHarcOdemeApp.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banka.BankaHarcOdemeApp.Service.BankaService;
import com.banka.BankaHarcOdemeApp.entity.Banka;

@RestController
@RequestMapping("bankaApi")
public class BankaRestController {
	private List<Banka> borcluList;
	@Autowired
	private BankaService bankaService;

	@GetMapping("/list")
	public List<Banka> getMusteriList(){
		borcluList = bankaService.getMusteriList();
		return borcluList;
	}
	@PostMapping("/add")
	public Banka addMusteri(@RequestBody Banka musteri){
		bankaService.saveMusteri(musteri);
		System.out.println("evet ekledim abi adamı");
		return musteri;
	}
}
