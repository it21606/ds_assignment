package com.distributedsystems.web;

import com.distributedsystems.helpers.Helpers;
import com.distributedsystems.model.Application;
import com.distributedsystems.service.ApplicationService;
import com.distributedsystems.web.viewmodel.ApplicationViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edit/application")
public class EditApplicationController {

    private final ApplicationService _applicationService;

    public EditApplicationController(ApplicationService applicationService) {
        this._applicationService = applicationService;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView showEditApplication(@PathVariable("id") int id, Model model) {
        ApplicationViewModel application = Map(_applicationService.findById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("applicationModel", application);
        modelAndView.setViewName("editapplication");
        return modelAndView;
    }


//    @RequestMapping(value = "/acceptApplication/{id}", method = RequestMethod.POST)
//    public ModelAndView deleteUser(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView();
//        if (id != null) {
//            _applicationService.(id);
//            modelAndView.setViewName("redirect:/listusers?userDeleted");
//            return modelAndView;
//        } else {
//            modelAndView.setViewName("redirect:/edituser/" + id + "?userDeleted");
//            return modelAndView;
//        }
//    }


    //    @PostMapping("/{id}")
//    public ModelAndView editApplicationAction(@ModelAttribute("user") ApplicationViewModel applicationViewModel, HttpServletRequest request, @PathVariable Integer id,
//                                       BindingResult bindingResult) throws Exception {
//        applicationViewModel.setId(id);
//        _applicationService.update(applicationViewModel);
//
//        if (applicationViewModel == null) {
//            throw new NotFoundException("Not found user with ID " + id);
//        }
//
//        ModelAndView modelAndView = new ModelAndView();
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("edituser");
//
//            return modelAndView;
//        } else {
//            modelAndView.addObject("user", applicationViewModel);
//            modelAndView.setViewName("redirect:/edit/" + applicationViewModel.getId() + "?success");
//            return modelAndView;
//        }
//    }
    public ApplicationViewModel Map(Application application) {
        ApplicationViewModel applicationViewModel = new ApplicationViewModel();
        if (application != null) {
            applicationViewModel.setUserId(application.getUserId());
            applicationViewModel.setUserInfo(application.getUserInfo());
            applicationViewModel.setId(application.getId());
            applicationViewModel.setBothParentsUnemployedDisplay(Helpers.booleanStatusMap.get(application.isBothParentsUnemployed()));
            applicationViewModel.setStatusDisplay(Helpers.statusStatusMap.get(application.getStatus()));
            applicationViewModel.setHasSiblingsDisplay(Helpers.booleanStatusMap.get(application.isHasSiblings()));
            applicationViewModel.setCollectedPoints(application.getCollectedPoints());
            applicationViewModel.setIncome(application.getIncome());
            applicationViewModel.setHasSiblingsInOtherCitiesDisplay(Helpers.booleanStatusMap.get(application.isHasSiblingsInOtherCities()));
        }
        return applicationViewModel;
    }
}
