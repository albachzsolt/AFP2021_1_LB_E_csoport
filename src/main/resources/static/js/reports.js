fetchReports();


function fetchReports() {
    var url = "/reports/orders";
    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonData) {
            showTables(jsonData);
        });
}

function showTables(jsonData) {
    document.getElementById("report-table").innerHTML = "";
    tableMain = document.getElementById("report-table");
    for (var i = 0; i < jsonData["statusOrderReportList"].length; i++) {
        var oneRow = document.createElement("tr");

        var yearTd = document.createElement("td");
        yearTd.innerHTML = jsonData["statusOrderReportList"][i].year;
        oneRow.appendChild(yearTd);

        var monthTd = document.createElement("td");
        monthTd.innerHTML = jsonData["statusOrderReportList"][i].month;
        oneRow.appendChild(monthTd);


        var actPieceTd = document.createElement("td");
        actPieceTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfActiveOrdersForThisMonth;
        oneRow.appendChild(actPieceTd);

        var actAmountTd = document.createElement("td");
        actAmountTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfAmountForActiveOrdersForThisMonth;
        oneRow.appendChild(actAmountTd);

        var deliPieceTd = document.createElement("td");
        deliPieceTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfDeliveredOrdersForThisMonth;
        oneRow.appendChild(deliPieceTd);

        var deliAmountTd = document.createElement("td");
        deliAmountTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfAmountForDeliveredOrdersForThisMonth;
        oneRow.appendChild(deliAmountTd);

        var delPieceTd = document.createElement("td");
        delPieceTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfDeletedOrdersForThisMonth;
        oneRow.appendChild(delPieceTd);

        var delAmountTd = document.createElement("td");
        delAmountTd.innerHTML = jsonData["statusOrderReportList"][i].sumOfAmountForDeletedOrdersForThisMonth;
        oneRow.appendChild(delAmountTd);

        tableMain.appendChild(oneRow);

    }
    var oneRow = document.createElement("tr");

    var emptyTd = document.createElement("td");
    emptyTd.innerHTML = "Orders";
    oneRow.appendChild(emptyTd);

    var emptyTd2 = document.createElement("td");
    emptyTd2.innerHTML = "Summary";
    oneRow.appendChild(emptyTd2);

    var actPieceTd = document.createElement("td");
    actPieceTd.innerHTML = jsonData["statRowSummary"].actPiece;
    oneRow.appendChild(actPieceTd);

    var actAmountTd = document.createElement("td");
    actAmountTd.innerHTML = jsonData["statRowSummary"].actAmount;
    oneRow.appendChild(actAmountTd);

    var deliPieceTd = document.createElement("td");
    deliPieceTd.innerHTML = jsonData["statRowSummary"].deliPiece;
    oneRow.appendChild(deliPieceTd);

    var deliAmountTd = document.createElement("td");
    deliAmountTd.innerHTML = jsonData["statRowSummary"].deliAmount;
    oneRow.appendChild(deliAmountTd);

    var delPieceTd = document.createElement("td");
    delPieceTd.innerHTML = jsonData["statRowSummary"].delPiece;
    oneRow.appendChild(delPieceTd);

    var delAmountTd = document.createElement("td");
    delAmountTd.innerHTML = jsonData["statRowSummary"].delAmount;
    oneRow.appendChild(delAmountTd);

    tableMain.appendChild(oneRow);
}
