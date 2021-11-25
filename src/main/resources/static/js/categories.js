getCategories();

function getCategories() {
    fetch('/api/categories')
        .then(response => response.json())
        .then(json => showCategories(json));
}
