package com.banka.BankaHarcOdemeApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.banka.BankaHarcOdemeApp.Service.BankaService;
import com.banka.BankaHarcOdemeApp.entity.Banka;

@Controller
@RequestMapping("banka")
public class BankaController {
	private final String borcOdemeApiUrl = "http://localhost:8084/ogrenciApi/update/{id}";
	private static RestTemplate restTemplate = new RestTemplate();
	private List<Banka> borcluList;
	@Autowired
	private BankaService bankaService;


	@GetMapping("/list")
	public String getMusteriList(Model model) {
		borcluList = bankaService.getMusteriList();

		
		model.addAttribute("borcluList", borcluList);
		return "musteri-list";
	}

	@GetMapping("/odeme")
	public String odemeYap(@ModelAttribute("musteriId") int musteriId) {

		Banka musteri = bankaService.getMusteri(musteriId);
		if (musteri.getBorcDurumu().toUpperCase().contains("ODENMEDI")) {
			musteri.setBorcTutari(0);
			musteri.setBorcDurumu("ÖDENDİ");
			restTemplate.put(borcOdemeApiUrl, musteri,musteriId);
			bankaService.saveMusteri(musteri);
			return "redirect:/banka/list";
		} else

			return "redirect:/banka/list";

	}

}
