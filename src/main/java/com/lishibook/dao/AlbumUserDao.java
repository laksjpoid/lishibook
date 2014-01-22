package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.AlbumUser;
import com.lishibook.mapper.AlbumUserMapper;

@Repository
public class AlbumUserDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		AlbumUserMapper albumUserMapper = sqlSessionTemplate.getMapper(AlbumUserMapper.class);
		
		return albumUserMapper.deleteByPrimaryKey(id);
	}

	public int insert(AlbumUser record){
		AlbumUserMapper albumUserMapper = sqlSessionTemplate.getMapper(AlbumUserMapper.class);
		
		return albumUserMapper.insert(record);
	}

	public int insertSelective(AlbumUser record){
		AlbumUserMapper albumUserMapper = sqlSessionTemplate.getMapper(AlbumUserMapper.class);
		
		return albumUserMapper.insertSelective(record);
	}

	public AlbumUser selectByPrimaryKey(Integer id){
		AlbumUserMapper albumUserMapper = sqlSessionTemplate.getMapper(AlbumUserMapper.class);
		
		return albumUserMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(AlbumUser record){
		AlbumUserMapper albumUserMapper = sqlSessionTemplate.getMapper(AlbumUserMapper.class);
		
		return albumUserMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(AlbumUser record){
		AlbumUserMapper albumUserMapper = sqlSessionTemplate.getMapper(AlbumUserMapper.class);
		
		return albumUserMapper.updateByPrimaryKey(record);
	}
}