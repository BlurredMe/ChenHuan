package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UesrMapper;
import pojo.Uesr;
@Service("us")
public class UesrServiceImp implements UesrService {
	@Autowired
	private UesrMapper uMapper;
	public UesrMapper getuMapper() {
		return uMapper;
	}
	public void setuMapper(UesrMapper uMapper) {
		this.uMapper = uMapper;
	}
	
	public Uesr ax(String userCode) {
		// TODO Auto-generated method stub
		return uMapper.ax(userCode);
	}
	public int dl(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		System.out.println("1111"+uMapper.dl(userCode, userPassword));
		return uMapper.dl(userCode, userPassword);
		
	}
	
	public int uadd(Uesr uesr) {
		// TODO Auto-generated method stub
		return uMapper.uadd(uesr);
	}
	public int udelete(int id) {
		// TODO Auto-generated method stub
		return uMapper.udelete(id);
	}
	public Uesr lUesr(int id) {
		// TODO Auto-generated method stub
		return uMapper.lUesr(id);
	}
	public int uupdate(Uesr uesr) {
		// TODO Auto-generated method stub
		return uMapper.uupdate(uesr);
	}
	public int zong() {
		// TODO Auto-generated method stub
		return uMapper.zong();
	}
	public List<Uesr> getAll(int y, int t) {
		// TODO Auto-generated method stub
		return uMapper.getAll(y, t);
	}
	

}
