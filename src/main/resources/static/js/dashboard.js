load();

function load() {
    var url = "/dashboard";
    fetch(url)
        .then(function (response) {
        return response.json();
    })
        .then(function (jsonData) {
            showStatistics(jsonData);
        });
}

function showStatistics(jsonData) {
    document.getElementById("user").innerHTML = 'We have ' + jsonData.numOfUsers + ' registered users!';
    var numberOfActiveProducts = jsonData.numOfActiveProducts;
    var numberOfAllProducts = jsonData.numOfProducts;
    var numberOfActiveOrders = jsonData.numOfActiveOrders;
    var numberOfAllOrders = jsonData.numOfOrders;
    var options = {responsive: true,
        maintainAspectRatio: false, fontStyle: 'Arial'
    };

}