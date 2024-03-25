package pc.ApiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pc.Data.PaperRepository;
import pc.Model.Paper;
import pc.Service.PaperService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRejectedController {
    
    @Autowired
    private PaperService paperService;
    
    @Autowired
    private PaperRepository paperRepository;

    @GetMapping("/rejectedpapers")
    public List<Paper> getAllRejectedPapers() {
        return paperService.getPapersByStatus("rejected");
    }
}