fetchOrders();
var json;
function fetchOrders() {
  var url = '/myorders';
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (jsonData) {
      showDivs(jsonData);
    });
}


