package com.ogrenci.OgrenciBilgiSistemiApp.Controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ogrenci.OgrenciBilgiSistemiApp.Service.OgrenciService;
import com.ogrenci.OgrenciBilgiSistemiApp.entity.Ogrenci;


@Controller
@RequestMapping("ogrenci")
public class OgrenciController {
	private final String borcOdemeApiUrl="http://localhost:8082/bankaApi/add";
	private static RestTemplate restTemplate = new RestTemplate();
	private List<Ogrenci> ogrenciList;
	@Autowired
	private OgrenciService ogrenciService;


	@GetMapping("/list")
	public String getOgrenciList(Model model) {
		ogrenciList = ogrenciService.getOgrenciList();		
		model.addAttribute("ogrenciList", ogrenciList);
		return "ogrenciler/ogrenci-list";
	}


	
	@GetMapping("/add")
	public String addOgrenci(Model model) {
		Ogrenci ogr = new Ogrenci();
		
		model.addAttribute("ogrenci",ogr);
		return "ogrenciler/ogr-form";
	}
	@PostMapping("/save")
	public String saveOgrenci(@ModelAttribute("ogrenci") Ogrenci ogr) {
		if(ogr.getId()!=null) {
			ogrenciService.saveOgrenci(ogr);
			return"redirect:/ogrenci/list";
		}
		else {
		ogr.setBorcTutari(750);
		ogr.setBorcDurumu("ODENMEDI");
		ResponseEntity<Ogrenci> responseEntity = 
				restTemplate.postForEntity(borcOdemeApiUrl, ogr,Ogrenci.class);
		ogrenciService.saveOgrenci(ogr);
		return "redirect:/ogrenci/list";
		}
	}
	@GetMapping("/update")
	public String showFormUpdate(@RequestParam("ogrenciId") int ogrId,Model model) {
		Ogrenci ogr = ogrenciService.getOgrenci(ogrId);
		model.addAttribute("ogrenci",ogr);
		return"ogrenciler/ogr-form";
	}
	@GetMapping("/delete")
	public String formDelete(@RequestParam("ogrenciId") int ogrId) {
		ogrenciService.deleteOgrenci(ogrId);
		return "redirect:/ogrenci/list";
	}

}
