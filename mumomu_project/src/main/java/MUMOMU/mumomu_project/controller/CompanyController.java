package MUMOMU.mumomu_project.controller;

import MUMOMU.mumomu_project.domain.Address;
import MUMOMU.mumomu_project.domain.Company;
import MUMOMU.mumomu_project.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping(value="/new")
    @ResponseBody
    public CompanyForm createForm(Model model){
        return new CompanyForm();
    }

    @PostMapping(value="/new")
    @ResponseBody
    public JsonResponse create (CompanyForm form, BindingResult result){
        if(result.hasErrors()){
            return new JsonResponse("error");
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode(), form.getDetails());
        Company company = new Company();
        company.setCompanyName(form.getCompanyName());
        company.setAddress(address);

        companyService.join(company);

        return new JsonResponse("success");
    }

}
