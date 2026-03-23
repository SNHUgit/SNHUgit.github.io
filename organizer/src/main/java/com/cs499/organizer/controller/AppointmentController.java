package com.cs499.organizer.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs499.organizer.IdGenerator;
import com.cs499.organizer.model.Appointment;
import com.cs499.organizer.service.AppointmentService;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService = new AppointmentService();

    // Initialize appointment page
    @GetMapping("/appointment")
    public String appointmentPage(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointment());
        model.addAttribute("appointmentSearchResults", new ArrayList<Appointment>());
        return "appointment";
    }

    // Adds new Appointment
    @PostMapping("/appointment/add")
    public String addAppointment(@RequestParam String addAppointmentDescription,
                                 @RequestParam String addAppointmentDate,
                                 Model model) {

        // Creates and adds new appointment
        Appointment newAppointment = new Appointment(
                IdGenerator.getNewAppointmentId(appointmentService.getAllAppointment()),
                addAppointmentDescription,
                addAppointmentDate);

        appointmentService.add(newAppointment);

        // Updates appointment list
        model.addAttribute("appointments", appointmentService.getAllAppointment());
        model.addAttribute("appointmentSearchResults", new ArrayList<Appointment>());
        return "appointment";
    }

    // Edit Appointment
    @PostMapping("/appointment/edit")
    public String updateAppointment(@RequestParam String id,
                                    @RequestParam String editAppointmentDescription,
                                    @RequestParam String editAppointmentDate) {

        // Updates Appointment Service
        appointmentService.updateAppointment(id, editAppointmentDescription, editAppointmentDate);
        return "redirect:/appointment";
    }

    // Delete Appointment
    @PostMapping("/appointment/delete")
    public String deleteAppointment(@RequestParam String id) {
        appointmentService.delete(id);
        return "redirect:/appointment";
    }

    // Search Appointment
    @GetMapping("/appointment/search")
    public String searchAppointment(@RequestParam String searchAppointment, Model model) {
        // Refresh appointment list
        model.addAttribute("appointments", appointmentService.getAllAppointment());

        model.addAttribute("appointmentSearchResults",
                appointmentService.descriptionSearch(searchAppointment));
        model.addAttribute("searchAppointmentValue", searchAppointment);

        // Stay in current tab
        model.addAttribute("activeTab", "searchAppointment");
        return "appointment";
    }
}