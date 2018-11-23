package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Userinfo;

public interface UserinfoDao {
	@Select("select * from userinfo")
	public List<Userinfo> query();
	
	@Select("select * from userinfo where username=#{param1} and userpassword=#{param2}")
	public Userinfo login(String username,String userpassword);
	
	@Update("update userinfo set photo=#{photo} where userid=#{userid}")
	int update(Userinfo userinfo);
}
