package MUMOMU.mumomu_project.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class PayController {

    private final IamportClient iamportClient;

    public PayController() {
        this.iamportClient = new IamportClient("7323775351547827",
                "yZVMXr8A76hI0g2b8bkG1PV8zF1oAqyfPqJhDmEFTMo8B5Ah59McAce4LuBIQJxqYGnJZ5H67Lo47ss4");
    }

    @ResponseBody
    @RequestMapping("/verify/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable("imp_uid") String imp_uid)
            throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(imp_uid);
    }
    @Controller
    public class HomeController {

        @GetMapping("/")
        public String home(){
            return "payment";
        }
    }



}
