package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Uesr;

public interface UesrMapper {

	public Uesr ax(@Param("userCode") String userCode);
	
	public int dl(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
	
	public List<Uesr> getAll(@Param("y")int y,@Param("t")int t);
	
	public int uadd(Uesr uesr);
	
	public Uesr lUesr(@Param("id") int id);
	
	public int udelete(@Param("id")int id);
	
	public int uupdate(Uesr uesr);
	
	public int zong();
}
