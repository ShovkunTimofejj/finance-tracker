function loadBankAccounts() {
    fetch('/api/bank-accounts')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('content');
            content.innerHTML = '<h2>Bank Accounts</h2>';
            let list = '<ul>';
            data.forEach(account => {
                list += `<li>${account.bankName} - ${account.accountNumber} - ${account.balance}</li>`;
            });
            list += '</ul>';
            content.innerHTML += list;
        })
        .catch(error => console.error('Error:', error));
}

// Function to load bank account form and handle submission can be added similarly
