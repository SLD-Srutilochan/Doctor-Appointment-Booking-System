let doctors = [];

async function loadDoctors() {
  try {
    const res = await fetch("http://localhost:8080/doctors");
    doctors = await res.json();

    if (!Array.isArray(doctors)) {
      console.error("Doctors list is not an array:", doctors);
      return;
    }

    // Group by department
    const departmentMap = {};
    doctors.forEach((doc) => {
      if (!departmentMap[doc.department]) {
        departmentMap[doc.department] = [];
      }
      departmentMap[doc.department].push(doc);
    });

    const select = document.getElementById("doctorList");
    select.innerHTML = '<option value="">-- Select a Doctor --</option>';

    for (const dept in departmentMap) {
      const optGroup = document.createElement("optgroup");
      optGroup.label = dept;

      departmentMap[dept].forEach((doc) => {
        const option = document.createElement("option");
        option.value = doc.id; // ✅ set actual doctor id
        option.textContent = `${doc.name} - ${doc.fromTime} to ${doc.toTime}`;
        optGroup.appendChild(option);
      });

      select.appendChild(optGroup);
    }
  } catch (e) {
    console.error("Error fetching doctors:", e);
  }
}

function showForm() {
  const selected = document.getElementById("doctorList").value;
  if (selected !== "") {
    document.getElementById("patientForm").style.display = "block";
    document.getElementById("confirmation").style.display = "none";
  } else {
    document.getElementById("patientForm").style.display = "none";
  }
}

async function submitAppointment() {
  const doctorId = parseInt(document.getElementById("doctorList").value);
  const selectedDoctor = doctors.find(doc => doc.id === doctorId); // ✅ find by ID

  const appointment = {
    patientName: document.getElementById("patientName").value,
    age: parseInt(document.getElementById("age").value),
    phone: document.getElementById("phone").value,
    address: document.getElementById("address").value,
    reason: document.getElementById("reason").value,
    doctorName: selectedDoctor.name,
    department: selectedDoctor.department,
    time: selectedDoctor.fromTime + " to " + selectedDoctor.toTime
  };

  const res = await fetch("http://localhost:8080/appointments", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(appointment)
  });

  const result = await res.json();

  document.getElementById("refId").innerText = result.referenceId;
  document.getElementById("confName").innerText = result.patientName;
  document.getElementById("confDoctor").innerText = result.doctorName;
  document.getElementById("confDept").innerText = result.department;
  document.getElementById("confTime").innerText = result.time;

  document.getElementById("patientForm").style.display = "none";
  document.getElementById("confirmation").style.display = "block";
}

window.onload = loadDoctors;
