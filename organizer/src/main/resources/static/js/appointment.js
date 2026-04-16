// Loads appointment data into the edit form.
// Includes:
// - reading button data
// - filling edit fields

function EditAppointmentFromButton(button) {
    document.getElementById("editAppointmentId").value = button.dataset.id;
    document.getElementById("editAppointmentDescription").value = button.dataset.description;
    document.getElementById("editAppointmentDate").value = button.dataset.date;
    showTab("editAppointment");
}