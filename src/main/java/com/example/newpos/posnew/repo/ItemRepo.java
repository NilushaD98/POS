package com.example.newpos.posnew.repo;

import com.example.newpos.posnew.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface ItemRepo extends JpaRepository<Item,Integer> {


    List<Item> findAllByActiveStateEquals(boolean status);

    int countAllByActiveStateEquals(boolean state);

    Page<Item> findAllByActiveStateEquals(boolean state, Pageable of);
}
