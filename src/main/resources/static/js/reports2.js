window.onload = function () {
    fetchReportsTwo();

    function fetchReportsTwo() {
        let url = "/reports/products";
        fetch(url)
            .then(function (response) {
                return response.json();
            })
            .then(function (jsonData) {
                showTables(jsonData);
            });
    }

    function showTables(jsonData) {
        tableMain = document.getElementById("report-table_prod");
        for (let i = 0; i < jsonData.length; i++) {
            let oneRow = document.createElement("tr");

            let yearTd = document.createElement("td");
            yearTd.innerHTML = jsonData[i].year;
            oneRow.appendChild(yearTd);

            let monthTd = document.createElement("td");
            monthTd.innerHTML = jsonData[i].month;
            oneRow.appendChild(monthTd);
            let productTd = document.createElement("td");
            productTd.innerHTML = jsonData[i].productName;
            oneRow.appendChild(productTd);

            let priceTd = document.createElement("td");
            priceTd.innerHTML = jsonData[i].productPrice;
            oneRow.appendChild(priceTd);

            let countTd = document.createElement("td");
            countTd.innerHTML = jsonData[i].productCounter;
            oneRow.appendChild(countTd);

            let amountTd = document.createElement("td");
            amountTd.innerHTML = jsonData[i].amount;
            oneRow.appendChild(amountTd);

            tableMain.appendChild(oneRow);

        }
    }
}