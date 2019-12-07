$(document).ready(function () {
    var table = new Tabulator("#example", {
        ajaxURL: "api/users/all", //ajax URL
        selectable: 1,
        headerFilterPlaceholder: "filter data...",
        columns: [
            {title: "Πλήρες όνομα", field: "fullName", headerFilter: "input"},
            {title: "Ε-mail", field: "email", headerFilter: "input"},
            {title: "Τηλέφωνο", field: "phoneNumber", headerFilter: "input"},
            {title: "Κατηγορία", field: "category", headerFilter: "input"},
            {title: "Μέλος από", field: "memberSince", headerFilter: "input"},
            {title: "Κατάσταση", field: "status", headerFilter: "input"},
        ],
        layout: "fitDataStretch",
        pagination: "local",
        paginationSize: 10,
        paginationSizeSelector: [10, 20, 50],
        movableColumns: true,
        rowSelected: function (e, row) {
            var selectedRows = this.getSelectedData();
            console.log(selectedRows[0].userId);
            let url = "/api/users/" + selectedRows[0].userId;
            window.open(url);
        },
    });
});


