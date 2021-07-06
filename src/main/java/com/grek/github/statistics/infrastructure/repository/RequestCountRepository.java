package com.grek.github.statistics.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

interface RequestCountRepository extends JpaRepository<RequestCountEntity, Long> {
}
