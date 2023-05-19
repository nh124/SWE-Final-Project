import React, { useState } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";

const Registry = ({ userData, setUserData }) => {
  let stompClient = null;
  const [publicChats, setPublicChats] = useState([]);
  const [privateChats, setPrivateChats] = useState(new Map());
  const handleUserName = (event) => {
    setUserData({ ...userData, username: event.target.value });
  };
  const onConnect = () => {
    setUserData({ ...userData, connected: true });
    setTimeout(() => {
      stompClient.subscribe("/chatroom/public/", onPublicMessageReceived);
      stompClient.subscribe(
        "/user/",
        userData.username + "/private",
        onPrivateMessageReceived
      );
      console.log("Connected");
    }, 500);
  };
  const onPublicMessageReceived = (payload) => {
    let payloadData = JSON.parse(payload.body);
    console.log("payloadData: " + payloadData, "payload: " + payload);
    switch (payload.status) {
      case "JOIN":
        if (!privateChats.get(payloadData.senderName)) {
          privateChats.set(payloadData.senderName, []);
          setPrivateChats(new Map(privateChats));
        }
        break;
      case "MESSAGE":
        publicChats.push(payload.data);
        setPublicChats([...publicChats]);
        console.log("publicChats: " + publicChats);
        break;
      case "LEAVE":
        break;
    }
  };

  const onPrivateMessageReceived = (payload) => {
    let payloadData = JSON.parse(payload.data);
    if (privateChats.get(payloadData.senderName)) {
      privateChats.get(payloadData.senderName).push(payloadData);
      setPrivateChats(new Map(privateChats));
    } else {
      let list = [];
      list.push(payloadData.senderName, list);
      setPrivateChats(new Map(privateChats));
    }
  };
  const onError = (err) => {
    console.log(err);
  };

  const registerUser = (event) => {
    let sock = new SockJS(`http://localhost:8080/ws`);
    stompClient = over(sock);
    stompClient.connect({}, onConnect(), onError());
  };
  return (
    <div>
      <input
        type="text"
        placeholder="Enter name"
        value={userData.username}
        onChange={handleUserName}
      />
      <button type="button" onClick={registerUser}>
        Connect
      </button>
    </div>
  );
};

export default Registry;
