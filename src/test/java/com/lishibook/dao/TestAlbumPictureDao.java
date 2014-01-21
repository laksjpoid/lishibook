package com.lishibook.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lishibook.entity.AlbumPicture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class TestAlbumPictureDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	public void selectByPrimaryKey(){
		AlbumPictureMapper albumPictureDao = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		AlbumPicture albumPicture = albumPictureDao.selectByPrimaryKey(1);
		
		Assert.assertTrue(albumPicture.getFilename().equalsIgnoreCase("abc.jpeg"));
		Assert.assertTrue(!albumPicture.getFilename().equalsIgnoreCase("abc.jeg"));
	}
	
	@Test
	public void insert(){
		AlbumPictureMapper albumPictureDao = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		AlbumPicture albumPicture = new AlbumPicture();
		albumPicture.setFilename("helloworld");
		albumPicture.setFiletype("jpeg");
		albumPicture.setFilesize(0);
		albumPicture.setUid(0);
		albumPicture.setVisible(1);
		albumPicture.setDownloads(0);
		
		albumPictureDao.insert(albumPicture);
		albumPictureDao.selectByPrimaryKey(albumPicture.getId());
	}
	
	@Test
	public void updateByPrimaryKey(){
		AlbumPictureMapper albumPictureDao = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		AlbumPicture albumPicture = albumPictureDao.selectByPrimaryKey(1);
		
		albumPicture.setDescription("my description");
		
		albumPictureDao.updateByPrimaryKey(albumPicture);
		
		albumPicture = albumPictureDao.selectByPrimaryKey(1);
		
		Assert.assertEquals(albumPicture.getDescription(), "my description");
	}
	
	@Test
	public void deleteByPrimaryKey(){
		AlbumPictureMapper albumPictureDao = sqlSessionTemplate.getMapper(AlbumPictureMapper.class);
		
		albumPictureDao.deleteByPrimaryKey(6);

		AlbumPicture albumPicture = albumPictureDao.selectByPrimaryKey(6);
		
		Assert.assertEquals(albumPicture, null);
	}
}
