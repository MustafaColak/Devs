package kodlama.io.devs.devs.business.concretes;

import kodlama.io.devs.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.devs.business.responses.GetProgrammingLanguageResponse;
import kodlama.io.devs.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        if (createProgrammingLanguageRequest.getName().isEmpty() || createProgrammingLanguageRequest.getName().isBlank()){
            throw new Exception("Name can not be null");
        } else if (programmingLanguageRepository.existsByName(createProgrammingLanguageRequest.getName())) {
            throw new Exception(createProgrammingLanguageRequest.getName() + " already exists");
        }else{
            ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
            programmingLanguage.setName(createProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);
        }
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        if(updateProgrammingLanguageRequest.getName().isEmpty()){
            throw new Exception("Name can not be null");
        } else if (programmingLanguageRepository.existsByName(updateProgrammingLanguageRequest.getName())) {
            throw new Exception(updateProgrammingLanguageRequest.getName() + " already exists");
        }else{
            ProgrammingLanguage programmingLanguage = programmingLanguageRepository
                    .findById(updateProgrammingLanguageRequest.getId())
                    .orElseThrow(() -> new Exception("Id does not exists"));
            programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);
        }
    }

    @Override
    public List<GetProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
        List<GetProgrammingLanguageResponse> getProgrammingLanguageResponses = new ArrayList<>();
        programmingLanguages = programmingLanguageRepository.findAll();

        for (ProgrammingLanguage languages: programmingLanguages ) {
            GetProgrammingLanguageResponse getProgrammingLanguageResponse = new GetProgrammingLanguageResponse();
            getProgrammingLanguageResponse.setId(languages.getId());
            getProgrammingLanguageResponse.setName(languages.getName());
            getProgrammingLanguageResponses.add(getProgrammingLanguageResponse);
        }

        return getProgrammingLanguageResponses;
    }

    @Override
    public GetProgrammingLanguageResponse getById(int id) throws Exception {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).orElseThrow(() -> new Exception("Id does not exists"));
        GetProgrammingLanguageResponse getProgrammingLanguageResponse = new GetProgrammingLanguageResponse();
        getProgrammingLanguageResponse.setId(programmingLanguage.getId());
        getProgrammingLanguageResponse.setName(programmingLanguage.getName());

        return getProgrammingLanguageResponse;
    }

}
