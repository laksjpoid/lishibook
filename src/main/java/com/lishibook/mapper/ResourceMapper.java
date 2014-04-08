package com.lishibook.mapper;

import java.util.List;

import com.lishibook.entity.Resource;

public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    Resource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKeyWithBLOBs(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKey(Resource record);
    
    List<Resource> search(String key);
}