var webSocket = new WebSocket("ws://localhost:8080/ChatApp_Web_exploded/comment");
webSocket.onmessage = function (event) {
    var data = JSON.parse(event.data);
    var blogComment= document.getElementById(data.topicId);
    var tr = document.createElement("tr");
    var name = document.createElement("td");
    name.innerText = data.name;

    var comment = document.createElement("td");
    comment.innerText = data.comment;

    var rating = document.createElement("td");
    rating.innerText = data.rating+"/10";

    tr.appendChild(name);
    tr.appendChild(comment);
    tr.appendChild(rating);
    blogComment.appendChild(tr);

}
function sendReply(id){
    var data = {};
    data["topicId"]=id;

    data["name"]=document.getElementsByName("name")[id].value;
    data["comment"]=document.getElementsByName("comment")[id].value;
    data["rating"]=document.getElementsByName("rating")[id].value;
    webSocket.send(JSON.stringify(data));
}