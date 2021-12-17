var actProduct;
var actRates;
fetchProduct();


function fetchProduct() {
  var address = (new URL(document.location)).searchParams.get("address");
  var url = "api/product/" + address;
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      if (jsonData.response == 'FAILED') {
        showProductNotFound(jsonData);
      } else {
        actProduct = jsonData;
        showTable(jsonData);
      }
    })
  return false;
}

function fetchRates() {
  var url = "/api/rating/list/" + actProduct["products"][0]["id"];
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      actRates = jsonData;
      showRates();
      fetchAvg();
      showRatesForUserIfExists();
    });
  return false;
}

function showRatesForUserIfExists() {
  var url = "/api/rating/" + actProduct["products"][0]["id"]
  fetch(url)
    .then(response => response.json())
    .then(jsonData => fillRate(jsonData))
}

function fillRate(jsonData) {
  createRatingDiv();
  var keys = Object.keys(jsonData);
  if (jsonData[keys[0]].response === "SUCCESS") {
    var stars = jsonData[keys[1]].stars;
    var message = jsonData[keys[1]].message;
    document.querySelector("#formId #star-" + stars).setAttribute("checked", "true");
    document.getElementById("message_text").value = message;
  }
}

function showTable(jsonData) {
  var table = document.getElementById("product-table");

  var tbody = document.createElement('tbody');
  tbody.setAttribute('class', 'product-body');
  table.appendChild(tbody);

  var trDetail = document.createElement('tr');
  tbody.appendChild(trDetail);

  var tdLeft = document.createElement('td');
  trDetail.appendChild(tdLeft);
  tdLeft.setAttribute('class', 'td-left');

  var link = document.createElement('div');
  link.addEventListener('click', goBack);
  link.innerHTML = 'Back to main menu';
  link.setAttribute('class', 'product-category link');
  tdLeft.appendChild(link);

  var categoryDiv = document.createElement('div');
  categoryDiv.innerText = jsonData.categoryName;
  categoryDiv.setAttribute('class', 'product-category');
  tdLeft.appendChild(categoryDiv);

  var span = document.createElement('span');
  span.innerHTML = ' / ' + jsonData.products[0].name;
  categoryDiv.appendChild(span);

  var productImg = document.createElement('img');
  productImg.setAttribute('class', 'product-img')
  productImg.setAttribute('src', '/img/products/' + jsonData.products[0].address + '.jpg')
  productImg.setAttribute('alt', '');
  tdLeft.appendChild(productImg);

  var tdRight = document.createElement('td');
  tdRight.setAttribute('class', 'td-right')
  trDetail.appendChild(tdRight);

  var inputField = document.createElement('input');
  inputField.setAttribute('class', 'purchase-quantity');
  inputField.setAttribute('type', 'number');
  inputField.setAttribute('name', 'quantity');
  inputField.setAttribute('id', 'quantity');
  inputField.setAttribute('min', '1');
  inputField.setAttribute('value', '1');
  tdRight.appendChild(inputField);

  var button = document.createElement('button');
  button.setAttribute('class', 'purchase add-to-cart');
  button.setAttribute('id', 'purchase');
  button.innerHTML = 'Add to cart';
  tdRight.appendChild(button);

  var nameDiv = document.createElement('div');
  nameDiv.innerText = jsonData.products[0].name;
  nameDiv.setAttribute('class', 'product-name');
  tdRight.appendChild(nameDiv);

  var avgDiv = document.createElement('div');
  avgDiv.setAttribute('class', 'avg');
  avgDiv.setAttribute('id', 'avg_product');
  tdRight.appendChild(avgDiv);

  var categoryDiv2 = document.createElement('div');
  categoryDiv2.innerText = jsonData.categoryName;
  categoryDiv2.setAttribute('class', 'category');
  tdRight.appendChild(categoryDiv2);

  var manufacturerDiv = document.createElement('div');
  manufacturerDiv.setAttribute('class', 'product-man');
  manufacturerDiv.innerText = 'by ' + jsonData.products[0].manufacturer;
  tdRight.appendChild(manufacturerDiv);

  var codeDiv = document.createElement('div');
  codeDiv.setAttribute('class', 'product-code');
  codeDiv.innerText = jsonData.products[0].code;
  tdRight.appendChild(codeDiv);

  var priceDiv = document.createElement('div');
  priceDiv.setAttribute('class', 'product-price');
  priceDiv.innerText = jsonData.products[0].price + ' Ft';
  tdRight.appendChild(priceDiv);

  document.querySelector('#purchase').addEventListener('click', function () {
    addToBasket(jsonData);
  });

  createRatingDiv(jsonData);

  fetchRates(jsonData);
}

function sendRate() {
  var numOfStars = 0;
  var stars = document.getElementById('formId').getElementsByTagName('input');
  for (let i = 0; i < stars.length; i++) {
    if (stars[i]["checked"]) {
      numOfStars = 5 - (i);
      break;
    }
  }
  if (numOfStars > 0) {
    var message = document.getElementById('message_text').value;
    var request = {
      'id': actProduct["id"],
      'stars': numOfStars,
      'message': message,
      'date': null,
      'user': null,
      'product': actProduct["products"][0]
    };

    fetch('/api/rating/userrating/' + actProduct["products"][0]["id"], {
        method: 'POST',
        body: JSON.stringify(request),
        headers: {
          'Content-type': 'application/json'
        }
      })
      .then(function (response) {
        return response.json();
      })
      .then(function (jsonData) {
        if (jsonData.response === "SUCCESS") {
          document.getElementById('message-div').setAttribute('class', 'alert alert-success');
          fetchRates();
        } else {
          document.getElementById('message-div').setAttribute('class', 'alert alert-danger');
        }
        document.getElementById('message-div').innerHTML = jsonData.message;
      })
    document.getElementById('message_text').value = "";
  } else {
    document.getElementById('message-div').setAttribute('class', 'alert alert-danger');
    document.getElementById('message-div').innerHTML = "Please select from the stars before rate!";
  }
}

function fetchAvg() {
  var url = "/api/rating/avg/" + actProduct["products"][0]["id"];
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      displayAvg(jsonData);
    });
  return false;

}