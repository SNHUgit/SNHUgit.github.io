// Loads contact data from selected edit button into edit form
function EditContactFromButton(button) {
    document.getElementById("editContactId").value = button.dataset.id;
    document.getElementById("editContactFirstName").value = button.dataset.firstName;
    document.getElementById("editContactLastName").value = button.dataset.lastName;
    document.getElementById("editContactNumber").value = button.dataset.number;
    document.getElementById("editContactAddress").value = button.dataset.address;
    showTab("editContact");
}