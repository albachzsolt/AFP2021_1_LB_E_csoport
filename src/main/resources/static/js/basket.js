window.onload = function () {
  fetchBasket();
};


document.querySelector('#clear-basket').addEventListener('click', function () {
  clearBasket();
});


function fetchBasket() {
  var url = '/basket';
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      showBasket(jsonData);
    });
}


function showBasket(jsonData) {
  var divBasket = document.getElementById('basket-div');
  var sumsDiv = document.querySelector('.sums-div');
  divBasket.innerHTML = '';
  sumsDiv.innerHTML = '';
  divBasket.setAttribute('class', 'container');

  var sumPieces = jsonData.sumPieces;
  var sumPrice = jsonData.sumPrice;


  var sumPiecesDiv = document.createElement('div');
  var sumpriceDiv = document.createElement('div');
  sumPiecesDiv.innerText = `Items in basket: ${sumPieces}`;
  sumpriceDiv.innerText = `Total value: ${sumPrice} Ft`;


  sumPiecesDiv.setAttribute('class', 'div_class');
  sumpriceDiv.setAttribute('class', 'div_class');

  sumsDiv.appendChild(sumPiecesDiv);
  sumsDiv.appendChild(sumpriceDiv);

  var table = document.createElement('table');
  table.setAttribute('class', 'table table-striped');
  divBasket.appendChild(table);

  var trHeading = document.createElement('tr');
  trHeading.setAttribute('class', 'basket-head-row')
  table.appendChild(trHeading);

  var codeTh = document.createElement('th');
  codeTh.innerHTML = 'Product code';
  trHeading.appendChild(codeTh);

  var nameTh = document.createElement('th');
  nameTh.innerHTML = 'Name';
  trHeading.appendChild(nameTh);

  var manufacturerTh = document.createElement('th');
  manufacturerTh.innerHTML = 'Manufacturer';
  trHeading.appendChild(manufacturerTh);

  var priceTh = document.createElement('th');
  priceTh.innerHTML = 'Unit price';
  trHeading.appendChild(priceTh);

  var quantityTh = document.createElement('th');
  quantityTh.innerHTML = 'Quantity';
  trHeading.appendChild(quantityTh);


  for (var i = 0; i < jsonData.basket.basketItems.length; i++) {
    var trRow = document.createElement('tr');
    trRow.setAttribute('class', 'tr-row')

    var codeTd = document.createElement('td');
    codeTd.innerHTML = jsonData.basket.basketItems[i].product.code;
    trRow.appendChild(codeTd);

    var nameTd = document.createElement('td');
    nameTd.innerHTML = jsonData.basket.basketItems[i].product.name;
    trRow.appendChild(nameTd);

    var manufacturerTd = document.createElement('td');
    manufacturerTd.innerHTML = jsonData.basket.basketItems[i].product.manufacturer;
    trRow.appendChild(manufacturerTd);

    var priceTd = document.createElement('td');
    priceTd.innerHTML = jsonData.basket.basketItems[i].product.price + ' Ft';
    trRow.appendChild(priceTd);

    var quantityTd = document.createElement('td');
    quantityTd.innerHTML = jsonData.basket.basketItems[i].pieces;
    quantityTd.setAttribute('id', 'quantityTd' + jsonData.basket.basketItems[i].product.id);
    trRow.appendChild(quantityTd);


    var editSaveButtonTd = document.createElement('td');
    trRow.appendChild(editSaveButtonTd);

    var editBtn = document.createElement('img');
    editSaveButtonTd.appendChild(editBtn);
    editBtn.setAttribute('src', '/img/edit-button.png');
    editBtn['raw-data'] = jsonData.basket.basketItems[i];
    editBtn.addEventListener('click', editBasketItemQuantity);
    editBtn.setAttribute('class', 'button-enabled button edit-button edit-enabled');
    editBtn.setAttribute('id', 'edit' + jsonData.basket.basketItems[i].product.id);

    var saveBtn = document.createElement('img');
    editSaveButtonTd.appendChild(saveBtn);
    saveBtn.addEventListener('click', saveUpdatedItemQuantity);
    saveBtn['raw-data'] = jsonData.basket.basketItems[i];
    saveBtn.setAttribute('src', '/img/save-button.png');
    saveBtn.setAttribute('class', 'button-disabled button save-button save-disabled');
    saveBtn.setAttribute('id', 'save' + jsonData.basket.basketItems[i].product.id);

    var deleteButtonTd = document.createElement('td');
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('id', 'delete-product-basket');
    deleteButton.innerHTML = 'Delete product';
    deleteButton.onclick = deleteFromBasket;
    deleteButton['raw-data'] = jsonData.basket.basketItems[i];
    deleteButtonTd.appendChild(deleteButton);
    trRow.appendChild(deleteButtonTd);


    table.appendChild(trRow);
  }

  fetchFormerShippingAddressList();
}