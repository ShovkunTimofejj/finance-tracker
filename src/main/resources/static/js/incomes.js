function loadIncomes() {
    fetch('/api/incomes')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('content');
            content.innerHTML = '<h2>Incomes</h2>';
            let list = '<ul>';
            data.forEach(income => {
                list += `<li>${income.amount} - ${income.source} - ${income.date}</li>`;
            });
            list += '</ul>';
            content.innerHTML += list;
        })
        .catch(error => console.error('Error:', error));
}

// Function to load income form and handle submission can be added similarly
