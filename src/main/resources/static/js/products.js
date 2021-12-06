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