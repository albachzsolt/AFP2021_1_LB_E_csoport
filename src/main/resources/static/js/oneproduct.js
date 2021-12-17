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