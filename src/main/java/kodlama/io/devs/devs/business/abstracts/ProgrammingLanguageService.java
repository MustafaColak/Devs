package kodlama.io.devs.devs.business.abstracts;

import kodlama.io.devs.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.devs.business.responses.GetProgrammingLanguageResponse;
import kodlama.io.devs.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
    void delete(int id);
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
    List<GetProgrammingLanguageResponse> getAll();
    GetProgrammingLanguageResponse getById(int id) throws Exception;
}
