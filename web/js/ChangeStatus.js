var button = document.getElementById("statusbutton");
button.onclick = setStatus;

var getStatusObject = new XMLHttpRequest();

function getNewStatus () {
    getStatusObject.open("GET", "Controller?action=GetStatus", true);
    getStatusObject.onreadystatechange = getStatusData;
    getStatusObject.send(null);
}
var newStatusObject = new XMLHttpRequest();
function setStatus(){
    var status = document.getElementById("status").value;
    var information = "status="+ encodeURIComponent(status);
    newStatusObject.open("POST", "Controller?action=ChangeStatus",true)
    newStatusObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    newStatusObject.send(information);
    getNewStatus();
}

function getStatusData () {
    if (getStatusObject.status == 200) {
        if (getStatusObject.readyState == 4) {
            //var serverResponse = JSON.parse(getFriendsObject.responseText);
            //var status = serverResponse.status; // of je kan ook doen: serverResponse["quote"]
            var status = getStatusObject.responseText;
            var quoteDiv = document.getElementById("showstatus");
            var quoteParagraph = quoteDiv.childNodes[0];

            if (quoteParagraph == null) {
                quoteParagraph = document.createElement('p');
                quoteParagraph.id = "statusText";
                //quoteParagraph.appendChild("Your current status is: ")
                quoteParagraph.appendChild(document.createTextNode(status));
                quoteDiv.appendChild(quoteParagraph);
            }
            else {
                quoteParagraph.removeChild(quoteParagraph.childNodes[0]);
                quoteParagraph.appendChild(document.createTextNode(status));
            }
        }
    }
    //setTimeout("getNewStatus()", 10000);

}