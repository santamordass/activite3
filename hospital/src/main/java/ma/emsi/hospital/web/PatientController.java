package ma.emsi.hospital.web;

import lombok.AllArgsConstructor;
import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page" ,defaultValue = "0") int page,
                                     @RequestParam(name="size",defaultValue = "4") int size,
                                     @RequestParam(name="keyword",defaultValue = "") String kw

    ){
        Page<Patient> patientList=patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients",patientList.getContent());
        model.addAttribute("pages",new int[patientList.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patients";
    }

}
