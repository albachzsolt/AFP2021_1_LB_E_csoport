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


function showDivs(jsonData) {
  var divMain = document.getElementById('main_div_adminproducts');
  divMain.innerHTML = '';
  for (var i = 0; i < jsonData.length; i++) {
    var categoryName = document.createElement('div');
    if (jsonData[i].products.length == 1){
    categoryName.innerHTML = jsonData[i].categoryName + '  (1 product)';
    } else{
    categoryName.innerHTML = jsonData[i].categoryName + '  (' + jsonData[i].products.length + ' products)';
    }
    categoryName.setAttribute('class', 'admin-category-names')
    divMain.appendChild(categoryName)

  for (var j = 0; j < jsonData[i].products.length; j++){
    var divRow = document.createElement('div');
    divRow.setAttribute('contenteditable', 'false');
    divRow.setAttribute('id', jsonData[i].products[j].id);
    divRow.setAttribute('class', 'admin-product-div');

    var codeDiv = document.createElement('div');
    codeDiv.innerHTML = jsonData[i].products[j].code;
    codeDiv.setAttribute('class', 'admin-product-code');
    divRow.appendChild(codeDiv);

    var nameDiv = document.createElement('div');
    nameDiv.innerHTML = jsonData[i].products[j].name;
    nameDiv.setAttribute('class', 'admin-product-name');
    divRow.appendChild(nameDiv);

    var addressDiv = document.createElement('div');
    addressDiv.innerHTML = jsonData[i].products[j].address;
    addressDiv.setAttribute('class', 'div_class_admin');
    divRow.appendChild(addressDiv);

    var manufacturerDiv = document.createElement('div');
    manufacturerDiv.innerHTML = jsonData[i].products[j].manufacturer;
    manufacturerDiv.setAttribute('class', 'div_class_admin');
    divRow.appendChild(manufacturerDiv);

    var priceDiv = document.createElement('div');
    priceDiv.innerHTML = jsonData[i].products[j].price + ' Ft';
    priceDiv.setAttribute('class', 'div_class_admin');
    divRow.appendChild(priceDiv);

    var statusDiv = document.createElement('div');
    statusDiv.innerHTML = jsonData[i].products[j].productStatus;
    statusDiv.setAttribute('class', 'admin-product-status status-div');
    divRow.appendChild(statusDiv);

    var categoryDiv = document.createElement('div');
    categoryDiv.innerHTML = jsonData[i].categoryName;
    categoryDiv.setAttribute('class', 'div_class_admin admin-category');
    divRow.appendChild(categoryDiv);

    var buttonsDiv = document.createElement('div');
    buttonsDiv.setAttribute('class', 'div_class_admin admin-product-div')
    buttonsDiv.setAttribute('id', 'buttons-div')

    var deleteBtn = document.createElement('img');
    deleteBtn.setAttribute('src','/img/delete-button.png')
    deleteBtn.setAttribute('id', jsonData[i].products[j].id)
    deleteBtn.addEventListener('click', deleteItem);
    deleteBtn.setAttribute('class', 'button');

    var editBtn = document.createElement('img');
    editBtn.setAttribute('src', '/img/edit-button.png');
    editBtn.setAttribute('id', jsonData[i].products[j].id)
    editBtn.addEventListener('click', (e) => {modify = true; fetchCategories(e)});
    editBtn.setAttribute('class', 'button');

    var saveBtn = document.createElement('img');
    saveBtn.addEventListener('click', saveUpdatedItem);
    saveBtn.setAttribute('id', jsonData[i].products[j].id);
    saveBtn.setAttribute('src', '/img/save-button.png');
    var attribute = 'button-disabled button save-button' + jsonData[i].products[j].id;
    saveBtn.setAttribute('class', attribute);

    divRow.appendChild(deleteBtn);
    divRow.appendChild(editBtn);
    divRow.appendChild(saveBtn);

    divMain.appendChild(divRow);
  }
  var clearerDiv = document.createElement('div');
  clearerDiv.setAttribute('class', 'clearer');
  divMain.appendChild(clearerDiv);
    }
}

function deleteItem() {
  var id = this.id;

  if (!confirm('Are you sure to delete?')) {
    return;
  }

  fetch('/api/product/' + id, {
    method: 'DELETE'
  })
    .then(function (response) {
        return response.json();
        })
    .then(function(jsonData){
        if (jsonData.response == 'SUCCESS'){
            fetchProducts();
            document.getElementById('message-div').innerHTML = jsonData.message;
            document.getElementById('message-div').setAttribute('class', 'alert alert-success');
        }else{
            document.getElementById('message-div').innerHTML = 'This product is already deleted.';
            document.getElementById('message-div').setAttribute('class', 'alert alert-danger');
        }
    });
    return false;
}