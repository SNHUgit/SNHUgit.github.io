// Function to create tabs, pass in the tab to load as tabId
function showTab(tabId) {
    
    // Find all tabcontent classes in template HTML pages
    const sections = document.querySelectorAll(".tabcontent");
    
    // Hide all tabcontent classes from being displayed
    sections.forEach(section => section.style.display = "none");
    
    // If no tabId was passed in, stop the function
    if (!tabId) {
        return;
    }
    
    // Find tabId passed in and display it
    const selectedTab = document.getElementById(tabId);
    if (selectedTab) {
        selectedTab.style.display = "block";
    }
}

// When page loads, reopen active tab if one was provided
window.onload = function () {
    const activeTabField = document.getElementById("activeTab");
    
    if (activeTabField && activeTabField.value) {
        showTab(activeTabField.value);
    }
};