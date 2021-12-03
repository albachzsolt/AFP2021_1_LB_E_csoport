load();

function load() {
    const url = "/dashboard";
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
    const numberOfActiveProducts = jsonData.numOfActiveProducts;
    const numberOfAllProducts = jsonData.numOfProducts;
    const numberOfActiveOrders = jsonData.numOfActiveOrders;
    const numberOfAllOrders = jsonData.numOfOrders;
    const options = {
        responsive: true,
        maintainAspectRatio: false, fontStyle: 'Arial'
    };

}