package io.mosip.idrepository.credentialsfeeder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.mosip.idrepository.credentialsfeeder.entity.CredentialRequestStatusEntity;

/**
 * The Interface CredentialRequestStatusRepository.
 *
 * @author Loganathan Sekar
 */
public interface CredentialRequestStatusRepository extends JpaRepository<CredentialRequestStatusEntity, Long> {
	
	@Query(value = "Select new CredentialRequestStatusEntity( individualId, idExpiryDtimes, idTransactionLimit, tokenId, partnerId ) "
			+ "from CredentialRequestStatusEntity crs "
			+ "where crs.status=:status")
	Page<CredentialRequestStatusEntity> findByRequestedStatusOrderByCrdtimes(@Param("status")String status, Pageable pageable);
}
