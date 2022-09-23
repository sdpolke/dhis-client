package com.ezest.dhis2.portal.repository;

import com.ezest.dhis2.portal.entity.DataElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataElementRepository extends JpaRepository<DataElement, String> {
    List<DataElement> findAll();
}
