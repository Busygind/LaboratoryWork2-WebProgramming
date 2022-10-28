function update(x, y, r) {
    if (validateVariables(x, y, r)) {
        $.ajax({
            type: "GET",
            url: "controller-servlet",
            async: false,
            dataType: "json",
            data: {
                "x-value": x.toString().trim(), "y-value": y.toString().trim(), "r-value": r.toString().trim(),
                "timezone": new Date().getTimezoneOffset()
            },
            success: function (data) {
                //console.log(data);
                addNewRowInTable(data["hit"]);
                if (globalBoard !== undefined) {
                    drawPoint(globalBoard, data["hit"]["x"], data["hit"]["y"], data["hit"]["result"]);
                }
                updateCounter(data)
            },
            error: function () {
                alert("Smth went wrong (update)");
            }
        });
    }
}

function updateCounter(data) {
    let counter = data["actionCounter"]
    let info = "<span>Count of servlets actions: " + counter + " </span>"
    $(".actionCounter").html(info);
}

