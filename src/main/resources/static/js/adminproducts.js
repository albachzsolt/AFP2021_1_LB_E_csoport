var modify = false;

fetchProducts();

var addButton = document.getElementById('add-btn');
addButton.onclick = addNewProduct;

function fetchProducts() {
  var url = '/api/products';
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      showDivs(jsonData);
    });
}

function fetchCategories(e){
  var url = '/api/categories';
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      if (modify){
      editItem(jsonData, e.target.id);
      } else {
      showInputFields(jsonData);
      }
    });
}