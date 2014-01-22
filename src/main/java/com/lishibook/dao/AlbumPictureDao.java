package com.lishibook.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lishibook.entity.AlbumPicture;
import com.lishibook.mapper.AlbumPictureMapper;

@Repository
public class AlbumPictureDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteByPrimaryKey(Integer id){
		AlbumPictureMapper albumPictureMapper = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		return albumPictureMapper.deleteByPrimaryKey(id);
	}

	public int insert(AlbumPicture record){
		AlbumPictureMapper albumPictureMapper = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		return albumPictureMapper.insert(record);
	}

	public int insertSelective(AlbumPicture record){
		AlbumPictureMapper albumPictureMapper = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		return albumPictureMapper.insertSelective(record);
	}

	public AlbumPicture selectByPrimaryKey(Integer id){
		AlbumPictureMapper albumPictureMapper = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		return albumPictureMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(AlbumPicture record){
		AlbumPictureMapper albumPictureMapper = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		return albumPictureMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(AlbumPicture record){
		AlbumPictureMapper albumPictureMapper = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		return albumPictureMapper.updateByPrimaryKey(record);
	}
}