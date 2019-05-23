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
            $('.msg_body').empty();
            for (var i = 0; i < response.length; i++) {
                //var msg = $("#mgs").val();
                //if (msg != '') {
                    msg = response[i].sender.firstName + ": " + response[i].message;
                    var div = $('<div></div>').text(msg);
                    if(response[i].sender.userId != $('.msg_head').html()) $(div).addClass("msg_b");
                    else $(div).addClass("msg_a");
                    $('.msg_body').append(div);
               // }
                $('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
            }
        },
        error: function () {
            alert("failed to get messages");
        }
    });
    setTimeout(getMessages, 1000);
}
$('textarea').keypress(function (e) {
    var person = $('.msg_head').text();
    var msg = $(this).val();
    if (e.keyCode == 13) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "Controller?action=SendMessage",
            data: {
                "messageTarget": person,
                "message": msg
            },
            success: $('textarea').val(''),
            error: function () {
                alert("failed to send message")
            }
        })
    }
});
