package com.example.kishanpracticals.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kishanpracticals.model.ExcelUploadDetail;

@Repository
public interface ExcelUploadDetailRepo extends JpaRepository<ExcelUploadDetail, Integer>{
	
}
