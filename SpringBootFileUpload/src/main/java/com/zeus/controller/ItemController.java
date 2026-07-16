package com.zeus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.List;
import java.util.UUID;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.commons.io.IOUtils;
import org.apache.el.parser.BooleanNode;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item;
import com.zeus.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
public class ItemController {

	@Autowired
	private ItemService service;

	@Value("${upload.path}")
	private String uploadPath;

	@RequestMapping(value = "/item/insertForm", method = RequestMethod.GET)

	public String iteminsertForm(Item item, Model model) throws Exception {

		return "item/insertForm";

	}

	@RequestMapping(value = "/item/insert", method = RequestMethod.POST)

	public String iteminsert(Item item, Model model) throws Exception {

		// 1. 파일을 가져온다

		MultipartFile file = item.getPicture();

		// 파일명에 중복되지 않는 파일명을 만들고, 그 파일에 원본파일에 내용을 복사하고, 중복되지 않는 파일명을 리턴받는다.
		String createdFiString = uploadFile(file.getOriginalFilename(), file.getBytes());
		item.setPictureUrl(createdFiString);
		Boolean result = service.insert(item);
		if (result == false) {
			return "item/fail";
		}
		return "item/success";
	}

	@RequestMapping(value = "/item/list", method = RequestMethod.GET)
	public String list(Item item, Model model) throws Exception {
		List<Item> list = service.list();
		model.addAttribute("List", list);
		return "item/list";
	}

	// File upload 삭제화면 요청
	@RequestMapping(value = "/item/deleteForm", method = RequestMethod.GET)
	public String itemDeleteForm(Item item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item/deleteForm";
	}

	@RequestMapping(value = "/item/updateForm", method = RequestMethod.GET)
	public String itemupdateForm(Item item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item/updateForm";
	}

	// File upload 삭제 요청
	@RequestMapping(value = "/item/update", method = RequestMethod.POST)
	public String itemupdate(Item item, Model model) throws Exception {
		// 1. 사용자가 선택한 파일 가죠온다
		MultipartFile file = item.getPicture();
		String oldFileName = item.getPictureUrl();
		// 2. 사용자가 새로운 파일을 선택했는지 점검
		if (file != null && file.getSize() > 0) {
			// 파일명에 중복되지 않는 파일명을 만들고, 그 파일에 원본파일에 내용을 복사하고, 중복되지 않는 파일명을 리턴받는다.
			String createdFiString = uploadFile(file.getOriginalFilename(), file.getBytes());
			item.setPictureUrl(createdFiString);
			if(oldFileName != null) {
				File _file = new File(uploadPath + File.separator + oldFileName);
				 if(_file.exists()) {
					 _file.delete();
				 }
				
			}

		} else {

		}
		//3.업데이트
		boolean result = service.update(item);
		if (result == true) {
			return "item/success";
		} else {
			return "item/fail";
		}

	}

	// File upload 삭제 요청
	@RequestMapping(value = "/item/delete", method = RequestMethod.POST)
	public String itemDelete(Item item, Model model) throws Exception {
		// 1. 삭제할 외장스토리지 저장되어 있는 테이블에서 가져온다.
		item = service.select(item);
		String createFileName = item.getPictureUrl();
		if (createFileName != null) {
			File file = new File(uploadPath + File.separator + createFileName);
			if (file.exists() == true) {
				file.delete();
			}
		}

		boolean result = service.delete(item);
		if (result == true) {
			return "item/success";
		} else {
			return "item/fail";
		}

	}

	// 요청한 이미지를 responsebody방식으로 전송요청하기
	@RequestMapping(value = "/item/display", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> display(Item item, Model model) throws Exception {
		// 이미지 파일을 BYTE 만들어서 클라한테 전송 => FILE
		// board 객체=>json클라로 전송
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		item = service.select(item);
		String createFileName = item.getPictureUrl();
		int index = createFileName.lastIndexOf(".");
		try {
			String formaName = createFileName.substring(index + 1);

			MediaType mediaType = null;
			switch (formaName.toUpperCase()) {
			case "JPG":
				mediaType = MediaType.IMAGE_JPEG;
				break;
			case "GIF":
				mediaType = MediaType.IMAGE_GIF;
				break;
			case "PNG":
				mediaType = MediaType.IMAGE_PNG;
				break;
			default:
				mediaType = null;
				break;
			}

			// 5. httpheaders
			HttpHeaders httpHeaders = new HttpHeaders();

			// 6. 외장하드에 있는 파일 읽어 오기
			in = new FileInputStream(uploadPath + File.separator + createFileName);

			// 7.미디어 타입
			if (mediaType != null) {
				httpHeaders.setContentType(mediaType);
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), httpHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		// 중복되지 않는 id 만듬!!! 7c547e42-3079-4b58-bf91-33fc7d139cfc_

		UUID uid = UUID.randomUUID();

		// 7c547e42-3079-4b58-bf91-33fc7d139cfc__홍길동.JPG

		String createdFileName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, createdFileName);

		FileCopyUtils.copy(fileData, target);

		return createdFileName;

	}

}
