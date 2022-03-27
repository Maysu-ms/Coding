package springmvc_testing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@Autowired
	ServletContext context;
	public static final String SAVE_LOCATION = "E:\\Java EE Workspace for Spring\\springmvc_testing_FileUpload\\temp\\";
	

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public ModelAndView inputFile() {
		return new ModelAndView("inputfile", "fileUpload", new FileModel());
	}

	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.POST)
	public String fileUpload1(@ModelAttribute("fileUpload") @Validated FileModel file, BindingResult bs, ModelMap map)
			throws IOException {
		if (bs.hasErrors()) {
			return "inputfile";
		} else {
			MultipartFile multipartFile = file.getFile();
			String fileName = multipartFile.getOriginalFilename();
			Path path = Paths.get(SAVE_LOCATION + fileName);
			
			InputStream input=Thread.currentThread().getContextClassLoader().getResourceAsStream("temp/Admin Blone.jpg");
			String uploadFile=new File("view/Admin Blone.jpg").getAbsolutePath();
			
			System.out.print(uploadFile);
			if (multipartFile != null && !multipartFile.isEmpty()) {
				try {
					multipartFile.transferTo(new File(path.toString()));

				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("Image Can't be upload!");
				}

			}
			map.addAttribute("fileName", fileName);
			return "success";
		}
	}

}
