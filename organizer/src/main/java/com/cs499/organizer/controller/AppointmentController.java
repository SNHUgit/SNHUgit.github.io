package com.cs499.organizer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs499.organizer.entity.Appointment;
import com.cs499.organizer.service.AppointmentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Initialize appointment page
    @GetMapping
    public String appointmentPage(@RequestParam(required = false) String searchAppointment,
            @RequestParam(required = false) String sort,
            Model model) {

        loadAppointmentPageModel(model, searchAppointment, sort, "showAppointment");
        return "appointment";
    }

    // Add Appointment
    @PostMapping("/add")
    public String addAppointment(@Valid @ModelAttribute("newAppointment") Appointment newAppointment,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            loadAppointmentPageModel(model, null, "asc", "addAppointment");
            return "appointment";
        }

        appointmentService.save(newAppointment);
        return "redirect:/appointment";
    }

    // Edit Appointment
    @PostMapping("/edit")
    public String updateAppointment(@RequestParam int id,
            @Valid @ModelAttribute("editAppointment") Appointment editAppointment,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            loadAppointmentPageModel(model, null, "asc", "editAppointment");
            return "appointment";
        }

        Appointment appointment = appointmentService.findById(id);
        appointment.setDescription(editAppointment.getDescription());
        appointment.setDate(editAppointment.getDate());
        appointmentService.save(appointment);

        return "redirect:/appointment";
    }

    // Delete Appointment
    @PostMapping("/delete")
    public String deleteAppointment(@RequestParam int id) {
        appointmentService.deleteById(id);
        return "redirect:/appointment";
    }

    // Loads common model data needed for the appointment page
    private void loadAppointmentPageModel(Model model, String searchAppointment, String sort, String activeTab) {

        if (sort == null || sort.isBlank()) {
            sort = "asc";
        }

        List<Appointment> appointments;

        if (searchAppointment != null && !searchAppointment.isBlank()) {
            appointments = appointmentService.searchAndSortByDescription(searchAppointment, sort);
        } else {
            appointments = appointmentService.findAllSorted(sort);
        }

        model.addAttribute("appointments", appointments);
        model.addAttribute("searchAppointmentValue", searchAppointment);
        model.addAttribute("sort", sort);
        model.addAttribute("activeTab", activeTab);

        if (!model.containsAttribute("newAppointment")) {
            model.addAttribute("newAppointment", new Appointment());
        }

        if (!model.containsAttribute("editAppointment")) {
            model.addAttribute("editAppointment", new Appointment());
        }
    }
}