package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserinfoDao;
import entity.Userinfo;

@Service
@Transactional
public class Service2 {
	@Autowired
	UserinfoDao dao;
	
	public List<Userinfo> query()
	{
		List<Userinfo> list=dao.query();
		return list;
	}
	public int update(Userinfo userinfo)
	{
		int res=dao.update(userinfo);
		return res;
	}
	
	public Userinfo login(String username,String userpassword)
	{
		Userinfo list=dao.login(username,userpassword);
		return list;
	}
}
