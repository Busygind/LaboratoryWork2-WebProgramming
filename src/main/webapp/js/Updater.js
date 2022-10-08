function update(x, y, r) {

    if (validateVariables(x, y, r)) {
        $.ajax({
            type: "GET",
            url: "controller-servlet",
            async: false,
            dataType: "json",
            data: {"x-value": x.toString().trim(), "y-value": y.toString().trim(), "r-value": r.toString().trim(),
                                        "timezone": new Date().getTimezoneOffset()},
            success: function(data) {
                //console.log(data);
                addNewRowInTable(data);
                if (globalBoard !== undefined) {
                    drawPoint(globalBoard, data["x"], data["y"], data["result"]);
                }
            },
            error: function(data) {
                alert("Smth went wrong (update)");
            }
        });     

        console.log(x, y, r);
    }
}

function getDataFromServer() {
    $.ajax({
        type: "POST",
        url: "controller-servlet",
        async: false,
        dataType: "json",
        data: {},
        success: function(data) {
            console.log(data);
            fillTable(data);
        },
        error: function() {
            alert("can't get data from server");
        }
    });
}

