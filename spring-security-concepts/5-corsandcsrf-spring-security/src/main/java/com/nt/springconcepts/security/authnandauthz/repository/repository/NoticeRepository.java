package com.nt.springconcepts.security.authnandauthz.repository.repository;

import java.util.List;

import com.nt.springconcepts.security.authnandauthz.repository.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	//not using derived name method query but using JPQL query(write queries with the help of entity class)
	@Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<Notice> findAllActiveNotices();

}
