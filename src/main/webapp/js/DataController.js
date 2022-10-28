function getDataFromServer() {
    $.ajax({
        type: "POST",
        url: "controller-servlet",
        async: false,
        dataType: "json",
        data: {},
        success: function (data) {
            console.log(data);
            fillTable(data);
            updateCounter(data)
        },
        error: function () {
            alert("can't get data from server");
        }
    });
}