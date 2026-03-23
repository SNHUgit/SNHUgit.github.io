function EditAppointmentFromButton(button) {
    document.getElementById("editAppointmentId").value = button.dataset.id;
    document.getElementById("editAppointmentDescription").value = button.dataset.description;
    document.getElementById("editAppointmentDate").value = button.dataset.date;
    showTab("editAppointment");
}