$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    $('#userDeleteModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    })
});