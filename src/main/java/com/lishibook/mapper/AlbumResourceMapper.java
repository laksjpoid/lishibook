package com.lishibook.mapper;

import com.lishibook.entity.AlbumResource;

public interface AlbumResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table album_resource
     *
     * @mbggenerated Wed Jan 22 15:32:02 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table album_resource
     *
     * @mbggenerated Wed Jan 22 15:32:02 CST 2014
     */
    int insert(AlbumResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table album_resource
     *
     * @mbggenerated Wed Jan 22 15:32:02 CST 2014
     */
    int insertSelective(AlbumResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table album_resource
     *
     * @mbggenerated Wed Jan 22 15:32:02 CST 2014
     */
    AlbumResource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table album_resource
     *
     * @mbggenerated Wed Jan 22 15:32:02 CST 2014
     */
    int updateByPrimaryKeySelective(AlbumResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table album_resource
     *
     * @mbggenerated Wed Jan 22 15:32:02 CST 2014
     */
    int updateByPrimaryKey(AlbumResource record);
}