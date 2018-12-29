package com.connext.onlineadmin.repository;

import com.connext.onlineadmin.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    @Query(value = "select a.* from article a left join comment c on c.message_id=a.id group by a.id order by max(c.date)desc,a.date desc",nativeQuery = true)
    List<Article> findAllByOrderByDate();

    //管理员删除用户时根据用户id删除文章
    @Modifying
    @Query(value = "delete from article where user_id=?1",nativeQuery = true)
    void deleteAllByUser_Id(Integer id);
}
