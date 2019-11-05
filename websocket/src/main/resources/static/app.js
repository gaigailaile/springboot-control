/**
 * Created by gaigaicoming on 2019/11/1.
 */

var stompClient = null;

function setConnect(connect){
    $("#connect").prop("disabled",connect);
    $("#disconnect").prop("disabled",!connect);
    if(connect){
        $("#conversation").show();
        $("#chat").show();
    }else{
        $("#conversation").hide();
        $("#chat").hide();
    }
    $("#greetings").html("");
}

function connect(){
    if(!$("#name").val()){
        return;
    }

    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({},function(frame){
        setConnect(true);
        stompClient.subscribe('/topic/greetings',function(greeting){
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect(){
    if(stompClient !==null){
        stompClient.disconnect();
    }
    setConnect(false);
}

function sendName(){
    if(stompClient==null){
        console.log("111111111111");
        return;
    }
    stompClient.send("/app/hello",{},
        JSON.stringify({'name':$("#name").val(),'content':$("#content").val()}));
}

function showGreeting(message){
    $("#greetings").append("<div>"+ message.name +":"+message.content+"</div>");
}

$(function(){
    $("#connect").click(function(){
        connect();
    });

    $("#disconnect").click(function(){
        disconnect();
    });

    $("#send").click(function(){
        sendName();
    });
});