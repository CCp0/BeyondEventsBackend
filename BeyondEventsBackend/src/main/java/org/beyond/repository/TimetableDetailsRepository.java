package org.beyond.repository;

import org.beyond.model.TimetableDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimetableDetailsRepository extends JpaRepository<TimetableDetailsEntity, UUID> {
}