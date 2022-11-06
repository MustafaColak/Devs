package kodlama.io.devs.devs.dataAccess.abstracts;

import kodlama.io.devs.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {
    boolean existsByName(String name);
}
