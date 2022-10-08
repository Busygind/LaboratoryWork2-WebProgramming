function cleanFields() {
    $('').prop('checked', false);
}

function cleanTable() {
    let emptyTable = `<tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Current time</th>
        <th>Result</th>
        </tr>`;
    $('#table').html(emptyTable);
    cleanGraph()

    // delete hits from context
    $.ajax({
        type: "PUT",
        url: "controller-servlet",
        async: false,
        error: function () {
            alert("can't clear table");
        }
    });
}

function cleanGraph() {
    document.getElementById('jxgbox').removeEventListener("click", mouseClickListener);
    drawBoard()
}