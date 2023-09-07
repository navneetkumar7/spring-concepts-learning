package com.nt.springconcepts.security.oauth2withkeycloak.repository;


import com.nt.springconcepts.security.oauth2withkeycloak.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	//not using derived name method query but using JPQL query(write queries with the help of entity class)
	//@PreAuthorize("hasRole('ROOT')")
	@Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<Notice> findAllActiveNotices();

}
