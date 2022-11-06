package kodlama.io.devs.devs.webApi.controllers;

import kodlama.io.devs.devs.business.abstracts.SubTechnologyService;
import kodlama.io.devs.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.devs.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.devs.devs.business.responses.GetSubTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtechnology")
public class SubTechnologyController {

    private SubTechnologyService subTechnologyService;

    public SubTechnologyController(SubTechnologyService subTechnologyService) {
        this.subTechnologyService = subTechnologyService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
        subTechnologyService.add(createSubTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<GetSubTechnologyResponse> getAll(){
        return subTechnologyService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        subTechnologyService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest){
        subTechnologyService.update(updateSubTechnologyRequest);
    }
}
