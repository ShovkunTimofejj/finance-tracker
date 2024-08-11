function loadReports() {
    fetch('/api/reports')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('content');
            content.innerHTML = '<h2>Reports</h2>';
            let list = '<ul>';
            data.forEach(report => {
                list += `<li>${report.date} - ${report.details}</li>`;
            });
            list += '</ul>';
            content.innerHTML += list;
        })
        .catch(error => console.error('Error:', error));
}

// Function to load report form and handle submission can be added similarly
