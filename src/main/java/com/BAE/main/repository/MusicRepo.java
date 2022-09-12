package com.BAE.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BAE.main.entities.Music;

@Repository
public interface MusicRepo extends JpaRepository<Music, Long>{

}
