function loadBudgets() {
    fetch('/api/budgets')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('content');
            content.innerHTML = '<h2>Budgets</h2>';
            let list = '<ul>';
            data.forEach(budget => {
                list += `<li>${budget.amount} - ${budget.category.name} - ${budget.date}</li>`;
            });
            list += '</ul>';
            content.innerHTML += list;
        })
        .catch(error => console.error('Error:', error));
}

// Function to load budget form and handle submission can be added similarly
