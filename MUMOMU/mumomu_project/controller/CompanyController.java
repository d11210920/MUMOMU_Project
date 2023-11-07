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

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping(value="/company/new")
    public String createForm(Model model){
        model.addAttribute("companyFrom", new CompanyForm());
        return "company/createCompanyForm";
    }

    @PostMapping(value="company/new")
    public String create (CompanyForm form, BindingResult result){
        if(result.hasErrors()){
            return "company/createCompanyForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode(), form.getDetails());
        Company company = new Company();
        company.setCompanyName(form.getCompanyName());
        company.setAddress(address);

        companyService.join(company);

        return "redirect:/";
    }

}
