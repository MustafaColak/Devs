package kodlama.io.devs.devs.business.abstracts;

import kodlama.io.devs.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.devs.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.devs.devs.business.responses.GetSubTechnologyResponse;

import java.util.List;

public interface SubTechnologyService {
    void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
    void delete(int id);
    void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);
    List<GetSubTechnologyResponse> getAll();
}
