package kodlama.io.devs.devs.business.concretes;

import kodlama.io.devs.devs.business.abstracts.SubTechnologyService;
import kodlama.io.devs.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.devs.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.devs.devs.business.responses.GetSubTechnologyResponse;
import kodlama.io.devs.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.devs.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.devs.entities.concretes.SubTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTechnologyManager implements SubTechnologyService {

    private SubTechnologyRepository subTechnologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
        this.subTechnologyRepository = subTechnologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createSubTechnologyRequest.getProgrammingLanguageId())
                .orElseThrow(() -> new Exception("Programming language id does not exists"));

        SubTechnology subTechnology = new SubTechnology();
        subTechnology.setName(createSubTechnologyRequest.getName());
        subTechnology.setProgrammingLanguage(programmingLanguage);
        subTechnologyRepository.save(subTechnology);
    }

    @Override
    public void delete(int id) {
        subTechnologyRepository.deleteById(id);
    }

    @Override
    public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateSubTechnologyRequest.getProgrammingLanguageId())
                .orElse(null);
        SubTechnology subTechnology = subTechnologyRepository.findById(updateSubTechnologyRequest.getId()).orElse(null);
        subTechnology.setName(updateSubTechnologyRequest.getName());
        subTechnology.setProgrammingLanguage(programmingLanguage);
        subTechnologyRepository.save(subTechnology);
    }

    @Override
    public List<GetSubTechnologyResponse> getAll() {
        List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
        List<GetSubTechnologyResponse> getSubTechnologyResponses = new ArrayList<>();

        for (SubTechnology subTechnology : subTechnologies) {
            GetSubTechnologyResponse getSubTechnologyResponse = new GetSubTechnologyResponse();
            getSubTechnologyResponse.setId(subTechnology.getId());
            getSubTechnologyResponse.setName(subTechnology.getName());
            getSubTechnologyResponse.setProgrammingLanguageId(subTechnology.getProgrammingLanguage().getId());
            getSubTechnologyResponses.add(getSubTechnologyResponse);
        }

        return getSubTechnologyResponses;
    }
}
