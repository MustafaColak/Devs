package kodlama.io.devs.devs.dataAccess.abstracts;

import kodlama.io.devs.devs.entities.concretes.SubTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology,Integer> {
}
