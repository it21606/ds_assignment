$(document).ready(function () {
    var table = new Tabulator("#example", {
        ajaxURL: "api/applications/my", //ajax URL
        selectable: 0,
        headerFilterPlaceholder: "filter data...",
        columns: [
            {title: "Αριθμός αίτησης", field: "id", headerFilter: "input"},
            {title: "Χρήστης", field: "userInfo", headerFilter: "input"},
            {title: "Εισόδημα", field: "income", headerFilter: "input"},
            {title: "Άνεργοι γονείς", field: "bothParentsUnemployedDisplay", headerFilter: "input"},
            {title: "Έχει αδέρφια", field: "hasSiblingsDisplay", headerFilter: "input"},
            {title: "Είναι από άλλη πόλη", field: "hasSiblingsInOtherCitiesDisplay", headerFilter: "input"},
            {title: "Κατάσταση", field: "statusDisplay", headerFilter: "input"},
            {title: "Βαθμολογία", field: "collectedPoints", headerFilter: "input"},
        ],
        layout: "fitDataStretch",
        pagination: "local",
        paginationSize: 10,
        paginationSizeSelector: [10, 20, 50],
        movableColumns: true,
    });
});


