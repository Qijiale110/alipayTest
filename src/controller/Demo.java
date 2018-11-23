package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import service.Service2;
import entity.Userinfo;
@Controller
@RequestMapping(value ="demo")
@SessionAttributes("users")
public class Demo {
	@Autowired
	Service2 service;
	
	@RequestMapping(value="login")
	public String login(Userinfo user,Model model)
	{
		System.out.println("adadawda");
		Userinfo user2=service.login(user.getUsername(), user.getUserpassword());
		System.out.println(user2+"sdas");
		if(user2!=null && !user2.getUsername().equals("")){
			model.addAttribute("users",user2);
			System.out.println(user2);
			return "redirect:/demo/query.do";
		}else{
			return "login";	
		}
	}
	@RequestMapping(value="query")
	public String query(Model model){
		List<Userinfo> list=service.query();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("upload")
	public String upload(MultipartFile photos,Userinfo user) {
		String fileName = photos.getOriginalFilename();
		System.out.println("".equals(fileName));
		System.out.println(null != fileName);
		try {
			if (!"".equals(fileName)) {
				// 1.获取文件后缀
				Integer index = fileName.lastIndexOf(".");
				String suffix = fileName.substring(index);

				// 2.重命名
				String newFileName = UUID.randomUUID().toString() + suffix;

				// 3.获取保存路径(绝对路径,web项目浏览器不能识别绝对路径,加虚拟路径)
				File newfile = new File("D:/upload/" + newFileName);
				System.out.println(newfile);
				// 4.另存为
				photos.transferTo(newfile);
				
				user.setPhoto(newFileName);
				service.update(user);
			}
		} catch (Exception e) {
			return "error";
		}

		return "redirect:/demo/query.do";
	}
}
