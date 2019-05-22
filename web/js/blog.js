var webSocket;
var messages = document.getElementById("messages");

function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/GWT_Ajax_Example_Chat_Push/echo");
    webSocket.onopen = function (event) {
    };
    webSocket.onmessage = function (event) {
        writeResponse(event.data);
    };
    webSocket.onclose = function (event) {
    };
}

function writeResponse(text) {
    messages.innerHTML += "<br/>" + text;
}