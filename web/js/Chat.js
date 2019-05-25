$(document).ready(function () {
    $("#friendList").click(function () {
        $("#showFriends").toggle();
    });
    $('.msg_wrap').hide();
    $('.msg_box').hide();
    $('.msg_head').hide();
    getMessages();
    $('.msgBox').hide();
});

function getMessages() {
    $.ajax({
        type: 'GET',
        url: 'Controller?action=GetMessages',
        success: function (response) {
            getOtherChatter();
            if (response.length > 0) {
                $('.msg_wrap').show();
                $('.msg_box').show();
                $('.msg_head').show();
            }
            $('.msg_body').empty();
            for (var i = 0; i < response.length; i++) {
                msg = response[i].sender.firstName + ": " + response[i].message;
                var div = $('<div></div>').text(msg);
                if (response[i].sender.userId != $('.msg_head').text()) $(div).addClass("msg_b");
                else $(div).addClass("msg_a");
                $('.msg_body').append(div);
            }

        },
        error: function () {
            alert("failed to get messages");
        }
    });
    setTimeout(getMessages, 1000);
}

function getOtherChatter() {
    $.ajax({
        type: 'GET',
        url: 'Controller?action=GetOtherChatter',
        dataType: ' text',
        success: function (response) {
            $('.msg_head').html("<strong>" + response + "</strong>");
        },
        error: function () {
            alert("failed to get other Chatter");
        }
    });
}

$('textarea').keypress(function (e) {
    var person = $('.msg_head').text();
    var msg = $(this).val();
    if (e.keyCode == 13) {
        e.preventDefault();
        sendMessage(person, msg);
    }
})

function sendMessage(person, msg) {
    $.ajax({
        type: "POST",
        url: "Controller?action=SendMessage",
        dataType: ' text',
        data: {
            "messageTarget": person,
            "message": msg
        },
        success: function () {
            $('textarea').val('')
        },
        error: function () {
            alert("failed to send message")
        }
    })
};
