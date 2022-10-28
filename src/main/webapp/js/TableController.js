function addNewRowInTable(data) {
    let date = new Date(data["time"]["epochSecond"] * 1000 + data["time"]["nano"] / 1000000);
    let html_row = "<tr><th>" + data["x"] + "</th><th>" + data["y"]
        + "</th><th>" + data["r"] + "</th><th>" + date.toISOString().slice(0, 19).replace("T", " ")
        + "</th><th>" + data["result"] + "</th></tr>";
    $('#table tr:last').after(html_row);
}

function fillTable(data) {
    data["hits"].forEach(item => addNewRowInTable(item))
}