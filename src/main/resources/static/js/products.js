var allProducts;
var fetchedCategoryNames;

fetchCategoryNames();

setTimeout(fetchProducts, 1000);

fetchRecommendations();


function fetchProducts() {
  var url = "/api/products";
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      allProducts = jsonData;
      showDivs(jsonData);
      addFilterButtons(fetchedCategoryNames);
    });
}


function fetchCategory(categoryName) {
  var categoryUrl = categoryName.replace(/ /g, '_');

  var url = "/api/category/" + categoryUrl;
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      var allProductsDiv = document.querySelector('.all-products-div');
      allProductsDiv.innerHTML = '';
      showCategoryDivs(jsonData);
    });
}

function fetchCategoryNames() {
  var url = "/api/categories";
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      fetchedCategoryNames = jsonData;
    });
}



function showCategoryDivs(category) {
  var allProductsDiv = document.querySelector('.all-products-div');
  allProductsDiv.innerHTML = "";
  var categoryArray = [];
  categoryArray.push(category);
  showDivs(categoryArray);
}


function showDivs(jsonData) {
  var mainDiv = document.getElementById('main_div');


  var allProductsDiv = document.querySelector('.all-products-div');
  allProductsDiv.innerHTML = '';

  for (var i = 0; i < jsonData.length; i++) {

    var divCategory = document.createElement("div");
    divCategory.setAttribute('class', 'category-div');
    divCategory.setAttribute('id', jsonData[i].categoryName);
    allProductsDiv.appendChild(divCategory);

    var divCategoryName = document.createElement("div");
    divCategoryName.innerHTML = '–––––––– ' + jsonData[i].categoryName + ' ––––––––';
    divCategoryName.setAttribute('class', 'category-name-div anchor');
    divCategoryName.setAttribute('id', jsonData[i].categoryName + ' Name');
    divCategory.appendChild(divCategoryName);

    for (var j = 0; j < jsonData[i].products.length; j++) {
      if (jsonData[i].products[j].productStatus === "ACTIVE") {
        var divRow = document.createElement("div");
        divRow.setAttribute('class', 'index-product-div')
        divCategory.appendChild(divRow);

        var imgDiv = document.createElement('img');
        imgDiv.setAttribute('src', '/img/products/' + jsonData[i].products[j].address + '.jpg');
        imgDiv.setAttribute('alt', '');
        imgDiv.setAttribute('class', 'products_img');
        imgDiv.setAttribute("onclick", `window.location.href="product.html?address=${jsonData[i].products[j].address}"`);
        divRow.appendChild(imgDiv);


        var nameDiv = document.createElement("div");
        nameDiv.innerHTML = jsonData[i].products[j].name;
        nameDiv.setAttribute('class', 'div_class_name');
        nameDiv.setAttribute("onclick", `window.location.href="product.html?address=${jsonData[i].products[j].address}"`);
        divRow.appendChild(nameDiv);

        var priceDiv = document.createElement("div");
        priceDiv.innerHTML = jsonData[i].products[j].price + " Ft";
        priceDiv.setAttribute("onclick", `window.location.href="product.html?address=${jsonData[i].products[j].address}"`);
        divRow.appendChild(priceDiv);
      }
    }
    var clearerDiv = document.createElement('div');
    clearerDiv.setAttribute('class', 'clearer');
    divCategory.appendChild(clearerDiv);
  }

       var clearerDiv = document.createElement('div');
       clearerDiv.setAttribute('class', 'clearer');
       mainDiv.appendChild(clearerDiv);

}