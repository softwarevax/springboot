package com.wit.ctw.basic.web.mapper.sc;

import com.wit.ctw.basic.web.entity.sc.Book;
import com.wit.ctw.basic.web.entity.sc.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int countByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int deleteByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int insertSelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    List<Book> selectByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    Book selectByPrimaryKey(String bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_book
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Book record);
}