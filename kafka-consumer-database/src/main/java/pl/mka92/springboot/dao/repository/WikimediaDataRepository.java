package pl.mka92.springboot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mka92.springboot.dao.model.WikimediaData;

import java.util.UUID;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, UUID> {

}
