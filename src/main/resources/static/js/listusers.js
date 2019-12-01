$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    $('#example').DataTable( {
        ajax: {
            url: '/api/users/all',
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        select: true,
        columns: [
            { data: 'fullName' },
            { data: 'email' },
            { data: 'phoneNumber'},
            { data: 'category'},
            { data: 'memberSince'},
            { data: 'status'}

        ]
    } );

     function checkbox ( data, type, full, meta ) {
        var is_checked = data === true ? "checked" : "";
        return '<input type="checkbox" class="checkbox" ' +
            is_checked + ' />';
    }
});