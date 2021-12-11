fetchReports();


function fetchReports() {
    const url = "/reports/orders";
    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonData) {
            showTables(jsonData);
        });
}

function showTables(jsonData) {
    let delAmountTd;
    let delPieceTd;
    let deliAmountTd;
    let actPieceTd;
    let deliPieceTd;
    let oneRow;
    let actAmountTd;

    document.getElementById("report-table").innerHTML = "";
    let tableMain = document.getElementById("report-table");
    for (let i = 0; i < jsonData["statusOrderReportList"].length; i++) {
        oneRow = document.createElement("tr");

        const yearTd = document.createElement("td");
        yearTd.innerHTML = jsonData["statusOrderReportList"][i].year;
        oneRow.appendChild(yearTd);

        const monthTd = document.createElement("td");
        monthTd.innerHTML = jsonData["statusOrderReportList"][i].month;
        oneRow.appendChild(monthTd);


        actPieceTd = document.createElement("td");
        actPieceTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfActiveOrdersForThisMonth;
        oneRow.appendChild(actPieceTd);

        actAmountTd = document.createElement("td");
        actAmountTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfAmountForActiveOrdersForThisMonth;
        oneRow.appendChild(actAmountTd);

        deliPieceTd = document.createElement("td");
        deliPieceTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfDeliveredOrdersForThisMonth;
        oneRow.appendChild(deliPieceTd);

        deliAmountTd = document.createElement("td");
        deliAmountTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfAmountForDeliveredOrdersForThisMonth;
        oneRow.appendChild(deliAmountTd);

        delPieceTd = document.createElement("td");
        delPieceTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfDeletedOrdersForThisMonth;
        oneRow.appendChild(delPieceTd);

        delAmountTd = document.createElement("td");
        delAmountTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfAmountForDeletedOrdersForThisMonth;
        oneRow.appendChild(delAmountTd);

        tableMain.appendChild(oneRow);

    }
    oneRow = document.createElement("tr");

    const emptyTd = document.createElement("td");
    emptyTd.innerHTML = "Orders";
    oneRow.appendChild(emptyTd);

    const emptyTd2 = document.createElement("td");
    emptyTd2.innerHTML = "Summary";
    oneRow.appendChild(emptyTd2);

    actPieceTd = document.createElement("td");
    actPieceTd.innerHTML = jsonData["statRowSummary"].actPiece;
    oneRow.appendChild(actPieceTd);

    actAmountTd = document.createElement("td");
    actAmountTd.innerHTML = jsonData["statRowSummary"].actAmount;
    oneRow.appendChild(actAmountTd);

    deliPieceTd = document.createElement("td");
    deliPieceTd.innerHTML = jsonData["statRowSummary"].deliPiece;
    oneRow.appendChild(deliPieceTd);

    deliAmountTd = document.createElement("td");
    deliAmountTd.innerHTML = jsonData["statRowSummary"].deliAmount;
    oneRow.appendChild(deliAmountTd);

    delPieceTd = document.createElement("td");
    delPieceTd.innerHTML = jsonData["statRowSummary"].delPiece;
    oneRow.appendChild(delPieceTd);

    delAmountTd = document.createElement("td");
    delAmountTd.innerHTML = jsonData["statRowSummary"].delAmount;
    oneRow.appendChild(delAmountTd);

    tableMain.appendChild(oneRow);
}

function showTables2(jsonData) {
    document.getElementById("report-table_prod").innerHTML = "";
    tableMain = document.getElementById("report-table_prod");
    for (var i = 0; i < jsonData.length; i++) {
        var oneRow = document.createElement("tr");

        var yearTd = document.createElement("td");
        yearTd.innerHTML = jsonData[i].year;
        oneRow.appendChild(yearTd);

        var monthTd = document.createElement("td");
        monthTd.innerHTML = jsonData[i].month;
        oneRow.appendChild(monthTd);


        var productTd = document.createElement("td");
        productTd.innerHTML = jsonData[i].productName;
        oneRow.appendChild(productTd);

        var priceTd = document.createElement("td");
        priceTd.innerHTML = jsonData[i].productPrice;
        oneRow.appendChild(priceTd);

        var countTd = document.createElement("td");
        countTd.innerHTML = jsonData[i].productCounter;
        oneRow.appendChild(countTd);

        var amountTd = document.createElement("td");
        amountTd.innerHTML = jsonData[i].amount;
        oneRow.appendChild(amountTd);

        tableMain.appendChild(oneRow);
    }
}
