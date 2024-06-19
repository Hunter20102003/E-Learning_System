// Thêm chức năng để hiển thị dropdown khi click vào avatar
document.getElementById("avatar").addEventListener("click", function() {
    var dropdownContent = document.getElementById("dropdown-content");
    if (dropdownContent.style.display === "block") {
        dropdownContent.style.display = "none";
    } else {
        dropdownContent.style.display = "block";
    }
});

// Đóng dropdown khi click ra ngoài
window.onclick = function(event) {
    if (!event.target.matches('.avatar')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.style.display === "block") {
                openDropdown.style.display = "none";
            }
        }
    }
}



//CRUD teacher
document.addEventListener("DOMContentLoaded", function() {
    const teachers = [];
    let editIndex = -1;

    const tableBody = document.querySelector("#teachers-table tbody");
    const modal = document.getElementById("teacher-modal");
    const span = document.getElementsByClassName("close")[0];
    const form = document.getElementById("teacher-form");
    const modalTitle = document.getElementById("modal-title");
    const nameInput = document.getElementById("name");
    const subjectInput = document.getElementById("subject");

    document.getElementById("btn-add-teacher").onclick = function() {
        editIndex = -1;
        form.reset();
        modalTitle.textContent = "Add Teacher";
        modal.style.display = "block";
    }

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    form.onsubmit = function(event) {
        event.preventDefault();
        const name = nameInput.value;
        const subject = subjectInput.value;

        if (editIndex === -1) {
            teachers.push({ name, subject });
        } else {
            teachers[editIndex] = { name, subject };
        }

        renderTable();
        modal.style.display = "none";
    }

    function renderTable() {
        tableBody.innerHTML = "";
        teachers.forEach((teacher, index) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${teacher.name}</td>
                <td>${teacher.subject}</td>
                <td>
                    <button onclick="editTeacher(${index})">Edit</button>
                    <button onclick="deleteTeacher(${index})">Delete</button>
                </td>
            `;
            tableBody.appendChild(row);
        });
    }

    window.editTeacher = function(index) {
        editIndex = index;
        const teacher = teachers[index];
        nameInput.value = teacher.name;
        subjectInput.value = teacher.subject;
        modalTitle.textContent = "Edit Teacher";
        modal.style.display = "block";
    }

    window.deleteTeacher = function(index) {
        teachers.splice(index, 1);
        renderTable();
    }
});
