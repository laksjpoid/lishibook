package com.lishibook.mapper;

import com.lishibook.entity.Pictures;

public interface PicturesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int insert(Pictures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int insertSelective(Pictures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    Pictures selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKeySelective(Pictures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKey(Pictures record);
}