package pl.mka92.springboot.dao.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;

@Setter
@Getter
@Entity
public class WikimediaData {

    @Id
    @Setter(AccessLevel.PRIVATE)
    private UUID id = UUID.randomUUID();

    @Lob
    private String wikimediaEventData;
}
