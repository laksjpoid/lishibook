package com.lishibook.mapper;

import com.lishibook.entity.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Mar 03 21:09:16 CST 2014
     */
    int updateByPrimaryKey(User record);

	User selectByEmail(String email);
}