
//Función Paginar
(function($) {
    $.fn.pagination = function() {
        $(this).each(function() {
            var current_page = $(this).attr("current-page");
            var num_per_page  = $(this).attr("number-per-page");
            var $table = $(this);
            $table.bind('repaginate', function() {
                $table.find('tbody tr').hide().slice(current_page * num_per_page, (current_page + 1) * num_per_page).show();
            });
            $table.trigger('repaginate');
            var num_rows = $table.find('tbody tr').length;
            var num_pages = Math.ceil(num_rows / num_per_page);
            var $pager = $('<ulll class="pager pagination"></ulll>');
            for (var page = 0; page < num_pages; page++) {
                $('<liii class="page"></liii>').text(page + 1).bind('click', {
                    new_page: page
                }, function(event) {
                    current_page = event.data['new_page'];
                    $table.trigger('repaginate');
                    $(this).addClass('activa').siblings().removeClass('activa');
                }).appendTo($pager);
            }
            $pager.insertAfter($table).find('.page:first').addClass('activa');
        });
    }
}(jQuery));

//Función Buscar 
function Buscar(){
    var tableReg = document.getElementById('datos');
    var searchText = document.getElementById('buscar').value.toLowerCase();
    var cellsOfRow = "";
    var found = false;
    var compareWith = "";

    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < tableReg.rows.length; i++)
    {
        cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
        found = false;
        // Recorre celdas
        for (var j = 0; j < cellsOfRow.length && !found; j++)
        {
            compareWith = cellsOfRow[j].innerHTML.toLowerCase();
            // Busca el texto en el contenido de la celda
            if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1))
            {
                found = true;
            }
        }
        if (found)
        {
            tableReg.rows[i].style.display = '';
        } else {
            // si no ha encontrado ninguna coincidencia, esconde la
            // fila de la tabla
            tableReg.rows[i].style.display = 'none';
        }
    }
}
