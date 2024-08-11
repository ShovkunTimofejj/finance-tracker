function loadCategories() {
    fetch('/api/categories')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('content');
            content.innerHTML = '<h2>Categories</h2>';
            let list = '<ul>';
            data.forEach(category => {
                list += `<li>${category.name}</li>`;
            });
            list += '</ul>';
            content.innerHTML += list;
        })
        .catch(error => console.error('Error:', error));
}

// Function to load category form and handle submission can be added similarly
