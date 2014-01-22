package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.AlbumResource;
import com.lishibook.mapper.AlbumResourceMapper;

@Repository
public class AlbumResourceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		AlbumResourceMapper albumResourceMapper = sqlSessionTemplate.getMapper(AlbumResourceMapper.class);
		
		return albumResourceMapper.deleteByPrimaryKey(id);
	}

	public int insert(AlbumResource record){
		AlbumResourceMapper albumResourceMapper = sqlSessionTemplate.getMapper(AlbumResourceMapper.class);
		
		return albumResourceMapper.insert(record);
	}

	public int insertSelective(AlbumResource record){
		AlbumResourceMapper albumResourceMapper = sqlSessionTemplate.getMapper(AlbumResourceMapper.class);
		
		return albumResourceMapper.insertSelective(record);
	}

	public AlbumResource selectByPrimaryKey(Integer id){
		AlbumResourceMapper albumResourceMapper = sqlSessionTemplate.getMapper(AlbumResourceMapper.class);
		
		return albumResourceMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(AlbumResource record){
		AlbumResourceMapper albumResourceMapper = sqlSessionTemplate.getMapper(AlbumResourceMapper.class);
		
		return albumResourceMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(AlbumResource record){
		AlbumResourceMapper albumResourceMapper = sqlSessionTemplate.getMapper(AlbumResourceMapper.class);
		
		return albumResourceMapper.updateByPrimaryKey(record);
	}
}