getCategories();

function getCategories() {
    fetch('/api/categories')
        .then(response => response.json())
        .then(json => showCategories(json));
}

function showCategories(jsonData) {
    var ul = document.getElementById('sortable');
    ul.innerHTML = '';
    for (const key in jsonData) {
        if (jsonData.hasOwnProperty(key)) {
            const e = jsonData[key];
            var id = jsonData[key].id;
            var liId = 'li-' + id;
            ul.innerHTML += `
      <li id=${liId}>
      <img src="img/dragNdrop.png" alt="dragNdrop" class="handle" height="25">
      <label>${e.sequence}</label>
      <label contenteditable="true">${e.categoryName}</label>
      <img id=${id} src="/img/delete-button.png" onclick="deleteCategory()" class='category-delete'>
      </li>
      `;
        }
    }
}
