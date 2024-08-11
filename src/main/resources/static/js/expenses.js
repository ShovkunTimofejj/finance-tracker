function loadExpenses() {
    fetch('/api/expenses')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('content');
            content.innerHTML = '<h2>Expenses</h2>';
            let list = '<ul>';
            data.forEach(expense => {
                list += `<li>${expense.amount} - ${expense.description} - ${expense.date}</li>`;
            });
            list += '</ul>';
            content.innerHTML += list;
        })
        .catch(error => console.error('Error:', error));
}

// Function to load expense form and handle submission can be added similarly
