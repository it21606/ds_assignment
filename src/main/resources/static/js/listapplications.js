$(document).ready(function () {
    var table = new Tabulator("#example", {
        ajaxURL: "api/applications/all", //ajax URL
        selectable: 1,
        headerFilterPlaceholder: "filter data...",
        columns: [
            {title: "Αριθμός αίτησης", field: "id", headerFilter: "input"},
            {title: "Χρήστης", field: "userInfo", headerFilter: "input"},
            {title: "Εισόδημα", field: "income", headerFilter: "input"},
            {title: "Άνεργοι γονείς", field: "bothParentsUnemployedDisplay", headerFilter: "input"},
            {title: "Έχει αδέρφια", field: "hasSiblingsDisplay", headerFilter: "input"},
            {title: "Έχει αδέρφια σε άλλη πόλη", field: "hasSiblingsInOtherCitiesDisplay", headerFilter: "input"},
            {title: "Κατάσταση", field: "statusDisplay", headerFilter: "input"},
            {title: "Βαθμολογία", field: "collected_points", headerFilter: "input"},
        ],
        layout: "fitDataStretch",
        pagination: "local",
        paginationSize: 10,
        paginationSizeSelector: [10, 20, 50],
        movableColumns: true,
        rowSelected: function (e, row) {
            let selectedRows = this.getSelectedData();
            console.log(selectedRows[0].user_id);
            let url = "/edit/application/" + selectedRows[0].id;
            window.open(url);
        },
    });
});


