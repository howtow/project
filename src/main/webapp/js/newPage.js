$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8081/Booking/api/customerSum",
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        method: 'GET',
        success: function (data) {
            console.log(data)
            let customerSum = '';
            $.each(data, function () {
                customerSum += data.customer;
                console.log(customerSum)
            })
            console.log(customerSum)
            $('#member').append(customerSum);
        },
        error: function (err) {
            console.log(err);
            alert('ajax發生錯誤')
        }

    })
    $.ajax({
        url: "http://localhost:8081/Booking/api/customerSum",
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        method: 'GET',
        success: function (data) {
            console.log(data)
            let customerSum = '';
            $.each(data, function () {
                customerSum += data.customer;
                console.log(customerSum)
            })
            console.log(customerSum)
            $('#member').append(customerSum);
        },
        error: function (err) {
            console.log(err);
            alert('ajax發生錯誤')
        }
    })
})