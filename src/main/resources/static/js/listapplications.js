$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    $('#example').DataTable( {
        ajax: {
            url: '/api/all',
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        select: true,
        columns: [
            { data: 'user_id' },
            { data: 'income' },
            { data: 'bothParentsUnemployed' , "render": checkbox},
            { data: 'hasSiblings' , "render": checkbox},
            { data: 'hasSiblingsInOtherCities', "render": checkbox }

        ]
    } );

     function checkbox ( data, type, full, meta ) {
        var is_checked = data === true ? "checked" : "";
        return '<input type="checkbox" class="checkbox" ' +
            is_checked + ' />';
    }
});